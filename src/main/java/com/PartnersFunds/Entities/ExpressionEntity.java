package com.PartnersFunds.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.sql.Date;

@Entity
@Table(
   name = "XXPF_EXPRESSIONS"
)
public class ExpressionEntity {
   @Id
   @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "XXPF_EXPRESSIONS_S"
   )
   @SequenceGenerator(
      name = "XXPF_EXPRESSIONS_S",
      sequenceName = "XXPF_EXPRESSIONS_S",
      allocationSize = 1
   )
   @Column(
      name = "EXPRESSION_ID"
   )
   private Long EXPRESSION_ID;
   @Column(
      name = "EXPRESSION_NAME"
   )
   private String EXPRESSION_NAME;
   @Column(
      name = "CREATED_BY"
   )
   private String CREATED_BY;
   @Column(
      name = "CREATION_DATE"
   )
   private Date CREATION_DATE;
   @Column(
      name = "LAST_UPDATED_BY"
   )
   private String LAST_UPDATED_BY;
   @Column(
      name = "LAST_UPDATE_DATE"
   )
   private Date LAST_UPDATE_DATE;

   public ExpressionEntity() {
   }

   public ExpressionEntity(Long eXPRESSION_ID, String eXPRESSION_NAME, String cREATED_BY, Date cREATION_DATE, String lAST_UPDATED_BY, Date lAST_UPDATE_DATE) {
      this.EXPRESSION_ID = eXPRESSION_ID;
      this.EXPRESSION_NAME = eXPRESSION_NAME;
      this.CREATED_BY = cREATED_BY;
      this.CREATION_DATE = cREATION_DATE;
      this.LAST_UPDATED_BY = lAST_UPDATED_BY;
      this.LAST_UPDATE_DATE = lAST_UPDATE_DATE;
   }

   public Long getEXPRESSION_ID() {
      return this.EXPRESSION_ID;
   }

   public void setEXPRESSION_ID(Long eXPRESSION_ID) {
      this.EXPRESSION_ID = eXPRESSION_ID;
   }

   public String getEXPRESSION_NAME() {
      return this.EXPRESSION_NAME;
   }

   public void setEXPRESSION_NAME(String eXPRESSION_NAME) {
      this.EXPRESSION_NAME = eXPRESSION_NAME;
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
