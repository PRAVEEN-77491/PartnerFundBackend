package com.PartnersFunds.service;

import java.security.Principal;

import java.util.List;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import com.PartnersFunds.dto.ManageActivitiesDTO;
import com.PartnersFunds.dto.ManageBPAEligibilityRulesDTO;
import com.PartnersFunds.dto.ManageBpaWorkflowActivitiesDTO;
import com.PartnersFunds.dto.ManageFundBPADTO;
import com.PartnersFunds.dto.ManageFundBpaRbacRolesDTO;
import com.PartnersFunds.dto.ManageFundDTO;
import com.PartnersFunds.dto.ManageFundPagesDTO;
import com.PartnersFunds.dto.ManageFundProgramAllocationsDTO;
import com.PartnersFunds.dto.ManageFundProgramsDTO;
import com.PartnersFunds.dto.ManageFundRolesDTO;
import com.PartnersFunds.dto.ManageFundTablesAttrDTO;
import com.PartnersFunds.dto.ManageFundTablesDTO;
import com.PartnersFunds.dto.ManageFundTimelinesDTO;
import com.PartnersFunds.dto.ManageLookupCodesDTO;
import com.PartnersFunds.dto.ManageLookupTypesDTO;
import com.PartnersFunds.dto.ManagePageFeatureRbacDTO;
import com.PartnersFunds.dto.ManagePageFeaturesDTO;
import com.PartnersFunds.dto.ManagePageRuleCriteriaDTO;
import com.PartnersFunds.dto.ManagePageRuleSetAttrDTO;
import com.PartnersFunds.dto.ManagePageRulesDTO;
import com.PartnersFunds.dto.ManagePartnerPlansAllocationsDTO;
import com.PartnersFunds.dto.ManagePartnerPlansDTO;
import com.PartnersFunds.dto.ManagePartnershipAssociationsDTO;
import com.PartnersFunds.dto.ManagePartnershipContactsDTO;
import com.PartnersFunds.dto.ManagePartnershipGeographyDTO;
import com.PartnersFunds.dto.ManagePartnershipReferencesDTO;
import com.PartnersFunds.dto.ManagePartnershipsDTO;
import com.PartnersFunds.dto.ManagePlansDTO;
import com.PartnersFunds.dto.ManageRolesDTO;
import com.PartnersFunds.dto.ManageSubProgramAllocationsDTO;
import com.PartnersFunds.dto.ManageSubProgramsDTO;
import com.PartnersFunds.dto.ManageWorkflowTransitionsDTO;

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


	public List<Map<String, Object>> getManageFundPagesDetails();

	public List<Map<String, Object>> getManageFundTablesDetails();

	public List<Map<String, Object>> getManageFundTablesAttrDetailsId(int id);

	public ResponseEntity<Map<String, Object>> saveOrUpdateManagePageFeatures(ManagePageFeaturesDTO mpfData);

	public ResponseEntity<Map<String, Object>> saveOrUpdateManagePageFeatureRbac(ManagePageFeatureRbacDTO mpfrData);

	public ResponseEntity<Map<String, Object>> saveOrUpdateManageFundBpaRbacRoles(ManageFundBpaRbacRolesDTO mfbrData);

	public ResponseEntity<Map<String, Object>> saveOrUpdateManageFundTimelines(ManageFundTimelinesDTO mftData);

//	public ResponseEntity<Map<String, Object>> saveOrUpdateManagePlans(ManagePlansDTO mpData);

	public ResponseEntity<Map<String, Object>> saveOrUpdateManageActivities(ManageActivitiesDTO maData);
	
	public List<Map<String, Object>> getManagePageFeaturesDetails();

	public List<Map<String, Object>> getManagePageFeatureRbacDetails();

	public List<Map<String, Object>> getManageFundBpaRbacRolesDetails();

	public List<Map<String, Object>> getManageFundTimelinesDetails();

