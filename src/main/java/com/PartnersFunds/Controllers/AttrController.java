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

import com.PartnersFunds.Entities.PageAttrPropertiesEntity;
import com.PartnersFunds.Entities.PageAttributesEntity;
import com.PartnersFunds.Entities.PagesEntity;
import com.PartnersFunds.serviceImpl.AttrServiceImpl;

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
	public List<PagesEntity> getData1() {
	   return ser.getPages();
	}
	
	@GetMapping("/getPageAttributes")
	public List<PageAttributesEntity> getData2() {
	   return ser.getPageAttributes();
	}
	
	@GetMapping("/getPageProperties")
	public List<PageAttrPropertiesEntity> getData3() {
	   return ser.getPageProperties();
	}
	
	@GetMapping("/getPageById/{pageId}")
	public PagesEntity getById(@PathVariable("pageId") int pageId){
		return ser.getPageById(pageId);
	}

}
