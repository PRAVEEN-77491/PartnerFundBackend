package com.PartnersFunds.service;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExpressionAttrPropDTO {
	
	@JsonProperty("PAGE_ID")
    private int PAGE_ID;
	@JsonProperty("EXPRESSION_ID")
    private int EXPRESSION_ID;
	@JsonProperty("ATTRIBUTE_ID")
    private int ATTRIBUTE_ID;
	@JsonProperty("ATTR_PROP_NAME")
    private String ATTR_PROP_NAME;
	@JsonProperty("CREATED_BY")
    private String CREATED_BY;
	@JsonProperty("CREATION_DATE")
    private Date CREATION_DATE;
	@JsonProperty("LAST_UPDATED_BY")
    private String LAST_UPDATED_BY;
	@JsonProperty("LAST_UPDATE_DATE")
    private Date LAST_UPDATE_DATE;
	
	public int getPAGE_ID() {
		return PAGE_ID;
	}
	public void setPAGE_ID(int pAGE_ID) {
		PAGE_ID = pAGE_ID;
	}
	public int getEXPRESSION_ID() {
		return EXPRESSION_ID;
	}
	public void setEXPRESSION_ID(int eXPRESSION_ID) {
		EXPRESSION_ID = eXPRESSION_ID;
	}
	public int getATTRIBUTE_ID() {
		return ATTRIBUTE_ID;
	}
	public void setATTRIBUTE_ID(int aTTRIBUTE_ID) {
		ATTRIBUTE_ID = aTTRIBUTE_ID;
	}
	public String getATTR_PROP_NAME() {
		return ATTR_PROP_NAME;
	}
	public void setATTR_PROP_NAME(String aTTR_PROP_NAME) {
		ATTR_PROP_NAME = aTTR_PROP_NAME;
	}
	public String getCREATED_BY() {
		return CREATED_BY;
	}
	public void setCREATED_BY(String cREATED_BY) {
		CREATED_BY = cREATED_BY;
	}
	public Date getCREATION_DATE() {
		return CREATION_DATE;
	}
	public void setCREATION_DATE(Date cREATION_DATE) {
		CREATION_DATE = cREATION_DATE;
	}
	public String getLAST_UPDATED_BY() {
		return LAST_UPDATED_BY;
	}
	public void setLAST_UPDATED_BY(String lAST_UPDATED_BY) {
		LAST_UPDATED_BY = lAST_UPDATED_BY;
	}
	public Date getLAST_UPDATE_DATE() {
		return LAST_UPDATE_DATE;
	}
	public void setLAST_UPDATE_DATE(Date lAST_UPDATE_DATE) {
		LAST_UPDATE_DATE = lAST_UPDATE_DATE;
	}


}
