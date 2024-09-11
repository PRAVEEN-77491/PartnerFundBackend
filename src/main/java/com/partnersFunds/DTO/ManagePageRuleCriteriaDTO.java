package com.PartnersFunds.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ManagePageRuleCriteriaDTO {

    @JsonProperty("criteriaId")
    private Integer criteriaId;

    @JsonProperty("pageRuleId")
    private Integer pageRuleId;

    @JsonProperty("sequence")
    private Integer sequence;

    @JsonProperty("groupLogicalOperator")
    private String groupLogicalOperator;

    @JsonProperty("groupSeperatorOpen")
    private String groupSeperatorOpen;

    @JsonProperty("featureId")
    private Integer featureId;

    @JsonProperty("operator")
    private String operator;

    @JsonProperty("conditionValue")
    private String conditionValue;

    @JsonProperty("groupSeperatorClose")
    private String groupSeperatorClose;

    @JsonProperty("conditionLogicalOperator")
    private String conditionLogicalOperator;

    @JsonProperty("userId")
    private Integer userId;

    @JsonProperty("status")
    private String status;

    @JsonProperty("message")
    private String message;

    // Getters and Setters
    public Integer getCriteriaId() {
        return criteriaId;
    }

    public void setCriteriaId(Integer criteriaId) {
        this.criteriaId = criteriaId;
    }

    public Integer getPageRuleId() {
        return pageRuleId;
    }

    public void setPageRuleId(Integer pageRuleId) {
        this.pageRuleId = pageRuleId;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getGroupLogicalOperator() {
        return groupLogicalOperator;
    }

    public void setGroupLogicalOperator(String groupLogicalOperator) {
        this.groupLogicalOperator = groupLogicalOperator;
    }

    public String getGroupSeperatorOpen() {
        return groupSeperatorOpen;
    }

    public void setGroupSeperatorOpen(String groupSeperatorOpen) {
        this.groupSeperatorOpen = groupSeperatorOpen;
    }

    public Integer getFeatureId() {
        return featureId;
    }

    public void setFeatureId(Integer featureId) {
        this.featureId = featureId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getConditionValue() {
        return conditionValue;
    }

    public void setConditionValue(String conditionValue) {
        this.conditionValue = conditionValue;
    }

    public String getGroupSeperatorClose() {
        return groupSeperatorClose;
    }

    public void setGroupSeperatorClose(String groupSeperatorClose) {
        this.groupSeperatorClose = groupSeperatorClose;
    }

    public String getConditionLogicalOperator() {
        return conditionLogicalOperator;
    }

    public void setConditionLogicalOperator(String conditionLogicalOperator) {
        this.conditionLogicalOperator = conditionLogicalOperator;
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
