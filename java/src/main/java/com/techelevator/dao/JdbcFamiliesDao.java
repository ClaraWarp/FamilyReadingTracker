package com.techelevator.dao;

import com.techelevator.model.Family;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Family> getFamilies() {
        String sql = "SELECT * FROM families";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        List<Family> families = new ArrayList<>();

        if (results.next()) {
            families.add(mapRowToFamily(results));
        }

        return families;
    }

    @Override
    public void createFamily(Family family) {

        String newFamily = "INSERT INTO families (family_id, name) VALUES (?, ?)";

        jdbcTemplate.update(newFamily, family.getFamilyId(), family.getName());
    }

    public Family mapRowToFamily(SqlRowSet rowSet) {
        Family family = new Family();

        family.setFamilyId(rowSet.getInt("family_id"));
        family.setName(rowSet.getString("family_name"));

        return family;
    }

//    public boolean addUserToFamily(User accountHolder, User accountToAdd) {
//        boolean userAdded = false;
//
//        //want to check if accountHolder is parent and in a family
//
//        String sql = "INSERT INTO families_users (family_id, user_id) VALUES (?, ?)";
//
//
//    };
}
