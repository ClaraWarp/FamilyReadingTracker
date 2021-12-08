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
        String sql = "SELECT * FROM prizes JOIN families_prizes ON prizes.prize_id = families_prizes.prize_id WHERE family_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, familyId);
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
    public boolean createPrize(Prize prize){
        boolean prizeCreated = false;
        String sql = "INSERT INTO prizes ('name', 'description', 'time_requirement', 'max_prizes', 'start_date', 'end_date') VALUES (?, ?, ?, ?, ?, ?)";

        //This line checks the number of rows affected by the jdbcTemplate.update(). It should affect 1 row if executed correctly.
        prizeCreated = jdbcTemplate.update(sql, prize.getName(), prize.getDescription(), prize.getTimeRequirement(),
                prize.getMaxPrize(), prize.getStartDate(), prize.getEndDate()) == 1;
        return prizeCreated;
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