package com.partnersFunds.Controllers;

import java.security.Principal;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.partnersFunds.DTO.ManageActivitiesDTO;
import com.partnersFunds.DTO.ManageBPAEligibilityRulesDTO;
import com.partnersFunds.DTO.ManageBpaWorkflowActivitiesDTO;
import com.partnersFunds.DTO.ManageFundBPADTO;
import com.partnersFunds.DTO.ManageFundBpaRbacRolesDTO;
import com.partnersFunds.DTO.ManageFundDTO;
import com.partnersFunds.DTO.ManageFundPagesDTO;
import com.partnersFunds.DTO.ManageFundProgramAllocationsDTO;
import com.partnersFunds.DTO.ManageFundProgramsDTO;
import com.partnersFunds.DTO.ManageFundRolesDTO;
import com.partnersFunds.DTO.ManageFundTablesAttrDTO;
import com.partnersFunds.DTO.ManageFundTablesDTO;
import com.partnersFunds.DTO.ManageFundTimelinesDTO;
import com.partnersFunds.DTO.ManageLookupCodesDTO;
import com.partnersFunds.DTO.ManageLookupTypesDTO;
import com.partnersFunds.DTO.ManagePageFeatureRbacDTO;
import com.partnersFunds.DTO.ManagePageFeaturesDTO;
import com.partnersFunds.DTO.ManagePageRuleCriteriaDTO;
import com.partnersFunds.DTO.ManagePageRuleSetAttrDTO;
import com.partnersFunds.DTO.ManagePageRulesDTO;
import com.partnersFunds.DTO.ManagePartnerPlansAllocationsDTO;
import com.partnersFunds.DTO.ManagePartnerPlansDTO;
import com.partnersFunds.DTO.ManagePartnershipAssociationsDTO;
import com.partnersFunds.DTO.ManagePartnershipContactsDTO;
import com.partnersFunds.DTO.ManagePartnershipGeographyDTO;
import com.partnersFunds.DTO.ManagePartnershipReferencesDTO;
import com.partnersFunds.DTO.ManagePartnershipsDTO;
import com.partnersFunds.DTO.ManagePlansDTO;
import com.partnersFunds.DTO.ManageRolesDTO;
import com.partnersFunds.DTO.ManageSubProgramAllocationsDTO;
import com.partnersFunds.DTO.ManageSubProgramsDTO;
import com.partnersFunds.DTO.ManageWorkflowTransitionsDTO;
import com.partnersFunds.service.FundPagesService;

@RestController
@RequestMapping("/funds")
@CrossOrigin(origins = "*")
public class PageFundsController {

	@Autowired
	FundPagesService ser;

//	@Secured({"ROLE_Collaborator"})
	@GetMapping("/getFundDetails")
	public List<Map<String, Object>> getFundDetails() {
		return ser.getFundDetails();
	}

//	@Secured("ROLE_Funds Manager Admin")
	@GetMapping("/getRoleDetails")
	public List<Map<String, Object>> getRoleDetails() {
		return ser.getRoleDetails();
	}

//	@Secured("ROLE_Participant")
	@GetMapping("/getFundRoleDetails")
	public List<Map<String, Object>> getFundroleDetails() {
		return ser.getFundroleDetails();
	}

//	@Secured("ROLE_ADMIN")
	@GetMapping("/getManageFundPagesDetails")
	public List<Map<String, Object>> getManageFundPagesDetails() {
		return ser.getManageFundPagesDetails();
	}

	//@Secured("ROLE_ADMIN")
	@GetMapping("/getManageFundTablesDetails")
	public List<Map<String, Object>> getManageFundTablesDetails() {
		return ser.getManageFundTablesDetails();
	}
	
	//@Secured("ROLE_ADMIN")
	@GetMapping("/getManageFundTablesAttrDetailsId")
	public List<Map<String, Object>> getManageFundTablesAttrDetailsId(@RequestParam("table_id") int id) {
		return ser.getManageFundTablesAttrDetailsId(id);
	}

