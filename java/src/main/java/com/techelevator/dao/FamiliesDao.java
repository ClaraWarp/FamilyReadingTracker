package com.techelevator.dao;

import com.techelevator.model.Family;

import java.util.List;

public interface FamiliesDao {

    Family getFamilyByName(String name);

    void createFamily (Family family);

    List<Family> getFamilies();
}
