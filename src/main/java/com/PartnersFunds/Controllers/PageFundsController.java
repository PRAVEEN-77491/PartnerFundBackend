package com.PartnersFunds.Controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.PartnersFunds.DTO.ManageRolesDTO;
import com.PartnersFunds.Entities.FundPagesEntity;
import com.PartnersFunds.service.FundPagesService;

@RestController
@RequestMapping("/funds")
@CrossOrigin(origins = "*")
public class PageFundsController {

	@Autowired
	FundPagesService ser;

	@PostMapping("/create")
	public FundPagesEntity saveViewObject(@RequestBody FundPagesEntity fundPages) {

		return ser.saveData(fundPages);
	}

	@GetMapping("/getDetails")
	public List<FundPagesEntity> getData() {
		return ser.getFundDetails();
	}

	@PostMapping("/manageFund")
	public Map<String, Object> manageFund(@RequestBody ManageFundDTO mfData) {
		return ser.manageFund(mfData);
	}

	@PostMapping("/manageRoles")
	public Map<String, Object> manageRoles(@RequestBody ManageRolesDTO mrData) {
		return ser.manageRoles(mrData);
	}

	@PostMapping("/manageFundRoles")
	public Map<String, Object> manageFundRoles(@RequestBody ManageFundRolesDTO mrData) {
		return ser.manageFundRoles(mrData);
	}

	@PostMapping("/manageFundPages")
	public Map<String, Object> manageFundPages(@RequestBody ManageFundPagesDTO mfpData) {
		return ser.manageFundPages(mfpData);
	}

	@PostMapping("/manageFundTables")
	public Map<String, Object> manageFundTables(@RequestBody ManageFundTablesDTO mftData) {
		return ser.manageFundtables(mftData);
	}

	@PostMapping("/manageFundTablesAttr")
	public Map<String, Object> manageFundTablesAttr(@RequestBody ManageFundTablesAttrDTO mftaData) {
		return ser.manageFundtablesAttr(mftaData);
	}
}
