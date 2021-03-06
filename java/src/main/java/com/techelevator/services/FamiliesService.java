package com.techelevator.services;

import com.techelevator.dao.FamiliesDao;
import com.techelevator.model.Family;
import com.techelevator.model.FamilyUserSum;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Service
public class FamiliesService {


    private FamiliesDao familiesDao;

    public FamiliesService (FamiliesDao familiesDao) {
        this.familiesDao = familiesDao;
    }

    // TO DO: AT A METHOD TO INSERT INTO FAMILIES_USERS TO ADD SOMEONE TO A FAMILY
    public void addUserToFamily(int userIdForFamily, int userIdToAdd, boolean isParent) { familiesDao.addUserToFamily(userIdForFamily, userIdToAdd, isParent); }

    public FamilyUserSum getFamilyByUser(int userID) {
        return familiesDao.getFamilyByUser(userID);
    }

    public Family getFamilyByName(String name) {
        return familiesDao.getFamilyByName(name);
    }

    public void createFamily(String familyName, int userID) {
        familiesDao.createFamily(familyName, userID);
    }

    public List<Family> getFamilies() {
        return familiesDao.getFamilies();
    };
}
