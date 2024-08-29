package com.PartnersFunds.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ManageFundTablesDTO {

	@JsonProperty("tableId")
	private Integer p_table_id;
	
	@JsonProperty("fundId")
	private Integer p_fund_id;
		
	@JsonProperty("tablename")
	private String p_table_name;
	
	@JsonProperty("displayName")
	private String p_display_name;
	
	@JsonProperty("usagelevel")
	private String p_usage_level;
	
	@JsonProperty("userId")
	private Integer p_user_id;

	public Integer getP_table_id() {
		return p_table_id;
	}

	public void setP_table_id(Integer p_table_id) {
		this.p_table_id = p_table_id;
	}

	public Integer getP_fund_id() {
		return p_fund_id;
	}

	public void setP_fund_id(Integer p_fund_id) {
		this.p_fund_id = p_fund_id;
	}

	public String getP_display_name() {
		return p_display_name;
	}

	public void setP_display_name(String p_display_name) {
		this.p_display_name = p_display_name;
	}

	public String getP_table_name() {
		return p_table_name;
	}

	public void setP_table_name(String p_table_name) {
		this.p_table_name = p_table_name;
	}

	public String getP_usage_level() {
		return p_usage_level;
	}

	public void setP_usage_level(String p_usage_level) {
		this.p_usage_level = p_usage_level;
	}

	public Integer getP_user_id() {
		return p_user_id;
	}

	public void setP_user_id(Integer p_user_id) {
		this.p_user_id = p_user_id;
	}
	
	
}
