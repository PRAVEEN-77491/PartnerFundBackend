package com.PartnersFunds.Entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

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
@Table(name = "xxpf_fund_roles")
public class ManageFundRolesEntity {

		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "xxpf_fund_roles_s")
		@SequenceGenerator(name = "xxpf_fund_roles_s", sequenceName = "xxpf_fund_roles_s", allocationSize = 1)
		@Column(name = "fund_role_id")
		private Integer fundRoleId;

		@Column(name = "fund_id")
		private Integer fundId;

		@Column(name = "role_id")
		private Integer roleId;

		@Column(name = "active_flag")
		private String activeFlag;

		@Column(name = "created_by")
		private String createdBy;

		@Column(name = "creation_date")
		@Temporal(TemporalType.TIMESTAMP)
		private Date creationDate;

		@Column(name = "last_updated_by")
		private String lastUpdatedBy;

		@Column(name = "last_update_date")
		@Temporal(TemporalType.TIMESTAMP)
		private Date lastUpdateDate;

		@Override
		public String toString() {
			return "ManageFundRolesEntity [fundRoleId=" + fundRoleId + ", fundId=" + fundId + ", roleId=" + roleId
					+ ", activeFlag=" + activeFlag + ", createdBy=" + createdBy + ", creationDate=" + creationDate
					+ ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdateDate=" + lastUpdateDate + "]";
		}

		public Integer getFundRoleId() {
			return fundRoleId;
		}

		public void setFundRoleId(Integer fundRoleId) {
			this.fundRoleId = fundRoleId;
		}

		public Integer getFundId() {
			return fundId;
		}

		public void setFundId(Integer fundId) {
			this.fundId = fundId;
		}

		public Integer getRoleId() {
			return roleId;
		}

		public void setRoleId(Integer roleId) {
			this.roleId = roleId;
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