	//@Secured("ROLE_ADMIN")
	@GetMapping("/getManagePageFeaturesDetails")
	public List<Map<String, Object>> getManagePageFeaturesDetails() {
		return ser.getManagePageFeaturesDetails();
	}
	
	//@Secured("ROLE_ADMIN")
	@GetMapping("/getPageFeaturesByPageId")
	public List<Map<String, Object>> getPageFeaturesByPageId(@RequestParam("page_id") int page_id) {
	    return ser.getPageFeaturesByPageId(page_id);
	}

	//@Secured("ROLE_ADMIN")
	@GetMapping("/getManagePageFeatureRbacDetails")
	public List<Map<String, Object>> getManagePageFeatureRbacDetails() {
	    return ser.getManagePageFeatureRbacDetails();
	}

	//@Secured("ROLE_ADMIN")
	@GetMapping("/getManageFundBpaRbacRolesDetails")
	public List<Map<String, Object>> getManageFundBpaRbacRolesDetails() {
	    return ser.getManageFundBpaRbacRolesDetails();
	}

	//@Secured("ROLE_ADMIN")
	@GetMapping("/getManageFundTimelinesDetails")
	public List<Map<String, Object>> getManageFundTimelinesDetails() {
	    return ser.getManageFundTimelinesDetails();
	}

	//@Secured("ROLE_ADMIN")
	@GetMapping("/getManageFundTimelinesDetailsById")
	public List<Map<String, Object>> getManageFundTimelinesDetailsById(@RequestParam("fund_id") int fund_id) {
		return ser.getManageFundTimelinesDetailsById(fund_id);
	}

	//@Secured("ROLE_ADMIN")
//	@GetMapping("/getManagePlansDetails")
//	public List<Map<String, Object>> getManagePlansDetails() {
//	    return ser.getManagePlansDetails();
//	}

	//@Secured("ROLE_ADMIN")
	@GetMapping("/getManageActivitiesDetails")
	public List<Map<String, Object>> getManageActivitiesDetails() {
	    return ser.getManageActivitiesDetails();
	}
	
	//@Secured("ROLE_ADMIN")
	@GetMapping("/getManageBpaWorkflowActivitiesDetails")
	public List<Map<String, Object>> getManageBpaWorkflowActivitiesDetails() {
	    return ser.getManageBpaWorkflowActivitiesDetails();
	}

	//@Secured("ROLE_ADMIN")
	@GetMapping("/getManageWorkflowTransitionsDetails")
	public List<Map<String, Object>> getManageWorkflowTransitionsDetails() {
	    return ser.getManageWorkflowTransitionsDetails();
	}
	
	//@Secured("ROLE_ADMIN")
	@GetMapping("/getManageLookupTypesDetails")
	public List<Map<String, Object>> getManageLookupTypesDetails() {
	    return ser.getManageLookupTypesDetails();
	}
	
//	//@Secured("ROLE_ADMIN")
//	@GetMapping("/getManageLookupCodesDetails")
//	public List<Map<String, Object>> getManageLookupCodesDetails(@RequestParam("lookup_type") String lookup_type) {
//	    return ser.getManageLookupCodesDetails(lookup_type);
//	}
	
	//@Secured("ROLE_ADMIN")
	@GetMapping("/getManagePageRulesDetails")
	public List<Map<String, Object>> getManagePageRulesDetails() {
	    return ser.getManagePageRulesDetails();
	}
	
	//@Secured("ROLE_ADMIN")
	@GetMapping("/getManagePageFeatureRulesDetails")
	public List<Map<String, Object>> getManagePageFeatureRulesDetails() {
	    return ser.getManagePageFeatureRulesDetails();
	}
	
	//@Secured("ROLE_ADMIN")
	@GetMapping("/getManagePageRuleCriteriaDetails")
	public List<Map<String, Object>> getManagePageRuleCriteriaDetails() {
	    return ser.getManagePageRuleCriteriaDetails();
	}

