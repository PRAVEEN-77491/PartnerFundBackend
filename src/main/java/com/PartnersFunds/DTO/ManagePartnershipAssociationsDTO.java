package com.PartnersFunds.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ManagePartnershipAssociationsDTO {

    @JsonProperty("associationId")
    private Integer associationId;
    
    @JsonProperty("partnershipId")
    private Integer partnershipId;
    
    @JsonProperty("referenceType")
    private String referenceType;
    
    @JsonProperty("referenceKey")
    private String referenceKey;
    
    @JsonProperty("userId")
    private Integer userId;

    public Integer getAssociationId() {
        return associationId;
    }

    public void setAssociationId(Integer associationId) {
        this.associationId = associationId;
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

    @Override
    public String toString() {
        return "ManagePartnershipAssociationsDTO{" +
                "associationId=" + associationId +
                ", partnershipId=" + partnershipId +
                ", referenceType='" + referenceType + '\'' +
                ", referenceKey='" + referenceKey + '\'' +
                ", userId=" + userId +
                '}';
    }
}
