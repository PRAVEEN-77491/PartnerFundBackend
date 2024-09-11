package com.PartnersFunds.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ManageFundPagesDTO {

	@JsonProperty("fundPageId")
	private Integer fundPageId;
	
	@JsonProperty("fundId")
	private Integer fundId;
	
	@JsonProperty("pageId")
	private Integer pageId;
	
	@JsonProperty("activeFlag")
	private String activeFlag;
	
	@JsonProperty("userId")
	private Integer userId;

	public Integer getFundPageId() {
		return fundPageId;
	}

	public void setFundPageId(Integer fundPageId) {
		this.fundPageId = fundPageId;
	}

	public Integer getFundId() {
		return fundId;
	}

	public void setFundId(Integer fundId) {
		this.fundId = fundId;
	}

	public Integer getPageId() {
		return pageId;
	}

	public void setPageId(Integer pageId) {
		this.pageId = pageId;
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