	//@Secured("ROLE_ADMIN")
	@GetMapping("/getManagePageRuleCriteriaDetailsByRuleId")
	public List<Map<String, Object>> getManagePageRuleCriteriaDetailsByRuleId(@RequestParam("pageRuleId") int pageRuleId) {
		return ser.getManagePageRuleCriteriaDetailsByRuleId(pageRuleId);
	}
	
	//@Secured("ROLE_ADMIN")
	@GetMapping("/getManagePageRuleSetAttrDetails")
	public List<Map<String, Object>> getManagePageRuleSetAttrDetails() {
	    return ser.getManagePageRuleSetAttrDetails();
	}
	
	//@Secured("ROLE_ADMIN")
	@GetMapping("/getManagePartnershipsDetails")
	public List<Map<String, Object>> getManagePartnershipsDetails() {
	    return ser.getManagePartnershipsDetails();
	}
	
	//@Secured("ROLE_ADMIN")
	@GetMapping("/getManagePartnershipGeographyDetails")
	public List<Map<String, Object>> getManagePartnershipGeographyDetails() {
	    return ser.getManagePartnershipGeographyDetails();
	}
	
	//@Secured("ROLE_ADMIN")
	@GetMapping("/getPartnershipReferencesDetails")
	public List<Map<String, Object>> getPartnershipReferencesDetails() {
	    return ser.getPartnershipReferencesDetails();
	}
	
	//@Secured("ROLE_ADMIN")
	@GetMapping("/getManagePartnershipContactsDetails")
	public List<Map<String, Object>> getManagePartnershipContactsDetails() {
	    return ser.getManagePartnershipContactsDetails();
	}
	
	//@Secured("ROLE_ADMIN")
	@GetMapping("/getManagePartnershipAssociationsDetails")
	public List<Map<String, Object>> getManagePartnershipAssociationsDetails() {
	    return ser.getManagePartnershipAssociationsDetails();
	}
		
	//@Secured("ROLE_ADMIN")
	@GetMapping("/getFundBpaDetails")
	public List<Map<String, Object>> getFundBpaDetails() {
	    return ser.getFundBpaDetails();
	}
	
	//@Secured("ROLE_ADMIN")
	@GetMapping("/getFundProgramsDetails")
	public List<Map<String, Object>> getFundProgramsDetails() {
	    return ser.getFundProgramsDetails();
	}

	//@Secured("ROLE_ADMIN")
	@GetMapping("/getFundProgramAllocationsDetails")
	public List<Map<String, Object>> getFundProgramAllocationsDetails() {
	    return ser.getFundProgramAllocationsDetails();
	}

	//@Secured("ROLE_ADMIN")
	@GetMapping("/getSubProgramsDetails")
	public List<Map<String, Object>> getSubProgramsDetails() {
	    return ser.getSubProgramsDetails();
	}

	//@Secured("ROLE_ADMIN")
	@GetMapping("/getSubProgramAllocationsDetails")
	public List<Map<String, Object>> getSubProgramAllocationsDetails() {
	    return ser.getSubProgramAllocationsDetails();
	}

	//@Secured("ROLE_ADMIN")
	@GetMapping("/getManagePartnerPlansDetails")
	public List<Map<String, Object>> getManagePartnerPlansDetails() {
	    return ser.getManagePartnerPlansDetails();
	}
	
	//@Secured("ROLE_ADMIN")
	@GetMapping("/getManagePartnerPlansAllocationsDetails")
	public List<Map<String, Object>> getManagePartnerPlansAllocationsDetails() {
	    return ser.getManagePartnerPlansAllocationsDetails();
	}
	
	//@Secured("ROLE_ADMIN")
	@GetMapping("/getManagePageDetails")
	public List<Map<String, Object>> getManagePageDetails() {
	    return ser.getManagePageDetails();
	}
	    
