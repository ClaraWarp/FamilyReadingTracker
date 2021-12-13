package com.techelevator.dao;

import com.techelevator.model.Family;
import com.techelevator.model.User;

import java.util.List;

public interface FamiliesDao {

    Family getFamilyByName(String name);

    void createFamily (String familyName, int userID);

    List<Family> getFamilies();

    String getFamilyByUser(int userID);

//    boolean addUserToFamily(User accountHolder, User accountToAdd);
}
