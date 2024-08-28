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
@Table(name = "XXPF_EXPRESSION_PROPERTY_MAPPINGS")
public class ExpressionPropertyMappings {
	 @Id
	   @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "XXPF_EXPRESSION_PROPERTY_MAPPINGS_S")
	   @SequenceGenerator(name = "XXPF_EXPRESSION_PROPERTY_MAPPINGS_S",sequenceName = "XXPF_EXPRESSION_PROPERTY_MAPPINGS_S",allocationSize = 1)
	   @Column(name = "MAPPING_ID")
	   private Integer MAPPING_ID;
	 
	 @Column(name = "PROPERTY_ID")
	 private Integer PROPERTY_ID;
	 
	 @Column(name = "EXPRESSION_ID")
	 private Integer EXPRESSION_ID;
	 
	 @Column(name = "CREATED_BY")
	 private String CREATED_BY;
     @Column(name = "CREATION_DATE")
     private Date CREATION_DATE;
     @Column(name = "LAST_UPDATED_BY")
     private String LAST_UPDATED_BY;
     @Column(name = "LAST_UPDATE_DATE")
     private Date LAST_UPDATE_DATE;
   
	public ExpressionPropertyMappings() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExpressionPropertyMappings(Integer mAPPING_ID, Integer pROPERTY_ID, Integer eXPRESSION_ID, String cREATED_BY,
			Date cREATION_DATE, String lAST_UPDATED_BY, Date lAST_UPDATE_DATE) {
		super();
		MAPPING_ID = mAPPING_ID;
		PROPERTY_ID = pROPERTY_ID;
		EXPRESSION_ID = eXPRESSION_ID;
		CREATED_BY = cREATED_BY;
		CREATION_DATE = cREATION_DATE;
		LAST_UPDATED_BY = lAST_UPDATED_BY;
		LAST_UPDATE_DATE = lAST_UPDATE_DATE;
	}
	public Integer getMAPPING_ID() {
		return MAPPING_ID;
	}
	public void setMAPPING_ID(Integer mAPPING_ID) {
		MAPPING_ID = mAPPING_ID;
	}
	public Integer getPROPERTY_ID() {
		return PROPERTY_ID;
	}
	public void setPROPERTY_ID(Integer pROPERTY_ID) {
		PROPERTY_ID = pROPERTY_ID;
	}
	public Integer getEXPRESSION_ID() {
		return EXPRESSION_ID;
	}
	public void setEXPRESSION_ID(Integer eXPRESSION_ID) {
		EXPRESSION_ID = eXPRESSION_ID;
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