	//	@Secured("ROLE_ADMIN")
    @GetMapping("/getChartFundProgrammDetails")
    public List<Map<String, Object>> getChartFundProgrammDetails() {
    	return ser.getChartFundProgrammDetails();
    }

    //	@Secured("ROLE_ADMIN")
    @GetMapping("/getChartFundProgramAllocationDetails")
    public List<Map<String, Object>> getChartFundProgramAllocationDetails() {
    	return ser.getChartFundProgramAllocationDetails();
    }

    //	@Secured("ROLE_ADMIN")
    @GetMapping("/getUserFungRole")
    public List<Map<String, Object>> getUserFungRole() {
    	return ser.getUserFungRole();
    }
		
//	//@Secured("ROLE_ADMIN")
//	@PostMapping("/getRoleBasedFundBpaDetails")
//	public List<Map<String, Object>> getRoleBasedFundBpaDetails() {
//	    return ser.getRoleBasedFundBpaDetails();
//	}
	
	//@Secured("ROLE_ADMIN")
	@PostMapping("/saveOrUpdateManageFund")
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageFund(@RequestBody ManageFundDTO mfData){//, Authentication pr) {
//		System.out.println("Principal ==>" + pr.getName());
		return ser.saveOrUpdateManageFund(mfData);
	}

	//@Secured("ROLE_ADMIN")
	@PostMapping("/saveOrUpdateManageRoles")
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageRoles(@RequestBody ManageRolesDTO mrData) {
		return ser.saveOrUpdateManageRoles(mrData);
	}

	//@Secured("ROLE_ADMIN")
	@PostMapping("/saveOrUpdateManageFundRoles")
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageFundRoles(@RequestBody ManageFundRolesDTO mfrData) {
		return ser.saveOrUpdateManageFundRoles(mfrData);
	}

	//@Secured("ROLE_ADMIN")
	@PostMapping("/saveOrUpdateManageFundPages")
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageFundPages(@RequestBody ManageFundPagesDTO mfpData) {
		return ser.saveOrUpdateManageFundPages(mfpData);
	}

	//@Secured("ROLE_ADMIN")
	@PostMapping("/saveOrUpdateManageFundTables")
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageFundTables(@RequestBody ManageFundTablesDTO mftData) {
		return ser.saveOrUpdateManageFundTables(mftData);
	}

	//@Secured("ROLE_ADMIN")
	@PostMapping("/saveOrUpdateManageFundTablesAttr")
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageFundTablesAttr(@RequestBody ManageFundTablesAttrDTO mftaData) {
		return ser.saveOrUpdateManageFundTablesAttr(mftaData);
	}
	
	//@Secured("ROLE_ADMIN")
	@PostMapping("/saveOrUpdateManagePageFeatures")
	public ResponseEntity<Map<String, Object>> saveOrUpdateManagePageFeatures(@RequestBody ManagePageFeaturesDTO mpfData) {
		return ser.saveOrUpdateManagePageFeatures(mpfData);
	}
	
	//@Secured("ROLE_ADMIN")
	@PostMapping("/saveOrUpdateManagePageFeatureRbac")
	public ResponseEntity<Map<String, Object>> saveOrUpdateManagePageFeatureRbac(@RequestBody ManagePageFeatureRbacDTO mpfrData) {
		return ser.saveOrUpdateManagePageFeatureRbac(mpfrData);
	}
	
	//@Secured("ROLE_ADMIN")
	@PostMapping("/saveOrUpdateManageFundBpaRbacRoles")
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageFundBpaRbacRoles(@RequestBody ManageFundBpaRbacRolesDTO mfbrrData) {
		return ser.saveOrUpdateManageFundBpaRbacRoles(mfbrrData);
	}
	
