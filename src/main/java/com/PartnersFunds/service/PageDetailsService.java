package com.PartnersFunds.service;

import com.PartnersFunds.Entities.pageAttrPropertiesEntity;

import com.PartnersFunds.Entities.pageAttributesEntity;
import com.PartnersFunds.Entities.pagesEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public interface PageDetailsService {
   List<Object[]> getAllDetails();

   pageAttributesEntity savePageAttributeDetails(pageAttributesEntity pageAttribute);

   Integer savePageDetails(pagesEntity page);

   String savePageAttributePropertiesDetails(List<pageAttrPropertiesEntity> pageAttrPropertiesList);

   procedureResult callFunction(Integer attribute_id, Map<String, Object> params);

   pagesEntity addPagePropDetails(pagePropDetailsDTO pagePropDetailsJSON) throws JsonMappingException, JsonProcessingException;

   boolean validPageOrNot(String pageName);
}
