package com.techelevator.services;
import com.techelevator.dao.PrizeDao;
import com.techelevator.model.Prize;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PrizeService {

    private PrizeDao prizeDao;

    public PrizeService(PrizeDao prizeDao) {
        this.prizeDao = prizeDao;
    }

    public List<Prize> getListOfPrizesByFamily(Integer familyId) {
        return prizeDao.getListOfPrizesByFamily(familyId);
    }

    public List<Prize> getListOfPrizesByUser(Integer userId) {
        return prizeDao.getListOfPrizesByUser(userId);
    }

    public Prize getPrizeById(Integer id) {
        return prizeDao.getPrizeById(id);
    }

    public Prize addPrize(Prize prize, Integer familyId) {
         Prize savedPrize = prizeDao.addPrize(prize);
         prizeDao.addPrizeToFamily(savedPrize.getPrizeId(), familyId);
         return savedPrize;
    }

    public boolean editPrize(Prize prize) {
        return prizeDao.editPrize(prize);
    }

    public boolean removePrize(Integer prizeId, Integer familyId) {
        return prizeDao.removePrize(prizeId, familyId);
    }




}
