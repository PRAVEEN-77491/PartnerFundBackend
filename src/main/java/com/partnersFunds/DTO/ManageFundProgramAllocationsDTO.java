package com.PartnersFunds.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ManageFundProgramAllocationsDTO {

    @JsonProperty("programAllocationId")
    private Integer programAllocationId;

    @JsonProperty("programId")
    private Integer programId;

    @JsonProperty("intervalName")
    private String intervalName;

    @JsonProperty("amount")
    private Double amount;

    @JsonProperty("userId")
    private Integer userId;

	public Integer getProgramAllocationId() {
		return programAllocationId;
	}

	public void setProgramAllocationId(Integer programAllocationId) {
		this.programAllocationId = programAllocationId;
	}

	public Integer getProgramId() {
		return programId;
	}

	public void setProgramId(Integer programId) {
		this.programId = programId;
	}

	public String getIntervalName() {
		return intervalName;
	}

	public void setIntervalName(String intervalName) {
		this.intervalName = intervalName;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "ManageFundProgramAllocationsDTO [programAllocationId=" + programAllocationId + ", programId="
				+ programId + ", intervalName=" + intervalName + ", amount=" + amount + ", userId=" + userId + "]";
	}
	
}
