package com.techelevator.services;

import com.techelevator.dao.ReaderDao;
import com.techelevator.dao.UserDao;
import org.springframework.stereotype.Service;

@Service
public class ReaderService {

    private ReaderDao readerDao;

    public ReaderService(ReaderDao readerDao) {
        this.readerDao = readerDao;
    }


}
