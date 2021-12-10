package com.techelevator.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcReaderDao implements ReaderDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcReaderDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int getReadingBankById(int userId) {

        String sql = "UPDATE reading_activity_bank SET minutes_read_bank = (\n" +
                "SELECT SUM(time_read) FROM reading_activity_log WHERE user_id = ?)\n" +
                "WHERE user_id = ?;";

        String sql1 = "SELECT minutes_read_bank FROM reading_activity_bank WHERE user_id = ?";

        jdbcTemplate.update(sql, userId, userId);

        return jdbcTemplate.queryForObject(sql1, int.class, userId);
    }


    public String getFamilyRoleById (int userId) {
        String sql = "SELECT family_role from families_users " +
                "JOIN users on families_users.user_id = user.user_id" +
                "WHERE user_id = ?";

        String result = jdbcTemplate.queryForObject(sql, String.class, userId);

        return result;
    }
}
