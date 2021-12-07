package com.techelevator.model;

//This class holds data for Reading Projects to be retrieved via DAO
public class ReadingProject {
    int projectId;
    int userId;
    String ISBN;
    String format;
    int timeRead;
    int prizeId;

    public ReadingProject(int projectId, int userId, String ISBN, String format, int timeRead, int prizeId) {
        this.projectId = projectId;
        this.userId = userId;
        this.ISBN = ISBN;
        this.format = format;
        this.timeRead = timeRead;
        this.prizeId = prizeId;
    }

    public int getProjectId() {
        return projectId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
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

    public int getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(int prizeId) {
        this.prizeId = prizeId;
    }
}