//	public List<Map<String, Object>> getManagePlansDetails();

	public List<Map<String, Object>> getManageActivitiesDetails();
	
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageBpaWorkflowActivities(ManageBpaWorkflowActivitiesDTO mbwaData);
	
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageWorkflowTransitions(ManageWorkflowTransitionsDTO mwtData);
	
	public List<Map<String, Object>> getManageWorkflowTransitionsDetails();
	
	public List<Map<String, Object>> getManageBpaWorkflowActivitiesDetails();

	public ResponseEntity<Map<String, Object>> saveOrUpdateManageLookupTypes(ManageLookupTypesDTO mltData);

	public ResponseEntity<Map<String, Object>> saveOrUpdateManageLookupCodes(ManageLookupCodesDTO mlcData);

	public ResponseEntity<Map<String, Object>> saveOrUpdateManagePageRules(ManagePageRulesDTO mprData);

	public ResponseEntity<Map<String, Object>> saveOrUpdateManagePageRuleCriteria(ManagePageRuleCriteriaDTO mprcData);

	public ResponseEntity<Map<String, Object>> saveOrUpdateManagePageRuleSetAttr(ManagePageRuleSetAttrDTO mprsaData);

	List<Map<String, Object>> getManageLookupTypesDetails();

	List<Map<String, Object>> getManageLookupCodesDetails(String lookup_type);

	List<Map<String, Object>> getManagePageRulesDetails();

	List<Map<String, Object>> getManagePageRuleCriteriaDetails();

	List<Map<String, Object>> getManagePageRuleSetAttrDetails();

	ResponseEntity<Map<String, Object>> saveOrUpdateManagePartnerships(ManagePartnershipsDTO mpData);

	ResponseEntity<Map<String, Object>> saveOrUpdateManagePartnershipGeography(ManagePartnershipGeographyDTO mpgData);

	ResponseEntity<Map<String, Object>> saveOrUpdatePartnershipReferences(ManagePartnershipReferencesDTO mprData);

	ResponseEntity<Map<String, Object>> saveOrUpdateManagePartnershipContacts(ManagePartnershipContactsDTO mpcData);

	ResponseEntity<Map<String, Object>> saveOrUpdateManagePartnershipAssociations(ManagePartnershipAssociationsDTO mpaData);

	List<Map<String, Object>> getManagePartnershipsDetails();

	List<Map<String, Object>> getManagePartnershipGeographyDetails();

	List<Map<String, Object>> getPartnershipReferencesDetails();

	List<Map<String, Object>> getManagePartnershipContactsDetails();

	List<Map<String, Object>> getManagePartnershipAssociationsDetails();

	List<Map<String, Object>> getFundBpaDetails();

	public ResponseEntity<Map<String, Object>> saveOrUpdateFundPrograms(ManageFundProgramsDTO manageFundProgramsDTO);

	public ResponseEntity<Map<String, Object>> saveOrUpdateFundProgramAllocations(
			ManageFundProgramAllocationsDTO manageFundProgramAllocationsDTO);

	public ResponseEntity<Map<String, Object>> saveOrUpdateSubPrograms(ManageSubProgramsDTO manageSubProgramsDTO);

	public ResponseEntity<Map<String, Object>> saveOrUpdateSubProgramAllocations(ManageSubProgramAllocationsDTO manageSubProgramAllocationsDTO);

	public List<Map<String, Object>> getFundProgramsDetails();

	public List<Map<String, Object>> getFundProgramAllocationsDetails();

	public List<Map<String, Object>> getSubProgramsDetails();

	public List<Map<String, Object>> getSubProgramAllocationsDetails();

	ResponseEntity<Map<String, Object>> saveOrUpdateManagePartnerPlans(ManagePartnerPlansDTO mppData);

	ResponseEntity<Map<String, Object>> saveOrUpdateManagePartnerPlanAllocations(ManagePartnerPlansAllocationsDTO mppaData);

	List<Map<String, Object>> getManagePartnerPlansDetails();

	List<Map<String, Object>> getManagePartnerPlansAllocationsDetails();

	List<Map<String, Object>> getManagePageDetails();

	List<Map<String, Object>> getPageFeaturesByPageId(int page_id);
	public List<Map<String, Object>> getChartFundProgrammDetails();

	public List<Map<String, Object>> getChartFundProgramAllocationDetails();

	public List<Map<String, Object>> getManagePageFeatureRulesDetails();

	public List<Map<String, Object>> getManagePageRuleCriteriaDetailsByRuleId(int pageRuleId);

	public List<Map<String, Object>> getUserFungRole();

	public List<Map<String, Object>> getManageFundTimelinesDetailsById(int fund_id);

	public ResponseEntity<Map<String, Object>> saveOrUpdateUpsertFundBPA(ManageFundBPADTO fundBPAData);

	public ResponseEntity<Map<String, Object>> saveOrUpdateManageBPAEligibilityRules(
			ManageBPAEligibilityRulesDTO eligibilityRulesData);

//	List<Map<String, Object>> getRoleBasedFundBpaDetails();
	
	
}