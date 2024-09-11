package com.partnersFunds.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ManagePartnerPlansAllocationsDTO {

    @JsonProperty("planAllocationId")
    private Integer planAllocationId;

    @JsonProperty("partnerPlanId")
    private Integer partnerPlanId;

    @JsonProperty("intervalName")
    private String intervalName;

    @JsonProperty("amount")
    private Double amount;

    @JsonProperty("userId")
    private Integer userId;

    public Integer getPlanAllocationId() {
        return planAllocationId;
    }

    public void setPlanAllocationId(Integer planAllocationId) {
        this.planAllocationId = planAllocationId;
    }

    public Integer getPartnerPlanId() {
        return partnerPlanId;
    }

    public void setPartnerPlanId(Integer partnerPlanId) {
        this.partnerPlanId = partnerPlanId;
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
}
