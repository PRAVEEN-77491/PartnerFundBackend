package com.PartnersFunds.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Date;

public class ExpressionConditionDTO {
	
   @JsonProperty("ATTRIBUTE_ID")
   private String ATTRIBUTE_ID;
   @JsonProperty("EXP_OPERATOR")
   private String EXP_OPERATOR;
   @JsonProperty("VALUE")
   private String VALUE;
   @JsonProperty("PARENT_OPERATOR")
   private String PARENT_OPERATOR;
   @JsonProperty("CREATED_BY")
   private String CREATED_BY;
   @JsonProperty("CREATION_DATE")
   private Date CREATION_DATE;
   @JsonProperty("LAST_UPDATED_BY")
   private String LAST_UPDATED_BY;
   @JsonProperty("LAST_UPDATE_DATE")
   private Date LAST_UPDATE_DATE;

   public String getATTRIBUTE_ID() {
      return this.ATTRIBUTE_ID;
   }

   public void setATTRIBUTE_ID(String aTTRIBUTE_ID) {
      this.ATTRIBUTE_ID = aTTRIBUTE_ID;
   }

   public String getEXP_OPERATOR() {
      return this.EXP_OPERATOR;
   }

   public void setEXP_OPERATOR(String eXP_OPERATOR) {
      this.EXP_OPERATOR = eXP_OPERATOR;
   }

   public String getVALUE() {
      return this.VALUE;
   }

   public void setVALUE(String vALUE) {
      this.VALUE = vALUE;
   }

   public String getPARENT_OPERATOR() {
      return this.PARENT_OPERATOR;
   }

   public void setPARENT_OPERATOR(String pARENT_OPERATOR) {
      this.PARENT_OPERATOR = pARENT_OPERATOR;
   }

   public String getCREATED_BY() {
      return this.CREATED_BY;
   }

   public void setCREATED_BY(String cREATED_BY) {
      this.CREATED_BY = cREATED_BY;
   }

   public Date getCREATION_DATE() {
      return this.CREATION_DATE;
   }

   public void setCREATION_DATE(Date cREATION_DATE) {
      this.CREATION_DATE = cREATION_DATE;
   }

   public String getLAST_UPDATED_BY() {
      return this.LAST_UPDATED_BY;
   }

   public void setLAST_UPDATED_BY(String lAST_UPDATED_BY) {
      this.LAST_UPDATED_BY = lAST_UPDATED_BY;
   }

   public Date getLAST_UPDATE_DATE() {
      return this.LAST_UPDATE_DATE;
   }

   public void setLAST_UPDATE_DATE(Date lAST_UPDATE_DATE) {
      this.LAST_UPDATE_DATE = lAST_UPDATE_DATE;
   }
}
