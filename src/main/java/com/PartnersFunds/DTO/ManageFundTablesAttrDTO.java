package com.PartnersFunds.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ManageFundTablesAttrDTO {

	@JsonProperty("attrId")
	private Integer p_attribute_id;
	
	@JsonProperty("tableId")
	private Integer p_table_id;
		
	@JsonProperty("columnName")
	private String p_column_name;
	
	@JsonProperty("displayName")
	private String p_display_name;
	
	@JsonProperty("activeFlag")
	private String p_active_flag;
	
	@JsonProperty("userId")
	private Integer p_user_id;

	public Integer getP_attribute_id() {
		return p_attribute_id;
	}

	public void setP_attribute_id(Integer p_attribute_id) {
		this.p_attribute_id = p_attribute_id;
	}

	public Integer getP_table_id() {
		return p_table_id;
	}

	public void setP_table_id(Integer p_table_id) {
		this.p_table_id = p_table_id;
	}

	public String getP_column_name() {
		return p_column_name;
	}

	public void setP_column_name(String p_column_name) {
		this.p_column_name = p_column_name;
	}

	public String getP_display_name() {
		return p_display_name;
	}

	public void setP_display_name(String p_display_name) {
		this.p_display_name = p_display_name;
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
