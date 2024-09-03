package com.PartnersFunds.serviceImpl;

import java.util.HashMap;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.util.Map;
import javax.sql.DataSource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.PartnersFunds.DTO.ManageActivitiesDTO;
import com.PartnersFunds.DTO.ManageBpaWorkflowActivitiesDTO;
import com.PartnersFunds.DTO.ManageFundBpaRbacRolesDTO;
import com.PartnersFunds.DTO.ManageFundDTO;
import com.PartnersFunds.DTO.ManageFundPagesDTO;
import com.PartnersFunds.DTO.ManageRolesDTO;
import com.PartnersFunds.DTO.ManageWorkflowTransitionsDTO;
import com.PartnersFunds.DTO.ManageFundRolesDTO;
import com.PartnersFunds.DTO.ManageFundTablesAttrDTO;
import com.PartnersFunds.DTO.ManageFundTablesDTO;
import com.PartnersFunds.DTO.ManageFundTimelinesDTO;
import com.PartnersFunds.DTO.ManageLookupCodesDTO;
import com.PartnersFunds.DTO.ManageLookupTypesDTO;
import com.PartnersFunds.DTO.ManagePageFeatureRbacDTO;
import com.PartnersFunds.DTO.ManagePageFeaturesDTO;
import com.PartnersFunds.DTO.ManagePageRuleCriteriaDTO;
import com.PartnersFunds.DTO.ManagePageRuleSetAttrDTO;
import com.PartnersFunds.DTO.ManagePageRulesDTO;
import com.PartnersFunds.DTO.ManagePartnershipAssociationsDTO;
import com.PartnersFunds.DTO.ManagePartnershipContactsDTO;
import com.PartnersFunds.DTO.ManagePartnershipGeographyDTO;
import com.PartnersFunds.DTO.ManagePartnershipReferencesDTO;
import com.PartnersFunds.DTO.ManagePartnershipsDTO;
import com.PartnersFunds.DTO.ManagePlansDTO;
import com.PartnersFunds.service.FundPagesService;
import com.PartnersFunds.utils.JdbcCallBuilder;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;

import java.security.Principal;
import java.sql.Types;

@Service
public class FundPagesServiceImpl implements FundPagesService {
    
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	JdbcCallBuilder jdbcCallBuilder;
	
	@Autowired
	DataSource dataSource;

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
	    String sql = "SELECT fr.*, f.name AS fundNname, rm.name AS roleName " +
                "FROM xxpf_fund_roles fr " +
                "JOIN xxpf_funds f ON fr.fund_id = f.fund_id " +
                "JOIN xxpf_role_master rm ON fr.role_id = rm.role_id";

