package com.PartnersFunds.Controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PartnersFunds.DTO.ManageActivitiesDTO;
import com.PartnersFunds.DTO.ManageBpaWorkflowActivitiesDTO;
import com.PartnersFunds.DTO.ManageFundBpaRbacRolesDTO;
import com.PartnersFunds.DTO.ManageFundDTO;
import com.PartnersFunds.DTO.ManageFundPagesDTO;
import com.PartnersFunds.DTO.ManageFundRolesDTO;
import com.PartnersFunds.DTO.ManageFundTablesAttrDTO;
import com.PartnersFunds.DTO.ManageFundTablesDTO;
import com.PartnersFunds.DTO.ManageFundTimelinesDTO;
import com.PartnersFunds.DTO.ManagePageFeatureRbacDTO;
import com.PartnersFunds.DTO.ManagePageFeaturesDTO;
import com.PartnersFunds.DTO.ManagePlansDTO;
import com.PartnersFunds.DTO.ManageRolesDTO;
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
	@GetMapping("/getManageFundTablesAttrDetails")
	public List<Map<String, Object>> getManageFundTablesAttrDetails() {
		return ser.getManageFundTablesAttrDetails();
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
	@GetMapping("/getManagePlansDetails")
	public List<Map<String, Object>> getManagePlansDetails() {
	    return ser.getManagePlansDetails();
	}

	//@Secured("ROLE_ADMIN")
	@GetMapping("/getManageActivitiesDetails")
	public List<Map<String, Object>> getManageActivitiesDetails() {
	    return ser.getManageActivitiesDetails();
	}
	
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
	@PostMapping("/saveOrUpdateManageFund")
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageFund(@RequestBody ManageFundDTO mfData) {
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
	
	//@Secured("ROLE_ADMIN")
	@PostMapping("/saveOrUpdateManagePlans")
	public ResponseEntity<Map<String, Object>> saveOrUpdateManagePlans(@RequestBody ManagePlansDTO mpData) {
		return ser.saveOrUpdateManagePlans(mpData);
	}
	
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
}
