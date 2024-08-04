package com.PartnersFunds.service;

import com.PartnersFunds.Entities.pageAttrPropertiesEntity;
import com.PartnersFunds.Entities.pageAttributesEntity;
import com.PartnersFunds.Entities.pagesEntity;
import com.PartnersFunds.Repo.PageDetailsRepo;
import com.PartnersFunds.Repo.entityObjectsRepo;
import com.PartnersFunds.Repo.pageAttrPropertiesRepo;
import com.PartnersFunds.Repo.pageAttributesRepo;
import com.PartnersFunds.Repo.pagesRepo;
import java.sql.CallableStatement;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.sql.DataSource;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class PageDetailsServiceImpl implements PageDetailsService {
	
   @Autowired
   PageDetailsRepo pageRepo;
   @Autowired
   pageAttributesRepo pageAttributeRepo;
   @Autowired
   pageAttrPropertiesRepo pageAttrPropertiesRepo;
   @Autowired
   pagesRepo pagesRepo;
   @Autowired
   JdbcTemplate template;
   @Autowired
   DataSource datasource;
   @Autowired
   entityObjectsRepo entityObjectsRepo;
   String status;
   String message;

   public List<Object[]> getAllDetails() {
      return this.pageRepo.allDetails();
   }

   public Integer savePageDetails(pagesEntity page) {
      try {
         pagesEntity savedData = (pagesEntity)this.pageRepo.save(page);
         System.out.println(savedData.getPage_id());
         return savedData.getPage_id();
      } catch (Exception e) {
         e.printStackTrace();
         return null;
      }
   }

   public pageAttributesEntity savePageAttributeDetails(pageAttributesEntity pageAttribute) {
      try {
    	  System.out.println("pageAttribute"+pageAttribute);
         return (pageAttributesEntity)this.pageAttributeRepo.save(pageAttribute);
      } catch (Exception e) {
         throw new RuntimeException("Failed to save page attribute details", e);
      }
   }

   public String savePageAttributePropertiesDetails(List<pageAttrPropertiesEntity> pageAttrPropertiesList) {
      try {
         Iterator<pageAttrPropertiesEntity> pageList = pageAttrPropertiesList.iterator();

         while(pageList.hasNext()) {
            pageAttrPropertiesEntity pageAttrProperties = (pageAttrPropertiesEntity)pageList.next();
            this.pageAttrPropertiesRepo.save(pageAttrProperties);
         }

         return "Success";
      } catch (Exception e) {
         return "Error: " + e.getMessage();
      }
   }

   public procedureResult callFunction(Integer attribute_id, Map<String, Object> parameters) {
      String funcNameWithParams = this.pageAttrPropertiesRepo.dBFuncName(attribute_id);
      String formattedFuncNameWithParams = this.replaceFunctionParameters(funcNameWithParams, parameters);
      System.out.println("formattedFuncName: " + formattedFuncNameWithParams);
      String callableSql = this.createCallableSql(formattedFuncNameWithParams);
      System.out.println("callableSql" + callableSql);

      try {
         template = new JdbcTemplate(this.datasource);
         return template.execute((ConnectionCallback<procedureResult>)(conn) -> {
            System.out.println(callableSql);
            CallableStatement callableStatement = conn.prepareCall(callableSql);
            callableStatement.registerOutParameter(1, 12);
            callableStatement.execute();

            JSONObject jsonObject = new JSONObject(callableStatement.getString(1));
            String status = jsonObject.getString("status");
            String message = jsonObject.getString("message");
            return new procedureResult(status, message);
         });
      } catch (Exception var7) {
         System.err.println("Error executing stored Function: " + var7.getMessage());
         var7.printStackTrace();
         return new procedureResult("FAILURE", var7.getMessage());
      }
   }

   private String replaceFunctionParameters(String funcNameWithParams, Map<String, Object> parameters) {
      String paramName;
      String paramValueString;
      for(Iterator<Entry<String, Object>> var = parameters.entrySet().iterator();
    	 var.hasNext(); 
         funcNameWithParams = funcNameWithParams.replace(paramName, paramValueString)) {
         Entry<String, Object> entry = (Entry<String, Object>)var.next();
         paramName = "$" + (String)entry.getKey() + "$";
         Object paramValue = entry.getValue();
         if (paramValue instanceof String) {
            paramValueString = "'" + paramValue.toString().replace("'", "''") + "'";
         } else if (!(paramValue instanceof Integer) && !(paramValue instanceof Long) && !(paramValue instanceof Short)) {
            paramValueString = paramValue.toString();
         } else {
            paramValueString = paramValue.toString();
         }
      }

      return funcNameWithParams;
   }

   private String createCallableSql(String buildProc) {
      StringBuilder callableSql = new StringBuilder("{ ? = call ");
      callableSql.append(buildProc);
      callableSql.append(" }");
      return callableSql.toString();
   }
}
