package com.PartnersFunds.Entities;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "EXP_ATTR_PROP_MAPPING")
public class ExpressionAttrPropEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXP_ATTR_PROP_MAPPING_S")
    @SequenceGenerator(name = "EXP_ATTR_PROP_MAPPING_S", sequenceName = "EXP_ATTR_PROP_MAPPING_S", allocationSize = 1)
    @Column(name = "EAP_MAPPING_ID")
    private Integer EAP_MAPPING_ID;

    @Column(name = "PAGE_ID")
    private Integer PAGE_ID;
    
    @Column(name = "EXPRESSION_ID")
    private Integer EXPRESSION_ID;

    @Column(name = "ATTRIBUTE_ID")
    private Integer ATTRIBUTE_ID;

    @Column(name = "ATTR_PROP_NAME")
    private String ATTR_PROP_NAME;

    @Column(name = "CREATED_BY")
    private String CREATED_BY;

    @Column(name = "CREATION_DATE")
    private Date CREATION_DATE;

    @Column(name = "LAST_UPDATED_BY")
    private String LAST_UPDATED_BY;

    @Column(name = "LAST_UPDATE_DATE")
    private Date LAST_UPDATE_DATE;

	public ExpressionAttrPropEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ExpressionAttrPropEntity(Integer pAGE_ID, Integer eXPRESSION_ID, Integer aTTRIBUTE_ID,
	        String aTTR_PROP_NAME, String cREATED_BY, Date cREATION_DATE, String lAST_UPDATED_BY,
	        Date lAST_UPDATE_DATE) {
	    super();
	    PAGE_ID = pAGE_ID;
	    EXPRESSION_ID = eXPRESSION_ID;
	    ATTRIBUTE_ID = aTTRIBUTE_ID;
	    ATTR_PROP_NAME = aTTR_PROP_NAME;
	    CREATED_BY = cREATED_BY;
	    CREATION_DATE = cREATION_DATE;
	    LAST_UPDATED_BY = lAST_UPDATED_BY;
	    LAST_UPDATE_DATE = lAST_UPDATE_DATE;
	}


	public Integer getEAP_MAPPING_ID() {
		return EAP_MAPPING_ID;
	}

	public void setEAP_MAPPING_ID(Integer eAP_MAPPING_ID) {
		EAP_MAPPING_ID = eAP_MAPPING_ID;
	}

	public Integer getPAGE_ID() {
		return PAGE_ID;
	}

	public void setPAGE_ID(Integer pAGE_ID) {
		PAGE_ID = pAGE_ID;
	}

	public Integer getEXPRESSION_ID() {
		return EXPRESSION_ID;
	}

	public void setEXPRESSION_ID(Integer eXPRESSION_ID) {
		EXPRESSION_ID = eXPRESSION_ID;
	}

	public Integer getATTRIBUTE_ID() {
		return ATTRIBUTE_ID;
	}

	public void setATTRIBUTE_ID(Integer aTTRIBUTE_ID) {
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

   
