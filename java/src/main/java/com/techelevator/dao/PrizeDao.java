package com.techelevator.dao;

import com.techelevator.model.Prize;

import java.util.Date;
import java.util.List;

public interface PrizeDao {

    List<Prize> getListOfPrizesByFamily(Integer familyId);

    List<Prize> getListOfPrizesByUser(Integer userId);

    Prize getPrizeById(Integer prizeId);

    boolean addPrize(Prize prize);

    boolean editPrize(Prize prize);

    boolean removePrize(int id);

}