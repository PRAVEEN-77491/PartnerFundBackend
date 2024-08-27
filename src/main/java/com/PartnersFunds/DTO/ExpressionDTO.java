package com.PartnersFunds.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Date;
import java.util.List;

public class ExpressionDTO {
	
	
   @JsonProperty("EXPRESSION_NAME")
   private String EXPRESSION_NAME;
   @JsonProperty("Exp_attribute_data")
   private List<ExpressionConditionDTO> Exp_attribute_data;
   @JsonProperty("CREATED_BY")
   private String CREATED_BY;
   @JsonProperty("CREATION_DATE")
   private Date CREATION_DATE;
   @JsonProperty("LAST_UPDATED_BY")
   private String LAST_UPDATED_BY;
   @JsonProperty("LAST_UPDATE_DATE")
   private Date LAST_UPDATE_DATE;

   public String getEXPRESSION_NAME() {
      return this.EXPRESSION_NAME;
   }

   public void setEXPRESSION_NAME(String EXPRESSION_NAME) {
      this.EXPRESSION_NAME = EXPRESSION_NAME;
   }

   public List<ExpressionConditionDTO> getExp_attribute_data() {
      return this.Exp_attribute_data;
   }

   public void setExp_attribute_data(List<ExpressionConditionDTO> Exp_attribute_data) {
      this.Exp_attribute_data = Exp_attribute_data;
   }

   public String getCREATED_BY() {
      return this.CREATED_BY;
   }

   public void setCREATED_BY(String CREATED_BY) {
      this.CREATED_BY = CREATED_BY;
   }

   public Date getCREATION_DATE() {
      return this.CREATION_DATE;
   }

   public void setCREATION_DATE(Date CREATION_DATE) {
      this.CREATION_DATE = CREATION_DATE;
   }

   public String getLAST_UPDATED_BY() {
      return this.LAST_UPDATED_BY;
   }

   public void setLAST_UPDATED_BY(String LAST_UPDATED_BY) {
      this.LAST_UPDATED_BY = LAST_UPDATED_BY;
   }

   public Date getLAST_UPDATE_DATE() {
      return this.LAST_UPDATE_DATE;
   }

   public void setLAST_UPDATE_DATE(Date LAST_UPDATE_DATE) {
      this.LAST_UPDATE_DATE = LAST_UPDATE_DATE;
   }
}
