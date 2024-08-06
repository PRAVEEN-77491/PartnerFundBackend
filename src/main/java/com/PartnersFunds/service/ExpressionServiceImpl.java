package com.PartnersFunds.service;

import com.PartnersFunds.Entities.ExpressionAttrPropEntity;

import com.PartnersFunds.Entities.ExpressionConditionEntity;
import com.PartnersFunds.Entities.ExpressionEntity;
import com.PartnersFunds.Repo.ExpressionAttrPropRepo;
import com.PartnersFunds.Repo.ExpressionConditionRepo;
import com.PartnersFunds.Repo.ExpressionRepo;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpressionServiceImpl implements ExpressionService {
	
   @Autowired
   private ExpressionRepo expressionRepo;
   @Autowired
   private ExpressionConditionRepo expressionConditionRepo;
   @Autowired
   private ExpressionAttrPropRepo expressionAttrPropRepo;

   public ResponseExpressionDTO saveExpression(ExpressionDTO expressionDTO) {
	   
      ExpressionEntity expressionEntity = new ExpressionEntity();
      expressionEntity.setEXPRESSION_NAME(expressionDTO.getEXPRESSION_NAME());
      expressionEntity.setCREATED_BY(expressionDTO.getCREATED_BY());
      expressionEntity.setCREATION_DATE(expressionDTO.getCREATION_DATE());
      expressionEntity.setLAST_UPDATED_BY(expressionDTO.getLAST_UPDATED_BY());
      expressionEntity.setLAST_UPDATE_DATE(expressionDTO.getLAST_UPDATE_DATE());
      ExpressionEntity exp = (ExpressionEntity)this.expressionRepo.save(expressionEntity);
      
      @SuppressWarnings("unchecked")
      List<ExpressionConditionEntity> conditionEntities = (List)expressionDTO.getExp_attribute_data().stream().map((condDTO) -> {
         ExpressionConditionEntity conditionEntity = new ExpressionConditionEntity();
         conditionEntity.setEXP_ID(exp.getEXPRESSION_ID());
         conditionEntity.setATTRIBUTE_ID(Integer.parseInt(condDTO.getATTRIBUTE_ID()));
         conditionEntity.setEXP_OPERATOR(condDTO.getEXP_OPERATOR());
         conditionEntity.setVALUE(condDTO.getVALUE());
         conditionEntity.setPARENT_OPERATOR(condDTO.getPARENT_OPERATOR());
         conditionEntity.setCREATED_BY(condDTO.getCREATED_BY());
         conditionEntity.setCREATION_DATE(condDTO.getCREATION_DATE());
         conditionEntity.setLAST_UPDATED_BY(condDTO.getLAST_UPDATED_BY());
         conditionEntity.setLAST_UPDATE_DATE(condDTO.getLAST_UPDATE_DATE());
         
         return conditionEntity;
      }).collect(Collectors.toList());
      
      
      this.expressionConditionRepo.saveAll(conditionEntities);
      
      ResponseExpressionDTO responseExpressionDTO = new ResponseExpressionDTO();
      responseExpressionDTO.setEXPRESSION_ID(exp.getEXPRESSION_ID());
      responseExpressionDTO.setEXPRESSION_NAME(expressionDTO.getEXPRESSION_NAME());
      responseExpressionDTO.setCREATED_BY(expressionDTO.getCREATED_BY());
      responseExpressionDTO.setCREATION_DATE(expressionDTO.getCREATION_DATE());
      responseExpressionDTO.setLAST_UPDATED_BY(expressionDTO.getLAST_UPDATED_BY());
      responseExpressionDTO.setLAST_UPDATE_DATE(expressionDTO.getLAST_UPDATE_DATE());
      responseExpressionDTO.setExp_attribute_details(conditionEntities);
      
      return responseExpressionDTO;
   }


   @Override
   public void saveAll(List<ExpressionAttrPropDTO> dtoList) {
	 List<ExpressionAttrPropEntity> entities = dtoList.stream().map(dto -> new ExpressionAttrPropEntity(
			 	dto.getPAGE_ID(),
		        dto.getEXPRESSION_ID(),
		        dto.getATTRIBUTE_ID(),
		        dto.getATTR_PROP_NAME(),
		        dto.getCREATED_BY(),
		        dto.getCREATION_DATE(),
		        dto.getLAST_UPDATED_BY(),
		        dto.getLAST_UPDATE_DATE()
		    )).collect(Collectors.toList());
		    expressionAttrPropRepo.saveAll(entities);
}

}
