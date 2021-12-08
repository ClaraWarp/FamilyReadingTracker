package com.techelevator.model;

//This class stores information about a family, a group of users that share reading goals and progress.
public class Family {
    int familyId;
    String name;

    public Family() {}

    public Family(int familyId, String name) {
        this.familyId = familyId;
        this.name = name;
    }

    public int getFamilyId() {
        return familyId;
    }

    public String getName() {
        return name;
    }

    public void setFamilyId(int familyId) {
        this.familyId = familyId;
    }

    public void setName(String name) {
        this.name = name;
    }
}
