package com.PartnersFunds.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class ManageActivitiesDTO {

    @JsonProperty("activityId")
    private Integer activityId;

    @JsonProperty("activityName")
    private String activityName;

    @JsonProperty("planId")
    private Integer planId;

    @JsonProperty("stage")
    private String stage;

    @JsonProperty("activityGroup")
    private String activityGroup;

    @JsonProperty("activityDescription")
    private String activityDescription;

    @JsonProperty("subTrack")
    private String subTrack;

    @JsonProperty("track")
    private String track;

    @JsonProperty("activityStartDate")
    private Date activityStartDate;

    @JsonProperty("activityEndDate")
    private Date activityEndDate;

    @JsonProperty("activityExpirationDate")
    private Date activityExpirationDate;

    @JsonProperty("activityRequestedAmount")
    private Integer activityRequestedAmount;

    @JsonProperty("activityRequestedAmountCurrency")
    private String activityRequestedAmountCurrency;

    @JsonProperty("activityMetrics")
    private String activityMetrics;

    @JsonProperty("activityTarget")
    private Integer activityTarget;

    @JsonProperty("activityResultsSubmitted")
    private Integer activityResultsSubmitted;

    @JsonProperty("fundingQuarter")
    private String fundingQuarter;

    @JsonProperty("ciscoFundingQuarter")
    private String ciscoFundingQuarter;

    @JsonProperty("activityStartFiscalQuarter")
    private String activityStartFiscalQuarter;

    @JsonProperty("activityType")
    private String activityType;

    @JsonProperty("distributorUniqueId")
    private String distributorUniqueId;

    @JsonProperty("initiative")
    private String initiative;

    @JsonProperty("fundShell")
    private String fundShell;

    @JsonProperty("milestoneName")
    private String milestoneName;

    @JsonProperty("achievement")
    private String achievement;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("achievementPercent")
    private Integer achievementPercent;

    @JsonProperty("slidingScalePercent")
    private Integer slidingScalePercent;

    @JsonProperty("claimSubmissionDeadline")
    private Date claimSubmissionDeadline;

    @JsonProperty("activitySubmissionDeadline")
    private Date activitySubmissionDeadline;

    @JsonProperty("activityExecutionDeadline")
    private Date activityExecutionDeadline;

    @JsonProperty("claimSubmitDate")
    private Date claimSubmitDate;

    @JsonProperty("activitySubmitDate")
    private Date activitySubmitDate;

    @JsonProperty("activityExecutionDate")
    private Date activityExecutionDate;

    @JsonProperty("tcAccepted")
    private String tcAccepted;

    @JsonProperty("wsActivityId")
    private String wsActivityId;

    @JsonProperty("userId")
    private Integer userId;

    @JsonProperty("status")
    private String status;

    @JsonProperty("message")
    private String message;

    // Getters and Setters
    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getActivityGroup() {
        return activityGroup;
    }

    public void setActivityGroup(String activityGroup) {
        this.activityGroup = activityGroup;
    }

    public String getActivityDescription() {
        return activityDescription;
    }

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }

    public String getSubTrack() {
        return subTrack;
    }

    public void setSubTrack(String subTrack) {
        this.subTrack = subTrack;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public Date getActivityStartDate() {
        return activityStartDate;
    }

    public void setActivityStartDate(Date activityStartDate) {
        this.activityStartDate = activityStartDate;
    }

    public Date getActivityEndDate() {
        return activityEndDate;
    }

    public void setActivityEndDate(Date activityEndDate) {
        this.activityEndDate = activityEndDate;
    }

    public Date getActivityExpirationDate() {
        return activityExpirationDate;
    }

    public void setActivityExpirationDate(Date activityExpirationDate) {
        this.activityExpirationDate = activityExpirationDate;
    }

    public Integer getActivityRequestedAmount() {
        return activityRequestedAmount;
    }

    public void setActivityRequestedAmount(Integer activityRequestedAmount) {
        this.activityRequestedAmount = activityRequestedAmount;
    }

    public String getActivityRequestedAmountCurrency() {
        return activityRequestedAmountCurrency;
    }

    public void setActivityRequestedAmountCurrency(String activityRequestedAmountCurrency) {
        this.activityRequestedAmountCurrency = activityRequestedAmountCurrency;
    }

    public String getActivityMetrics() {
        return activityMetrics;
    }

    public void setActivityMetrics(String activityMetrics) {
        this.activityMetrics = activityMetrics;
    }

    public Integer getActivityTarget() {
        return activityTarget;
    }

    public void setActivityTarget(Integer activityTarget) {
        this.activityTarget = activityTarget;
    }

    public Integer getActivityResultsSubmitted() {
        return activityResultsSubmitted;
    }

    public void setActivityResultsSubmitted(Integer activityResultsSubmitted) {
        this.activityResultsSubmitted = activityResultsSubmitted;
    }

    public String getFundingQuarter() {
        return fundingQuarter;
    }

    public void setFundingQuarter(String fundingQuarter) {
        this.fundingQuarter = fundingQuarter;
    }

    public String getCiscoFundingQuarter() {
        return ciscoFundingQuarter;
    }

    public void setCiscoFundingQuarter(String ciscoFundingQuarter) {
        this.ciscoFundingQuarter = ciscoFundingQuarter;
    }

    public String getActivityStartFiscalQuarter() {
        return activityStartFiscalQuarter;
    }

    public void setActivityStartFiscalQuarter(String activityStartFiscalQuarter) {
        this.activityStartFiscalQuarter = activityStartFiscalQuarter;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getDistributorUniqueId() {
        return distributorUniqueId;
    }

    public void setDistributorUniqueId(String distributorUniqueId) {
        this.distributorUniqueId = distributorUniqueId;
    }

    public String getInitiative() {
        return initiative;
    }

    public void setInitiative(String initiative) {
        this.initiative = initiative;
    }

    public String getFundShell() {
        return fundShell;
    }

    public void setFundShell(String fundShell) {
        this.fundShell = fundShell;
    }

    public String getMilestoneName() {
        return milestoneName;
    }

    public void setMilestoneName(String milestoneName) {
        this.milestoneName = milestoneName;
    }

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getAchievementPercent() {
        return achievementPercent;
    }

    public void setAchievementPercent(Integer achievementPercent) {
        this.achievementPercent = achievementPercent;
    }

    public Integer getSlidingScalePercent() {
        return slidingScalePercent;
    }

    public void setSlidingScalePercent(Integer slidingScalePercent) {
        this.slidingScalePercent = slidingScalePercent;
    }

    public Date getClaimSubmissionDeadline() {
        return claimSubmissionDeadline;
    }

    public void setClaimSubmissionDeadline(Date claimSubmissionDeadline) {
        this.claimSubmissionDeadline = claimSubmissionDeadline;
    }

    public Date getActivitySubmissionDeadline() {
        return activitySubmissionDeadline;
    }

    public void setActivitySubmissionDeadline(Date activitySubmissionDeadline) {
        this.activitySubmissionDeadline = activitySubmissionDeadline;
    }

    public Date getActivityExecutionDeadline() {
        return activityExecutionDeadline;
    }

    public void setActivityExecutionDeadline(Date activityExecutionDeadline) {
        this.activityExecutionDeadline = activityExecutionDeadline;
    }

    public Date getClaimSubmitDate() {
        return claimSubmitDate;
    }

    public void setClaimSubmitDate(Date claimSubmitDate) {
        this.claimSubmitDate = claimSubmitDate;
    }

    public Date getActivitySubmitDate() {
        return activitySubmitDate;
    }

    public void setActivitySubmitDate(Date activitySubmitDate) {
        this.activitySubmitDate = activitySubmitDate;
    }

    public Date getActivityExecutionDate() {
        return activityExecutionDate;
    }

    public void setActivityExecutionDate(Date activityExecutionDate) {
        this.activityExecutionDate = activityExecutionDate;
    }

    public String getTcAccepted() {
        return tcAccepted;
    }

    public void setTcAccepted(String tcAccepted) {
        this.tcAccepted = tcAccepted;
    }

    public String getWsActivityId() {
        return wsActivityId;
    }

    public void setWsActivityId(String wsActivityId) {
        this.wsActivityId = wsActivityId;
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
