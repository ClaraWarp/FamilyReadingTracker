package com.techelevator.dao;

import com.techelevator.model.Family;
import com.techelevator.model.FamilyUserSum;
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
    public FamilyUserSum getFamilyByUser(int userID) {
        String sql = "SELECT name, family_role FROM families f " +
                "JOIN families_users fu ON f.family_id = fu.family_id " +
                "WHERE user_id = ? LIMIT 1";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, userID);
        FamilyUserSum familyUserSum = new FamilyUserSum();
        if (result.next()) {
            familyUserSum.setFamilyRole(result.getBoolean("family_role"));
            familyUserSum.setFamilyName(result.getString("name"));
        }
        return familyUserSum;
    }

    @Override
    public void createFamily(String familyName, int userID) {

        String sql = "INSERT INTO families (name) VALUES (?) RETURNING family_id";

        int newFamilyID = jdbcTemplate.queryForObject(sql, Integer.class, familyName);

        sql = "INSERT INTO families_users VALUES (?, TRUE, ?)";

        jdbcTemplate.update(sql, newFamilyID, userID);
    }

    public Family mapRowToFamily(SqlRowSet rowSet) {
        Family family = new Family();

        family.setFamilyId(rowSet.getInt("family_id"));
        family.setName(rowSet.getString("family_name"));

        return family;
    }


}
