package com.PartnersFunds.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ManagePartnershipContactsDTO {

    @JsonProperty("contactId")
    private Integer contactId;

    @JsonProperty("partnershipId")
    private Integer partnershipId;

    @JsonProperty("contactType")
    private String contactType;

    @JsonProperty("email")
    private String email;

    @JsonProperty("paymentContactFlag")
    private String paymentContactFlag;

    @JsonProperty("userId")
    private Integer userId;

    // Getters and Setters
    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public Integer getPartnershipId() {
        return partnershipId;
    }

    public void setPartnershipId(Integer partnershipId) {
        this.partnershipId = partnershipId;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPaymentContactFlag() {
        return paymentContactFlag;
    }

    public void setPaymentContactFlag(String paymentContactFlag) {
        this.paymentContactFlag = paymentContactFlag;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
