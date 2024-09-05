package com.PartnersFunds.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ManagePartnerPlansDTO {

    @JsonProperty("partnerPlanId")
    private Integer partnerPlanId;

    @JsonProperty("referenceType")
    private String referenceType;

    @JsonProperty("referenceKey")
    private Integer referenceKey;

    @JsonProperty("planName")
    private String planName;

    @JsonProperty("track")
    private String track;

    @JsonProperty("partnershipId")
    private Integer partnershipId;

    @JsonProperty("planStage")
    private String planStage;

    @JsonProperty("wsPlanToken")
    private String wsPlanToken;

    @JsonProperty("userId")
    private Integer userId;

    // Getters and Setters

    public Integer getPartnerPlanId() {
        return partnerPlanId;
    }

    public void setPartnerPlanId(Integer partnerPlanId) {
        this.partnerPlanId = partnerPlanId;
    }

    public String getReferenceType() {
        return referenceType;
    }

    public void setReferenceType(String referenceType) {
        this.referenceType = referenceType;
    }

    public Integer getReferenceKey() {
        return referenceKey;
    }

    public void setReferenceKey(Integer referenceKey) {
        this.referenceKey = referenceKey;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public Integer getPartnershipId() {
        return partnershipId;
    }

    public void setPartnershipId(Integer partnershipId) {
        this.partnershipId = partnershipId;
    }

    public String getPlanStage() {
        return planStage;
    }

    public void setPlanStage(String planStage) {
        this.planStage = planStage;
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
}
