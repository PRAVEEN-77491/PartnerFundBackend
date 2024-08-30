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

import com.PartnersFunds.DTO.ManageFundDTO;
import com.PartnersFunds.DTO.ManageFundPagesDTO;
import com.PartnersFunds.DTO.ManageFundRolesDTO;
import com.PartnersFunds.DTO.ManageFundTablesAttrDTO;
import com.PartnersFunds.DTO.ManageFundTablesDTO;
import com.PartnersFunds.DTO.ManagePageFeaturesDTO;
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
	////////////////////////////////////////////////////////////////////////////////////
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

	@PostMapping("/saveOrUpdateManageFund")
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageFund(@RequestBody ManageFundDTO mfData) {
		return ser.saveOrUpdateManageFund(mfData);
	}

	@PostMapping("/saveOrUpdateManageRoles")
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageRoles(@RequestBody ManageRolesDTO mrData) {
		return ser.saveOrUpdateManageRoles(mrData);
	}

	@PostMapping("/saveOrUpdateManageFundRoles")
	public ResponseEntity<Map<String, Object>> saveOrUpdateManageFundRoles(@RequestBody ManageFundRolesDTO mrData) {
		return ser.saveOrUpdateManageFundRoles(mrData);
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
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
	
	@PostMapping("/managePagesFeature")
	public ResponseEntity<Map<String, Object>> managePagesFeature(@RequestBody ManagePageFeaturesDTO mpfData) {
		return ser.saveOrUpdateManagePageFeatures(mpfData);
	}
}
