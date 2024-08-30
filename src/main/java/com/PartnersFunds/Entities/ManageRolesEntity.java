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
@Table(name = "xxpf_role_master")
public class ManageRolesEntity {
		
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "xxpf_role_master_s")
		@SequenceGenerator(name = "xxpf_role_master_s", sequenceName = "xxpf_role_master_s", allocationSize = 1)
		@Column(name = "role_id")
		private Integer roleId;

		@Column(name = "name")
		private String fundName;

		@Column(name = "description")
		private String description;

		@Column(name = "active_flag")
		private String activeFlag;

		@Column(name = "created_by")
		private String createdBy;

		@Column(name = "creation_date")
		@Temporal(TemporalType.DATE)
		private Date creationDate;

		@Column(name = "last_updated_by")
		private String lastUpdatedBy;

		@Column(name = "last_update_date")
		@Temporal(TemporalType.DATE)
		private Date lastUpdateDate;

		public Integer getRoleId() {
			return roleId;
		}

		public void setRoleId(Integer roleId) {
			this.roleId = roleId;
		}

		public String getFundName() {
			return fundName;
		}

		public void setFundName(String fundName) {
			this.fundName = fundName;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
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
