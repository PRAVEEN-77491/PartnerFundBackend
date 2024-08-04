package com.PartnersFunds.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import com.PartnersFunds.Entities.pagesEntity;
//import com.PartnersFunds.Repo.pageAttrPropertiesRepo;
//import com.PartnersFunds.Repo.pageAttributesRepo;
//import com.PartnersFunds.Repo.pagesRepo;
//import com.PartnersFunds.Entities.pageAttributesEntity;
//import com.PartnersFunds.Entities.pageAttrPropertiesEntity;
//
//import java.sql.Date;
//import java.util.Map;
//
//@Service
//public class PageService {
//    @Autowired
//    private pagesRepo pagesRepository;
//    @Autowired
//    private pageAttributesRepo pageAttributesRepository;
//    @Autowired
//    private pageAttrPropertiesRepo pageAttrPropertiesRepository;
//
//    @Transactional
//    public pagesEntity savePage(CustomPageDTO pageDto) {
//       
//        pagesEntity page = new pagesEntity();
//        page.setPage_id(pageDto.getId());
//       
////        page.setCreation_date(new Date(System.currentTimeMillis()));
////        page.setLast_update_date(new Date(System.currentTimeMillis()));
//        pagesEntity savedPage = pagesRepository.save(page);
//
//      
//        for (CustomJsonElementsDTO element : pageDto.getJsonElements()) {
//            pageAttributesEntity attribute = new pageAttributesEntity();
//            attribute.setAttribute_id(Integer.valueOf(element.getId()));
//            attribute.setPage_id(savedPage.getPage_id());
//            attribute.setAttribute_name(element.getType());
//            attribute.setAttribute_type(element.getType());
//            attribute.setCreation_date(new Date(System.currentTimeMillis()));
//            attribute.setLast_update_date(new Date(System.currentTimeMillis()));
//            pageAttributesEntity savedAttribute = pageAttributesRepository.save(attribute);
//
//            for (Map.Entry<String, Object> property : element.getProperties().entrySet()) {
//                pageAttrPropertiesEntity propertyEntity = new pageAttrPropertiesEntity();
//                propertyEntity.setAttribute_id(savedAttribute.getAttribute_id());
//                propertyEntity.setProperty_name(property.getKey());
//                propertyEntity.setProperty_value(property.getValue().toString());
//                propertyEntity.setProperty_type("VISUAL");
//                if (property.getKey().equalsIgnoreCase("onClick") ||
//                    property.getKey().equalsIgnoreCase("disabled") ||
//                    property.getKey().equalsIgnoreCase("form") ||
//                    property.getKey().equalsIgnoreCase("formAction") ||
//                    property.getKey().equalsIgnoreCase("formMethod") ||
//                    property.getKey().equalsIgnoreCase("formTarget")) {
//                    propertyEntity.setProperty_type("EVENT");
//                }
//                propertyEntity.setCreation_date(new Date(System.currentTimeMillis()));
//                propertyEntity.setLast_updated_date(new Date(System.currentTimeMillis()));
//                pageAttrPropertiesRepository.save(propertyEntity);
//            }
//        }
//
//        return savedPage;
//    }
//}



import com.PartnersFunds.Entities.pageAttributesEntity;
import com.PartnersFunds.Entities.pageAttrPropertiesEntity;
import com.PartnersFunds.Entities.pagesEntity;
import com.PartnersFunds.Repo.pageAttrPropertiesRepo;
import com.PartnersFunds.Repo.pageAttributesRepo;
import com.PartnersFunds.Repo.pagesRepo;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PageService {

    @Autowired
    private pagesRepo pagesRepository;

    @Autowired
    private pageAttributesRepo pageAttributesRepository;

    @Autowired
    private pageAttrPropertiesRepo pageAttrPropertiesRepository;

    public void savePageData(List<com.PartnersFunds.service.pagesDTO> pageDataList) {
        pagesEntity page = new pagesEntity();
//        page = pagesRepository.save(page);

        for (com.PartnersFunds.service.pagesDTO pageData : pageDataList) {
            pageAttributesEntity attribute = new pageAttributesEntity();
            attribute.setPage_id(pageData.getId());
            attribute.setAttribute_name(pageData.getType());
            attribute.setAttribute_type(pageData.getType());
            attribute = pageAttributesRepository.save(attribute);

            for (Map.Entry<String, JsonNode> entry : pageData.getProperties().entrySet()) {
                String key = entry.getKey();
                JsonNode value = entry.getValue();

                pageAttrPropertiesEntity property = new pageAttrPropertiesEntity();
                property.setAttribute_id(attribute.getAttribute_id());
                property.setProperty_name(key);
                property.setProperty_tag(key);
                property.setProperty_value(value.toString());
                property.setProperty_type("VISUAL");
                // Check for EVENT properties
                if (key.equals("onClick") || key.equals("disabled") || key.equals("form") || key.equals("formAction") || key.equals("formMethod") || key.equals("formTarget")) {
                    property.setProperty_type("EVENT");
                }
                pageAttrPropertiesRepository.save(property);
            }
        }
    }
}
