package com.PartnersFunds.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class ManageSubProgramsDTO {

    @JsonProperty("subProgramId")
    private Integer subProgramId;

    @JsonProperty("subProgramName")
    private String subProgramName;

    @JsonProperty("programId")
    private Integer programId;

    @JsonProperty("startDate")
    private Date startDate;

    @JsonProperty("endDate")
    private Date endDate;

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

	public Integer getSubProgramId() {
		return subProgramId;
	}

	public void setSubProgramId(Integer subProgramId) {
		this.subProgramId = subProgramId;
	}

	public String getSubProgramName() {
		return subProgramName;
	}

	public void setSubProgramName(String subProgramName) {
		this.subProgramName = subProgramName;
	}

	public Integer getProgramId() {
		return programId;
	}

	public void setProgramId(Integer programId) {
		this.programId = programId;
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
		return "ManageSubProgramsDTO [subProgramId=" + subProgramId + ", subProgramName=" + subProgramName
				+ ", programId=" + programId + ", startDate=" + startDate + ", endDate=" + endDate + ", fundManager="
				+ fundManager + ", fundOperations=" + fundOperations + ", fundFinance=" + fundFinance
				+ ", allocationStatus=" + allocationStatus + ", approver=" + approver + ", approvalDate=" + approvalDate
				+ ", approvalNotes=" + approvalNotes + ", userId=" + userId + "]";
	}
	
}
