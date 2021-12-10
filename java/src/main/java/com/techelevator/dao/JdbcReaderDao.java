package com.techelevator.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcReaderDao {

<<<<<<< HEAD

=======
>>>>>>> e2d40560a2418bfd63a864b8f7237f3865dc5dc5
    private JdbcTemplate jdbcTemplate;

    public JdbcReaderDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int getReadingBankById(int id) {
<<<<<<< HEAD

=======
>>>>>>> e2d40560a2418bfd63a864b8f7237f3865dc5dc5
//    private JdbcTemplate jdbcTemplate;
//
//    public JdbcReaderDao(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//

        String sql = "UPDATE reading_activity_bank SET minutes_read_bank = (\n" +
                "SELECT SUM(time_read) FROM reading_activity_log WHERE user_id = ?)\n" +
                "WHERE user_id = ?;";

        String sql1 = "SELECT minutes_read_bank FROM reading_activity_bank WHERE user_id = ?";

        jdbcTemplate.update(sql, id, id);

        return jdbcTemplate.queryForObject(sql1, int.class, id);
    }
}
