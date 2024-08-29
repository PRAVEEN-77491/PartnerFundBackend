package com.PartnersFunds.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ManageFundPagesDTO {

	@JsonProperty("fundPageId")
	private Integer p_fund_page_id;
	
	@JsonProperty("fundId")
	private Integer p_fund_id;
	
	@JsonProperty("pageId")
	private Integer p_page_id;
	
	@JsonProperty("activeFlag")
	private String p_active_flag;
	
	@JsonProperty("userId")
	private Integer p_user_id;

	public Integer getP_fund_page_id() {
		return p_fund_page_id;
	}

	public void setP_fund_page_id(Integer p_fund_page_id) {
		this.p_fund_page_id = p_fund_page_id;
	}

	public Integer getP_fund_id() {
		return p_fund_id;
	}

	public void setP_fund_id(Integer p_fund_id) {
		this.p_fund_id = p_fund_id;
	}

	public Integer getP_page_id() {
		return p_page_id;
	}

	public void setP_page_id(Integer p_page_id) {
		this.p_page_id = p_page_id;
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
