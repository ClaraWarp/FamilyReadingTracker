package com.techelevator.model;

import java.util.Date;

public class Prize {

    private String name;
    private String description;
    private Integer milestone;
    private Integer maxPrize;
    private Date startDate;
    private Date endDate;

    public Prize(){}

    public Prize(String name, String description, Integer milestone, Integer maxPrize, Date startDate, Date endDate){
        this.name = name;
        this.description = description;
        this.milestone = milestone;
        this.maxPrize = maxPrize;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMilestone() {
        return milestone;
    }

    public void setMilestone(Integer milestone) {
        this.milestone = milestone;
    }

    public Integer getMaxPrize() {
        return maxPrize;
    }

    public void setMaxPrize(Integer maxPrize) {
        this.maxPrize = maxPrize;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
