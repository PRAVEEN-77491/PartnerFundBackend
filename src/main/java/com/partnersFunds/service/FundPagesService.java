package com.partnersFunds.service;

import java.security.Principal;

import java.util.List;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import com.partnersFunds.DTO.ManageActivitiesDTO;
import com.partnersFunds.DTO.ManageBPAEligibilityRulesDTO;
import com.partnersFunds.DTO.ManageBpaWorkflowActivitiesDTO;
import com.partnersFunds.DTO.ManageFundBPADTO;
import com.partnersFunds.DTO.ManageFundBpaRbacRolesDTO;
import com.partnersFunds.DTO.ManageFundDTO;
import com.partnersFunds.DTO.ManageFundPagesDTO;
import com.partnersFunds.DTO.ManageFundProgramAllocationsDTO;
import com.partnersFunds.DTO.ManageFundProgramsDTO;
import com.partnersFunds.DTO.ManageRolesDTO;
import com.partnersFunds.DTO.ManageSubProgramAllocationsDTO;
import com.partnersFunds.DTO.ManageSubProgramsDTO;
import com.partnersFunds.DTO.ManageWorkflowTransitionsDTO;
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