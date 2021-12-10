package com.techelevator.model;

//This class holds the the data for a user. It is separate from the User class which handles security.
//This is how information is stored as an object post login.

public class Reader {

    private int userId;
    private int familyId;
    private boolean isAdmin;
    private boolean isParent;
    private int readingBank;

    public Reader(int userId, int familyId, boolean isAdmin, boolean isParent) {
        this.userId = userId;
        this.familyId = familyId;
        this.isAdmin = isAdmin;
        this.isParent = isParent;
        this.readingBank = 0;
    }

    public int getUserId() {
        return userId;
    }

    public int getFamilyId() {
        return familyId;
    }

    public void setFamilyId(int familyId) {
        this.familyId = familyId;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isParent() {
        return isParent;
    }

    public void setParent(boolean parent) {
        isParent = parent;
    }

    public int getReadingBank() { return readingBank;}

    public void addToReadingBank(int readingMinutes) {
        readingBank += readingMinutes;
    }

}