	//@Secured("ROLE_ADMIN")
	@PostMapping("/saveOrUpdateManageFundTimelines")
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageFundTimelines(@RequestBody ManageFundTimelinesDTO mftData) {
		return ser.saveOrUpdateManageFundTimelines(mftData);
	}
	
//	//@Secured("ROLE_ADMIN")
//	@PostMapping("/saveOrUpdateManagePlans")
//	public ResponseEntity<Map<String, Object>> saveOrUpdateManagePlans(@RequestBody ManagePlansDTO mpData) {
//		return ser.saveOrUpdateManagePlans(mpData);
//	}
	
	//@Secured("ROLE_ADMIN")
	@PostMapping("/saveOrUpdateManageActivities")
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageActivities(@RequestBody ManageActivitiesDTO maData) {
		return ser.saveOrUpdateManageActivities(maData);
	}
	
	//@Secured("ROLE_ADMIN")
	@PostMapping("/saveOrUpdateManageBpaWorkflowActivities")
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageBpaWorkflowActivities(@RequestBody ManageBpaWorkflowActivitiesDTO mbwa) {
		return ser.saveOrUpdateManageBpaWorkflowActivities(mbwa);
	}
	
	//@Secured("ROLE_ADMIN")
	@PostMapping("/saveOrUpdateManageWorkflowTransitions")
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageWorkflowTransitions(@RequestBody ManageWorkflowTransitionsDTO mwtData) {
		return ser.saveOrUpdateManageWorkflowTransitions(mwtData);
	}
	
	//@Secured("ROLE_ADMIN")
	@PostMapping("/saveOrUpdateManagePageRules")
	public ResponseEntity<Map<String, Object>> saveOrUpdateManagePageRules(@RequestBody ManagePageRulesDTO mprData) {
		return ser.saveOrUpdateManagePageRules(mprData);
	}
	
	//@Secured("ROLE_ADMIN")
	@PostMapping("/saveOrUpdateManagePageRuleCriteria")
	public ResponseEntity<Map<String, Object>> saveOrUpdateManagePageRuleCriteria(@RequestBody ManagePageRuleCriteriaDTO mprcData) {
		return ser.saveOrUpdateManagePageRuleCriteria(mprcData);
	}
	
	//@Secured("ROLE_ADMIN")
	@PostMapping("/saveOrUpdateManagePageRuleSetAttr")
	public ResponseEntity<Map<String, Object>> saveOrUpdateManagePageRuleSetAttr(@RequestBody ManagePageRuleSetAttrDTO mprsaData) {
		return ser.saveOrUpdateManagePageRuleSetAttr(mprsaData);
	}

	//@Secured("ROLE_ADMIN")
	@PostMapping("/saveOrUpdateManageLookupTypes")
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageLookupTypes(@RequestBody ManageLookupTypesDTO mltData) {
		return ser.saveOrUpdateManageLookupTypes(mltData);
	}

	//@Secured("ROLE_ADMIN")
	@PostMapping("/saveOrUpdateManageLookupCodes")
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageLookupCodes(@RequestBody ManageLookupCodesDTO mlcData) {
		return ser.saveOrUpdateManageLookupCodes(mlcData);
	}
	
	//@Secured("ROLE_ADMIN")
	@PostMapping("/saveOrUpdateManagePartnerships")
	public ResponseEntity<Map<String, Object>> saveOrUpdateManagePartnerships(@RequestBody ManagePartnershipsDTO mpData) {
		return ser.saveOrUpdateManagePartnerships(mpData);
	}
	
	//@Secured("ROLE_ADMIN")
	@PostMapping("/saveOrUpdateManagePartnershipGeography")
	public ResponseEntity<Map<String, Object>> saveOrUpdateManagePartnershipGeography(@RequestBody ManagePartnershipGeographyDTO mpgData) {
		return ser.saveOrUpdateManagePartnershipGeography(mpgData);
	}
	
	//@Secured("ROLE_ADMIN")
	@PostMapping("/saveOrUpdateManagePartnershipsReferences")
	public ResponseEntity<Map<String, Object>> saveOrUpdateManagePartnershipsReferences(@RequestBody ManagePartnershipReferencesDTO pfData) {
		return ser.saveOrUpdatePartnershipReferences(pfData);
	}
	
