package com.techelevator.model;

//This class stores information about a family, a group of users that share reading goals and progress.
public class Family {
    int familyId;
    String familyName;

    public Family() {}

    public Family(int familyId, String familyName) {
        this.familyId = familyId;
        this.familyName = familyName;
    }

    public int getFamilyId() {
        return familyId;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyId(int familyId) {
        this.familyId = familyId;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }
}
