package com.partnersFunds.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ManagePartnershipReferencesDTO {

    @JsonProperty("referenceId")
    private Integer referenceId;

    @JsonProperty("partnershipId")
    private Integer partnershipId;

    @JsonProperty("referenceType")
    private String referenceType;

    @JsonProperty("referenceKey")
    private String referenceKey;

    @JsonProperty("userId")
    private Integer userId;

    // Getters and Setters
    public Integer getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Integer referenceId) {
        this.referenceId = referenceId;
    }

    public Integer getPartnershipId() {
        return partnershipId;
    }

    public void setPartnershipId(Integer partnershipId) {
        this.partnershipId = partnershipId;
    }

    public String getReferenceType() {
        return referenceType;
    }

    public void setReferenceType(String referenceType) {
        this.referenceType = referenceType;
    }

    public String getReferenceKey() {
        return referenceKey;
    }

    public void setReferenceKey(String referenceKey) {
        this.referenceKey = referenceKey;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
