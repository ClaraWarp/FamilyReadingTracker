package com.techelevator.dao;

import com.techelevator.model.Family;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class JdbcFamiliesDao implements FamiliesDao {


    // May need to revise getFamilyByName method in the case of multiple families with same name

    private JdbcTemplate jdbcTemplate;

    public JdbcFamiliesDao (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Family getFamilyByName(String name) {

        String findName = "SELECT * FROM families WHERE name = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(findName, name);

        if(result.next()) {
            return mapRowToFamily(result);
        }
        throw new RuntimeException("Account not found for family name: " + name);
    }

    public Family mapRowToFamily(SqlRowSet rowSet) {
        Family family = new Family();

        family.setFamilyId(rowSet.getInt("family_id"));
        family.setName(rowSet.getString("family_name"));

        return family;
    }
}
