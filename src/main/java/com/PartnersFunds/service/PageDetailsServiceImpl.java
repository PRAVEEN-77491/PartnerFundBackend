package com.PartnersFunds.service;

import com.PartnersFunds.Entities.pageAttrPropertiesEntity;
import com.PartnersFunds.Entities.pageAttributesEntity;
import com.PartnersFunds.Entities.pagesEntity;
import com.PartnersFunds.Repo.PageDetailsRepo;
import com.PartnersFunds.Repo.entityObjectsRepo;
import com.PartnersFunds.Repo.pageAttrPropertiesRepo;
import com.PartnersFunds.Repo.pageAttributesRepo;
import com.PartnersFunds.Repo.pagesRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

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

	private final ObjectMapper objectMapper = new ObjectMapper();

	public List<Object[]> getAllDetails() {
		return this.pageRepo.allDetails();
	}

	public Integer savePageDetails(pagesEntity page) {
		try {
			pagesEntity savedData = (pagesEntity) this.pageRepo.save(page);
			System.out.println(savedData.getPage_id());
			return savedData.getPage_id();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public pageAttributesEntity savePageAttributeDetails(pageAttributesEntity pageAttribute) {
		try {
			return (pageAttributesEntity) this.pageAttributeRepo.save(pageAttribute);
		} catch (Exception var3) {
			throw new RuntimeException("Failed to save page attribute details", var3);
		}
	}

	public String savePageAttributePropertiesDetails(List<pageAttrPropertiesEntity> pageAttrPropertiesList) {
		try {
			Iterator<pageAttrPropertiesEntity> pageList = pageAttrPropertiesList.iterator();

			while (pageList.hasNext()) {
				pageAttrPropertiesEntity pageAttrProperties = (pageAttrPropertiesEntity) pageList.next();
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
			return template.execute((ConnectionCallback<procedureResult>) (conn) -> {
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
		for (Iterator<Entry<String, Object>> var = parameters.entrySet().iterator(); var
				.hasNext(); funcNameWithParams = funcNameWithParams.replace(paramName, paramValueString)) {
			Entry<String, Object> entry = (Entry<String, Object>) var.next();
			paramName = "$" + (String) entry.getKey() + "$";
			Object paramValue = entry.getValue();
			if (paramValue instanceof String) {
				paramValueString = "'" + paramValue.toString().replace("'", "''") + "'";
			} else if (!(paramValue instanceof Integer) && !(paramValue instanceof Long)
					&& !(paramValue instanceof Short)) {
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

	public pagesEntity addPagePropDetails(pagePropDetailsDTO pagePropDetailsJSON)
			throws JsonMappingException, JsonProcessingException {
		
		System.out.println("getPage_id : " + pagePropDetailsJSON.getPage_id());

		pagesEntity pagesEntity = pagesRepo.findByPage_id(pagePropDetailsJSON.getPage_id());

		System.out.println("pagesEntity : " + pagesEntity);

		List<JsonElementDTO> pagePropDetailsJsonElements = objectMapper.readValue(pagePropDetailsJSON.getJsonElements(),
				new TypeReference<List<JsonElementDTO>>() {
				});

		List<pageAttributesEntity> existingAttributes = pagesEntity.getPageAttributes();
		existingAttributes.clear();

        for (JsonElementDTO element : pagePropDetailsJsonElements) {
            pageAttributesEntity pageAttributesEntity = existingAttributes.stream()
                .filter(attr -> attr.getAttribute_id().equals(element.getId()))
                .findFirst()
                .orElseGet(() -> {
                    pageAttributesEntity newAttr = new pageAttributesEntity();
                    newAttr.setAttribute_id(element.getId());
                    newAttr.setPage_id(pagesEntity.getPage_id());
                    return newAttr;
                });

            pageAttributesEntity.setAttribute_name(element.getType());
            pageAttributesEntity.setAttribute_type(element.getType());

            List<pageAttrPropertiesEntity> existingProperties = pageAttributesEntity.getPageAttrPropertiesEntity();
            existingProperties.clear();

            for (Map.Entry<String, Object> entry : element.getProperties().entrySet()) {
                // Check if property already exists
                pageAttrPropertiesEntity existingProperty = pageAttrPropertiesRepo.findByAttributeIdAndPropertyName(pageAttributesEntity.getAttribute_id(), entry.getKey());

                pageAttrPropertiesEntity pageAttrProperties = Optional.ofNullable(existingProperty).orElseGet(() -> {
                    pageAttrPropertiesEntity newProp = new pageAttrPropertiesEntity();
                    newProp.setAttribute_id(pageAttributesEntity.getAttribute_id());
                    newProp.setProperty_name(entry.getKey());
                    newProp.setProperty_tag(entry.getKey());
                    newProp.setProperty_type("VISUAL");
                    if (List.of("onClick", "disabled", "form", "formAction", "formMethod", "formTarget").contains(entry.getKey())) {
                        newProp.setProperty_type("EVENT");
                    }
                    return newProp;
                });

                pageAttrProperties.setProperty_value(entry.getValue().toString());
                existingProperties.add(pageAttrProperties);
            }

            existingAttributes.add(pageAttributesEntity);
        }

        pagesEntity.setPageAttributes(existingAttributes);
		return pagesRepo.save(pagesEntity);

	}
}
