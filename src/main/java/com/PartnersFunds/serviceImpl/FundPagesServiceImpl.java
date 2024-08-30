package com.PartnersFunds.serviceImpl;

import java.util.HashMap;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import java.util.Map;
import java.util.Optional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.PartnersFunds.DTO.ManageFundDTO;
import com.PartnersFunds.DTO.ManageFundPagesDTO;
import com.PartnersFunds.DTO.ManageRolesDTO;
import com.PartnersFunds.Entities.ManageFundEntity;
import com.PartnersFunds.Entities.ManageFundPagesEntity;
import com.PartnersFunds.Entities.ManageFundRolesEntity;
import com.PartnersFunds.Entities.ManageFundTableAttributesEntity;
import com.PartnersFunds.Entities.ManageFundTablesEntity;
import com.PartnersFunds.Entities.ManageRolesEntity;
import com.PartnersFunds.DTO.ManageFundRolesDTO;
import com.PartnersFunds.DTO.ManageFundTablesAttrDTO;
import com.PartnersFunds.DTO.ManageFundTablesDTO;
import com.PartnersFunds.Repo.ManageFundPagesRepo;
import com.PartnersFunds.Repo.ManageFundRepo;
import com.PartnersFunds.Repo.ManageFundRolesRepo;
import com.PartnersFunds.Repo.ManageFundTableAttributesRepo;
import com.PartnersFunds.Repo.ManageFundTableRepo;
import com.PartnersFunds.Repo.ManageRolesRepo;
import com.PartnersFunds.service.FundPagesService;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;

import java.sql.Types;

@Service
public class FundPagesServiceImpl implements FundPagesService {
    
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	ManageFundRepo manageFundRepo;

	@Autowired
	ManageRolesRepo manageRolesRepo;
	
	@Autowired
	ManageFundRolesRepo manageFundRolesRepo;
	
	@Autowired
	ManageFundPagesRepo manageFundPagesRepo;
	
	@Autowired
	ManageFundTableRepo manageFundTableRepo;
	
	@Autowired
	ManageFundTableAttributesRepo manageFundTableAttributesRepo;

	@Override
	public List<Map<String, Object>> getFundDetails() {
		String sql = "select * from xxpf_funds";
		List<Map<String, Object>> queryResult = jdbcTemplate.queryForList(sql);
        System.out.println("queryResult : " + queryResult);
		return queryResult;
	}

	@Override
	public List<Map<String, Object>> getRoleDetails() {
		String sql = "select * from xxpf_role_master";
		List<Map<String, Object>> queryResult = jdbcTemplate.queryForList(sql);
        System.out.println("queryResult : " + queryResult);
		return queryResult;
	}

	@Override
	public List<Map<String, Object>> getFundroleDetails() {
		String sql = "select * from xxpf_fund_roles";
		List<Map<String, Object>> queryResult = jdbcTemplate.queryForList(sql);
        System.out.println("queryResult : " + queryResult);
		return queryResult;
	}
	
