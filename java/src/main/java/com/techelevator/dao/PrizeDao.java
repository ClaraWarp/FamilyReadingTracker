package com.techelevator.dao;

import com.techelevator.model.Prize;

import java.util.Date;
import java.util.List;

public interface PrizeDao {

    List<Prize> findAllPrizesByFamily(Integer familyId);

    Prize getPrizeById(Integer prizeId);

    boolean create(String name, String description, Integer milestone, Integer maxPrize, Date startDate, Date endDate);

}