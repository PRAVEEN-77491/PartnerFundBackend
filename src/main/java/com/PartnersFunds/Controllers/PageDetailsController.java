package com.PartnersFunds.Controllers;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.PartnersFunds.DTO.PagePropDetailsDTO;
import com.PartnersFunds.Entities.EntityObjectsEntity;
import com.PartnersFunds.Entities.PageAttrPropertiesEntity;
import com.PartnersFunds.Entities.PageAttributesEntity;
import com.PartnersFunds.Entities.PagesEntity;
import com.PartnersFunds.Entities.ViewObjectsEntity;
import com.PartnersFunds.service.PageDetailsService;
import com.PartnersFunds.service.ProcedureResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/page")
@CrossOrigin(origins="*")
public class PageDetailsController {
	
    private final ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
	PageDetailsService pageService;
	
	@GetMapping("/getAllPages")
	public List<Object[]> getDetails(){
		return pageService.getAllDetails();
	}
	
	@PostMapping("/pageNameValidation")
	public boolean pageNameValidation(@RequestParam("pagename") String pageName) {	
        if (pageName == null || pageName.trim().isEmpty()) {
            throw new IllegalArgumentException("Page name cannot be null or empty.");
        }
        
        try {
            return pageService.validPageOrNot(pageName);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while validating the page name.");
        }
	}	
	
	@PostMapping("/addPage")
	public Integer addPage(@RequestBody PagesEntity page) {	
		return pageService.savePageDetails(page);
	}

	@PostMapping("/addPageAttributes")
	 public ResponseEntity<?> addPageProperties(@RequestBody PageAttributesEntity pageAttribute) {
       try {
           PageAttributesEntity savedAttribute = pageService.savePageAttributeDetails(pageAttribute);

           // Create a simplified JSON response containing only attribute_id and attribute_type
           JSONObject response = new JSONObject();
           response.put("attribute_id", savedAttribute.getAttribute_id());
           response.put("attribute_type", savedAttribute.getAttribute_type());
           response.put("page_id", savedAttribute.getPage_id());
           return ResponseEntity.ok(response.toString());
       } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                   .body("Error: Failed to save page attribute details - " + e.getMessage());
       }
   }


	@PostMapping("/addPageAttrProperties")
	public String addPage(@RequestBody List<PageAttrPropertiesEntity> pageAttrPropertiesList) {
	pageService.savePageAttributePropertiesDetails(pageAttrPropertiesList);
	return "Added Page Attribute properties details successfully";
	}

	@PostMapping("/call")
	public ProcedureResult callProcedure(@RequestBody Map<String, Object> request) {
	    Integer attr_id = (Integer) request.get("attribute_id");
	    List<Map<String, Object>> params = (List<Map<String, Object>>) request.get("params");
	    return pageService.callFunction(attr_id, params);
	}
	
	@PostMapping("/pagePropDetails")
	public ResponseEntity<Map<String, Object>> addPagePropDetails(@RequestBody String jsonString) throws Exception,JsonMappingException, JsonProcessingException {
		 
		 PagePropDetailsDTO pagePropDetailsJSON = objectMapper.readValue(jsonString, new TypeReference<PagePropDetailsDTO>() {});
		 
		 ResponseEntity<Map<String, Object>> updatedPageEntity = null;
		 
		 updatedPageEntity  = pageService.addPagePropDetails(pagePropDetailsJSON);
		 
		return updatedPageEntity;
		
	}
	
	@PostMapping("/deletedAttribute")
	@ResponseBody
	public String deletedAttribute(@RequestParam("removedAttrId") Integer removedAttrId) {
		return pageService.deleteRemovedAttr(removedAttrId);
	}

	@PostMapping("/saveEntityObject")
	public EntityObjectsEntity saveEntityObject(@RequestBody EntityObjectsEntity entityObject) {
		EntityObjectsEntity entityObj = pageService.saveEntityObject(entityObject);
		return entityObj;
	}

	@PostMapping("/saveViewObject")
	public ViewObjectsEntity saveViewObject(@RequestBody ViewObjectsEntity viewObject) {
		ViewObjectsEntity viewObj = pageService.saveViewObject(viewObject);
		return viewObj;
	}

	@PostMapping("/saveEOData")
	public PageAttributesEntity saveEOData(@RequestBody List<Map<String, String>> attributes) throws IOException, SQLException {
		return pageService.saveEOData(attributes);
	}

	@PostMapping("/api/{viewObjectName}")
	public Map<String, Object> getVOData(@PathVariable("viewObjectName") String voObjectName) throws IOException, SQLException {
		return pageService.getVOData(voObjectName);
	}
	
//	@Secured("ROLE_ADMIN")
	@PostMapping("/hello")
	@ResponseBody
	public String getHello() {
		return "hello";
	}
	
}