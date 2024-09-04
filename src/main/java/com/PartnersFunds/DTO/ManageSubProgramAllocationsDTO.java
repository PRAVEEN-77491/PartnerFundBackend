package com.PartnersFunds.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ManageSubProgramAllocationsDTO {

    @JsonProperty("subprogramAllocationId")
    private Integer subprogramAllocationId;

    @JsonProperty("subProgramId")
    private Integer subProgramId;

    @JsonProperty("intervalName")
    private String intervalName;

    @JsonProperty("amount")
    private Double amount;

    @JsonProperty("userId")
    private Integer userId;

	public Integer getSubprogramAllocationId() {
		return subprogramAllocationId;
	}

	public void setSubprogramAllocationId(Integer subprogramAllocationId) {
		this.subprogramAllocationId = subprogramAllocationId;
	}

	public Integer getSubProgramId() {
		return subProgramId;
	}

	public void setSubProgramId(Integer subProgramId) {
		this.subProgramId = subProgramId;
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
		return "ManageSubProgramAllocationsDTO [subprogramAllocationId=" + subprogramAllocationId + ", subProgramId="
				+ subProgramId + ", intervalName=" + intervalName + ", amount=" + amount + ", userId=" + userId + "]";
	}

}
