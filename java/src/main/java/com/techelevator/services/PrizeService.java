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

    public Prize getPrizeById(Integer id) {
        return prizeDao.getPrizeById(id);
    }

    public boolean addPrize(Prize prize) {
        return prizeDao.addPrize(prize);
    }





}