	@Override
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageFund(ManageFundDTO mfData) {
		System.out.println("mfDatea ======> "+mfData.toString());
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName("APPS")
				.withCatalogName("xxpf_partner_fund_utils_pkg").withProcedureName("manage_fund").declareParameters(
						new SqlParameter("p_fund_id", Types.NUMERIC), 
						new SqlParameter("p_fund_name", Types.VARCHAR),
						new SqlParameter("p_description", Types.VARCHAR),
						new SqlParameter("p_active_flag", Types.VARCHAR), 
						new SqlParameter("p_user_id", Types.NUMERIC),
						
						new SqlOutParameter("p_fund_id", Types.NUMERIC),
						new SqlOutParameter("o_status", Types.VARCHAR),
						new SqlOutParameter("o_message", Types.VARCHAR));

		Map<String, Object> inParams = new HashMap<>();
		inParams.put("p_fund_id", mfData.getFundId());
		inParams.put("p_fund_name", mfData.getFundName());
		inParams.put("p_description", mfData.getDescription());
		inParams.put("p_active_flag", mfData.getActiveFlag());
		inParams.put("p_user_id", mfData.getUserId());
		
		Map<String, Object> outParams = jdbcCall.execute(inParams);

	    Map<String, Object> response = new HashMap<>();
	    response.put("o_status", outParams.get("o_status"));
	    response.put("o_message", outParams.get("o_message"));
	    
	    if ("S".equals(outParams.get("o_status"))) { // Assuming "S" indicates success
	    	Optional<ManageFundEntity> manageFund = manageFundRepo.findById(Integer.parseInt(String.valueOf(outParams.get("p_fund_id"))));
	        if (manageFund.isPresent()) {
	            response.put("p_fund", manageFund.get());
	        } else {
	            response.put("p_fund", new HashMap<>()); // or handle the case where fund is not found
	        }
	    } else {
	        response.put("p_fund", new HashMap<>()); // Empty or default value if not successful
	    }
  
	    return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageRoles(ManageRolesDTO mrData) {
		System.out.println("mrDatea ======> "+mrData.toString());
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName("APPS")
				.withCatalogName("xxpf_partner_fund_utils_pkg").withProcedureName("manage_roles").declareParameters(
						new SqlParameter("p_role_id", Types.NUMERIC),
						new SqlParameter("p_role_name", Types.VARCHAR),
						new SqlParameter("p_description", Types.VARCHAR),
						new SqlParameter("p_active_flag", Types.VARCHAR),
						new SqlParameter("p_user_id", Types.NUMERIC),
						new SqlOutParameter("p_role_id", Types.NUMERIC),
						new SqlOutParameter("o_status", Types.VARCHAR),
						new SqlOutParameter("o_message", Types.VARCHAR));

		Map<String, Object> inParams = new HashMap<>();
		inParams.put("p_role_id", mrData.getRoleId());
		inParams.put("p_role_name", mrData.getRoleName());
		inParams.put("p_description", mrData.getDescription());
		inParams.put("p_active_flag", mrData.getActiveFlag());
		inParams.put("p_user_id", mrData.getUserId());

		Map<String, Object> outParams = jdbcCall.execute(inParams);

		 Map<String, Object> response = new HashMap<>();
		    response.put("o_status", outParams.get("o_status"));
		    response.put("o_message", outParams.get("o_message"));
		    
		 if ("S".equals(outParams.get("o_status"))) { 
		    	Optional<ManageRolesEntity> manageRoles = manageRolesRepo.findById(Integer.parseInt(String.valueOf(outParams.get("p_role_id"))));
		        if (manageRoles.isPresent()) {
		            response.put("p_roles", manageRoles.get());
		        } else {
		            response.put("p_roles", new HashMap<>()); // or handle the case where fund is not found
		        }
		    } else {
		        response.put("p_roles", new HashMap<>()); // Empty or default value if not successful
		    }

		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageFundRoles(ManageFundRolesDTO mfrData) {
	    String fundName = mfrData.getFundname();
	    String roleName = mfrData.getRolename();

	    String fundSql = "SELECT fund_id FROM xxpf_funds WHERE name = ?";
	    List<Map<String, Object>> fundQueryResult = jdbcTemplate.queryForList(fundSql, fundName);
	    
	    mfrData.setFundId(Integer.parseInt(String.valueOf(fundQueryResult.get(0).get("fund_id"))));
	    String roleSql = "SELECT role_id FROM xxpf_role_master WHERE name = ?";
	    List<Map<String, Object>> roleQueryResult = jdbcTemplate.queryForList(roleSql, roleName);
	    
	    mfrData.setRoleId(Integer.parseInt(String.valueOf(roleQueryResult.get(0).get("role_id"))));
		System.out.println("mfrDatea ======> "+mfrData.toString());

		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName("APPS")
				.withCatalogName("xxpf_partner_fund_utils_pkg").withProcedureName("manage_fund_roles")
				.declareParameters(new SqlParameter("p_fund_role_id", Types.NUMERIC),
						new SqlParameter("p_fund_id", Types.NUMERIC), 
						new SqlParameter("p_role_id", Types.NUMERIC),
						new SqlParameter("p_active_flag", Types.VARCHAR), 
						new SqlParameter("p_user_id", Types.NUMERIC),
						new SqlOutParameter("p_fund_role_id", Types.NUMERIC),
						new SqlOutParameter("o_status", Types.VARCHAR),
						new SqlOutParameter("o_message", Types.VARCHAR));

		Map<String, Object> inParams = new HashMap<>();
		inParams.put("p_fund_role_id", mfrData.getFundRoleId());
		inParams.put("p_fund_id", mfrData.getFundId());
		inParams.put("p_role_id", mfrData.getRoleId());
		inParams.put("p_active_flag", mfrData.getActiveFlag());
		inParams.put("p_user_id", mfrData.getUserId());

		Map<String, Object> outParams = jdbcCall.execute(inParams);

		Map<String, Object> response = new HashMap<>();
	    response.put("o_status", outParams.get("o_status"));
	    response.put("o_message", outParams.get("o_message"));
	 if ("S".equals(outParams.get("o_status"))) { // Assuming "S" indicates success
	    	Optional<ManageFundRolesEntity> manageFundRoles = manageFundRolesRepo.findById(Integer.parseInt(String.valueOf(outParams.get("p_fund_role_id"))));
	        if (manageFundRoles.isPresent()) {
	            response.put("p_fund_roles", manageFundRoles.get());
	        } else {
	            response.put("p_fund_roles", new HashMap<>()); // or handle the case where fund is not found
	        }
	    } else {
	        response.put("p_fund_roles", new HashMap<>()); // Empty or default value if not successful
	    }
	 
	 return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageFundPages(ManageFundPagesDTO mfpData) {
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName("APPS")
				.withCatalogName("xxpf_partner_fund_utils_pkg") // Package name
				.withProcedureName("manage_fund_pages") // Procedure name
				.declareParameters(new SqlParameter("p_fund_page_id", Types.NUMERIC),
						new SqlParameter("p_fund_id", Types.NUMERIC),
						new SqlParameter("p_page_id", Types.NUMERIC),
						new SqlParameter("p_active_flag", Types.VARCHAR),
						new SqlParameter("p_user_id", Types.NUMERIC),
						new SqlOutParameter("p_fund_page_id", Types.NUMERIC),
						new SqlOutParameter("o_status", Types.VARCHAR),
						new SqlOutParameter("o_message", Types.VARCHAR));

		Map<String, Object> inParams = new HashMap<>();
		inParams.put("p_fund_page_id", mfpData.getP_fund_page_id());
		inParams.put("p_fund_id", mfpData.getP_fund_id());
		inParams.put("p_page_id", mfpData.getP_page_id());
		inParams.put("p_active_flag", mfpData.getP_active_flag());
		inParams.put("p_user_id", mfpData.getP_user_id());

		Map<String, Object> outParams = jdbcCall.execute(inParams);

		Map<String, Object> response = new HashMap<>();
	    response.put("o_status", outParams.get("o_status"));
	    response.put("o_message", outParams.get("o_message"));
	    if ("S".equals(outParams.get("o_status"))) { // Assuming "S" indicates success
	    	Optional<ManageFundPagesEntity> manageFundRoles = manageFundPagesRepo.findById(Integer.parseInt(String.valueOf(outParams.get("p_fund_page_id"))));
	        if (manageFundRoles.isPresent()) {
	            response.put("p_fund_pages", manageFundRoles.get());
	        } else {
	            response.put("p_fund_pages", new HashMap<>()); // or handle the case where fund is not found
	        }
	    } else {
	        response.put("p_fund_pages", new HashMap<>()); // Empty or default value if not successful
	    }
	 
	 return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageFundTables(ManageFundTablesDTO mftData) {
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName("APPS")
				.withCatalogName("xxpf_partner_fund_utils_pkg").withProcedureName("manage_fund_tables")
				.declareParameters(new SqlParameter("p_table_id", Types.NUMERIC),
						new SqlParameter("p_fund_id", Types.NUMERIC), new SqlParameter("p_table_name", Types.VARCHAR),
						new SqlParameter("p_display_name", Types.VARCHAR),
						new SqlParameter("p_usage_level", Types.VARCHAR), new SqlParameter("p_user_id", Types.NUMERIC),
						new SqlOutParameter("o_status", Types.VARCHAR),
						new SqlOutParameter("o_message", Types.VARCHAR));

		Map<String, Object> inParams = new HashMap<>();
		inParams.put("p_table_id", mftData.getP_table_id());
		inParams.put("p_fund_id", mftData.getP_fund_id());
		inParams.put("p_table_name", mftData.getP_table_name());
		inParams.put("p_display_name", mftData.getP_display_name());
		inParams.put("p_usage_level", mftData.getP_usage_level());
		inParams.put("p_user_id", mftData.getP_user_id());

		Map<String, Object> outParams = jdbcCall.execute(inParams);

		Map<String, Object> response = new HashMap<>();
	    response.put("o_status", outParams.get("o_status"));
	    response.put("o_message", outParams.get("o_message"));
	 if ("S".equals(outParams.get("o_status"))) { // Assuming "S" indicates success
	    	Optional<ManageFundTablesEntity> manageFundTable = manageFundTableRepo.findById(Integer.parseInt(String.valueOf(outParams.get("p_table_id"))));
	        if (manageFundTable.isPresent()) {
	            response.put("p_fund_table", manageFundTable.get());
	        } else {
	            response.put("p_fund_table", new HashMap<>()); // or handle the case where fund is not found
	        }
	    } else {
	        response.put("p_fund_table", new HashMap<>()); // Empty or default value if not successful
	    }
	 
	 return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<Map<String, Object>>  saveOrUpdateManageFundTablesAttr(ManageFundTablesAttrDTO mftaData) {
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName("APPS")
				.withCatalogName("xxpf_partner_fund_utils_pkg").withProcedureName("manage_fund_table_attributes")
				.declareParameters(new SqlParameter("p_attribute_id", Types.NUMERIC),
						new SqlParameter("p_table_id", Types.NUMERIC), new SqlParameter("p_column_name", Types.VARCHAR),
						new SqlParameter("p_display_name", Types.VARCHAR),
						new SqlParameter("p_active_flag", Types.VARCHAR), new SqlParameter("p_user_id", Types.NUMERIC),
						new SqlOutParameter("o_status", Types.VARCHAR),
						new SqlOutParameter("o_message", Types.VARCHAR));

		Map<String, Object> inParams = new HashMap<>();
		inParams.put("p_attribute_id", mftaData.getP_attribute_id());
		inParams.put("p_table_id", mftaData.getP_table_id());
		inParams.put("p_column_name", mftaData.getP_column_name());
		inParams.put("p_display_name", mftaData.getP_display_name());
		inParams.put("p_active_flag", mftaData.getP_active_flag());
		inParams.put("p_user_id", mftaData.getP_user_id());

		Map<String, Object> outParams = jdbcCall.execute(inParams);

		Map<String, Object> response = new HashMap<>();
	    response.put("o_status", outParams.get("o_status"));
	    response.put("o_message", outParams.get("o_message"));
	 if ("S".equals(outParams.get("o_status"))) { // Assuming "S" indicates success
	    	Optional<ManageFundTableAttributesEntity> manageFundTableAttribute = manageFundTableAttributesRepo.findById(Integer.parseInt(String.valueOf(outParams.get("p_attribute_id"))));
	        if (manageFundTableAttribute.isPresent()) {
	            response.put("p_fund_table_attributes", manageFundTableAttribute.get());
	        } else {
	            response.put("p_fund_table_attributes", new HashMap<>()); // or handle the case where fund is not found
	        }
	    } else {
	        response.put("p_fund_table_attributes", new HashMap<>()); // Empty or default value if not successful
	    }
	 
	 return ResponseEntity.ok(response);
	}
	

}
