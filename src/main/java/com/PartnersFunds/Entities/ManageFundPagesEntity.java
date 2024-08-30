package com.PartnersFunds.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "xxpf_fund_pages")
public class ManageFundPagesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "xxpf_fund_pages_s")
	@SequenceGenerator(name = "xxpf_fund_pages_s", sequenceName = "xxpf_fund_pages_s", allocationSize = 1)
    @Column(name = "FUND_PAGE_ID")
    private Integer fundPageId;

    @Column(name = "FUND_ID")
    private Integer fundId;

    @Column(name = "PAGE_ID")
    private Integer pageId;

    @Column(name = "ACTIVE_FLAG")
    private String activeFlag;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATION_DATE")
    private Date creationDate;

    @Column(name = "LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @Column(name = "LAST_UPDATE_DATE")
    private Date lastUpdateDate;

    // Getters and Setters
    public Integer getFundPageId() {
        return fundPageId;
    }

    public void setFundPageId(Integer fundPageId) {
        this.fundPageId = fundPageId;
    }

    public Integer getFundId() {
        return fundId;
    }

    public void setFundId(Integer fundId) {
        this.fundId = fundId;
    }

    public Integer getPageId() {
        return pageId;
    }

    public void setPageId(Integer pageId) {
        this.pageId = pageId;
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
