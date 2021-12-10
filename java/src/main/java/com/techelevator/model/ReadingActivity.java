package com.techelevator.model;

//This class holds data for Reading Projects to be retrieved via DAO
public class ReadingActivity {
    int activityId;
    int userId;
    String isbn;
    String format;
    int timeRead;

// add setter for activity ID

    public ReadingActivity(int activityId, int userId, String isbn, String format, int timeRead) {
        this.activityId = activityId;
        this.userId = userId;
        this.isbn = isbn;
        this.format = format;
        this.timeRead = timeRead;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getTimeRead() {
        return timeRead;
    }

    public void setTimeRead(int timeRead) {
        this.timeRead = timeRead;
    }
}
