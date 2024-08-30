package com.PartnersFunds.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.PartnersFunds.DTO.ManageFundDTO;
import com.PartnersFunds.DTO.ManageFundPagesDTO;
import com.PartnersFunds.DTO.ManageRolesDTO;
import com.PartnersFunds.DTO.ManageFundRolesDTO;
import com.PartnersFunds.DTO.ManageFundTablesAttrDTO;
import com.PartnersFunds.DTO.ManageFundTablesDTO;

public interface FundPagesService {

	public ResponseEntity<Map<String, Object>> saveOrUpdateManageFund(ManageFundDTO mfData);

	public ResponseEntity<Map<String, Object>> saveOrUpdateManageRoles(ManageRolesDTO mrData);
	
	public ResponseEntity<Map<String, Object>>  saveOrUpdateManageFundRoles(ManageFundRolesDTO mfrData);

	public  ResponseEntity<Map<String, Object>> saveOrUpdateManageFundPages(ManageFundPagesDTO mfpData);

	public ResponseEntity<Map<String, Object>> saveOrUpdateManageFundTables(ManageFundTablesDTO mftData);

	public ResponseEntity<Map<String, Object>>  saveOrUpdateManageFundTablesAttr(ManageFundTablesAttrDTO mftaData);

	public List<Map<String, Object>> getFundDetails();

	public List<Map<String, Object>> getRoleDetails();

	public List<Map<String, Object>> getFundroleDetails();

}
