package com.PartnersFunds.service;

import java.sql.Date;
import java.util.List;
import com.PartnersFunds.Entities.ExpressionConditionEntity;

public class ResponseExpressionDTO {

   private Integer EXPRESSION_ID;
   private String EXPRESSION_NAME;
   private List<ExpressionConditionEntity> Exp_attribute_details;
   private String CREATED_BY;
   private Date CREATION_DATE;
   private String LAST_UPDATED_BY;
   private Date LAST_UPDATE_DATE;
	   
	public Integer getEXPRESSION_ID() {
		return EXPRESSION_ID;
	}
	public void setEXPRESSION_ID(Integer eXPRESSION_ID) {
		EXPRESSION_ID = eXPRESSION_ID;
	}
	public String getEXPRESSION_NAME() {
		return EXPRESSION_NAME;
	}
	public void setEXPRESSION_NAME(String eXPRESSION_NAME) {
		EXPRESSION_NAME = eXPRESSION_NAME;
	}
	public List<ExpressionConditionEntity> getExp_attribute_details() {
		return Exp_attribute_details;
	}
	public void setExp_attribute_details(List<ExpressionConditionEntity> exp_attribute_details) {
		Exp_attribute_details = exp_attribute_details;
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
