package com.partnersFunds.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class ManageFundProgramsDTO {

    @JsonProperty("programId")
    private Integer programId;

    @JsonProperty("programName")
    private String programName;

    @JsonProperty("fundId")
    private Integer fundId;

    @JsonProperty("startDate")
    private Date startDate;

    @JsonProperty("endDate")
    private Date endDate;

    @JsonProperty("region")
    private String region;

    @JsonProperty("theater")
    private String theater;

    @JsonProperty("country")
    private String country;

    @JsonProperty("fundManager")
    private String fundManager;

    @JsonProperty("fundOperations")
    private String fundOperations;

    @JsonProperty("fundFinance")
    private String fundFinance;

    @JsonProperty("allocationStatus")
    private String allocationStatus;

    @JsonProperty("approver")
    private String approver;

    @JsonProperty("approvalDate")
    private Date approvalDate;

    @JsonProperty("approvalNotes")
    private String approvalNotes;

    @JsonProperty("userId")
    private Integer userId;

	public Integer getProgramId() {
		return programId;
	}

	public void setProgramId(Integer programId) {
		this.programId = programId;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public Integer getFundId() {
		return fundId;
	}

	public void setFundId(Integer fundId) {
		this.fundId = fundId;
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

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getTheater() {
		return theater;
	}

	public void setTheater(String theater) {
		this.theater = theater;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFundManager() {
		return fundManager;
	}

	public void setFundManager(String fundManager) {
		this.fundManager = fundManager;
	}

	public String getFundOperations() {
		return fundOperations;
	}

	public void setFundOperations(String fundOperations) {
		this.fundOperations = fundOperations;
	}

	public String getFundFinance() {
		return fundFinance;
	}

	public void setFundFinance(String fundFinance) {
		this.fundFinance = fundFinance;
	}

	public String getAllocationStatus() {
		return allocationStatus;
	}

	public void setAllocationStatus(String allocationStatus) {
		this.allocationStatus = allocationStatus;
	}

	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

	public Date getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}

	public String getApprovalNotes() {
		return approvalNotes;
	}

	public void setApprovalNotes(String approvalNotes) {
		this.approvalNotes = approvalNotes;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "ManageFundProgramsDTO [programId=" + programId + ", programName=" + programName + ", fundId=" + fundId
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", region=" + region + ", theater=" + theater
				+ ", country=" + country + ", fundManager=" + fundManager + ", fundOperations=" + fundOperations
				+ ", fundFinance=" + fundFinance + ", allocationStatus=" + allocationStatus + ", approver=" + approver
				+ ", approvalDate=" + approvalDate + ", approvalNotes=" + approvalNotes + ", userId=" + userId + "]";
	}
	
	

}
