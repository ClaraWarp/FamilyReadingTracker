package com.techelevator.dao;

import com.techelevator.model.Book;
import com.techelevator.model.ReadingActivity;
import com.techelevator.model.ReadingActivity;
import com.techelevator.model.User;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.dao.EmptyResultDataAccessException;
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

        String bookSql = "SELECT book_id FROM books WHERE title = ?";

        String addToReadingBank = "SELECT SUM(minutes_read_bank) FROM reading_activity_bank WHERE user_id = ?";

        try {
            Integer bookId = jdbcTemplate.queryForObject(bookSql, Integer.class, readingActivity.getBookNameToAdd());
            Integer bank = jdbcTemplate.queryForObject(addToReadingBank, Integer.class, readingActivity.getUserId());

            String newActivity = "INSERT INTO reading_activity_log (user_id, book_id, format, time_read) values (?, ?, ?, ?) \n" +
                    " RETURNING activity_id";

            jdbcTemplate.queryForObject(newActivity, Integer.class, readingActivity.getUserId(), bookId, readingActivity.getFormat()
                    , readingActivity.getTimeRead());

        } catch (EmptyResultDataAccessException ex) {
            System.out.println("book not found.");
        }


    }

    @Override
    public int getTotalMinutesRead(int userId) {
        Integer bank = 0;
        String addToReadingBank = "SELECT SUM(time_read) FROM reading_activity_log WHERE user_id = ?";
        ;

        try {
            bank = jdbcTemplate.queryForObject(addToReadingBank, Integer.class, userId);

        } catch (EmptyResultDataAccessException ex) {
            System.out.println("unable to get total Minutes");
        }

        return bank;
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