	//@Secured("ROLE_ADMIN")
	@PostMapping("/saveOrUpdateManagePartnershipsContacts")
	public ResponseEntity<Map<String, Object>> saveOrUpdateManagePartnershipsContacts(@RequestBody ManagePartnershipContactsDTO mpcData) {
		return ser.saveOrUpdateManagePartnershipContacts(mpcData);
	}
	
	//@Secured("ROLE_ADMIN")
	@PostMapping("/saveOrUpdateManagePartnershipAssociations")
	public ResponseEntity<Map<String, Object>> saveOrUpdateManagePartnershipAssociations(@RequestBody ManagePartnershipAssociationsDTO mpaData) {
		return ser.saveOrUpdateManagePartnershipAssociations(mpaData);
	}
	
//    @Secured("ROLE_ADMIN")
    @PostMapping("/saveOrUpdateFundPrograms")
    public ResponseEntity<Map<String, Object>> saveOrUpdateFundPrograms(@RequestBody ManageFundProgramsDTO manageFundProgramsDTO) {
        return ser.saveOrUpdateFundPrograms(manageFundProgramsDTO);
    }

//    @Secured("ROLE_ADMIN")
    @PostMapping("/saveOrUpdateFundProgramAllocations")
    public ResponseEntity<Map<String, Object>> saveOrUpdateFundProgramAllocations(@RequestBody ManageFundProgramAllocationsDTO manageFundProgramAllocationsDTO) {
        return ser.saveOrUpdateFundProgramAllocations(manageFundProgramAllocationsDTO);
    }

//    @Secured("ROLE_ADMIN")
    @PostMapping("/saveOrUpdateSubPrograms")
    public ResponseEntity<Map<String, Object>> saveOrUpdateSubPrograms(@RequestBody ManageSubProgramsDTO manageSubProgramsDTO) {
        return ser.saveOrUpdateSubPrograms(manageSubProgramsDTO);
    }

//  @Secured("ROLE_ADMIN")
    @PostMapping("/saveOrUpdateSubProgramAllocations")
    public ResponseEntity<Map<String, Object>> saveOrUpdateSubProgramAllocations(@RequestBody ManageSubProgramAllocationsDTO manageSubProgramAllocationsDTO) {
        return ser.saveOrUpdateSubProgramAllocations(manageSubProgramAllocationsDTO);
    }
    
//  @Secured("ROLE_ADMIN")
    @PostMapping("/saveOrUpdateManagePartnerPlans")
	public ResponseEntity<Map<String, Object>> saveOrUpdateManagePartnerPlans(@RequestBody ManagePartnerPlansDTO mppData) {
	    return ser.saveOrUpdateManagePartnerPlans(mppData);
	}
  
//	@Secured("ROLE_ADMIN")
    @PostMapping("/saveOrUpdateManagePartnerPlanAllocations")
	public ResponseEntity<Map<String, Object>> saveOrUpdateManagePartnerPlanAllocations(@RequestBody ManagePartnerPlansAllocationsDTO mppaData) {
    	return ser.saveOrUpdateManagePartnerPlanAllocations(mppaData);
	}
    
    //@Secured("ROLE_ADMIN")
    @PostMapping("/saveOrUpdateUpsertFundBPA")
    public ResponseEntity<Map<String, Object>> saveOrUpdateUpsertFundBPA(@RequestBody ManageFundBPADTO fundBPAData) {
        return ser.saveOrUpdateUpsertFundBPA(fundBPAData);
    }

    //@Secured("ROLE_ADMIN")
    @PostMapping("/saveOrUpdateManageBPAEligibilityRules")
    public ResponseEntity<Map<String, Object>> saveOrUpdateManageBPAEligibilityRules(@RequestBody ManageBPAEligibilityRulesDTO eligibilityRulesData) {
        return ser.saveOrUpdateManageBPAEligibilityRules(eligibilityRulesData);
    }
  
}
