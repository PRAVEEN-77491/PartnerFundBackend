package com.PartnersFunds.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ManageFundTablesDTO {

	@JsonProperty("tableId")
	private Integer tableId;
	
	@JsonProperty("fundId")
	private Integer fundId;
		
	@JsonProperty("tablename")
	private String tablename;
	
	@JsonProperty("displayName")
	private String displayName;
	
	@JsonProperty("usagelevel")
	private String usagelevel;
	
	@JsonProperty("userId")
	private Integer userId;

	public Integer getTableId() {
		return tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}

	public Integer getFundId() {
		return fundId;
	}

	public void setFundId(Integer fundId) {
		this.fundId = fundId;
	}

	public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getUsagelevel() {
		return usagelevel;
	}

	public void setUsagelevel(String usagelevel) {
		this.usagelevel = usagelevel;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
