package com.techelevator.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcReaderDao {

<<<<<<< HEAD
    private JdbcTemplate jdbcTemplate;

    public JdbcReaderDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int getReadingBankById(int id) {
=======
//    private JdbcTemplate jdbcTemplate;
//
//    public JdbcReaderDao(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
>>>>>>> 9864cb42778c5bd7999fb9c6266bd6e9d479a410

        String sql = "UPDATE reading_activity_bank SET minutes_read_bank = (\n" +
                "SELECT SUM(time_read) FROM reading_activity_log WHERE user_id = ?)\n" +
                "WHERE user_id = ?;";

        String sql1 = "SELECT minutes_read_bank FROM reading_activity_bank WHERE user_id = ?";

        jdbcTemplate.update(sql, id, id);

        return jdbcTemplate.queryForObject(sql1, int.class, id);
    }
}