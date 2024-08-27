package com.PartnersFunds.Controllers;

import com.PartnersFunds.DTO.ExpressionAttrPropDTO;
import com.PartnersFunds.DTO.ExpressionDTO;
import com.PartnersFunds.DTO.ResponseExpMappingDTO;
import com.PartnersFunds.DTO.ResponseExpressionDTO;
import com.PartnersFunds.service.ExpressionService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ExpressionController {
   @Autowired
   private ExpressionService expressionService;
   
   @PostMapping({"/expressions"})
   public ResponseExpressionDTO saveExpressions(@RequestBody ExpressionDTO expressionDTOs) {
	   System.out.println("expController="+expressionDTOs.getEXPRESSION_NAME());
	   ResponseExpressionDTO response_data=expressionService.saveExpression(expressionDTOs);
      return response_data;
   }
  
   @PostMapping("/expMapping")
   public ResponseExpMappingDTO saveAll(@RequestBody List<ExpressionAttrPropDTO> dtoList) {
	   
	   return expressionService.saveAll(dtoList);
   }
}
