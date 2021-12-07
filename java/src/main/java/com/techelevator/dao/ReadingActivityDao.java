package com.techelevator.dao;

import com.techelevator.model.ReadingActivity;
import com.techelevator.model.ReadingActivity;

public interface ReadingActivityDao {


    void createActivity (int activityId, int userId, String isbn, String format, int timeRead);

    ReadingActivity getActivityById (int projectId);


}
