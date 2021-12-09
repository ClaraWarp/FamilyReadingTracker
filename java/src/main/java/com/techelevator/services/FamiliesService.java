package com.techelevator.services;

import com.techelevator.dao.FamiliesDao;
import com.techelevator.model.Family;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
public class FamiliesService {


    private FamiliesDao familiesDao;

    public FamiliesService (FamiliesDao familiesDao) {
        this.familiesDao = familiesDao;
    }

    public Family getFamilyByName(String name) {
        return familiesDao.getFamilyByName(name);
    }

    public void createFamily(Family family) {
        familiesDao.createFamily(family);
    }
}
