package com.techelevator.services;

import com.techelevator.dao.ReaderDao;

import org.springframework.stereotype.Service;

@Service
public class ReaderService {

    private ReaderDao readerDao;

    public ReaderService(ReaderDao readerDao) {
        this.readerDao = readerDao;
    }


    public int getReadingBankById(int userId) {
        return readerDao.getReadingBankById(userId);
    }

    public String getFamilyRoleById(int userId) {
        return readerDao.getFamilyRoleById(userId);
    }


}
