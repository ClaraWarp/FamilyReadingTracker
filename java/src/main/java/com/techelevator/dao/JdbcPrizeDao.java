package com.techelevator.dao;

import com.techelevator.model.Prize;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class JdbcPrizeDao implements PrizeDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcPrizeDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;

    }

    @Override
    public List<Prize> getListOfPrizesByFamily(Integer familyId){
        List<Prize> prizes = new ArrayList<>();
        String sql = "SELECT * FROM prizes " +
                "JOIN families_prizes ON prizes.prize_id = families_prizes.prize_id " +
                "WHERE family_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, familyId);
        while(results.next()) {
            Prize prize = mapRowToPrize(results);
            prizes.add(prize);
        }
        return prizes;
    }

    @Override
    public List<Prize> getListOfPrizesByUser(Integer userId){
        List<Prize> prizes = new ArrayList<>();
        String sql = "SELECT * FROM prizes " +
                "JOIN families_prizes ON prizes.prize_id = families_prizes.prize_id " +
                "JOIN families_users ON families_prizes.family_id = families_users.family_id" +
                "JOIN users ON families_users.user_id = user.user_id" +
                "WHERE user.user_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while(results.next()) {
            Prize prize = mapRowToPrize(results);
            prizes.add(prize);
        }
        return prizes;
    }


    @Override
    public Prize getPrizeById(Integer prizeId){
        String sql = "SELECT * FROM prizes WHERE prize_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, prizeId);
        return mapRowToPrize(results);
    }

    @Override
    public Prize addPrize(Prize prize){
        String sql = "INSERT INTO prizes (name, description, time_requirement, max_prizes, start_date, end_date) VALUES (?, ?, ?, ?, ?, ?) " +
                "RETURNING prize_id";

        //This line checks the number of rows affected by the jdbcTemplate.update(). It should affect 1 row if executed correctly.
        Integer prizeId = jdbcTemplate.queryForObject(sql, Integer.class, prize.getName(), prize.getDescription(), prize.getTimeRequirement(),
                prize.getMaxPrize(), prize.getStartDate(), prize.getEndDate());

        prize.setPrizeId(prizeId);

        return prize;
    }

    @Override
    public boolean editPrize(Prize prize){

        String sql = "UPDATE prizes SET name = ?, description = ?, time_requirement = ?, max_prizes = ?, start_date = ?, end_date = ? WHERE prize_id = ?";

        //This line checks the number of rows affected by the jdbcTemplate.update(). It should affect 1 row if executed correctly.
        return jdbcTemplate.update(sql, prize.getName(), prize.getDescription(), prize.getTimeRequirement(),
                prize.getMaxPrize(), prize.getStartDate(), prize.getEndDate(), prize.getPrizeId()) == 1;

    }

    @Override
    public boolean removePrize(Integer prizeId, Integer familyId){
        boolean prizeDeleted = false;
        String sql = "DELETE FROM families_prizes WHERE prize_id = ? AND family_id = ?;" +
                "DELETE FROM prizes WHERE prize_id = ?;";

        //This line checks the number of rows affected by the jdbcTemplate.update(). It should affect 1 row if executed correctly.
        prizeDeleted = jdbcTemplate.update(sql, prizeId, familyId, prizeId) == 1;
        return prizeDeleted;
    }

    @Override
    public void addPrizeToFamily(Integer prizeId, Integer familyId) {

        String sql = "INSERT INTO families_prizes (prize_id, family_id) VALUES (?, ?);\n";

        jdbcTemplate.update(sql, prizeId, familyId);

    }


    private Prize mapRowToPrize(SqlRowSet rs){
        Prize prize = new Prize();
        prize.setPrizeId(rs.getInt("prize_id"));
        prize.setName(rs.getString("name"));
        prize.setDescription(rs.getString("description"));
        prize.setTimeRequirement(rs.getInt("time_requirement"));
        prize.setMaxPrize(rs.getInt("max_prizes"));
        prize.setStartDate(rs.getDate("start_date"));
        prize.setEndDate(rs.getDate("end_date"));
        return prize;
    }
}
