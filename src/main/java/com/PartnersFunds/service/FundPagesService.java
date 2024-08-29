package com.PartnersFunds.service;

import java.util.List;
import java.util.Map;

import com.PartnersFunds.DTO.ManageFundDTO;
import com.PartnersFunds.DTO.ManageFundPagesDTO;
import com.PartnersFunds.DTO.ManageRolesDTO;
import com.PartnersFunds.DTO.ManageFundRolesDTO;
import com.PartnersFunds.DTO.ManageFundTablesAttrDTO;
import com.PartnersFunds.DTO.ManageFundTablesDTO;
import com.PartnersFunds.Entities.FundPagesEntity;

public interface FundPagesService {

	FundPagesEntity saveData(FundPagesEntity funds);
	
	List<FundPagesEntity> getFundDetails();
	
	public Map<String, Object> manageFund(ManageFundDTO mfData);
	public Map<String, Object> manageRoles(ManageRolesDTO mrData);
	public Map<String, Object> manageFundRoles(ManageFundRolesDTO mfrData) ;
	public Map<String, Object> manageFundPages(ManageFundPagesDTO mfpData) ;
	public Map<String,Object> manageFundtables(ManageFundTablesDTO mftData);
	public Map<String,Object> manageFundtablesAttr(ManageFundTablesAttrDTO mftaData);
}
