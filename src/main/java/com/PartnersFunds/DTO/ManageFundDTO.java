package com.PartnersFunds.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ManageFundDTO {

    @JsonProperty("fund_id")
    private Integer fundId;

    @JsonProperty("fundname")
    private String fundName;

    @JsonProperty("description")
    private String description;

    @JsonProperty("active")
    private String activeFlag;

    @JsonProperty("createdBy")
    private String createdBy;

    @JsonProperty("creationDate")
    private String creationDate; 

    @JsonProperty("lastUpdatedBy")
    private String lastUpdatedBy;

    @JsonProperty("lastUpdateDate")
    private String lastUpdateDate; 
    
	@JsonProperty("userId")
	private Integer userId;

    // Getters and Setters

    public Integer getFundId() {
        return fundId;
    }

    public void setFundId(Integer fundId) {
        this.fundId = fundId;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(String activeFlag) {
        this.activeFlag = activeFlag;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "ManageFundDTO [fundId=" + fundId + ", fundName=" + fundName + ", description=" + description
				+ ", activeFlag=" + activeFlag + ", createdBy=" + createdBy + ", creationDate=" + creationDate
				+ ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdateDate=" + lastUpdateDate + ", userId=" + userId
				+ "]";
	}
    
}
