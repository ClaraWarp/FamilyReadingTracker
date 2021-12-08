package com.techelevator.services;


import com.techelevator.dao.ReadingActivityDao;

import com.techelevator.model.ReadingActivity;
import org.springframework.stereotype.Service;


@Service
public class ReadingActivityService {

    private ReadingActivityDao readingActivityDao;

    public void createActivity(ReadingActivity readingActivity) { readingActivityDao.createActivity(readingActivity);};

    public ReadingActivity getActivityById (int activityId) {
        return readingActivityDao.getActivityById(activityId);
    }
}
