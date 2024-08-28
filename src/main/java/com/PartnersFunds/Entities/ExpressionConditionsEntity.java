package com.PartnersFunds.Entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(
   name = "XXPF_EXPRESSION_CONDITIONS"
)
public class ExpressionConditionsEntity {
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
		   name = "EXPRESSION_ID")
   private Integer EXPRESSION_ID;
   @Column(
		   name = "GROUP_ID")
   private Integer GROUP_ID;
   @Column(
		   name = "SEQUENCE")
   private Integer SEQUENCE;
   @Column(
		   name = "OPERAND1_TYPE")
   private String OPERAND1_TYPE;
   @Column(
		   name = "OPERAND1_VALUE")
   private String OPERAND1_VALUE;
   @Column(
		   name = "OPERATOR")
   private String OPERATOR;
   @Column(
		   name = "OPERAND2_TYPE")
   private String OPERAND2_TYPE;
   @Column(
		   name = "OPERAND2_VALUE")
   private String OPERAND2_VALUE;
   @Column(
		   name = "OPERAND3_TYPE")
   private String OPERAND3_TYPE;
   @Column(
		   name = "OPERAND3_VALUE")
   private String OPERAND3_VALUE;
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
   
	public ExpressionConditionsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExpressionConditionsEntity(Integer cONDITION_ID, Integer eXPRESSION_ID, Integer gROUP_ID, Integer sEQUENCE,
			String oPERAND1_TYPE, String oPERAND1_VALUE, String oPERATOR, String oPERAND2_TYPE, String oPERAND2_VALUE,
			String oPERAND3_TYPE, String oPERAND3_VALUE, String cREATED_BY, Date cREATION_DATE, String lAST_UPDATED_BY,
			Date lAST_UPDATE_DATE) {
		super();
		CONDITION_ID = cONDITION_ID;
		EXPRESSION_ID = eXPRESSION_ID;
		GROUP_ID = gROUP_ID;
		SEQUENCE = sEQUENCE;
		OPERAND1_TYPE = oPERAND1_TYPE;
		OPERAND1_VALUE = oPERAND1_VALUE;
		OPERATOR = oPERATOR;
		OPERAND2_TYPE = oPERAND2_TYPE;
		OPERAND2_VALUE = oPERAND2_VALUE;
		OPERAND3_TYPE = oPERAND3_TYPE;
		OPERAND3_VALUE = oPERAND3_VALUE;
		CREATED_BY = cREATED_BY;
		CREATION_DATE = cREATION_DATE;
		LAST_UPDATED_BY = lAST_UPDATED_BY;
		LAST_UPDATE_DATE = lAST_UPDATE_DATE;
	}

	public Integer getCONDITION_ID() {
		return CONDITION_ID;
	}

	public void setCONDITION_ID(Integer cONDITION_ID) {
		CONDITION_ID = cONDITION_ID;
	}

	public Integer getEXPRESSION_ID() {
		return EXPRESSION_ID;
	}

	public void setEXPRESSION_ID(Integer eXPRESSION_ID) {
		EXPRESSION_ID = eXPRESSION_ID;
	}

	public Integer getGROUP_ID() {
		return GROUP_ID;
	}

	public void setGROUP_ID(Integer gROUP_ID) {
		GROUP_ID = gROUP_ID;
	}

	public Integer getSEQUENCE() {
		return SEQUENCE;
	}

	public void setSEQUENCE(Integer sEQUENCE) {
		SEQUENCE = sEQUENCE;
	}

	public String getOPERAND1_TYPE() {
		return OPERAND1_TYPE;
	}

	public void setOPERAND1_TYPE(String oPERAND1_TYPE) {
		OPERAND1_TYPE = oPERAND1_TYPE;
	}

	public String getOPERAND1_VALUE() {
		return OPERAND1_VALUE;
	}

	public void setOPERAND1_VALUE(String oPERAND1_VALUE) {
		OPERAND1_VALUE = oPERAND1_VALUE;
	}

	public String getOPERATOR() {
		return OPERATOR;
	}

	public void setOPERATOR(String oPERATOR) {
		OPERATOR = oPERATOR;
	}

	public String getOPERAND2_TYPE() {
		return OPERAND2_TYPE;
	}

	public void setOPERAND2_TYPE(String oPERAND2_TYPE) {
		OPERAND2_TYPE = oPERAND2_TYPE;
	}

	public String getOPERAND2_VALUE() {
		return OPERAND2_VALUE;
	}

	public void setOPERAND2_VALUE(String oPERAND2_VALUE) {
		OPERAND2_VALUE = oPERAND2_VALUE;
	}

	public String getOPERAND3_TYPE() {
		return OPERAND3_TYPE;
	}

	public void setOPERAND3_TYPE(String oPERAND3_TYPE) {
		OPERAND3_TYPE = oPERAND3_TYPE;
	}

	public String getOPERAND3_VALUE() {
		return OPERAND3_VALUE;
	}

	public void setOPERAND3_VALUE(String oPERAND3_VALUE) {
		OPERAND3_VALUE = oPERAND3_VALUE;
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
   
   
