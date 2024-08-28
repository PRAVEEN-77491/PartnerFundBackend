package com.PartnersFunds.service;

import java.util.List;
import java.util.Map;

import com.PartnersFunds.DTO.ManageFundDTO;
import com.PartnersFunds.DTO.ManageRolesDTO;
import com.PartnersFunds.Entities.FundPagesEntity;

public interface FundPagesService {

	FundPagesEntity saveData(FundPagesEntity funds);
	
	List<FundPagesEntity> getFundDetails();
	
//	public java.util.Map<String, Object> manageFund(Long fundId, String fundName, String description, String activeFlag, Long userId);
	public Map<String, Object> manageFund(ManageFundDTO mfData);
	public Map<String, Object> manageRoles(ManageRolesDTO mrData);
//	public java.util.Map<String, Object> manageRoles(Long roleId, String roleName, String description, String activeFlag, Long userId);
}
