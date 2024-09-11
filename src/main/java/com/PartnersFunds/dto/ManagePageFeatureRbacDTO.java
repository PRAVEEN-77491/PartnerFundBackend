package com.partnersFunds.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ManagePageFeatureRbacDTO {

    @JsonProperty("rbacFeatureId")
    private Integer rbacFeatureId;

    @JsonProperty("fundBpaId")
    private Integer fundBpaId;

    @JsonProperty("pageId")
    private Integer pageId;

    @JsonProperty("featureId")
    private Integer featureId;

    @JsonProperty("readFlag")
    private String readFlag;

    @JsonProperty("writeFlag")
    private String writeFlag;

    @JsonProperty("userId")
    private Integer userId;

    @JsonProperty("status")
    private String status;

    @JsonProperty("message")
    private String message;

    // Getters and Setters
    public Integer getRbacFeatureId() {
        return rbacFeatureId;
    }

    public void setRbacFeatureId(Integer rbacFeatureId) {
        this.rbacFeatureId = rbacFeatureId;
    }

    public Integer getFundBpaId() {
        return fundBpaId;
    }

    public void setFundBpaId(Integer fundBpaId) {
        this.fundBpaId = fundBpaId;
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

    public String getReadFlag() {
        return readFlag;
    }

    public void setReadFlag(String readFlag) {
        this.readFlag = readFlag;
    }

    public String getWriteFlag() {
        return writeFlag;
    }

    public void setWriteFlag(String writeFlag) {
        this.writeFlag = writeFlag;
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
