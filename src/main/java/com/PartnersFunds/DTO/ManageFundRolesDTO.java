package com.PartnersFunds.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ManageFundRolesDTO {

	@JsonProperty("fundRoleId")
	private Integer fundRoleId;
	
	@JsonProperty("fundId")
	private Integer fundId;
	
	@JsonProperty("fundname")
	private String fundname;
	
	@JsonProperty("roleId")
	private Integer roleId;
	
	@JsonProperty("rolename")
	private String rolename;
	
	@JsonProperty("active")
	private String activeFlag;
	
	@JsonProperty("userId")
	private Integer userId;

	@Override
	public String toString() {
		return "ManageFundRolesDTO [fundRoleId=" + fundRoleId + ", fundId=" + fundId + ", fundname=" + fundname
				+ ", roleId=" + roleId + ", rolename=" + rolename + ", activeFlag=" + activeFlag + ", userId=" + userId
				+ "]";
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

	public String getFundname() {
		return fundname;
	}

	public void setFundname(String fundname) {
		this.fundname = fundname;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}	
}
