package com.PartnersFunds.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.PartnersFunds.Entities.pageAttrPropertiesEntity;
import com.PartnersFunds.Entities.pageAttributesEntity;
import com.PartnersFunds.Entities.pagesEntity;
import com.PartnersFunds.service.JsonElementDTO;
import com.PartnersFunds.service.PageDetailsService;
import com.PartnersFunds.service.pagePropDetailsDTO;
import com.PartnersFunds.service.procedureResult;
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
	public Integer addPage(@RequestBody pagesEntity page) {	
		return pageService.savePageDetails(page);
	}

	@PostMapping("/addPageAttributes")
	 public ResponseEntity<?> addPageProperties(@RequestBody pageAttributesEntity pageAttribute) {
       try {
           pageAttributesEntity savedAttribute = pageService.savePageAttributeDetails(pageAttribute);

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
	public String addPage(@RequestBody List<pageAttrPropertiesEntity> pageAttrPropertiesList) {
	pageService.savePageAttributePropertiesDetails(pageAttrPropertiesList);
	return "Added Page Attribute properties details successfully";
	}

	@PostMapping("/call")
	public procedureResult callProcedure(@RequestBody Map<String, Object> request){
        Integer attr_id = (Integer) request.get("attribute_id");
        Map<String, Object> params = (Map<String, Object>) request.get("params");
        return pageService.callFunction(attr_id, params);
	}
	
	@PostMapping("/pagePropDetails")
	public pagesEntity addPagePropDetails(@RequestBody String jsonString) throws Exception,JsonMappingException, JsonProcessingException {
		 
		 pagePropDetailsDTO pagePropDetailsJSON = objectMapper.readValue(jsonString, new TypeReference<pagePropDetailsDTO>() {});
		 
		 pagesEntity updatedPageEntity = null;
		 
		 updatedPageEntity  = pageService.addPagePropDetails(pagePropDetailsJSON);
		 
		return updatedPageEntity;
		
	}
}