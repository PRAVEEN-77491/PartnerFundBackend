package com.PartnersFunds.Controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PartnersFunds.Entities.pageAttrPropertiesEntity;
import com.PartnersFunds.Entities.pageAttributesEntity;
import com.PartnersFunds.Entities.pagesEntity;
import com.PartnersFunds.service.AttrServiceImpl;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AttrController {
	
	@Autowired
	private AttrServiceImpl ser;

//	@GetMapping("/getByType/{type}")
//	public List<AttrEntity> searchAttribute(@PathVariable String type){
//		return ser.searchByType(type);
//	}
//	
//	 @PostMapping("/setDefaultValue")
//	    public ResponseEntity<String> postData(@RequestBody AttrEntity data) {
//	        try {
//	           
//	            ser.saveData(data);
//
//	            return new ResponseEntity<>("Data saved successfully", HttpStatus.OK);
//	        } catch (Exception e) {
//	            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
//	        }
//	    }
//	
//	
//	@GetMapping("/getAttribute")
//	public List<AttrEntity> getData() {
//	   return ser.getAttrDetails();
//	}
	
	@GetMapping("/getPages")
	public List<pagesEntity> getData1() {
	   return ser.getPages();
	}
	
	@GetMapping("/getPageAttributes")
	public List<pageAttributesEntity> getData2() {
	   return ser.getPageAttributes();
	}
	
	@GetMapping("/getPageProperties")
	public List<pageAttrPropertiesEntity> getData3() {
	   return ser.getPageProperties();
	}
	
	@GetMapping("/getPageById/{pageId}")
	public pagesEntity getById(@PathVariable("pageId") int pageId){
		return ser.getPageById(pageId);
	}

}
