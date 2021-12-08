package com.techelevator.dao;

import com.techelevator.model.ReadingActivity;
import com.techelevator.model.ReadingActivity;

public interface ReadingActivityDao {

    void createActivity(ReadingActivity readingActivity);

    ReadingActivity getActivityById (int activityId);


}
