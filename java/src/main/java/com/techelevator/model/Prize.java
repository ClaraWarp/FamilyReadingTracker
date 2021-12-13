package com.techelevator.model;

import java.util.Date;

//This class holds information about a prize. Prizes can be redeemed by a family or a single reader.

public class Prize {

    private Integer prizeId;
    private String name;
    private String description;
    private Integer timeRequirement;
    private Integer maxPrize;
    private Date startDate;
    private Date endDate;

    public Prize(){}

    public Prize(Integer prizeId, String name, String description, Integer timeRequirement, Integer maxPrize, Date startDate, Date endDate){
        this.prizeId = prizeId;
        this.name = name;
        this.description = description;
        this.timeRequirement = timeRequirement;
        this.maxPrize = maxPrize;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void setPrizeId(Integer prizeId) {
        this.prizeId = prizeId;
    }

    public Integer getPrizeId() {
        return prizeId;
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

    public Integer getTimeRequirement() {
        return timeRequirement;
    }

    public void setTimeRequirement(Integer timeRequirement) {
        this.timeRequirement = timeRequirement;
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
