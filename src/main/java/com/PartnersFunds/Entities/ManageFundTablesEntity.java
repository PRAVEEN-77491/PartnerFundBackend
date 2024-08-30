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
@Table(name = "xxpf_fund_tables")
public class ManageFundTablesEntity {

	 @Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "xxpf_fund_tables_s")
		@SequenceGenerator(name = "xxpf_fund_tables_s", sequenceName = "xxpf_fund_tables_s", allocationSize = 1)
	    @Column(name = "TABLE_ID")
	    private Integer tableId;

	    @Column(name = "FUND_ID")
	    private Integer fundId;

	    @Column(name = "TABLE_NAME")
	    private String tableName;

	    @Column(name = "DISPLAY_NAME")
	    private String displayName;

	    @Column(name = "USAGE_LEVEL")
	    private String usageLevel;

	    @Column(name = "CREATED_BY")
	    private Integer createdBy;

	    @Column(name = "CREATION_DATE")
	    private Date creationDate;

	    @Column(name = "LAST_UPDATED_BY")
	    private Integer lastUpdatedBy;

	    @Column(name = "LAST_UPDATE_DATE")
	    private Date lastUpdateDate;

	    // Getters and Setters
	    public Integer getTableId() {
	        return tableId;
	    }

	    public void setTableId(Integer tableId) {
	        this.tableId = tableId;
	    }

	    public Integer getFundId() {
	        return fundId;
	    }

	    public void setFundId(Integer fundId) {
	        this.fundId = fundId;
	    }

	    public String getTableName() {
	        return tableName;
	    }

	    public void setTableName(String tableName) {
	        this.tableName = tableName;
	    }

	    public String getDisplayName() {
	        return displayName;
	    }

	    public void setDisplayName(String displayName) {
	        this.displayName = displayName;
	    }

	    public String getUsageLevel() {
	        return usageLevel;
	    }

	    public void setUsageLevel(String usageLevel) {
	        this.usageLevel = usageLevel;
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
