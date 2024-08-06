package com.PartnersFunds.service;

import java.util.List;

public interface ExpressionService {
	
	ResponseExpressionDTO saveExpression(ExpressionDTO expressionDTO);

	ResponseExpMappingDTO saveAll(List<ExpressionAttrPropDTO> dtoList);
}
