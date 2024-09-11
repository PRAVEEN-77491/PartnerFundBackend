package com.partnersFunds.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ManageRolesDTO {

	@JsonProperty("role_id")
	private Integer roleId;
	
	@JsonProperty("rolename")
	private String roleName;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("active")
	private String activeFlag;
	
	@JsonProperty("userId")
	private Integer userId;

	@Override
	public String toString() {
		return "ManageRolesDTO [roleId=" + roleId + ", roleName=" + roleName + ", description=" + description
				+ ", activeFlag=" + activeFlag + ", p_user_id=" + userId + "]";
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}	
	
}
