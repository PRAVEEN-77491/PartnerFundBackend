package com.PartnersFunds.Controllers;

import com.PartnersFunds.service.ExpressionAttrPropDTO;
import com.PartnersFunds.service.ExpressionDTO;
import com.PartnersFunds.service.ExpressionService;
import com.PartnersFunds.service.ResponseExpressionDTO;

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
	   ResponseExpressionDTO response_data=this.expressionService.saveExpression(expressionDTOs);
      return response_data;
   }
  
   @PostMapping("/expMapping")
   public String saveAll(@RequestBody List<ExpressionAttrPropDTO> dtoList) {
	   expressionService.saveAll(dtoList);
	   return "ExpressionAttrProp saved successfully";
   }
}
