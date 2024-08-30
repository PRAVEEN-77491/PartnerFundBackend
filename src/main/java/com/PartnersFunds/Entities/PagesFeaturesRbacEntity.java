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
@Table(name = "xxpf_fund_bpa_page_feature_rbac")
public class PagesFeaturesRbacEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "xxpf_fund_bpa_page_feature_rbac_s")
  	@SequenceGenerator(name = "xxpf_fund_bpa_page_feature_rbac_s", sequenceName = "xxpf_fund_bpa_page_feature_rbac_s", allocationSize = 1)
    @Column(name = "RBAC_FEATURE_ID")
    private Integer rbacFeatureId;

    @Column(name = "FUND_BPA_ID")
    private Integer fundBpaId;

    @Column(name = "PAGE_ID")
    private Integer pageId;

    @Column(name = "FEATURE_ID")
    private Integer featureId;

    @Column(name = "READ_FLAG")
    private String readFlag;

    @Column(name = "WRITE_FLAG")
    private String writeFlag;

    @Column(name = "CREATED_BY")
    private Integer createdBy;

    @Column(name = "CREATION_DATE")
    private Date creationDate;

    @Column(name = "LAST_UPDATED_BY")
    private Integer lastUpdatedBy;

    @Column(name = "LAST_UPDATE_DATE")
    private Date lastUpdateDate;

    // Getters and Setters

    public Integer getRbacFeatureId() {
        return rbacFeatureId;
    }

    public void setRbacFeatureId(Integer rbacFeatureId) {
        this.rbacFeatureId = rbacFeatureId;
    }

    public Integer getFundBpaId() {
        return fundBpaId;
    }

    public void setFundBpaId(Integer fundBpaId) {
        this.fundBpaId = fundBpaId;
    }

    public Integer getPageId() {
        return pageId;
    }

    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }

    public Integer getFeatureId() {
        return featureId;
    }

    public void setFeatureId(Integer featureId) {
        this.featureId = featureId;
    }

    public String getReadFlag() {
        return readFlag;
    }

    public void setReadFlag(String readFlag) {
        this.readFlag = readFlag;
    }

    public String getWriteFlag() {
        return writeFlag;
    }

    public void setWriteFlag(String writeFlag) {
        this.writeFlag = writeFlag;
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
