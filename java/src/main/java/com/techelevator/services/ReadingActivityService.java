package com.techelevator.services;


import com.techelevator.dao.BookDao;
import com.techelevator.dao.ReadingActivityDao;

import com.techelevator.model.ReadingActivity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReadingActivityService {

    private ReadingActivityDao readingActivityDao;
    private BookDao bookDao;

    public ReadingActivityService(ReadingActivityDao readingActivityDao, BookDao bookDao) {
        this.readingActivityDao = readingActivityDao;
        this.bookDao = bookDao;
    }

    public void addActivity(ReadingActivity readingActivity) {
        readingActivityDao.addActivity(readingActivity);};

    public ReadingActivity getActivityByUserId (int userId) {
        return readingActivityDao.getActivityByUserId(userId);
    }

    public List<ReadingActivity> getListOfActivitiesByUserId(int userId) {
        return readingActivityDao.getListOfActivitiesByUserId(userId);
    }
}
