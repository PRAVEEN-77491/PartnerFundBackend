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
@Table(name = "xxpf_fund_pages")
public class FundPagesEntity {

	 @Id
	   @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "xxpf_fund_pages_s")
	   @SequenceGenerator(name = "xxpf_fund_pages_s",sequenceName = "xxpf_fund_pages_s",allocationSize = 1)
	   @Column(name = "FUND_PAGE_ID")
	   private Integer FUND_PAGE_ID;
	   @Column(name = "FUND_ID")
	   private Integer FUND_ID;
	   @Column(name = "PAGE_ID")
	   private Integer PAGE_ID;
	   @Column(name = "ACTIVE_FLAG")
	   private String ACTIVE_FLAG;
	
	   @Column(name = "CREATED_BY")
	   private String CREATED_BY;
	   @Column(name = "CREATION_DATE")
	   private Date CREATION_DATE;
	   @Column(name = "LAST_UPDATED_BY")
	   private String LAST_UPDATED_BY;
	   @Column(name = "LAST_UPDATE_DATE")
	   private Date LAST_UPDATE_DATE;
	public FundPagesEntity() {
		super();
	}
	public FundPagesEntity(Integer fUND_PAGE_ID, Integer fUND_ID, Integer pAGE_ID, String aCTIVE_FLAG,
			String cREATED_BY, Date cREATION_DATE, String lAST_UPDATED_BY, Date lAST_UPDATE_DATE) {
		super();
		FUND_PAGE_ID = fUND_PAGE_ID;
		FUND_ID = fUND_ID;
		PAGE_ID = pAGE_ID;
		ACTIVE_FLAG = aCTIVE_FLAG;
		CREATED_BY = cREATED_BY;
		CREATION_DATE = cREATION_DATE;
		LAST_UPDATED_BY = lAST_UPDATED_BY;
		LAST_UPDATE_DATE = lAST_UPDATE_DATE;
	}
	public Integer getFUND_PAGE_ID() {
		return FUND_PAGE_ID;
	}
	public void setFUND_PAGE_ID(Integer fUND_PAGE_ID) {
		FUND_PAGE_ID = fUND_PAGE_ID;
	}
	public Integer getFUND_ID() {
		return FUND_ID;
	}
	public void setFUND_ID(Integer fUND_ID) {
		FUND_ID = fUND_ID;
	}
	public Integer getPAGE_ID() {
		return PAGE_ID;
	}
	public void setPAGE_ID(Integer pAGE_ID) {
		PAGE_ID = pAGE_ID;
	}
	public String getACTIVE_FLAG() {
		return ACTIVE_FLAG;
	}
	public void setACTIVE_FLAG(String aCTIVE_FLAG) {
		ACTIVE_FLAG = aCTIVE_FLAG;
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
