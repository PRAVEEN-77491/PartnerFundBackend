package com.PartnersFunds.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ManagePageRulesDTO {

    @JsonProperty("pageRuleId")
    private Integer pageRuleId;

    @JsonProperty("pageId")
    private Integer pageId;

    @JsonProperty("featureId")
    private Integer featureId;

    @JsonProperty("actionType")
    private String actionType;

    @JsonProperty("userMessage")
    private String userMessage;

    @JsonProperty("userId")
    private Integer userId;

    @JsonProperty("status")
    private String status;

    @JsonProperty("message")
    private String message;

    // Getters and Setters
    public Integer getPageRuleId() {
        return pageRuleId;
    }

    public void setPageRuleId(Integer pageRuleId) {
        this.pageRuleId = pageRuleId;
    }

    public Integer getPageId() {
        return pageId;
    }

    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }

    public Integer getFeatureId() {
        return featureId;
    }

    public void setFeatureId(Integer featureId) {
        this.featureId = featureId;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
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
