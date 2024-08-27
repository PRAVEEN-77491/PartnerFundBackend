package com.PartnersFunds.service;

import java.util.List;

import com.PartnersFunds.DTO.ExpressionAttrPropDTO;
import com.PartnersFunds.DTO.ExpressionDTO;
import com.PartnersFunds.DTO.ResponseExpMappingDTO;
import com.PartnersFunds.DTO.ResponseExpressionDTO;

public interface ExpressionService {
	
	ResponseExpressionDTO saveExpression(ExpressionDTO expressionDTO);

	ResponseExpMappingDTO saveAll(List<ExpressionAttrPropDTO> dtoList);
}
