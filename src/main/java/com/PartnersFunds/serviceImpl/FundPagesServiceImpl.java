package com.PartnersFunds.serviceImpl;

import java.util.HashMap;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import java.util.Map;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PartnersFunds.DTO.ManageFundDTO;
import com.PartnersFunds.DTO.ManageFundPagesDTO;
import com.PartnersFunds.DTO.ManageRolesDTO;
import com.PartnersFunds.DTO.ManageFundRolesDTO;
import com.PartnersFunds.DTO.ManageFundTablesAttrDTO;
import com.PartnersFunds.DTO.ManageFundTablesDTO;
import com.PartnersFunds.Entities.FundPagesEntity;
import com.PartnersFunds.Repo.FundPagesRepo;
import com.PartnersFunds.service.FundPagesService;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;

import java.sql.Types;

@Service
public class FundPagesServiceImpl implements FundPagesService{

	@Autowired
	FundPagesRepo fundRepo;
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
    public FundPagesServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

	@Override
	public FundPagesEntity saveData(FundPagesEntity funds) {
		return fundRepo.save(funds);
	}

	@Override
	public List<FundPagesEntity> getFundDetails() {
		return fundRepo.findAll();
	}
	
	@Override
	public  Map<String, Object> manageFund(ManageFundDTO mfData) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
        		.withSchemaName("APPS")
                .withCatalogName("xxpf_partner_fund_utils_pkg") 
                .withProcedureName("manage_fund")               
                .declareParameters(
                        new SqlParameter("p_fund_id", Types.NUMERIC),
                        new SqlParameter("p_fund_name", Types.VARCHAR),
                        new SqlParameter("p_description", Types.VARCHAR),
                        new SqlParameter("p_active_flag", Types.VARCHAR),
                        new SqlParameter("p_user_id", Types.NUMERIC),
                        new SqlOutParameter("o_status", Types.VARCHAR),
                        new SqlOutParameter("o_message", Types.VARCHAR)
                );

        Map<String, Object> inParams = new HashMap<>();
        inParams.put("p_fund_id", mfData.getP_fund_id());
        inParams.put("p_fund_name", mfData.getP_fund_name());
        inParams.put("p_description", mfData.getP_description());
        inParams.put("p_active_flag", mfData.getP_active_flag());
        inParams.put("p_user_id", mfData.getP_user_id());

        Map<String, Object> outParams = jdbcCall.execute(inParams);

