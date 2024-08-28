package com.PartnersFunds.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ManageFundDTO {

	@JsonProperty("p_fund_id")
	private Integer p_fund_id;
	
	@JsonProperty("p_fund_name")
	private String p_fund_name;
	
	@JsonProperty("p_description")
	private String p_description;
	
	@JsonProperty("p_active_flag")
	private String p_active_flag;
	
	@JsonProperty("p_user_id")
	private Integer p_user_id;

	public Integer getP_fund_id() {
		return p_fund_id;
	}

	public void setP_fund_id(Integer p_fund_id) {
		this.p_fund_id = p_fund_id;
	}

	public String getP_fund_name() {
		return p_fund_name;
	}

	public void setP_fund_name(String p_fund_name) {
		this.p_fund_name = p_fund_name;
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
