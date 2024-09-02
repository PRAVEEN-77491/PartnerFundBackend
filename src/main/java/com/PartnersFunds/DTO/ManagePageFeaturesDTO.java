package com.PartnersFunds.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class ManagePageFeaturesDTO {

    @JsonProperty("featureId")
    private Integer featureId;
    
    @JsonProperty("pageId")
    private Integer pageId;
    
    @JsonProperty("featureName")
    private String featureName;
    
    @JsonProperty("featureType")
    private String featureType;
    
    @JsonProperty("displayName")
    private String displayName;
    
    @JsonProperty("propertyTag")
    private String propertyTag;
    
    @JsonProperty("createdBy")
    private Integer createdBy;
    
    @JsonProperty("creationDate")
    private Date creationDate;
    
    @JsonProperty("lastUpdatedBy")
    private Integer lastUpdatedBy;
    
    @JsonProperty("lastUpdateDate")
    private Date lastUpdateDate;
    
	@JsonProperty("userId")
	private Integer userId;

    // Getters and Setters

    public Integer getFeatureId() {
        return featureId;
    }

    public void setFeatureId(Integer featureId) {
        this.featureId = featureId;
    }

    public Integer getPageId() {
        return pageId;
    }

    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getFeatureType() {
        return featureType;
    }

    public void setFeatureType(String featureType) {
        this.featureType = featureType;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPropertyTag() {
        return propertyTag;
    }

    public void setPropertyTag(String propertyTag) {
        this.propertyTag = propertyTag;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Integer lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
