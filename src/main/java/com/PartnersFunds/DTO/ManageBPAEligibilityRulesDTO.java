package com.PartnersFunds.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ManageBPAEligibilityRulesDTO {

    @JsonProperty("bpaEligibRuleId")
    private Integer bpaEligibRuleId;  // BPA Eligibility Rule ID

    @JsonProperty("fundBpaId")
    private Integer fundBpaId;  // Fund BPA ID (mandatory)

    @JsonProperty("sequence")
    private Integer sequence;  // Sequence (mandatory)

    @JsonProperty("groupLogicalOperator")
    private String groupLogicalOperator;  // Group Logical Operator

    @JsonProperty("groupSeparator")
    private String groupSeparator;  // Group Separator

    @JsonProperty("tableName")
    private String tableName;  // Table name

    @JsonProperty("attributeName")
    private String attributeName;  // Attribute name

    @JsonProperty("operator")
    private String operator;  // Operator

    @JsonProperty("value")
    private String value;  // Value

    @JsonProperty("conditionLogicalOperator")
    private String conditionLogicalOperator;  // Condition Logical Operator

    @JsonProperty("userId")
    private Integer userId;  // ID of the user performing the action

    @JsonProperty("action")
    private String action;  // Action type (INSERT/UPDATE/DELETE)

    @Override
    public String toString() {
        return "ManageBpaEligibilityRulesDTO [bpaEligibRuleId=" + bpaEligibRuleId + ", fundBpaId=" + fundBpaId + 
                ", sequence=" + sequence + ", groupLogicalOperator=" + groupLogicalOperator + ", groupSeparator=" + groupSeparator + 
                ", tableName=" + tableName + ", attributeName=" + attributeName + ", operator=" + operator + 
                ", value=" + value + ", conditionLogicalOperator=" + conditionLogicalOperator + 
                ", userId=" + userId + ", action=" + action + "]";
    }

    // Getters and Setters
    public Integer getBpaEligibRuleId() {
        return bpaEligibRuleId;
    }

    public void setBpaEligibRuleId(Integer bpaEligibRuleId) {
        this.bpaEligibRuleId = bpaEligibRuleId;
    }

    public Integer getFundBpaId() {
        return fundBpaId;
    }

    public void setFundBpaId(Integer fundBpaId) {
        this.fundBpaId = fundBpaId;
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

    public String getGroupSeparator() {
        return groupSeparator;
    }

    public void setGroupSeparator(String groupSeparator) {
        this.groupSeparator = groupSeparator;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}