package com.techelevator.dao;

import com.techelevator.model.ReadingActivity;
import com.techelevator.model.ReadingActivity;

import java.util.List;

public interface ReadingActivityDao {

    void addActivity(ReadingActivity readingActivity);

    ReadingActivity getActivityByUserId (int userId);

    List<ReadingActivity> getListOfActivitiesByUserId(int userId);

    //ReadingActivity getReadingActivityByBook(String isbn)

}
