package com.PartnersFunds.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ManagePartnershipsDTO {

    @JsonProperty("partnershipId")
    private Integer partnershipId;

    @JsonProperty("partnershipName")
    private String partnershipName;

    @JsonProperty("userId")
    private Integer userId;

    // Getters and Setters
    public Integer getPartnershipId() {
        return partnershipId;
    }

    public void setPartnershipId(Integer partnershipId) {
        this.partnershipId = partnershipId;
    }

    public String getPartnershipName() {
        return partnershipName;
    }

    public void setPartnershipName(String partnershipName) {
        this.partnershipName = partnershipName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
