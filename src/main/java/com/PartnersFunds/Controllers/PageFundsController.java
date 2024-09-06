package com.PartnersFunds.Controllers;

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

import com.PartnersFunds.DTO.ManageActivitiesDTO;
import com.PartnersFunds.DTO.ManageBpaWorkflowActivitiesDTO;
import com.PartnersFunds.DTO.ManageFundBpaRbacRolesDTO;
import com.PartnersFunds.DTO.ManageFundDTO;
import com.PartnersFunds.DTO.ManageFundPagesDTO;
import com.PartnersFunds.DTO.ManageFundProgramAllocationsDTO;
import com.PartnersFunds.DTO.ManageFundProgramsDTO;
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
import com.PartnersFunds.DTO.ManagePartnerPlansAllocationsDTO;
import com.PartnersFunds.DTO.ManagePartnerPlansDTO;
import com.PartnersFunds.DTO.ManagePartnershipAssociationsDTO;
import com.PartnersFunds.DTO.ManagePartnershipContactsDTO;
import com.PartnersFunds.DTO.ManagePartnershipGeographyDTO;
import com.PartnersFunds.DTO.ManagePartnershipReferencesDTO;
import com.PartnersFunds.DTO.ManagePartnershipsDTO;
import com.PartnersFunds.DTO.ManagePlansDTO;
import com.PartnersFunds.DTO.ManageRolesDTO;
import com.PartnersFunds.DTO.ManageSubProgramAllocationsDTO;
import com.PartnersFunds.DTO.ManageSubProgramsDTO;
import com.PartnersFunds.DTO.ManageWorkflowTransitionsDTO;
import com.PartnersFunds.service.FundPagesService;

@RestController
@RequestMapping("/funds")
@CrossOrigin(origins = "*")
public class PageFundsController {

	@Autowired
	FundPagesService ser;

	//@Secured("ROLE_ADMIN")
	@GetMapping("/getFundDetails")
	public List<Map<String, Object>> getFundDetails() {
		return ser.getFundDetails();
	}

	//@Secured("ROLE_ADMIN")
	@GetMapping("/getRoleDetails")
	public List<Map<String, Object>> getRoleDetails() {
		return ser.getRoleDetails();
	}

	//@Secured("ROLE_ADMIN")
	@GetMapping("/getFundRoleDetails")
	public List<Map<String, Object>> getFundroleDetails() {
		return ser.getFundroleDetails();
	}

	//@Secured("ROLE_ADMIN")
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
	
	//@Secured("ROLE_ADMIN")
	@GetMapping("/getManageLookupCodesDetails")
	public List<Map<String, Object>> getManageLookupCodesDetails() {
	    return ser.getManageLookupCodesDetails();
	}
	
	//@Secured("ROLE_ADMIN")
	@GetMapping("/getManagePageRulesDetails")
	public List<Map<String, Object>> getManagePageRulesDetails() {
	    return ser.getManagePageRulesDetails();
	}
	
	//@Secured("ROLE_ADMIN")
	@GetMapping("/getManagePageRuleCriteriaDetails")
	public List<Map<String, Object>> getManagePageRuleCriteriaDetails() {
	    return ser.getManagePageRuleCriteriaDetails();
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
	
	//@Secured("ROLE_ADMIN")
	@GetMapping("/getPageFeaturesByPageId")
	public List<Map<String, Object>> getPageFeaturesByPageId(@RequestParam("page_id") int page_id) {
	    return ser.getPageFeaturesByPageId(page_id);
	}
			
    
	//	@Secured("ROLE_ADMIN")
    @PostMapping("/getChartFundProgrammDetails")
    public List<Map<String, Object>> getChartFundProgrammDetails() {
    	return ser.getChartFundProgrammDetails();
    }

    //	@Secured("ROLE_ADMIN")
    @PostMapping("/getChartFundProgramAllocationDetails")
    public List<Map<String, Object>> getChartFundProgramAllocationDetails() {
    	return ser.getChartFundProgramAllocationDetails();
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
  
}
