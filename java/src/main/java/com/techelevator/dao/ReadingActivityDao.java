package com.techelevator.dao;

import com.techelevator.model.ReadingActivity;
import com.techelevator.model.ReadingActivity;

public interface ReadingActivityDao {

    void createActivity(ReadingActivity readingActivity);

//    void updateActivity (ReadingActivity readingActivity);

    ReadingActivity getActivityById (int activityId);

//    void deleteActivity (int id);


}
