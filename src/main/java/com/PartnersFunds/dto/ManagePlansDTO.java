package com.partnersFunds.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ManagePlansDTO {

    @JsonProperty("planId")
    private Integer planId;

    @JsonProperty("planName")
    private String planName;

    @JsonProperty("fundId")
    private Integer fundId;

    @JsonProperty("partnershipId")
    private Integer partnershipId;

    @JsonProperty("region")
    private String region;

    @JsonProperty("theater")
    private String theater;

    @JsonProperty("fiscalYear")
    private Integer fiscalYear;

    @JsonProperty("distributorIdPlan")
    private String distributorIdPlan;

    @JsonProperty("planStage")
    private String planStage;

    @JsonProperty("planDistributorPayeeCountry")
    private String planDistributorPayeeCountry;

    @JsonProperty("distributorPayeeCountry")
    private String distributorPayeeCountry;

    @JsonProperty("wsPlanToken")
    private String wsPlanToken;

    @JsonProperty("userId")
    private Integer userId;

    @JsonProperty("status")
    private String status;

    @JsonProperty("message")
    private String message;

    // Getters and Setters
    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public Integer getFundId() {
        return fundId;
    }

    public void setFundId(Integer fundId) {
        this.fundId = fundId;
    }

    public Integer getPartnershipId() {
        return partnershipId;
    }

    public void setPartnershipId(Integer partnershipId) {
        this.partnershipId = partnershipId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTheater() {
        return theater;
    }

    public void setTheater(String theater) {
        this.theater = theater;
    }

    public Integer getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(Integer fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public String getDistributorIdPlan() {
        return distributorIdPlan;
    }

    public void setDistributorIdPlan(String distributorIdPlan) {
        this.distributorIdPlan = distributorIdPlan;
    }

    public String getPlanStage() {
        return planStage;
    }

    public void setPlanStage(String planStage) {
        this.planStage = planStage;
    }

    public String getPlanDistributorPayeeCountry() {
        return planDistributorPayeeCountry;
    }

    public void setPlanDistributorPayeeCountry(String planDistributorPayeeCountry) {
        this.planDistributorPayeeCountry = planDistributorPayeeCountry;
    }

    public String getDistributorPayeeCountry() {
        return distributorPayeeCountry;
    }

    public void setDistributorPayeeCountry(String distributorPayeeCountry) {
        this.distributorPayeeCountry = distributorPayeeCountry;
    }

    public String getWsPlanToken() {
        return wsPlanToken;
    }

    public void setWsPlanToken(String wsPlanToken) {
        this.wsPlanToken = wsPlanToken;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