        Map<String, Object> result = new HashMap<>();
        result.put("p_fund_id", inParams.get("p_fund_id"));
        result.put("o_status", outParams.get("o_status"));
        result.put("o_message", outParams.get("o_message"));
        return result;
    }

	@Override
	public  Map<String, Object> manageRoles(ManageRolesDTO mrData) {
		System.out.println("mrData.getP_role_id()==> "+mrData.getP_role_id());
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
        		.withSchemaName("APPS")
                .withCatalogName("xxpf_partner_fund_utils_pkg") 
                .withProcedureName("manage_roles")              
                .declareParameters(
                        new SqlParameter("p_role_id", Types.NUMERIC),
                        new SqlParameter("p_role_name", Types.VARCHAR),
                        new SqlParameter("p_description", Types.VARCHAR),
                        new SqlParameter("p_active_flag", Types.VARCHAR),
                        new SqlParameter("p_user_id", Types.NUMERIC),
                        new SqlOutParameter("o_status", Types.VARCHAR),
                        new SqlOutParameter("o_message", Types.VARCHAR)
                );

        Map<String, Object> inParams = new HashMap<>();
        inParams.put("p_role_id", mrData.getP_role_id());
        inParams.put("p_role_name", mrData.getP_role_name());
        inParams.put("p_description", mrData.getP_description());
        inParams.put("p_active_flag", mrData.getP_active_flag());
        inParams.put("p_user_id", mrData.getP_user_id());

        Map<String, Object> outParams = jdbcCall.execute(inParams);

        Map<String, Object> result = new HashMap<>();
        result.put("p_role_id", inParams.get("p_role_id"));
        result.put("o_status", outParams.get("o_status"));
        result.put("o_message", outParams.get("o_message"));
        return result;
    }
	
	@Override
	public  Map<String, Object> manageFundRoles(ManageFundRolesDTO mfrData) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
        		.withSchemaName("APPS")
                .withCatalogName("xxpf_partner_fund_utils_pkg") 
                .withProcedureName("manage_fund_roles")              
                .declareParameters(
                        new SqlParameter("p_fund_role_id", Types.NUMERIC),
                        new SqlParameter("p_fund_id", Types.NUMERIC),
                        new SqlParameter("p_role_id", Types.NUMERIC),
                        new SqlParameter("p_active_flag", Types.VARCHAR),
                        new SqlParameter("p_user_id", Types.NUMERIC),
                        new SqlOutParameter("o_status", Types.VARCHAR),
                        new SqlOutParameter("o_message", Types.VARCHAR)
                );

        Map<String, Object> inParams = new HashMap<>();
        inParams.put("p_fund_role_id", mfrData.getP_fund_role_id());
        inParams.put("p_fund_id", mfrData.getP_fund_id());
        inParams.put("p_role_id", mfrData.getP_role_id());
        inParams.put("p_active_flag", mfrData.getP_active_flag());
        inParams.put("p_user_id", mfrData.getP_user_id());

        Map<String, Object> outParams = jdbcCall.execute(inParams);

        Map<String, Object> result = new HashMap<>();
        result.put("p_fund_role_id", inParams.get("p_fund_role_id"));
        result.put("o_status", outParams.get("o_status"));
        result.put("o_message", outParams.get("o_message"));
        return result;
    }

	@Override
	public Map<String, Object> manageFundPages(ManageFundPagesDTO mfpData) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
        		.withSchemaName("APPS")
                .withCatalogName("xxpf_partner_fund_utils_pkg") // Package name
                .withProcedureName("manage_fund_pages")                // Procedure name
                .declareParameters(
                        new SqlParameter("p_fund_page_id", Types.NUMERIC),
                        new SqlParameter("p_fund_id", Types.NUMERIC),
                        new SqlParameter("p_page_id", Types.NUMERIC),
                        new SqlParameter("p_active_flag", Types.VARCHAR),
                        new SqlParameter("p_user_id", Types.NUMERIC),
                        new SqlOutParameter("o_status", Types.VARCHAR),
                        new SqlOutParameter("o_message", Types.VARCHAR)
                );

        Map<String, Object> inParams = new HashMap<>();
        inParams.put("p_fund_page_id", mfpData.getP_fund_page_id());
        inParams.put("p_fund_id", mfpData.getP_fund_id());
        inParams.put("p_page_id", mfpData.getP_page_id());
        inParams.put("p_active_flag", mfpData.getP_active_flag());
        inParams.put("p_user_id", mfpData.getP_user_id());

        Map<String, Object> outParams = jdbcCall.execute(inParams);

        Map<String, Object> result = new HashMap<>();
        result.put("p_fund_page_id", inParams.get("p_fund_page_id"));
        result.put("o_status", outParams.get("o_status"));
        result.put("o_message", outParams.get("o_message"));
        return result;
	}

	@Override
	public Map<String, Object> manageFundtables(ManageFundTablesDTO mftData) {
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName("APPS")
				.withCatalogName("xxpf_partner_fund_utils_pkg")
				.withProcedureName("manage_fund_tables")
				.declareParameters(
						new SqlParameter("p_table_id", Types.NUMERIC),
						new SqlParameter("p_fund_id", Types.NUMERIC),
						new SqlParameter("p_table_name", Types.VARCHAR),
						new SqlParameter("p_display_name", Types.VARCHAR),
						new SqlParameter("p_usage_level", Types.VARCHAR),
						new SqlParameter("p_user_id", Types.NUMERIC),
						new SqlOutParameter("o_status", Types.VARCHAR),
						new SqlOutParameter("o_message", Types.VARCHAR)
						);
						
						Map<String, Object> inParams = new HashMap<>();
				        inParams.put("p_table_id", mftData.getP_table_id());
				        inParams.put("p_fund_id", mftData.getP_fund_id());
				        inParams.put("p_table_name", mftData.getP_table_name());
				        inParams.put("p_display_name", mftData.getP_display_name());
				        inParams.put("p_usage_level", mftData.getP_usage_level());
				        inParams.put("p_user_id", mftData.getP_user_id());

				        Map<String, Object> outParams = jdbcCall.execute(inParams);

				        Map<String, Object> result = new HashMap<>();
				        result.put("p_table_id", inParams.get("p_table_id"));
				        result.put("o_status", outParams.get("o_status"));
				        result.put("o_message", outParams.get("o_message"));
				        return result;
	}

	@Override
	public Map<String, Object> manageFundtablesAttr(ManageFundTablesAttrDTO mftaData) {
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName("APPS")
				.withCatalogName("xxpf_partner_fund_utils_pkg")
				.withProcedureName("manage_fund_table_attributes")
				.declareParameters(
						new SqlParameter("p_attribute_id", Types.NUMERIC),
						new SqlParameter("p_table_id", Types.NUMERIC),
						new SqlParameter("p_column_name", Types.VARCHAR),
						new SqlParameter("p_display_name", Types.VARCHAR),
						new SqlParameter("p_active_flag", Types.VARCHAR),
						new SqlParameter("p_user_id", Types.NUMERIC),
						new SqlOutParameter("o_status", Types.VARCHAR),
						new SqlOutParameter("o_message", Types.VARCHAR)
						);
						
						Map<String, Object> inParams = new HashMap<>();
				        inParams.put("p_attribute_id", mftaData.getP_attribute_id());
				        inParams.put("p_table_id", mftaData.getP_table_id());
				        inParams.put("p_column_name", mftaData.getP_column_name());
				        inParams.put("p_display_name", mftaData.getP_display_name());
				        inParams.put("p_active_flag", mftaData.getP_active_flag());
				        inParams.put("p_user_id", mftaData.getP_user_id());

				        Map<String, Object> outParams = jdbcCall.execute(inParams);

				        Map<String, Object> result = new HashMap<>();
				        result.put("p_attribute_id", inParams.get("p_attribute_id"));
				        result.put("o_status", outParams.get("o_status"));
				        result.put("o_message", outParams.get("o_message"));
				        return result;
	}

}
