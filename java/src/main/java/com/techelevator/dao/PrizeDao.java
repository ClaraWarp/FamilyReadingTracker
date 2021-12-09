package com.techelevator.dao;

import com.techelevator.model.Prize;

import java.util.Date;
import java.util.List;

public interface PrizeDao {

    List<Prize> getListOfPrizesByFamily(Integer familyId);

    Prize getPrizeById(Integer prizeId);

    boolean addPrize(Prize prize);

}