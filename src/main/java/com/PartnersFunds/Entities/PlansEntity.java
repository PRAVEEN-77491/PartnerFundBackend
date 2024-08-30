package com.PartnersFunds.Entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "xxpf_plans")
public class PlansEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "xxpf_plans_s")
 	@SequenceGenerator(name = "xxpf_plans_s", sequenceName = "xxpf_plans_s", allocationSize = 1)
    @Column(name = "PLAN_ID")
    private Integer planId;

    @Column(name = "PLAN_NAME")
    private String planName;

    @Column(name = "PARTNERSHIP_ID")
    private Integer partnershipId;

    @Column(name = "FUND_ID")
    private Integer fundId;

    @Column(name = "REGION")
    private String region;

    @Column(name = "THEATER")
    private String theater;

    @Column(name = "FISCAL_YEAR")
    private Integer fiscalYear;

    @Column(name = "DISTRIBUTOR_ID_PLAN")
    private String distributorIdPlan;

    @Column(name = "PLAN_STAGE")
    private String planStage;

    @Column(name = "PLAN_DISTRIBUTOR_PAYEE_COUNTRY")
    private String planDistributorPayeeCountry;

    @Column(name = "DISTRIBUTOR_PAYEE_COUNTRY")
    private String distributorPayeeCountry;

    @Column(name = "WS_PLAN_TOKEN")
    private String wsPlanToken;

    @Column(name = "CREATED_BY")
    private Integer createdBy;

    @Column(name = "CREATION_DATE")
    private Date creationDate;

    @Column(name = "LAST_UPDATED_BY")
    private Integer lastUpdatedBy;

    @Column(name = "LAST_UPDATE_DATE")
    private Date lastUpdateDate;

    // Getters and Setters

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public Integer getPartnershipId() {
        return partnershipId;
    }

    public void setPartnershipId(Integer partnershipId) {
        this.partnershipId = partnershipId;
    }

    public Integer getFundId() {
        return fundId;
    }

    public void setFundId(Integer fundId) {
        this.fundId = fundId;
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

    public Integer getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(Integer fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public String getDistributorIdPlan() {
        return distributorIdPlan;
    }

    public void setDistributorIdPlan(String distributorIdPlan) {
        this.distributorIdPlan = distributorIdPlan;
    }

    public String getPlanStage() {
        return planStage;
    }

    public void setPlanStage(String planStage) {
        this.planStage = planStage;
    }

    public String getPlanDistributorPayeeCountry() {
        return planDistributorPayeeCountry;
    }

    public void setPlanDistributorPayeeCountry(String planDistributorPayeeCountry) {
        this.planDistributorPayeeCountry = planDistributorPayeeCountry;
    }

    public String getDistributorPayeeCountry() {
        return distributorPayeeCountry;
    }

    public void setDistributorPayeeCountry(String distributorPayeeCountry) {
        this.distributorPayeeCountry = distributorPayeeCountry;
    }

    public String getWsPlanToken() {
        return wsPlanToken;
    }

    public void setWsPlanToken(String wsPlanToken) {
        this.wsPlanToken = wsPlanToken;
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

}