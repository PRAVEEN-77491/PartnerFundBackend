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
   name = "XXPF_EXP_CONDITIONS"
)
public class ExpressionConditionEntity {
   @Id
   @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "XXPF_EXP_CONDITIONS_S"
   )
   @SequenceGenerator(
      name = "XXPF_EXP_CONDITIONS_S",
      sequenceName = "XXPF_EXP_CONDITIONS_S",
      allocationSize = 1
   )
   @Column(
      name = "CONDITION_ID"
   )
   private Integer CONDITION_ID;
   @Column(
      name = "EXP_ID"
   )
   private Integer EXP_ID;
   @Column(
      name = "ATTRIBUTE_ID"
   )
   private int ATTRIBUTE_ID;
   @Column(
      name = "EXP_OPERATOR"
   )
   private String EXP_OPERATOR;
   @Column(
      name = "VALUE"
   )
   private String VALUE;
   @Column(
      name = "PARENT_OPERATOR"
   )
   private String PARENT_OPERATOR;
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

   public ExpressionConditionEntity() {
   }

   public ExpressionConditionEntity(Integer cONDITION_ID, Integer eXP_ID, int aTTRIBUTE_ID, String eXP_OPERATOR, String vALUE, String pARENT_OPERATOR, String cREATED_BY, Date cREATION_DATE, String lAST_UPDATED_BY, Date lAST_UPDATE_DATE) {
      this.CONDITION_ID = cONDITION_ID;
      this.EXP_ID = eXP_ID;
      this.ATTRIBUTE_ID = aTTRIBUTE_ID;
      this.EXP_OPERATOR = eXP_OPERATOR;
      this.VALUE = vALUE;
      this.PARENT_OPERATOR = pARENT_OPERATOR;
      this.CREATED_BY = cREATED_BY;
      this.CREATION_DATE = cREATION_DATE;
      this.LAST_UPDATED_BY = lAST_UPDATED_BY;
      this.LAST_UPDATE_DATE = lAST_UPDATE_DATE;
   }

   public Integer getCONDITION_ID() {
      return this.CONDITION_ID;
   }

   public void setCONDITION_ID(Integer cONDITION_ID) {
      this.CONDITION_ID = cONDITION_ID;
   }

   public Integer getEXP_ID() {
      return this.EXP_ID;
   }

   public void setEXP_ID(Integer Integer1) {
      this.EXP_ID = Integer1;
   }

   public int getATTRIBUTE_ID() {
      return this.ATTRIBUTE_ID;
   }

   public void setATTRIBUTE_ID(int aTTRIBUTE_ID) {
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
