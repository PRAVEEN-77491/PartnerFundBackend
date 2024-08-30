package com.PartnersFunds.Entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "xxpf_activities")
public class ActivitiesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "xxpf_activities_s")
 	@SequenceGenerator(name = "xxpf_activities_s", sequenceName = "xxpf_activities_s", allocationSize = 1)
    @Column(name = "ACTIVITY_ID")
    private Integer activityId;

    @Column(name = "ACTIVITY_NAME")
    private String activityName;

    @Column(name = "PLAN_ID")
    private Integer planId;

    @Column(name = "STAGE")
    private String stage;

    @Column(name = "ACTIVITY_GROUP")
    private String activityGroup;

    @Column(name = "ACTIVITY_DESCRIPTION")
    private String activityDescription;

    @Column(name = "SUB_TRACK")
    private String subTrack;

    @Column(name = "TRACK")
    private String track;

    @Column(name = "ACTIVITY_START_DATE")
    @Temporal(TemporalType.DATE)
    private Date activityStartDate;

    @Column(name = "ACTIVITY_END_DATE")
    @Temporal(TemporalType.DATE)
    private Date activityEndDate;

    @Column(name = "ACTIVITY_EXPIRATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date activityExpirationDate;

    @Column(name = "ACTIVITY_REQUESTED_AMOUNT")
    private Integer activityRequestedAmount;

    @Column(name = "ACTIVITY_REQUESTED_AMOUNT_CURRENCY")
    private String activityRequestedAmountCurrency;

    @Column(name = "ACTIVITY_METRICS")
    private String activityMetrics;

    @Column(name = "ACTIVITY_TARGET")
    private Integer activityTarget;

    @Column(name = "ACTIVITY_RESULTS_SUBMITTED")
    private Integer activityResultsSubmitted;

    @Column(name = "FUNDING_QUARTER")
    private String fundingQuarter;

    @Column(name = "CISCO_FUNDING_QUARTER")
    private String ciscoFundingQuarter;

    @Column(name = "ACTIVITY_START_FISCAL_QUARTER")
    private String activityStartFiscalQuarter;

    @Column(name = "ACTIVITY_TYPE")
    private String activityType;

    @Column(name = "DISTRIBUTOR_UNIQUE_ID")
    private String distributorUniqueId;

    @Column(name = "INITIATIVE")
    private String initiative;

    @Column(name = "FUND_SHELL")
    private String fundShell;

    @Column(name = "MILESTONE_NAME")
    private String milestoneName;

    @Column(name = "ACHIEVEMENT")
    private String achievement;

    @Column(name = "CURRENCY")
    private String currency;

    @Column(name = "ACHIEVEMENT_PERCENT")
    private Integer achievementPercent;

    @Column(name = "SLIDING_SCALE_PERCENT")
    private Integer slidingScalePercent;

    @Column(name = "CLAIM_SUBMISSION_DEADLINE")
    @Temporal(TemporalType.DATE)
    private Date claimSubmissionDeadline;

    @Column(name = "ACTIVITY_SUBMISSION_DEADLINE")
    @Temporal(TemporalType.DATE)
    private Date activitySubmissionDeadline;

    @Column(name = "ACTIVITY_EXECUTION_DEADLINE")
    @Temporal(TemporalType.DATE)
    private Date activityExecutionDeadline;

    @Column(name = "CLAIM_SUBMIT_DATE")
    @Temporal(TemporalType.DATE)
    private Date claimSubmitDate;

    @Column(name = "ACTIVITY_SUBMIT_DATE")
    @Temporal(TemporalType.DATE)
    private Date activitySubmitDate;

    @Column(name = "ACTIVITY_EXECUTION_DATE")
    @Temporal(TemporalType.DATE)
    private Date activityExecutionDate;

    @Column(name = "TC_ACCEPTED")
    private String tcAccepted;

    @Column(name = "WS_ACTIVITY_ID")
    private String wsActivityId;

    @Column(name = "CREATED_BY")
    private Integer createdBy;

    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Column(name = "LAST_UPDATED_BY")
    private Integer lastUpdatedBy;

    @Column(name = "LAST_UPDATE_DATE")
    @Temporal(TemporalType.DATE)
    private Date lastUpdateDate;

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

 
}