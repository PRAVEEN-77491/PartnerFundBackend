package com.PartnersFunds.serviceImpl;

import java.util.HashMap;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import java.util.Map;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PartnersFunds.DTO.ManageFundDTO;
import com.PartnersFunds.DTO.ManageRolesDTO;
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
	
//	private SimpleJdbcCall simpleJdbcCall;
//    @Autowired
//    DataSource dataSource;

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
                .withCatalogName("xxpf_partner_fund_utils_pkg") // Package name
                .withProcedureName("manage_fund")                // Procedure name
                .declareParameters(
                        new SqlParameter("p_fund_id", Types.NUMERIC),
                        new SqlParameter("p_fund_name", Types.VARCHAR),
                        new SqlParameter("p_description", Types.VARCHAR),
                        new SqlParameter("p_active_flag", Types.VARCHAR),
                        new SqlParameter("p_user_id", Types.NUMERIC),
                        new SqlOutParameter("o_status", Types.VARCHAR),
                        new SqlOutParameter("o_message", Types.VARCHAR)
                );

        // Prepare the input parameters
        Map<String, Object> inParams = new HashMap<>();
        inParams.put("p_fund_id", mfData.getP_fund_id());
        inParams.put("p_fund_name", mfData.getP_fund_name());
        inParams.put("p_description", mfData.getP_description());
        inParams.put("p_active_flag", mfData.getP_active_flag());
        inParams.put("p_user_id", mfData.getP_user_id());

        // Execute the procedure and get the output parameters
        Map<String, Object> outParams = jdbcCall.execute(inParams);

        // Return the output parameters and input ID (in case it was changed by the procedure)
        Map<String, Object> result = new HashMap<>();
        result.put("p_fund_id", inParams.get("p_fund_id"));
        result.put("o_status", outParams.get("o_status"));
        result.put("o_message", outParams.get("o_message"));
        return result;
    }

	@Override
	public  Map<String, Object> manageRoles(ManageRolesDTO mrData) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("xxpf_partner_fund_utils_pkg") // Package name
                .withProcedureName("manage_roles")                // Procedure name
                .declareParameters(
                        new SqlParameter("p_role_id", Types.NUMERIC),
                        new SqlParameter("p_role_name", Types.VARCHAR),
                        new SqlParameter("p_description", Types.VARCHAR),
                        new SqlParameter("p_active_flag", Types.VARCHAR),
                        new SqlParameter("p_user_id", Types.NUMERIC),
                        new SqlOutParameter("o_status", Types.VARCHAR),
                        new SqlOutParameter("o_message", Types.VARCHAR)
                );

        // Prepare the input parameters
        Map<String, Object> inParams = new HashMap<>();
        inParams.put("p_role_id", mrData.getP_role_id());
        inParams.put("p_role_name", mrData.getP_role_name());
        inParams.put("p_description", mrData.getP_description());
        inParams.put("p_active_flag", mrData.getP_active_flag());
        inParams.put("p_user_id", mrData.getP_user_id());

        // Execute the procedure and get the output parameters
        Map<String, Object> outParams = jdbcCall.execute(inParams);

        // Return the output parameters and input ID (in case it was changed by the procedure)
        Map<String, Object> result = new HashMap<>();
        result.put("p_role_id", inParams.get("p_role_id"));
        result.put("o_status", outParams.get("o_status"));
        result.put("o_message", outParams.get("o_message"));
        return result;
    }

//public ResponseEntity<?> createClaim(ClaimRequest request) throws JsonProcessingException {
//        
//        try {
//            CreateClaimJdbcTemplate();
//        }
//        catch (Exception e) {
//            System.out.println("Error: Exception occurred calling CreateClaimJdbcTemplate");
//        }
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            System.out.println(request);
//            
//            String claimRequestJsonString = objectMapper.writeValueAsString(request);
//            
//            MapSqlParameterSource params = new MapSqlParameterSource()
//                    .addValue("claim_Request_Payload",claimRequestJsonString,OracleTypes.CLOB);
//            
//            Map<String, Object> createClaimResponse = simpleJdbcCall.execute(params);
////            ResponseEntity<UpsertClaimPegaResponse> result = restCientAdapter.exchange(url, request, UpsertClaimPegaResponse.class, HttpMethod.POST);
////            UpsertClaimPegaResponse pegaResponse = result.getBody();
//            System.out.println("CreateClaim response: " + createClaimResponse);
//            return new ResponseEntity(null)<>(createClaimResponse, HttpStatus.OK);
//        } catch (Exception e) {
//            System.out.println("Error while connecting to pega services");
//        }
//        return new ResponseEntity<>("Error in creating claim", HttpStatus.BAD_GATEWAY);
//
//    }
//
//    private void CreateClaimJdbcTemplate() {
////        this.simpleJdbcCall = new SimpleJdbcCall(dataSource)
////                .withSchemaName("hb_student_tracker")
////                .withProcedureName("SAVECLAIMDETAILS");
//        
//        simpleJdbcCall = this.simpleJdbcCallBuilder.buildSimpleJdbcCall(dataSource, "apps", "xxpf_partner_fund_utils_pkg", "manage_fund");
//        simpleJdbcCall.declareParameters(
//                new SqlParameter("claim_Request_Payload", OracleTypes.CLOB),
//        
////                new SqlOutParameter("RequestJSON", OracleTypes.VARCHAR));
//                new SqlOutParameter("CLAIM_ID", OracleTypes.VARCHAR),
//                new SqlOutParameter("CLAIM_STATUS", OracleTypes.VARCHAR),
//                new SqlOutParameter("STATUS", OracleTypes.VARCHAR),
//                new SqlOutParameter("ERROR_MESSAGE", OracleTypes.VARCHAR));
//                
//    }
	

}
