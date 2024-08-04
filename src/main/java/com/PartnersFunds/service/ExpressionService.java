package com.PartnersFunds.service;

import java.util.List;

public interface ExpressionService {
	
	ResponseExpressionDTO saveExpression(ExpressionDTO expressionDTO);

	void saveAll(List<ExpressionAttrPropDTO> dtoList);
}