	   List<Map<String, Object>> queryResult = jdbcTemplate.queryForList(sql);
	   System.out.println("queryResult : " + queryResult);
		return queryResult;
	}
	

	@Override
	public List<Map<String, Object>> getManageFundPagesDetails() {
		String sql = "select * from xxpf_fund_pages";
		List<Map<String, Object>> queryResult = jdbcTemplate.queryForList(sql);
		System.out.println("queryResult : " + queryResult);
		return queryResult;
	}
	
	@Override
	public List<Map<String, Object>> getManageFundTablesDetails() {
//		String sql = "select * from xxpf_fund_tables";
	    String sql = "SELECT fr.*, f.name AS fundNname  " +
                "FROM xxpf_fund_tables fr " +
                "JOIN xxpf_funds f ON fr.fund_id = f.fund_id";
		List<Map<String, Object>> queryResult = jdbcTemplate.queryForList(sql);
		System.out.println("queryResult : " + queryResult);
		return queryResult;
	}
	
	@Override
	public List<Map<String, Object>> getManageFundTablesAttrDetails() {
		String sql = "select * from xxpf_fund_table_attributes";
		List<Map<String, Object>> queryResult = jdbcTemplate.queryForList(sql);
		System.out.println("queryResult : " + queryResult);
		return queryResult;
	}
	
	@Override
	public List<Map<String, Object>> getManagePageFeaturesDetails() {
		String sql = "select * from xxpf_page_features";
		List<Map<String, Object>> queryResult = jdbcTemplate.queryForList(sql);
		System.out.println("queryResult : " + queryResult);
		return queryResult;
	}
	
	@Override
	public List<Map<String, Object>> getManagePageFeatureRbacDetails() {
		String sql = "select * from xxpf_fund_bpa_page_feature_rbac";
		List<Map<String, Object>> queryResult = jdbcTemplate.queryForList(sql);
		System.out.println("queryResult : " + queryResult);
		return queryResult;
	}

	@Override
	public List<Map<String, Object>> getManageFundBpaRbacRolesDetails() {
		String sql = "select * from xxpf_fund_bpa_rbac_roles";
		List<Map<String, Object>> queryResult = jdbcTemplate.queryForList(sql);
		System.out.println("queryResult : " + queryResult);
		return queryResult;
	}

	@Override
	public List<Map<String, Object>> getManageFundTimelinesDetails() {
		String sql = "select * from xxpf_fund_timelines";
		List<Map<String, Object>> queryResult = jdbcTemplate.queryForList(sql);
		System.out.println("queryResult : " + queryResult);
		return queryResult;
	}

	@Override
	public List<Map<String, Object>> getManagePlansDetails() {
		String sql = "select * from xxpf_plans";
		List<Map<String, Object>> queryResult = jdbcTemplate.queryForList(sql);
		System.out.println("queryResult : " + queryResult);
		return queryResult;
	}

	@Override
	public List<Map<String, Object>> getManageActivitiesDetails() {
		String sql = "select * from xxpf_activities";
		List<Map<String, Object>> queryResult = jdbcTemplate.queryForList(sql);
		System.out.println("queryResult : " + queryResult);
		return queryResult;
	}
	
	@Override
	public List<Map<String, Object>> getManageBpaWorkflowActivitiesDetails() {
		String sql = "select * from xxpf_bpa_workflow_activities";
		List<Map<String, Object>> queryResult = jdbcTemplate.queryForList(sql);
		System.out.println("queryResult : " + queryResult);
		return queryResult;
	}
	
	@Override
	public List<Map<String, Object>> getManageWorkflowTransitionsDetails() {
		String sql = "select * from xxpf_bpa_workflow_transition";
		List<Map<String, Object>> queryResult = jdbcTemplate.queryForList(sql);
		System.out.println("queryResult : " + queryResult);
		return queryResult;
	}
	
	@Override
	public List<Map<String, Object>> getManageLookupTypesDetails() {
		String sql = "select * from xxpf_lookup_types";
		List<Map<String, Object>> queryResult = jdbcTemplate.queryForList(sql);
		System.out.println("queryResult : " + queryResult);
		return queryResult;
	}
	
	@Override
	public List<Map<String, Object>> getManageLookupCodesDetails() {
		String sql = "select * from xxpf_lookup_codes";
		List<Map<String, Object>> queryResult = jdbcTemplate.queryForList(sql);
		System.out.println("queryResult : " + queryResult);
		return queryResult;
	}
	
	@Override
	public List<Map<String, Object>> getManagePageRulesDetails() {
		String sql = "select * from xxpf_page_rules;";
		List<Map<String, Object>> queryResult = jdbcTemplate.queryForList(sql);
		System.out.println("queryResult : " + queryResult);
		return queryResult;
	}
	
	@Override
	public List<Map<String, Object>> getManagePageRuleCriteriaDetails() {
		String sql = "select * from xxpf_page_rule_criteria";
		List<Map<String, Object>> queryResult = jdbcTemplate.queryForList(sql);
		System.out.println("queryResult : " + queryResult);
		return queryResult;
	}
	
	@Override
	public List<Map<String, Object>> getManagePageRuleSetAttrDetails() {
		String sql = "select * from xxpf_page_rule_set_attributes";
		List<Map<String, Object>> queryResult = jdbcTemplate.queryForList(sql);
		System.out.println("queryResult : " + queryResult);
		return queryResult;
	}
	
	@Override
	public List<Map<String, Object>> getManagePartnershipsDetails() {
		String sql = "select * from xxpf_partnerships";
		List<Map<String, Object>> queryResult = jdbcTemplate.queryForList(sql);
		System.out.println("queryResult : " + queryResult);
		return queryResult;
	}
	
	@Override
	public List<Map<String, Object>> getManagePartnershipGeographyDetails() {
		String sql = "select * from xxpf_partnership_geography";
		List<Map<String, Object>> queryResult = jdbcTemplate.queryForList(sql);
		System.out.println("queryResult : " + queryResult);
		return queryResult;
	}
	
	@Override
	public List<Map<String, Object>> getPartnershipReferencesDetails() {
		String sql = "select * from xxpf_partnership_references";
		List<Map<String, Object>> queryResult = jdbcTemplate.queryForList(sql);
		System.out.println("queryResult : " + queryResult);
		return queryResult;
	}
	
	@Override
	public List<Map<String, Object>> getManagePartnershipContactsDetails() {
		String sql = "select * from xxpf_partnership_contacts";
		List<Map<String, Object>> queryResult = jdbcTemplate.queryForList(sql);
		System.out.println("queryResult : " + queryResult);
		return queryResult;
	}
	
	@Override
	public List<Map<String, Object>> getManagePartnershipAssociationsDetails() {
		String sql = "select * from xxpf_partnership_associations";
		List<Map<String, Object>> queryResult = jdbcTemplate.queryForList(sql);
		System.out.println("queryResult : " + queryResult);
		return queryResult;
	}
	
	@Override
	public List<Map<String, Object>> getFundBpaDetails() {
		String sql = "select * from xxpf_fund_bpa";
		List<Map<String, Object>> queryResult = jdbcTemplate.queryForList(sql);
		System.out.println("queryResult : " + queryResult);
		return queryResult;
	}
	
	@Override
	public List<Map<String, Object>> getRoleBasedFundBpaDetails() {
		String sql = "select * from xxpf_fund_bpa where bpa_type = 'Role Based'";
		List<Map<String, Object>> queryResult = jdbcTemplate.queryForList(sql);
		System.out.println("queryResult : " + queryResult);
		return queryResult;
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageFund(ManageFundDTO mfData){//, Authentication pr) {
		System.out.println("mfDatea ======> "+mfData.toString());
		SimpleJdbcCall jdbcCall = jdbcCallBuilder.buildSimpleJdbcCall(dataSource, "APPS", "xxpf_partner_fund_utils_pkg", "manage_fund").declareParameters(
						new SqlInOutParameter("p_fund_id", Types.NUMERIC), 
						new SqlParameter("p_fund_name", Types.VARCHAR),
						new SqlParameter("p_description", Types.VARCHAR),
						new SqlParameter("p_active_flag", Types.VARCHAR), 
						new SqlParameter("p_user_id", Types.NUMERIC),

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
	    
	    if ("S".equals(outParams.get("o_status"))) {
	        String query = "SELECT * FROM xxpf_funds WHERE fund_id = ?";
	        Map<String, Object> manageFund = jdbcTemplate.queryForMap(query, outParams.get("p_fund_id"));
	        response.put("fund", manageFund);
	    } else {
	        response.put("fund", new HashMap<>());
	    }
  
	    return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageRoles(ManageRolesDTO mrData) {
		System.out.println("mrDatea ======> "+mrData.toString());
		SimpleJdbcCall jdbcCall = jdbcCallBuilder.buildSimpleJdbcCall(dataSource, "APPS", "xxpf_partner_fund_utils_pkg", "manage_roles").declareParameters(
						new SqlInOutParameter("p_role_id", Types.NUMERIC),
						new SqlParameter("p_role_name", Types.VARCHAR),
						new SqlParameter("p_description", Types.VARCHAR),
						new SqlParameter("p_active_flag", Types.VARCHAR),
						new SqlParameter("p_user_id", Types.NUMERIC),
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
		        String query = "SELECT * FROM xxpf_role_master WHERE role_id = ?";
		        Map<String, Object> manageRoles = jdbcTemplate.queryForMap(query, outParams.get("p_role_id"));
		        response.put("role", manageRoles);
		    } else {
		        response.put("role", new HashMap<>());
		    }

		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageFundRoles(ManageFundRolesDTO mfrData) {
		System.out.println("mfrData ======> "+mfrData.toString());
	    String fundName = mfrData.getFundname();
	    String roleName = mfrData.getRolename();

	    String fundSql = "SELECT fund_id FROM xxpf_funds WHERE name = ?";
	    List<Map<String, Object>> fundQueryResult = jdbcTemplate.queryForList(fundSql, fundName);
	    System.out.println("fundQueryResult : " + fundQueryResult.toString());
	    
	    mfrData.setFundId(Integer.parseInt(String.valueOf(fundQueryResult.get(0).get("fund_id"))));
	    String roleSql = "SELECT role_id FROM xxpf_role_master WHERE name = ?";
	    List<Map<String, Object>> roleQueryResult = jdbcTemplate.queryForList(roleSql, roleName);
	    System.out.println("roleQueryResult : " + fundQueryResult.toString());
	    
	    mfrData.setRoleId(Integer.parseInt(String.valueOf(roleQueryResult.get(0).get("role_id"))));
		System.out.println("mfrDatea ======> "+mfrData.toString());

		SimpleJdbcCall jdbcCall = jdbcCallBuilder.buildSimpleJdbcCall(dataSource, "APPS", "xxpf_partner_fund_utils_pkg", "manage_fund_roles")
				.declareParameters(new SqlInOutParameter("p_fund_role_id", Types.NUMERIC),
						new SqlParameter("p_fund_id", Types.NUMERIC), 
						new SqlParameter("p_role_id", Types.NUMERIC),
						new SqlParameter("p_active_flag", Types.VARCHAR), 
						new SqlParameter("p_user_id", Types.NUMERIC),
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

	    if ("S".equals(outParams.get("o_status"))) {
	        String query = "SELECT fr.*, f.name AS fundName, rm.name AS roleName " +
	                 "FROM xxpf_fund_roles fr " +
	                 "JOIN xxpf_funds f ON fr.fund_id = f.fund_id " +
	                 "JOIN xxpf_role_master rm ON fr.role_id = rm.role_id " +
	                 "WHERE fr.fund_role_id = :fundroleId";
	        Map<String, Object> manageFundRoles = jdbcTemplate.queryForMap(query, outParams.get("p_fund_role_id"));
	        response.put("fund_role", manageFundRoles);
	    } else {
	        response.put("fund_role", new HashMap<>());
	    }
	 
	 return ResponseEntity.ok(response);
	}
	@Override
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageFundPages(ManageFundPagesDTO mfpData) {
		System.out.println("mfrData ======> "+mfpData.toString());
		SimpleJdbcCall jdbcCall = jdbcCallBuilder.buildSimpleJdbcCall(dataSource, "APPS", "xxpf_partner_fund_utils_pkg", "manage_fund_pages")
				.declareParameters(new SqlInOutParameter("p_fund_page_id", Types.NUMERIC),
						new SqlParameter("p_fund_id", Types.NUMERIC),
						new SqlParameter("p_page_id", Types.NUMERIC),
						new SqlParameter("p_active_flag", Types.VARCHAR),
						new SqlParameter("p_user_id", Types.NUMERIC),
						new SqlOutParameter("o_status", Types.VARCHAR),
						new SqlOutParameter("o_message", Types.VARCHAR));

		Map<String, Object> inParams = new HashMap<>();
		inParams.put("p_fund_page_id", mfpData.getFundPageId());
		inParams.put("p_fund_id", mfpData.getFundId());
		inParams.put("p_page_id", mfpData.getPageId());
		inParams.put("p_active_flag", mfpData.getActiveFlag());
		inParams.put("p_user_id", mfpData.getUserId());

		Map<String, Object> outParams = jdbcCall.execute(inParams);

		Map<String, Object> response = new HashMap<>();
	    response.put("o_status", outParams.get("o_status"));
	    response.put("o_message", outParams.get("o_message"));

	    if ("S".equals(outParams.get("o_status"))) {
	        String query = "SELECT * FROM xxpf_fund_pages WHERE fund_page_id = ?";
	        Map<String, Object> manageFundPage = jdbcTemplate.queryForMap(query, outParams.get("p_fund_page_id"));
	        response.put("fund_page", manageFundPage);
	    } else {
	        response.put("fund_page", new HashMap<>());
	    }
	 
	 return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageFundTables(ManageFundTablesDTO mftData) {
		System.out.println("mfrData ======> "+mftData.toString());
		SimpleJdbcCall jdbcCall = jdbcCallBuilder.buildSimpleJdbcCall(dataSource, "APPS", "xxpf_partner_fund_utils_pkg", "manage_fund_tables")
				.declareParameters(new SqlInOutParameter("p_table_id", Types.NUMERIC),
						new SqlParameter("p_fund_id", Types.NUMERIC), new SqlParameter("p_table_name", Types.VARCHAR),
						new SqlParameter("p_display_name", Types.VARCHAR),
						new SqlParameter("p_usage_level", Types.VARCHAR), new SqlParameter("p_user_id", Types.NUMERIC),
						new SqlOutParameter("o_status", Types.VARCHAR),
						new SqlOutParameter("o_message", Types.VARCHAR));

		Map<String, Object> inParams = new HashMap<>();
		inParams.put("p_table_id", mftData.getTableId());
		inParams.put("p_fund_id", mftData.getFundId());
		inParams.put("p_table_name", mftData.getTablename());
		inParams.put("p_display_name", mftData.getDisplayName());
		inParams.put("p_usage_level", mftData.getUsagelevel());
		inParams.put("p_user_id", mftData.getUserId());

		Map<String, Object> outParams = jdbcCall.execute(inParams);

		Map<String, Object> response = new HashMap<>();
	    response.put("o_status", outParams.get("o_status"));
	    response.put("o_message", outParams.get("o_message"));
	 
	    if ("S".equals(outParams.get("o_status"))) {
	        String query = "SELECT * FROM xxpf_fund_tables WHERE table_id = ?";
	        Map<String, Object> manageFundTable = jdbcTemplate.queryForMap(query, outParams.get("p_table_id"));
	        response.put("fund_table", manageFundTable);
	    } else {
	        response.put("fund_table", new HashMap<>());
	    }
	 
	 return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<Map<String, Object>>  saveOrUpdateManageFundTablesAttr(ManageFundTablesAttrDTO mftaData) {
		System.out.println("mfrData ======> "+mftaData.toString());
		SimpleJdbcCall jdbcCall = jdbcCallBuilder.buildSimpleJdbcCall(dataSource, "APPS", "xxpf_partner_fund_utils_pkg", "manage_fund_table_attributes")
				.declareParameters(new SqlInOutParameter("p_attribute_id", Types.NUMERIC),
						new SqlParameter("p_table_id", Types.NUMERIC), new SqlParameter("p_column_name", Types.VARCHAR),
						new SqlParameter("p_display_name", Types.VARCHAR),
						new SqlParameter("p_active_flag", Types.VARCHAR), new SqlParameter("p_user_id", Types.NUMERIC),
						new SqlOutParameter("o_status", Types.VARCHAR),
						new SqlOutParameter("o_message", Types.VARCHAR));

		Map<String, Object> inParams = new HashMap<>();
		inParams.put("p_attribute_id", mftaData.getAttrId());
		inParams.put("p_table_id", mftaData.getTableId());
		inParams.put("p_column_name", mftaData.getColumnName());
		inParams.put("p_display_name", mftaData.getDisplayName());
		inParams.put("p_active_flag", mftaData.getActiveFlag());
		inParams.put("p_user_id", mftaData.getUserId());

		Map<String, Object> outParams = jdbcCall.execute(inParams);

		Map<String, Object> response = new HashMap<>();
	    response.put("o_status", outParams.get("o_status"));
	    response.put("o_message", outParams.get("o_message"));
	 
	    if ("S".equals(outParams.get("o_status"))) {
	        String query = "SELECT * FROM xxpf_fund_table_attributes WHERE attribute_id = ?";
	        Map<String, Object> manageFundTableAttribute = jdbcTemplate.queryForMap(query, outParams.get("p_attribute_id"));
	        response.put("fund_table_attr", manageFundTableAttribute);
	    } else {
	        response.put("fund_table_attr", new HashMap<>());
	    }
	 
	 return ResponseEntity.ok(response);
	}
	
	@Override
	public ResponseEntity<Map<String, Object>> saveOrUpdateManagePageFeatures(ManagePageFeaturesDTO mpfData) {
		System.out.println("mfrData ======> "+mpfData.toString());
	    SimpleJdbcCall jdbcCall = jdbcCallBuilder.buildSimpleJdbcCall(dataSource, "APPS", "xxpf_partner_fund_utils_pkg", "manage_page_features")
	            .declareParameters(
	                    new SqlInOutParameter("p_feature_id", Types.NUMERIC),
	                    new SqlParameter("p_page_id", Types.NUMERIC),
	                    new SqlParameter("p_feature_name", Types.VARCHAR),
	                    new SqlParameter("p_feature_type", Types.VARCHAR),
	                    new SqlParameter("p_display_name", Types.VARCHAR),
	                    new SqlParameter("p_property_tag", Types.VARCHAR),
	                    new SqlParameter("p_user_id", Types.NUMERIC),
	                    new SqlOutParameter("o_status", Types.VARCHAR),
	                    new SqlOutParameter("o_message", Types.VARCHAR)
	            );

	    // Map input parameters
		Map<String, Object> inParams = new HashMap<>();
	    inParams.put("p_feature_id", mpfData.getFeatureId());
	    inParams.put("p_page_id", mpfData.getPageId());
	    inParams.put("p_feature_name", mpfData.getFeatureName());
	    inParams.put("p_feature_type", mpfData.getFeatureType());
	    inParams.put("p_display_name", mpfData.getDisplayName());
	    inParams.put("p_property_tag", mpfData.getPropertyTag());
	    inParams.put("p_user_id", mpfData.getUserId());

	    Map<String, Object> outParams = jdbcCall.execute(inParams);

	    Map<String, Object> response = new HashMap<>();
	    response.put("o_status", outParams.get("o_status"));
	    response.put("o_message", outParams.get("o_message"));

	    if ("S".equals(outParams.get("o_status"))) {
	        String query = "SELECT * FROM xxpf_page_features WHERE feature_id = ?";
	        Map<String, Object> pageFeature = jdbcTemplate.queryForMap(query, outParams.get("p_feature_id"));
	        response.put("page_feature", pageFeature);
	    } else {
	        response.put("page_feature", new HashMap<>());
	    }

	    return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<Map<String, Object>> saveOrUpdateManagePageFeatureRbac(ManagePageFeatureRbacDTO mpfrData) {
		System.out.println("mfrData ======> "+mpfrData.toString());
	    SimpleJdbcCall jdbcCall = jdbcCallBuilder.buildSimpleJdbcCall(dataSource, "APPS", "xxpf_partner_fund_utils_pkg", "manage_page_feature_rbac")
	            .declareParameters(
	                    new SqlInOutParameter("p_rbac_feature_id", Types.NUMERIC),
	                    new SqlParameter("p_fund_bpa_id", Types.NUMERIC),
	                    new SqlParameter("p_page_id", Types.NUMERIC),
	                    new SqlParameter("p_feature_id", Types.NUMERIC),
	                    new SqlParameter("p_read_flag", Types.VARCHAR),
	                    new SqlParameter("p_write_flag", Types.VARCHAR),
	                    new SqlParameter("p_user_id", Types.NUMERIC),
	                    new SqlOutParameter("o_status", Types.VARCHAR),
	                    new SqlOutParameter("o_message", Types.VARCHAR)
	            );

	    Map<String, Object> inParams = new HashMap<>();
	    inParams.put("p_rbac_feature_id", mpfrData.getRbacFeatureId());
	    inParams.put("p_fund_bpa_id", mpfrData.getFundBpaId());
	    inParams.put("p_page_id", mpfrData.getPageId());
	    inParams.put("p_feature_id", mpfrData.getFeatureId());
	    inParams.put("p_read_flag", mpfrData.getReadFlag());
	    inParams.put("p_write_flag", mpfrData.getWriteFlag());
	    inParams.put("p_user_id", mpfrData.getUserId());

	    Map<String, Object> outParams = jdbcCall.execute(inParams);

	    Map<String, Object> response = new HashMap<>();
	    response.put("o_status", outParams.get("o_status"));
	    response.put("o_message", outParams.get("o_message"));

	    if ("S".equals(outParams.get("o_status"))) {
	        String query = "SELECT * FROM xxpf_fund_bpa_page_feature_rbac WHERE rbac_feature_id = ?";
	        Map<String, Object> featureData = jdbcTemplate.queryForMap(query, outParams.get("p_rbac_feature_id"));
	        response.put("page_feature_rbac", featureData);
	    } else {
	        response.put("page_feature_rbac", new HashMap<>());
	    }

	    return ResponseEntity.ok(response);
	}	
	
	@Override
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageFundBpaRbacRoles(ManageFundBpaRbacRolesDTO mfbrrData) {
		System.out.println("mfrData ======> "+mfbrrData.toString());
	    SimpleJdbcCall jdbcCall = jdbcCallBuilder.buildSimpleJdbcCall(dataSource, "APPS", "xxpf_partner_fund_utils_pkg", "manage_fund_bpa_rbac_roles")
	            .declareParameters(
	                    new SqlInOutParameter("p_rbac_role_id", Types.NUMERIC),
	                    new SqlParameter("p_fund_bpa_id", Types.NUMERIC),
	                    new SqlParameter("p_role_id", Types.NUMERIC),
	                    new SqlParameter("p_user_id", Types.NUMERIC),
	                    new SqlOutParameter("o_status", Types.VARCHAR),
	                    new SqlOutParameter("o_message", Types.VARCHAR)
	            );

	    Map<String, Object> inParams = new HashMap<>();
	    inParams.put("p_rbac_role_id", mfbrrData.getRbacRoleId());
	    inParams.put("p_fund_bpa_id", mfbrrData.getFundBpaId());
	    inParams.put("p_role_id", mfbrrData.getRoleId());
	    inParams.put("p_user_id", mfbrrData.getUserId());

	    Map<String, Object> outParams = jdbcCall.execute(inParams);

	    Map<String, Object> response = new HashMap<>();
	    response.put("o_status", outParams.get("o_status"));
	    response.put("o_message", outParams.get("o_message"));

	    if ("S".equals(outParams.get("o_status"))) {
	        String query = "SELECT * FROM xxpf_fund_bpa_rbac_roles WHERE rbac_role_id = ?";
	        Map<String, Object> roleData = jdbcTemplate.queryForMap(query, outParams.get("p_rbac_role_id"));
	        response.put("fund_bpa_rbac_role", roleData);
	    } else {
	        response.put("fund_bpa_rbac_role", new HashMap<>());
	    }

	    return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageFundTimelines(ManageFundTimelinesDTO mftData) {
		System.out.println("mfrData ======> "+mftData.toString());
	    SimpleJdbcCall jdbcCall = jdbcCallBuilder.buildSimpleJdbcCall(dataSource, "APPS", "xxpf_partner_fund_utils_pkg", "manage_fund_timelines")
	            .declareParameters(
	                    new SqlInOutParameter("p_timeline_id", Types.NUMERIC),
	                    new SqlParameter("p_fund_id", Types.NUMERIC),
	                    new SqlParameter("p_timeline_category", Types.VARCHAR),
	                    new SqlParameter("p_fiscal_year", Types.NUMERIC),
	                    new SqlParameter("p_stage_name", Types.VARCHAR),
	                    new SqlParameter("p_interval_value", Types.VARCHAR),
	                    new SqlParameter("p_start_date", Types.DATE),
	                    new SqlParameter("p_end_date", Types.DATE),
	                    new SqlParameter("p_user_id", Types.NUMERIC),
	                    new SqlOutParameter("o_status", Types.VARCHAR),
	                    new SqlOutParameter("o_message", Types.VARCHAR)
	            );

	    Map<String, Object> inParams = new HashMap<>();
	    inParams.put("p_timeline_id", mftData.getTimelineId());
	    inParams.put("p_fund_id", mftData.getFundId());
	    inParams.put("p_timeline_category", mftData.getTimelineCategory());
	    inParams.put("p_fiscal_year", mftData.getFiscalYear());
	    inParams.put("p_stage_name", mftData.getStageName());
	    inParams.put("p_interval_value", mftData.getIntervalValue());
	    inParams.put("p_start_date", mftData.getStartDate());
	    inParams.put("p_end_date", mftData.getEndDate());
	    inParams.put("p_user_id", mftData.getUserId());

	    Map<String, Object> outParams = jdbcCall.execute(inParams);

	    Map<String, Object> response = new HashMap<>();
	    response.put("o_status", outParams.get("o_status"));
	    response.put("o_message", outParams.get("o_message"));

	    if ("S".equals(outParams.get("o_status"))) {
	        String query = "SELECT * FROM xxpf_fund_timelines WHERE timeline_id = ?";
	        Map<String, Object> timelineData = jdbcTemplate.queryForMap(query, outParams.get("p_timeline_id"));
	        response.put("fund_timeline", timelineData);
	    } else {
	        response.put("fund_timeline", new HashMap<>());
	    }

	    return ResponseEntity.ok(response);
	}


	@Override
	public ResponseEntity<Map<String, Object>> saveOrUpdateManagePlans(ManagePlansDTO mpData) {
	    System.out.println("mpData ======> " + mpData.toString());
	    SimpleJdbcCall jdbcCall = jdbcCallBuilder.buildSimpleJdbcCall(dataSource, "APPS", "xxpf_partner_fund_utils_pkg", "manage_plans")
	            .declareParameters(
	                    new SqlInOutParameter("p_Plan_ID", Types.NUMERIC),
	                    new SqlParameter("p_Plan_Name", Types.VARCHAR),
	                    new SqlParameter("p_Fund_id", Types.NUMERIC),
	                    new SqlParameter("p_partnership_id", Types.NUMERIC),
	                    new SqlParameter("p_Region", Types.VARCHAR),
	                    new SqlParameter("p_Theater", Types.VARCHAR),
	                    new SqlParameter("p_Fiscal_Year", Types.NUMERIC),
	                    new SqlParameter("p_Distributor_ID_Plan", Types.VARCHAR),
	                    new SqlParameter("p_Plan_Stage", Types.VARCHAR),
	                    new SqlParameter("p_Plan_Distributor_Payee_Country", Types.VARCHAR),
	                    new SqlParameter("p_Distributor_Payee_Country", Types.VARCHAR),
	                    new SqlParameter("p_WS_Plan_Token", Types.VARCHAR),
	                    new SqlParameter("p_user_id", Types.NUMERIC),
	                    new SqlOutParameter("o_status", Types.VARCHAR),
	                    new SqlOutParameter("o_message", Types.VARCHAR)
	            );

	    // Map input parameters
	    Map<String, Object> inParams = new HashMap<>();
	    inParams.put("p_Plan_ID", mpData.getPlanId());
	    inParams.put("p_Plan_Name", mpData.getPlanName());
	    inParams.put("p_Fund_id", mpData.getFundId());
	    inParams.put("p_partnership_id", mpData.getPartnershipId());
	    inParams.put("p_Region", mpData.getRegion());
	    inParams.put("p_Theater", mpData.getTheater());
	    inParams.put("p_Fiscal_Year", mpData.getFiscalYear());
	    inParams.put("p_Distributor_ID_Plan", mpData.getDistributorIdPlan());
	    inParams.put("p_Plan_Stage", mpData.getPlanStage());
	    inParams.put("p_Plan_Distributor_Payee_Country", mpData.getPlanDistributorPayeeCountry());
	    inParams.put("p_Distributor_Payee_Country", mpData.getDistributorPayeeCountry());
	    inParams.put("p_WS_Plan_Token", mpData.getWsPlanToken());
	    inParams.put("p_user_id", mpData.getUserId());

	    Map<String, Object> outParams = jdbcCall.execute(inParams);

	    Map<String, Object> response = new HashMap<>();
	    response.put("o_status", outParams.get("o_status"));
	    response.put("o_message", outParams.get("o_message"));

	    if ("S".equals(outParams.get("o_status"))) {
	        String query = "SELECT * FROM xxpf_plans WHERE plan_id = ?";
	        Map<String, Object> planDetails = jdbcTemplate.queryForMap(query, outParams.get("p_Plan_ID"));
	        response.put("plan", planDetails);
	    } else {
	        response.put("plan", new HashMap<>());
	    }

	    return ResponseEntity.ok(response);
	}


	@Override
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageActivities(ManageActivitiesDTO maData) {
	    System.out.println("maData ======> " + maData.toString());
	    SimpleJdbcCall jdbcCall = jdbcCallBuilder.buildSimpleJdbcCall(dataSource, "APPS", "xxpf_partner_fund_utils_pkg", "manage_activities")
	            .declareParameters(
	                    new SqlInOutParameter("p_Activity_Id", Types.NUMERIC),
	                    new SqlParameter("p_Activity_Name", Types.VARCHAR),
	                    new SqlParameter("p_Plan_Id", Types.NUMERIC),
	                    new SqlParameter("p_Stage", Types.VARCHAR),
	                    new SqlParameter("p_Activity_Group", Types.VARCHAR),
	                    new SqlParameter("p_Activity_Description", Types.VARCHAR),
	                    new SqlParameter("p_Sub_Track", Types.VARCHAR),
	                    new SqlParameter("p_Track", Types.VARCHAR),
	                    new SqlParameter("p_Activity_Start_Date", Types.DATE),
	                    new SqlParameter("p_Activity_End_Date", Types.DATE),
	                    new SqlParameter("p_Activity_Expiration_Date", Types.DATE),
	                    new SqlParameter("p_Activity_Requested_Amount", Types.NUMERIC),
	                    new SqlParameter("p_Activity_Requested_Amount_Currency", Types.VARCHAR),
	                    new SqlParameter("p_Activity_Metrics", Types.VARCHAR),
	                    new SqlParameter("p_Activity_Target", Types.NUMERIC),
	                    new SqlParameter("p_Activity_Results_Submitted", Types.NUMERIC),
	                    new SqlParameter("p_Funding_Quarter", Types.VARCHAR),
	                    new SqlParameter("p_Cisco_Funding_Quarter", Types.VARCHAR),
	                    new SqlParameter("p_Activity_Start_Fiscal_Quarter", Types.VARCHAR),
	                    new SqlParameter("p_Activity_Type", Types.VARCHAR),
	                    new SqlParameter("p_Distributor_Unique_Id", Types.VARCHAR),
	                    new SqlParameter("p_Initiative", Types.VARCHAR),
	                    new SqlParameter("p_Fund_Shell", Types.VARCHAR),
	                    new SqlParameter("p_Milestone_Name", Types.VARCHAR),
	                    new SqlParameter("p_Achievement", Types.VARCHAR),
	                    new SqlParameter("p_Currency", Types.VARCHAR),
	                    new SqlParameter("p_Achievement_Percent", Types.NUMERIC),
	                    new SqlParameter("p_Sliding_Scale_Percent", Types.NUMERIC),
	                    new SqlParameter("p_Claim_Submission_Deadline", Types.DATE),
	                    new SqlParameter("p_Activity_Submission_Deadline", Types.DATE),
	                    new SqlParameter("p_Activity_Execution_Deadline", Types.DATE),
	                    new SqlParameter("p_Claim_Submit_Date", Types.DATE),
	                    new SqlParameter("p_Activity_Submit_Date", Types.DATE),
	                    new SqlParameter("p_Activity_Execution_Date", Types.DATE),
	                    new SqlParameter("p_Tc_Accepted", Types.VARCHAR),
	                    new SqlParameter("p_Ws_Activity_Id", Types.VARCHAR),
	                    new SqlParameter("p_user_id", Types.NUMERIC),
	                    new SqlOutParameter("o_status", Types.VARCHAR),
	                    new SqlOutParameter("o_message", Types.VARCHAR)
	            );

	    // Map input parameters
	    Map<String, Object> inParams = new HashMap<>();
	    inParams.put("p_Activity_Id", maData.getActivityId());
	    inParams.put("p_Activity_Name", maData.getActivityName());
	    inParams.put("p_Plan_Id", maData.getPlanId());
	    inParams.put("p_Stage", maData.getStage());
	    inParams.put("p_Activity_Group", maData.getActivityGroup());
	    inParams.put("p_Activity_Description", maData.getActivityDescription());
	    inParams.put("p_Sub_Track", maData.getSubTrack());
	    inParams.put("p_Track", maData.getTrack());
	    inParams.put("p_Activity_Start_Date", maData.getActivityStartDate());
	    inParams.put("p_Activity_End_Date", maData.getActivityEndDate());
	    inParams.put("p_Activity_Expiration_Date", maData.getActivityExpirationDate());
	    inParams.put("p_Activity_Requested_Amount", maData.getActivityRequestedAmount());
	    inParams.put("p_Activity_Requested_Amount_Currency", maData.getActivityRequestedAmountCurrency());
	    inParams.put("p_Activity_Metrics", maData.getActivityMetrics());
	    inParams.put("p_Activity_Target", maData.getActivityTarget());
	    inParams.put("p_Activity_Results_Submitted", maData.getActivityResultsSubmitted());
	    inParams.put("p_Funding_Quarter", maData.getFundingQuarter());
	    inParams.put("p_Cisco_Funding_Quarter", maData.getCiscoFundingQuarter());
	    inParams.put("p_Activity_Start_Fiscal_Quarter", maData.getActivityStartFiscalQuarter());
	    inParams.put("p_Activity_Type", maData.getActivityType());
	    inParams.put("p_Distributor_Unique_Id", maData.getDistributorUniqueId());
	    inParams.put("p_Initiative", maData.getInitiative());
	    inParams.put("p_Fund_Shell", maData.getFundShell());
	    inParams.put("p_Milestone_Name", maData.getMilestoneName());
	    inParams.put("p_Achievement", maData.getAchievement());
	    inParams.put("p_Currency", maData.getCurrency());
	    inParams.put("p_Achievement_Percent", maData.getAchievementPercent());
	    inParams.put("p_Sliding_Scale_Percent", maData.getSlidingScalePercent());
	    inParams.put("p_Claim_Submission_Deadline", maData.getClaimSubmissionDeadline());
	    inParams.put("p_Activity_Submission_Deadline", maData.getActivitySubmissionDeadline());
	    inParams.put("p_Activity_Execution_Deadline", maData.getActivityExecutionDeadline());
	    inParams.put("p_Claim_Submit_Date", maData.getClaimSubmitDate());
	    inParams.put("p_Activity_Submit_Date", maData.getActivitySubmitDate());
	    inParams.put("p_Activity_Execution_Date", maData.getActivityExecutionDate());
	    inParams.put("p_Tc_Accepted", maData.getTcAccepted());
	    inParams.put("p_Ws_Activity_Id", maData.getWsActivityId());
	    inParams.put("p_user_id", maData.getUserId());

	    Map<String, Object> outParams = jdbcCall.execute(inParams);

	    Map<String, Object> response = new HashMap<>();
	    response.put("o_status", outParams.get("o_status"));
	    response.put("o_message", outParams.get("o_message"));

	    if ("S".equals(outParams.get("o_status"))) {
	        String query = "SELECT * FROM xxpf_activities WHERE activity_id = ?";
	        Map<String, Object> activityDetails = jdbcTemplate.queryForMap(query, outParams.get("p_Activity_Id"));
	        System.out.println(activityDetails);
            response.put("p_activity", activityDetails);
	    } else {
	        response.put("p_activity", new HashMap<>());
	    }

	    return ResponseEntity.ok(response);
	}
	
	@Override
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageBpaWorkflowActivities(ManageBpaWorkflowActivitiesDTO mbwaData) {
	    System.out.println("mbwaData ======> " + mbwaData.toString());
	    SimpleJdbcCall jdbcCall = jdbcCallBuilder.buildSimpleJdbcCall(dataSource, "APPS", "xxpf_partner_fund_utils_pkg", "manage_bpa_workflow_activities")
	            .declareParameters(
	                    new SqlInOutParameter("p_activity_id", Types.NUMERIC),
	                    new SqlParameter("p_sequence", Types.NUMERIC),
	                    new SqlParameter("p_fund_bpa_id", Types.NUMERIC),
	                    new SqlParameter("p_activity_label", Types.VARCHAR),
	                    new SqlParameter("p_activity_type", Types.VARCHAR),
	                    new SqlParameter("p_process_func", Types.VARCHAR),
	                    new SqlParameter("p_notif_subject", Types.VARCHAR),
	                    new SqlParameter("p_notif_body", Types.VARCHAR),
	                    new SqlParameter("p_approval_level", Types.VARCHAR),
	                    new SqlParameter("p_approvers", Types.VARCHAR),
	                    new SqlParameter("p_user_id", Types.NUMERIC),
	                    new SqlOutParameter("o_status", Types.VARCHAR),
	                    new SqlOutParameter("o_message", Types.VARCHAR)
	            );

	    // Map input parameters
	    Map<String, Object> inParams = new HashMap<>();
	    inParams.put("p_activity_id", mbwaData.getP_activity_id());
	    inParams.put("p_sequence", mbwaData.getP_sequence());
	    inParams.put("p_fund_bpa_id", mbwaData.getP_fund_bpa_id());
	    inParams.put("p_activity_label", mbwaData.getP_activity_label());
	    inParams.put("p_activity_type", mbwaData.getP_activity_type());
	    inParams.put("p_process_func", mbwaData.getP_process_func());
	    inParams.put("p_notif_subject", mbwaData.getP_notif_subject());
	    inParams.put("p_notif_body", mbwaData.getP_notif_body());
	    inParams.put("p_approval_level", mbwaData.getP_approval_level());
	    inParams.put("p_approvers", mbwaData.getP_approvers());
	    inParams.put("p_user_id", mbwaData.getP_user_id());

	    Map<String, Object> outParams = jdbcCall.execute(inParams);

	    Map<String, Object> response = new HashMap<>();
	    response.put("o_status", outParams.get("o_status"));
	    response.put("o_message", outParams.get("o_message"));

	    if ("S".equals(outParams.get("o_status"))) {
	        String query = "select * from xxpf_bpa_workflow_activities WHERE activity_id = ?";
	        Map<String, Object> planDetails = jdbcTemplate.queryForMap(query, outParams.get("p_activity_id"));
	        response.put("plan", planDetails);
	    } else {
	        response.put("plan", new HashMap<>());
	    }

	    return ResponseEntity.ok(response);
	}
	
	@Override
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageWorkflowTransitions(ManageWorkflowTransitionsDTO mwtData) {
	    System.out.println("mwtData ======> " + mwtData.toString());
	    SimpleJdbcCall jdbcCall = jdbcCallBuilder.buildSimpleJdbcCall(dataSource, "APPS", "xxpf_partner_fund_utils_pkg", "manage_workflow_transition")
	            .declareParameters(
	                    new SqlInOutParameter("p_transition_id", Types.NUMERIC),
	                    new SqlParameter("p_activity_id", Types.NUMERIC),
	                    new SqlParameter("p_transition_activity_id", Types.NUMERIC),
	                    new SqlParameter("p_outcome_value", Types.VARCHAR),
	                    new SqlParameter("p_user_id", Types.NUMERIC),
	                    new SqlOutParameter("o_status", Types.VARCHAR),
	                    new SqlOutParameter("o_message", Types.VARCHAR)
	            );

	    // Map input parameters
	    Map<String, Object> inParams = new HashMap<>();
	    inParams.put("p_transition_id", mwtData.getP_transition_id());
	    inParams.put("p_activity_id", mwtData.getP_activity_id());
	    inParams.put("p_transition_activity_id", mwtData.getP_transition_activity_id());
	    inParams.put("p_outcome_value", mwtData.getP_outcome_value());
	    inParams.put("p_user_id", mwtData.getP_user_id());

	    Map<String, Object> outParams = jdbcCall.execute(inParams);

	    Map<String, Object> response = new HashMap<>();
	    response.put("o_status", outParams.get("o_status"));
	    response.put("o_message", outParams.get("o_message"));

	    if ("S".equals(outParams.get("o_status"))) {
	        String query = "select * from xxpf_bpa_workflow_transition WHERE transition_id = ?";
	        Map<String, Object> planDetails = jdbcTemplate.queryForMap(query, outParams.get("p_transition_id"));
	        response.put("plan", planDetails);
	    } else {
	        response.put("plan", new HashMap<>());
	    }

	    return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<Map<String, Object>> saveOrUpdateManagePageRules(ManagePageRulesDTO pageRulesData) {
	    SimpleJdbcCall jdbcCall = jdbcCallBuilder.buildSimpleJdbcCall(dataSource, "APPS", "xxpf_partner_fund_utils_pkg", "manage_page_rules")
	            .declareParameters(
	                    new SqlInOutParameter("p_Page_rule_id", Types.NUMERIC),
	                    new SqlParameter("p_page_id", Types.NUMERIC),
	                    new SqlParameter("p_FEATURE_ID", Types.NUMERIC),
	                    new SqlParameter("p_action_type", Types.VARCHAR),
	                    new SqlParameter("p_user_message", Types.VARCHAR),
	                    new SqlParameter("p_user_id", Types.NUMERIC),
	                    new SqlOutParameter("o_status", Types.VARCHAR),
	                    new SqlOutParameter("o_message", Types.VARCHAR)
	            );

	    // Map input parameters
	    Map<String, Object> inParams = new HashMap<>();
	    inParams.put("p_Page_rule_id", pageRulesData.getPageRuleId());
	    inParams.put("p_page_id", pageRulesData.getPageId());
	    inParams.put("p_FEATURE_ID", pageRulesData.getFeatureId());
	    inParams.put("p_action_type", pageRulesData.getActionType());
	    inParams.put("p_user_message", pageRulesData.getUserMessage());
	    inParams.put("p_user_id", pageRulesData.getUserId());

	    Map<String, Object> outParams = jdbcCall.execute(inParams);

	    Map<String, Object> response = new HashMap<>();
	    response.put("o_status", outParams.get("o_status"));
	    response.put("o_message", outParams.get("o_message"));

	    if ("S".equals(outParams.get("o_status"))) {
	        String query = "SELECT * FROM xxpf_page_rules WHERE page_rule_id = ?";
	        Map<String, Object> ruleDetails = jdbcTemplate.queryForMap(query, outParams.get("p_Page_rule_id"));
	        response.put("rule", ruleDetails);
	    } else {
	        response.put("rule", new HashMap<>());
	    }

	    return ResponseEntity.ok(response);
	}


	@Override
	public ResponseEntity<Map<String, Object>> saveOrUpdateManagePageRuleCriteria(ManagePageRuleCriteriaDTO pageRuleCriteriaData) {
	    SimpleJdbcCall jdbcCall = jdbcCallBuilder.buildSimpleJdbcCall(dataSource, "APPS", "xxpf_partner_fund_utils_pkg", "manage_page_rule_criteria")
	            .declareParameters(
	                    new SqlInOutParameter("p_criteria_id", Types.NUMERIC),
	                    new SqlParameter("p_Page_rule_id", Types.NUMERIC),
	                    new SqlParameter("p_sequence", Types.NUMERIC),
	                    new SqlParameter("p_group_logical_operator", Types.VARCHAR),
	                    new SqlParameter("p_group_seperator_open", Types.VARCHAR),
	                    new SqlParameter("p_FEATURE_ID", Types.NUMERIC),
	                    new SqlParameter("p_operator", Types.VARCHAR),
	                    new SqlParameter("p_condition_value", Types.VARCHAR),
	                    new SqlParameter("p_group_seperator_close", Types.VARCHAR),
	                    new SqlParameter("p_condition_logical_operator", Types.VARCHAR),
	                    new SqlParameter("p_user_id", Types.NUMERIC),
	                    new SqlOutParameter("o_status", Types.VARCHAR),
	                    new SqlOutParameter("o_message", Types.VARCHAR)
	            );

	    // Map input parameters
	    Map<String, Object> inParams = new HashMap<>();
	    inParams.put("p_criteria_id", pageRuleCriteriaData.getCriteriaId());
	    inParams.put("p_Page_rule_id", pageRuleCriteriaData.getPageRuleId());
	    inParams.put("p_sequence", pageRuleCriteriaData.getSequence());
	    inParams.put("p_group_logical_operator", pageRuleCriteriaData.getGroupLogicalOperator());
	    inParams.put("p_group_seperator_open", pageRuleCriteriaData.getGroupSeperatorOpen());
	    inParams.put("p_FEATURE_ID", pageRuleCriteriaData.getFeatureId());
	    inParams.put("p_operator", pageRuleCriteriaData.getOperator());
	    inParams.put("p_condition_value", pageRuleCriteriaData.getConditionValue());
	    inParams.put("p_group_seperator_close", pageRuleCriteriaData.getGroupSeperatorClose());
	    inParams.put("p_condition_logical_operator", pageRuleCriteriaData.getConditionLogicalOperator());
	    inParams.put("p_user_id", pageRuleCriteriaData.getUserId());

	    Map<String, Object> outParams = jdbcCall.execute(inParams);

	    Map<String, Object> response = new HashMap<>();
	    response.put("o_status", outParams.get("o_status"));
	    response.put("o_message", outParams.get("o_message"));

	    if ("S".equals(outParams.get("o_status"))) {
	        String query = "SELECT * FROM xxpf_page_rule_criteria WHERE criteria_id = ?";
	        Map<String, Object> criteriaDetails = jdbcTemplate.queryForMap(query, outParams.get("p_criteria_id"));
	        response.put("criteria", criteriaDetails);
	    } else {
	        response.put("criteria", new HashMap<>());
	    }

	    return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<Map<String, Object>> saveOrUpdateManagePageRuleSetAttr(ManagePageRuleSetAttrDTO pageRuleSetAttributesData) {
	    SimpleJdbcCall jdbcCall = jdbcCallBuilder.buildSimpleJdbcCall(dataSource, "APPS", "xxpf_partner_fund_utils_pkg", "manage_page_rule_set_attributes")
	            .declareParameters(
	                    new SqlInOutParameter("p_set_attribute_id", Types.NUMERIC),
	                    new SqlParameter("p_feature_id", Types.NUMERIC),
	                    new SqlParameter("p_feature_value", Types.VARCHAR),
	                    new SqlParameter("p_user_id", Types.NUMERIC),
	                    new SqlOutParameter("o_status", Types.VARCHAR),
	                    new SqlOutParameter("o_message", Types.VARCHAR)
	            );

	    // Map input parameters
	    Map<String, Object> inParams = new HashMap<>();
	    inParams.put("p_set_attribute_id", pageRuleSetAttributesData.getSetAttributeId());
	    inParams.put("p_feature_id", pageRuleSetAttributesData.getFeatureId());
	    inParams.put("p_feature_value", pageRuleSetAttributesData.getFeatureValue());
	    inParams.put("p_user_id", pageRuleSetAttributesData.getUserId());

	    Map<String, Object> outParams = jdbcCall.execute(inParams);

	    Map<String, Object> response = new HashMap<>();
	    response.put("o_status", outParams.get("o_status"));
	    response.put("o_message", outParams.get("o_message"));

	    if ("S".equals(outParams.get("o_status"))) {
	        String query = "SELECT * FROM xxpf_page_rule_set_attributes WHERE set_attribute_id = ?";
	        Map<String, Object> attributeDetails = jdbcTemplate.queryForMap(query, outParams.get("p_set_attribute_id"));
	        response.put("attribute", attributeDetails);
	    } else {
	        response.put("attribute", new HashMap<>());
	    }

	    return ResponseEntity.ok(response);
	}


	@Override
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageLookupTypes(ManageLookupTypesDTO lookupTypesDTO) {
	    System.out.println("lookupTypesDTO ======> " + lookupTypesDTO.toString());
	    SimpleJdbcCall jdbcCall = jdbcCallBuilder.buildSimpleJdbcCall(dataSource, "APPS", "xxpf_partner_fund_utils_pkg", "manage_lookup_types")
	            .declareParameters(
	                    new SqlInOutParameter("p_Lookup_type", Types.VARCHAR),
	                    new SqlParameter("p_description", Types.VARCHAR),
	                    new SqlParameter("p_user_id", Types.NUMERIC),
	                    new SqlOutParameter("o_status", Types.VARCHAR),
	                    new SqlOutParameter("o_message", Types.VARCHAR)
	            );

	    // Map input parameters
	    Map<String, Object> inParams = new HashMap<>();
	    inParams.put("p_Lookup_type", lookupTypesDTO.getLookupType());
	    inParams.put("p_description", lookupTypesDTO.getDescription());
	    inParams.put("p_user_id", lookupTypesDTO.getUserId());

	    Map<String, Object> outParams = jdbcCall.execute(inParams);

	    Map<String, Object> response = new HashMap<>();
	    response.put("o_status", outParams.get("o_status"));
	    response.put("o_message", outParams.get("o_message"));

	    // Conditional logic based on o_status
	    if ("S".equals(outParams.get("o_status"))) {
	        String query = "select * from xxpf_page_rule_set_attributes WHERE lookup_type = ?";
	        Map<String, Object> details = jdbcTemplate.queryForMap(query, outParams.get("p_Lookup_type"));
	        response.put("details", details);
	    } else {
	        response.put("details", new HashMap<>());
	    }

	    return ResponseEntity.ok(response);
	}


	@Override
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageLookupCodes(ManageLookupCodesDTO lookupCodesDTO) {
	    System.out.println("lookupCodesDTO ======> " + lookupCodesDTO.toString());
	    SimpleJdbcCall jdbcCall = jdbcCallBuilder.buildSimpleJdbcCall(dataSource, "APPS", "xxpf_partner_fund_utils_pkg", "manage_lookup_codes")
	            .declareParameters(
	            		new SqlParameter("p_Lookup_type", Types.VARCHAR),
	                    new SqlInOutParameter("p_Lookup_code", Types.VARCHAR),
	                    new SqlParameter("p_meaning", Types.VARCHAR),
	                    new SqlParameter("p_description", Types.VARCHAR),
	                    new SqlParameter("p_active_flag", Types.VARCHAR),
	                    new SqlParameter("p_user_id", Types.NUMERIC),
	                    new SqlOutParameter("o_status", Types.VARCHAR),
	                    new SqlOutParameter("o_message", Types.VARCHAR)
	            );

	    // Map input parameters
	    Map<String, Object> inParams = new HashMap<>();
	    inParams.put("p_Lookup_code", lookupCodesDTO.getLookupCode());
	    inParams.put("p_Lookup_type", lookupCodesDTO.getLookupType());
	    inParams.put("p_meaning", lookupCodesDTO.getMeaning());
	    inParams.put("p_description", lookupCodesDTO.getDescription());
	    inParams.put("p_active_flag", lookupCodesDTO.getActiveFlag());
	    inParams.put("p_user_id", lookupCodesDTO.getUserId());

	    Map<String, Object> outParams = jdbcCall.execute(inParams);

	    Map<String, Object> response = new HashMap<>();
	    response.put("o_status", outParams.get("o_status"));
	    response.put("o_message", outParams.get("o_message"));

	    // Conditional logic based on o_status
	    if ("S".equals(outParams.get("o_status"))) {
	        String query = "select * from xxpf_lookup_codes WHERE lookup_code = ?";
	        Map<String, Object> details = jdbcTemplate.queryForMap(query, outParams.get("p_Lookup_code"));
	        response.put("details", details);
	    } else {
	        response.put("details", new HashMap<>());
	    }

	    return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<Map<String, Object>> saveOrUpdateManagePartnerships(ManagePartnershipsDTO mpData) {
	    System.out.println("mpData ======> " + mpData.toString());
	    SimpleJdbcCall jdbcCall = jdbcCallBuilder.buildSimpleJdbcCall(dataSource, "APPS", "xxpf_partner_fund_utils_pkg", "manage_partnerships")
	            .declareParameters(
	                    new SqlInOutParameter("p_partnership_id", Types.NUMERIC),
	                    new SqlParameter("p_partnership_name", Types.VARCHAR),
	                    new SqlParameter("p_user_id", Types.NUMERIC),
	                    new SqlOutParameter("o_status", Types.VARCHAR),
	                    new SqlOutParameter("o_message", Types.VARCHAR)
	            );

	    Map<String, Object> inParams = new HashMap<>();
	    inParams.put("p_partnership_id", mpData.getPartnershipId());
	    inParams.put("p_partnership_name", mpData.getPartnershipName());
	    inParams.put("p_user_id", mpData.getUserId());

	    Map<String, Object> outParams = jdbcCall.execute(inParams);

	    Map<String, Object> response = new HashMap<>();
	    response.put("o_status", outParams.get("o_status"));
	    response.put("o_message", outParams.get("o_message"));

	    if ("S".equals(outParams.get("o_status"))) {
	        String query = "SELECT * FROM xxpf_partnerships WHERE partnership_id = ?";
	        Map<String, Object> managePartnership = jdbcTemplate.queryForMap(query, outParams.get("p_partnership_id"));
	        response.put("partnership", managePartnership);
	    } else {
	        response.put("partnership", new HashMap<>());
	    }

	    return ResponseEntity.ok(response);
	}
	
	@Override
	public ResponseEntity<Map<String, Object>> saveOrUpdateManagePartnershipGeography(ManagePartnershipGeographyDTO mpgData) {
	    System.out.println("mpgData ======> " + mpgData.toString());

	    SimpleJdbcCall jdbcCall = jdbcCallBuilder.buildSimpleJdbcCall(dataSource, "APPS", "xxpf_partner_fund_utils_pkg", "manage_partnership_geography")
	            .declareParameters(new SqlInOutParameter("p_geography_id", Types.NUMERIC),
	                    new SqlParameter("p_partnership_id", Types.NUMERIC), 
	                    new SqlParameter("p_local_name", Types.VARCHAR),
	                    new SqlParameter("p_territory", Types.VARCHAR),
	                    new SqlParameter("p_country", Types.VARCHAR), 
	                    new SqlParameter("p_geo_name", Types.VARCHAR),
	                    new SqlParameter("p_theater", Types.VARCHAR), 
	                    new SqlParameter("p_user_id", Types.NUMERIC),
	                    new SqlOutParameter("o_status", Types.VARCHAR), 
	                    new SqlOutParameter("o_message", Types.VARCHAR));

	    Map<String, Object> inParams = new HashMap<>();
	    inParams.put("p_geography_id", mpgData.getGeographyId());
	    inParams.put("p_partnership_id", mpgData.getPartnershipId());
	    inParams.put("p_local_name", mpgData.getLocalName());
	    inParams.put("p_territory", mpgData.getTerritory());
	    inParams.put("p_country", mpgData.getCountry());
	    inParams.put("p_geo_name", mpgData.getGeoName());
	    inParams.put("p_theater", mpgData.getTheater());
	    inParams.put("p_user_id", mpgData.getUserId());

	    Map<String, Object> outParams = jdbcCall.execute(inParams);

	    Map<String, Object> response = new HashMap<>();
	    response.put("o_status", outParams.get("o_status"));
	    response.put("o_message", outParams.get("o_message"));

	    if ("S".equals(outParams.get("o_status"))) {
	        String query = "SELECT * FROM xxpf_partnership_geography WHERE geography_id = ?";
	        Map<String, Object> manageGeographyTable = jdbcTemplate.queryForMap(query, outParams.get("p_geography_id"));
	        response.put("geography_table", manageGeographyTable);
	    } else {
	        response.put("geography_table", new HashMap<>());
	    }

	    return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<Map<String, Object>> saveOrUpdatePartnershipReferences(ManagePartnershipReferencesDTO mprData) {
        System.out.println("mprData ======> " + mprData.toString());

        SimpleJdbcCall jdbcCall = jdbcCallBuilder.buildSimpleJdbcCall(dataSource, "APPS", "xxpf_partner_fund_utils_pkg", "manage_partnership_references")
                .declareParameters(
                        new SqlInOutParameter("p_reference_id", Types.NUMERIC),
                        new SqlParameter("p_partnership_id", Types.NUMERIC),
                        new SqlParameter("p_reference_type", Types.VARCHAR),
                        new SqlParameter("p_reference_key", Types.VARCHAR),
                        new SqlParameter("p_user_id", Types.NUMERIC),
                        new SqlOutParameter("o_status", Types.VARCHAR),
                        new SqlOutParameter("o_message", Types.VARCHAR)
                );

        Map<String, Object> inParams = new HashMap<>();
        inParams.put("p_reference_id", mprData.getReferenceId());
        inParams.put("p_partnership_id", mprData.getPartnershipId());
        inParams.put("p_reference_type", mprData.getReferenceType());
        inParams.put("p_reference_key", mprData.getReferenceKey());
        inParams.put("p_user_id", mprData.getUserId());

        Map<String, Object> outParams = jdbcCall.execute(inParams);

        Map<String, Object> response = new HashMap<>();
        response.put("o_status", outParams.get("o_status"));
        response.put("o_message", outParams.get("o_message"));

        if ("S".equals(outParams.get("o_status"))) {
            String query = "SELECT * FROM xxpf_partnership_references WHERE reference_id = ?";
            Map<String, Object> partnershipReference = jdbcTemplate.queryForMap(query, outParams.get("p_reference_id"));
            response.put("partnership_reference", partnershipReference);
        } else {
            response.put("partnership_reference", new HashMap<>());
        }

        return ResponseEntity.ok(response);
    }
	
	@Override
	public ResponseEntity<Map<String, Object>> saveOrUpdateManagePartnershipContacts(ManagePartnershipContactsDTO mpcData) {
	    System.out.println("mpcData ======> " + mpcData.toString());
	    
	    SimpleJdbcCall jdbcCall = jdbcCallBuilder.buildSimpleJdbcCall(dataSource, "APPS", "xxpf_partner_fund_utils_pkg", "manage_partnership_contacts")
	            .declareParameters(new SqlInOutParameter("p_contact_id", Types.NUMERIC),
	                               new SqlParameter("p_partnership_id", Types.NUMERIC),
	                               new SqlParameter("p_contact_type", Types.VARCHAR),
	                               new SqlParameter("p_email", Types.VARCHAR),
	                               new SqlParameter("p_payment_contact_flag", Types.VARCHAR),
	                               new SqlParameter("p_user_id", Types.NUMERIC),
	                               new SqlOutParameter("o_status", Types.VARCHAR),
	                               new SqlOutParameter("o_message", Types.VARCHAR));

	    Map<String, Object> inParams = new HashMap<>();
	    inParams.put("p_contact_id", mpcData.getContactId());
	    inParams.put("p_partnership_id", mpcData.getPartnershipId());
	    inParams.put("p_contact_type", mpcData.getContactType());
	    inParams.put("p_email", mpcData.getEmail());
	    inParams.put("p_payment_contact_flag", mpcData.getPaymentContactFlag());
	    inParams.put("p_user_id", mpcData.getUserId());

	    Map<String, Object> outParams = jdbcCall.execute(inParams);

	    Map<String, Object> response = new HashMap<>();
	    response.put("o_status", outParams.get("o_status"));
	    response.put("o_message", outParams.get("o_message"));

	    if ("S".equals(outParams.get("o_status"))) {
	        String query = "SELECT * FROM xxpf_partnership_contacts WHERE contact_id = ?";
	        Map<String, Object> managePartnershipContact = jdbcTemplate.queryForMap(query, outParams.get("p_contact_id"));
	        response.put("partnership_contact", managePartnershipContact);
	    } else {
	        response.put("partnership_contact", new HashMap<>());
	    }

	    return ResponseEntity.ok(response);
	}
	
	@Override
	public ResponseEntity<Map<String, Object>> saveOrUpdateManagePartnershipAssociations(ManagePartnershipAssociationsDTO mpaData) {
	    System.out.println("mpaData ======> " + mpaData.toString());
	    
	    SimpleJdbcCall jdbcCall = jdbcCallBuilder.buildSimpleJdbcCall(dataSource, "APPS", "xxpf_partner_fund_utils_pkg", "manage_partnership_associations")
	            .declareParameters(
	                    new SqlInOutParameter("p_association_id", Types.NUMERIC),
	                    new SqlParameter("p_partnership_id", Types.NUMERIC),
	                    new SqlParameter("p_reference_type", Types.VARCHAR),
	                    new SqlParameter("p_reference_key", Types.VARCHAR),
	                    new SqlParameter("p_user_id", Types.NUMERIC),
	                    new SqlOutParameter("o_status", Types.VARCHAR),
	                    new SqlOutParameter("o_message", Types.VARCHAR)
	            );

	    Map<String, Object> inParams = new HashMap<>();
	    inParams.put("p_association_id", mpaData.getAssociationId());
	    inParams.put("p_partnership_id", mpaData.getPartnershipId());
	    inParams.put("p_reference_type", mpaData.getReferenceType());
	    inParams.put("p_reference_key", mpaData.getReferenceKey());
	    inParams.put("p_user_id", mpaData.getUserId());

	    Map<String, Object> outParams = jdbcCall.execute(inParams);

	    Map<String, Object> response = new HashMap<>();
	    response.put("o_status", outParams.get("o_status"));
	    response.put("o_message", outParams.get("o_message"));

	    if ("S".equals(outParams.get("o_status"))) {
	        String query = "SELECT * FROM xxpf_partnership_associations WHERE association_id = ?";
	        Map<String, Object> partnershipAssociation = jdbcTemplate.queryForMap(query, outParams.get("p_association_id"));
	        response.put("partnership_association", partnershipAssociation);
	    } else {
	        response.put("partnership_association", new HashMap<>());
	    }

	    return ResponseEntity.ok(response);
	}


}
