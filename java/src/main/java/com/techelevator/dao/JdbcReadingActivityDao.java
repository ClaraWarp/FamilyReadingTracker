package com.techelevator.dao;

import com.techelevator.model.Book;
import com.techelevator.model.ReadingActivity;
import com.techelevator.model.ReadingActivity;
import com.techelevator.model.User;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcReadingActivityDao implements ReadingActivityDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcReadingActivityDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addActivity (ReadingActivity readingActivity) {

        String newActivity = "INSERT INTO reading_activity_log (user_id, isbn, format, time_read) values (?, ?, ?, ?) \n" +
                " RETURNING activity_id";

        jdbcTemplate.update(newActivity, readingActivity.getActivityId(), readingActivity.getUserId(), readingActivity.getIsbn(), readingActivity.getFormat()
                , readingActivity.getTimeRead()) ;
    }

    @Override
    public ReadingActivity getActivityByUserId(int userId) {

        String sql = "SELECT * FROM reading_activity_log rag " +
                "WHERE user_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);

        if(results.next()) {
            return mapRowToReadingActivity(results);
        } else {
            throw new RuntimeException("Reading activity was not found for project id: " + userId);
        }
    }

    @Override
    public List<ReadingActivity> getListOfActivitiesByUserId(int userId) {

        List<ReadingActivity> readingActivities = new ArrayList<>();

        String sql = "SELECT * FROM reading_activity_log ral " +
                "WHERE user_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);

        while(results.next()) {
            ReadingActivity readingActivity = mapRowToReadingActivity(results);
            readingActivities.add(readingActivity);
        }

        return readingActivities;
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
