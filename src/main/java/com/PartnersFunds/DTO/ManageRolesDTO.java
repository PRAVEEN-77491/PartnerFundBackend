package com.PartnersFunds.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ManageRolesDTO {

	@JsonProperty("p_role_id")
	private Integer p_role_id;
	
	@JsonProperty("p_role_name")
	private String p_role_name;
	
	@JsonProperty("p_description")
	private String p_description;
	
	@JsonProperty("p_active_flag")
	private String p_active_flag;
	
	@JsonProperty("p_user_id")
	private Integer p_user_id;

	public Integer getP_role_id() {
		return p_role_id;
	}

	public void setP_role_id(Integer p_role_id) {
		this.p_role_id = p_role_id;
	}

	public String getP_role_name() {
		return p_role_name;
	}

	public void setP_role_name(String p_role_name) {
		this.p_role_name = p_role_name;
	}

	public String getP_description() {
		return p_description;
	}

	public void setP_description(String p_description) {
		this.p_description = p_description;
	}

	public String getP_active_flag() {
		return p_active_flag;
	}

	public void setP_active_flag(String p_active_flag) {
		this.p_active_flag = p_active_flag;
	}

	public Integer getP_user_id() {
		return p_user_id;
	}

	public void setP_user_id(Integer p_user_id) {
		this.p_user_id = p_user_id;
	}
	
	
}
