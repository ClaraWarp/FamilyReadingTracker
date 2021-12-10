package com.techelevator.dao;

import com.techelevator.model.ReadingActivity;
import com.techelevator.model.ReadingActivity;

public interface ReadingActivityDao {

    void addActivity(ReadingActivity readingActivity);

//    void updateActivity (ReadingActivity readingActivity);

    ReadingActivity getActivityByUserId (int userId);

//    void deleteActivity (int id);


}
