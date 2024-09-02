package com.PartnersFunds.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ManagePageRuleSetAttrDTO {

    @JsonProperty("setAttributeId")
    private Integer setAttributeId;

    @JsonProperty("featureId")
    private Integer featureId;

    @JsonProperty("featureValue")
    private String featureValue;

    @JsonProperty("userId")
    private Integer userId;

    @JsonProperty("status")
    private String status;

    @JsonProperty("message")
    private String message;

    // Getters and Setters
    public Integer getSetAttributeId() {
        return setAttributeId;
    }

    public void setSetAttributeId(Integer setAttributeId) {
        this.setAttributeId = setAttributeId;
    }

    public Integer getFeatureId() {
        return featureId;
    }

    public void setFeatureId(Integer featureId) {
        this.featureId = featureId;
    }

    public String getFeatureValue() {
        return featureValue;
    }

    public void setFeatureValue(String featureValue) {
        this.featureValue = featureValue;
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
