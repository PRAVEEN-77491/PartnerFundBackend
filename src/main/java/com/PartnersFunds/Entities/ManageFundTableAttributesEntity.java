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
@Table(name = "xxpf_fund_table_attributes") 
public class ManageFundTableAttributesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "xxpf_fund_table_attributes_s")
	@SequenceGenerator(name = "xxpf_fund_table_attributes_s", sequenceName = "xxpf_fund_table_attributes_s", allocationSize = 1)
    @Column(name = "ATTRIBUTE_ID")
    private Integer attributeId;

    @Column(name = "TABLE_ID")
    private Integer tableId;

    @Column(name = "COLUMN_NAME")
    private String columnName;

    @Column(name = "DISPLAY_NAME")
    private String displayName;

    @Column(name = "ACTIVE_FLAG")
    private String activeFlag;

    @Column(name = "CREATED_BY")
    private Integer createdBy;

    @Column(name = "CREATION_DATE")
    private Date creationDate;

    @Column(name = "LAST_UPDATED_BY")
    private Integer lastUpdatedBy;

    @Column(name = "LAST_UPDATE_DATE")
    private Date lastUpdateDate;

    // Getters and Setters
    public Integer getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Integer attributeId) {
        this.attributeId = attributeId;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(String activeFlag) {
        this.activeFlag = activeFlag;
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
