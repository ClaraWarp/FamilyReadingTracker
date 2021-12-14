package com.techelevator.dao;

import com.techelevator.model.Family;
import com.techelevator.model.FamilyUserSum;
import com.techelevator.model.User;

import java.util.List;

public interface FamiliesDao {
    // TO DO: AT A METHOD TO INSERT INTO FAMILIES_USERS TO ADD SOMEONE TO A FAMILY

    Family getFamilyByName(String name);

    void createFamily (String familyName, int userID);

    List<Family> getFamilies();

    FamilyUserSum getFamilyByUser(int userID);

//    boolean addUserToFamily(User accountHolder, User accountToAdd);
}
