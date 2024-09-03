package com.PartnersFunds.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Date;

public class UserDTO {

    @JsonProperty("USER_ID")
    private Long userId;

    @JsonProperty("USER_NAME")
    private String userName;

    @JsonProperty("FIRST_NAME")
    private String firstName;

    @JsonProperty("MIDDLE_NAME")
    private String middleName;

    @JsonProperty("LAST_NAME")
    private String lastName;

    @JsonProperty("START_DATE")
    private Date startDate;

    @JsonProperty("END_DATE")
    private Date endDate;

    @JsonProperty("EMAIL_ADDRESS")
    private String emailAddress;

    @JsonProperty("PASSWORD")
    private String password;

    @JsonProperty("LAST_LOGIN_DATE")
    private Date lastLoginDate;

    @JsonProperty("PASSWORD_CHANGED_DATE")
    private Date passwordChangedDate;

    @JsonProperty("CISCO_CEC_ID")
    private String ciscoCecId;

    @JsonProperty("PROFILE_IMAGE")
    private String profileImage; // Base64-encoded string for the BLOB

    @JsonProperty("ACTIVE_FLAG")
    private String activeFlag;
    
    

    @JsonProperty("CREATED_BY")
    private String createdBy;

    @JsonProperty("CREATION_DATE")
    private Date creationDate;

    @JsonProperty("LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @JsonProperty("LAST_UPDATE_DATE")
    private Date lastUpdateDate;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Date getPasswordChangedDate() {
		return passwordChangedDate;
	}

	public void setPasswordChangedDate(Date passwordChangedDate) {
		this.passwordChangedDate = passwordChangedDate;
	}

	public String getCiscoCecId() {
		return ciscoCecId;
	}

	public void setCiscoCecId(String ciscoCecId) {
		this.ciscoCecId = ciscoCecId;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
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

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
    
}