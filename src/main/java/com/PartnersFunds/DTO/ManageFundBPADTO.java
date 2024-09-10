package com.PartnersFunds.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class ManageFundBPADTO {

    @JsonProperty("fundBpaId")
    private Integer fundBpaId; // BPA ID for update/delete

    @JsonProperty("fundId")
    private Integer fundId;  // Fund ID (required for update and delete)

    @JsonProperty("fundName")
    private String fundName;  // Fund name

    @JsonProperty("bpaUsageLevel")
    private String bpaUsageLevel;  // BPA usage level

    @JsonProperty("bpaName")
    private String bpaName;  // BPA name

    @JsonProperty("bpaDescription")
    private String bpaDescription;  // BPA description

    @JsonProperty("bpaType")
    private String bpaType;  // BPA type

    @JsonProperty("startDate")
    private Date startDate;  // BPA start date

    @JsonProperty("endDate")
    private Date endDate;  // BPA end date

    @JsonProperty("activeFlag")
    private String activeFlag;  // Active flag (Y/N)

    @JsonProperty("userId")
    private Integer userId;  // ID of the user performing the action

    @JsonProperty("action")
    private String action;  // Action type: DELETE/INSERT

    @Override
    public String toString() {
        return "UpsertFundBpaDTO [fundBpaId=" + fundBpaId + ", fundId=" + fundId + ", fundName=" + fundName + ", bpaUsageLevel=" + bpaUsageLevel +
                ", bpaName=" + bpaName + ", bpaDescription=" + bpaDescription + ", bpaType=" + bpaType +
                ", startDate=" + startDate + ", endDate=" + endDate + ", activeFlag=" + activeFlag + 
                ", userId=" + userId + ", action=" + action + "]";
    }

    // Getters and Setters
    public Integer getFundBpaId() {
        return fundBpaId;
    }

    public void setFundBpaId(Integer fundBpaId) {
        this.fundBpaId = fundBpaId;
    }

    public Integer getFundId() {
        return fundId;
    }

    public void setFundId(Integer fundId) {
        this.fundId = fundId;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getBpaUsageLevel() {
        return bpaUsageLevel;
    }

    public void setBpaUsageLevel(String bpaUsageLevel) {
        this.bpaUsageLevel = bpaUsageLevel;
    }

    public String getBpaName() {
        return bpaName;
    }

    public void setBpaName(String bpaName) {
        this.bpaName = bpaName;
    }

    public String getBpaDescription() {
        return bpaDescription;
    }

    public void setBpaDescription(String bpaDescription) {
        this.bpaDescription = bpaDescription;
    }

    public String getBpaType() {
        return bpaType;
    }

    public void setBpaType(String bpaType) {
        this.bpaType = bpaType;
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

    public String getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(String activeFlag) {
        this.activeFlag = activeFlag;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}