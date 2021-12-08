package com.techelevator.dao;

import com.techelevator.model.Book;
import com.techelevator.model.ReadingActivity;
import com.techelevator.model.ReadingActivity;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class JdbcReadingActivityDao implements ReadingActivityDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcReadingActivityDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createActivity (ReadingActivity readingActivity) {

        String newActivity = "INSERT INTO reading_activity_log (user_id, isbn, format, time_read) values (?, ?, ?, ?) \n" +
                " RETURNING activity_id";

        jdbcTemplate.update(newActivity, readingActivity.getActivityId(), readingActivity.getUserId(), readingActivity.getIsbn(), readingActivity.getFormat()
                , readingActivity.getTimeRead());
    }

    @Override
    public ReadingActivity getActivityById(int activityId) {

        String getActivity = "SELECT * FROM reading_activity_log WHERE activity_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(getActivity, activityId);

        if(results.next()) {
            return mapRowToReadingActivity(results);
        } else {
            throw new RuntimeException("Reading activity was not found for project id: " + activityId);
        }
    }

    private ReadingActivity mapRowToReadingActivity(SqlRowSet rowSet) {
        ReadingActivity readingActivity = new ReadingActivity();

        readingActivity.setActivityId(rowSet.getInt("activity_id"));
        readingActivity.setUserId(rowSet.getInt("user_id"));
        readingActivity.setISBN(rowSet.getString("isbn"));
        readingActivity.setFormat(rowSet.getString("format"));
        readingActivity.setTimeRead(rowSet.getInt("time_read"));
        
        return readingActivity;
    }
}
