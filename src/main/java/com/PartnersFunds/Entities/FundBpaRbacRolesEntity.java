package com.PartnersFunds.Entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "xxpf_fund_bpa_rbac_roles")
public class FundBpaRbacRolesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "xxpf_fund_bpa_rbac_roles_s")
 	@SequenceGenerator(name = "xxpf_fund_bpa_rbac_roles_s", sequenceName = "xxpf_fund_bpa_rbac_roles_s", allocationSize = 1)
    @Column(name = "RBAC_ROLE_ID")
    private Integer rbacRoleId;

    @Column(name = "FUND_BPA_ID")
    private Integer fundBpaId;

    @Column(name = "ROLE_ID")
    private Integer roleId;

    @Column(name = "CREATED_BY")
    private Integer createdBy;

    @Column(name = "CREATION_DATE")
    private Date creationDate;

    @Column(name = "LAST_UPDATED_BY")
    private Integer lastUpdatedBy;

    @Column(name = "LAST_UPDATE_DATE")
    private Date lastUpdateDate;

    // Getters and Setters

    public Integer getRbacRoleId() {
        return rbacRoleId;
    }

    public void setRbacRoleId(Integer rbacRoleId) {
        this.rbacRoleId = rbacRoleId;
    }

    public Integer getFundBpaId() {
        return fundBpaId;
    }

    public void setFundBpaId(Integer fundBpaId) {
        this.fundBpaId = fundBpaId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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
