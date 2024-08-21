package com.PartnersFunds.service;

import com.PartnersFunds.Entities.EntityObjectsEntity;
import com.PartnersFunds.Entities.PageAttrPropertiesEntity;

import com.PartnersFunds.Entities.PageAttributesEntity;
import com.PartnersFunds.Entities.PagesEntity;
import com.PartnersFunds.Entities.ViewObjectsEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface PageDetailsService {
   List<Object[]> getAllDetails();

   PageAttributesEntity savePageAttributeDetails(PageAttributesEntity pageAttribute);

   Integer savePageDetails(PagesEntity page);

   String savePageAttributePropertiesDetails(List<PageAttrPropertiesEntity> pageAttrPropertiesList);

   ProcedureResult callFunction(Integer attribute_id, Map<String, Object> params);

   ResponseEntity<Map<String, Object>> addPagePropDetails(PagePropDetailsDTO pagePropDetailsJSON) throws JsonMappingException, JsonProcessingException;

   boolean validPageOrNot(String pageName);

   EntityObjectsEntity saveEntityObject(EntityObjectsEntity entityObject);

   ViewObjectsEntity saveViewObject(ViewObjectsEntity viewObject);

   String deleteRemovedAttr(Integer removedAttr);

//   pageAttributesEntity saveEOData(Integer attrId, String entityObject, String entityObjectAttr, String  attribute_value);

   PageAttributesEntity saveEOData(List<Map<String, String>> attributes) throws JsonMappingException, JsonProcessingException, IOException, SQLException;

   List<Map<String, Object>> getVOData(List<Map<String, String>> voMaps);
}
