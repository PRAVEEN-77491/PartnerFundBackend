package com.PartnersFunds.Controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PartnersFunds.DTO.ManageActivitiesDTO;
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
import com.PartnersFunds.service.FundPagesService;

@RestController
@RequestMapping("/funds")
@CrossOrigin(origins = "*")
public class PageFundsController {

	@Autowired
	FundPagesService ser;

	@GetMapping("/getFundDetails")
	public List<Map<String, Object>> getFundDetails() {
		return ser.getFundDetails();
	}

	@GetMapping("/getRoleDetails")
	public List<Map<String, Object>> getRoleDetails() {
		return ser.getRoleDetails();
	}

	@GetMapping("/getFundRoleDetails")
	public List<Map<String, Object>> getFundroleDetails() {
		return ser.getFundroleDetails();
	}

	@GetMapping("/getManageFundPagesDetails")
	public List<Map<String, Object>> getManageFundPagesDetails() {
		return ser.getManageFundPagesDetails();
	}
	
	@GetMapping("/getManageFundTablesDetails")
	public List<Map<String, Object>> getManageFundTablesDetails() {
		return ser.getManageFundTablesDetails();
	}
	
	@GetMapping("/getManageFundTablesAttrDetails")
	public List<Map<String, Object>> getManageFundTablesAttrDetails() {
		return ser.getManageFundTablesAttrDetails();
	}

	@GetMapping("/getManagePageFeaturesDetails")
	public List<Map<String, Object>> getManagePageFeaturesDetails() {
		return ser.getManagePageFeaturesDetails();
	}
	
	@GetMapping("/getManagePageFeatureRbacDetails")
	public List<Map<String, Object>> getManagePageFeatureRbacDetails() {
	    return ser.getManagePageFeatureRbacDetails();
	}

	@GetMapping("/getManageFundBpaRbacRolesDetails")
	public List<Map<String, Object>> getManageFundBpaRbacRolesDetails() {
	    return ser.getManageFundBpaRbacRolesDetails();
	}

	@GetMapping("/getManageFundTimelinesDetails")
	public List<Map<String, Object>> getManageFundTimelinesDetails() {
	    return ser.getManageFundTimelinesDetails();
	}

	@GetMapping("/getManagePlansDetails")
	public List<Map<String, Object>> getManagePlansDetails() {
	    return ser.getManagePlansDetails();
	}

	@GetMapping("/getManageActivitiesDetails")
	public List<Map<String, Object>> getManageActivitiesDetails() {
	    return ser.getManageActivitiesDetails();
	}

	@PostMapping("/saveOrUpdateManageFund")
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageFund(@RequestBody ManageFundDTO mfData) {
		return ser.saveOrUpdateManageFund(mfData);
	}

	@PostMapping("/saveOrUpdateManageRoles")
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageRoles(@RequestBody ManageRolesDTO mrData) {
		return ser.saveOrUpdateManageRoles(mrData);
	}

	@PostMapping("/saveOrUpdateManageFundRoles")
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageFundRoles(@RequestBody ManageFundRolesDTO mfrData) {
		return ser.saveOrUpdateManageFundRoles(mfrData);
	}
	
	@PostMapping("/saveOrUpdateManageFundPages")
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageFundPages(@RequestBody ManageFundPagesDTO mfpData) {
		return ser.saveOrUpdateManageFundPages(mfpData);
	}

	@PostMapping("/saveOrUpdateManageFundTables")
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageFundTables(@RequestBody ManageFundTablesDTO mftData) {
		return ser.saveOrUpdateManageFundTables(mftData);
	}

	@PostMapping("/saveOrUpdateManageFundTablesAttr")
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageFundTablesAttr(@RequestBody ManageFundTablesAttrDTO mftaData) {
		return ser.saveOrUpdateManageFundTablesAttr(mftaData);
	}
	@PostMapping("/saveOrUpdateManagePageFeatures")
	public ResponseEntity<Map<String, Object>> saveOrUpdateManagePageFeatures(@RequestBody ManagePageFeaturesDTO mpfData) {
		return ser.saveOrUpdateManagePageFeatures(mpfData);
	}
	
//////////////////////////////////////////////////////////////////////////////////////
	@PostMapping("/saveOrUpdateManagePageFeatureRbac")
	public ResponseEntity<Map<String, Object>> saveOrUpdateManagePageFeatureRbac(@RequestBody ManagePageFeatureRbacDTO mpfrData) {
		return ser.saveOrUpdateManagePageFeatureRbac(mpfrData);
	}
	
	@PostMapping("/saveOrUpdateManageFundBpaRbacRoles")
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageFundBpaRbacRoles(@RequestBody ManageFundBpaRbacRolesDTO mfbrrData) {
		return ser.saveOrUpdateManageFundBpaRbacRoles(mfbrrData);
	}
	
	@PostMapping("/saveOrUpdateManageFundTimelines")
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageFundTimelines(@RequestBody ManageFundTimelinesDTO mftData) {
		return ser.saveOrUpdateManageFundTimelines(mftData);
	}
	
	@PostMapping("/saveOrUpdateManagePlans")
	public ResponseEntity<Map<String, Object>> saveOrUpdateManagePlans(@RequestBody ManagePlansDTO mpData) {
		return ser.saveOrUpdateManagePlans(mpData);
	}
	
	@PostMapping("/saveOrUpdateManageActivities")
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageActivities(@RequestBody ManageActivitiesDTO maData) {
		return ser.saveOrUpdateManageActivities(maData);
	}
}
