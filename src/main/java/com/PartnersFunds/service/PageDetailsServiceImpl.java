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
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.transaction.Transactional;

import java.sql.CallableStatement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.sql.DataSource;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
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
	Logger logger = LoggerFactory.getLogger(getClass());

	public List<Object[]> getAllDetails() {
		return this.pageRepo.allDetails();
	}
	
	public boolean validPageOrNot(String pageName) {
		return pagesRepo.findbyPageName(pageName);
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

	@Transactional
	public pagesEntity addPagePropDetails(pagePropDetailsDTO pagePropDetailsJSON)
			throws JsonMappingException, JsonProcessingException {
		try {
			logger.info("Logging : addPagePropDetails() : execution started ");
			// Parse JSON elements
			logger.info("Parsing JSON elements from pagePropDetailsDTO");
			JsonNode jsonElementsArray = objectMapper.readTree(pagePropDetailsJSON.getJsonElements());

			// Extract attribute IDs
			List<Integer> attributeIds = new ArrayList<>();
			jsonElementsArray.forEach(jsonElement -> attributeIds.add(jsonElement.get("id").asInt()));
			logger.info("Extracted attribute IDs: {}", attributeIds);

			// Retrieve pages entity from repository
			logger.info("Retrieving pages entity with page_id: {} and attributeIds: {}",
					pagePropDetailsJSON.getPage_id(), attributeIds);
			pagesEntity pagesEntity = pagesRepo.findByPageIdAndAttributeIds(pagePropDetailsJSON.getPage_id(),
					attributeIds);

			// Deserialize JSON elements into a list of DTOs
			logger.info("Deserializing JSON elements into a list of DTOs");
			List<JsonElementDTO> pagePropDetailsJsonElements = objectMapper
					.readValue(pagePropDetailsJSON.getJsonElements(), new TypeReference<List<JsonElementDTO>>() {
					});

			// Create a map of existing attributes for faster lookup
			logger.info("Creating a map of existing attributes for faster lookup");
			Map<Integer, pageAttributesEntity> existingAttributes = pagesEntity.getPageAttributes().stream()
					.collect(Collectors.toMap(pageAttributesEntity::getAttribute_id, Function.identity()));

			// Create a list to hold the updated attribute details
			List<pageAttributesEntity> updatedAttributes = new ArrayList<>();

			// Iterate over JSON elements and update attributes and properties
			pagePropDetailsJsonElements.forEach(element -> {
				pageAttributesEntity pageAttributesEntity = existingAttributes.get(element.getId());
				logger.info("Processing element with ID: {}", element.getId());

				// Update attribute properties
				element.getProperties().forEach((key, value) -> {
					pageAttrPropertiesEntity property = pageAttributesEntity.getPageAttrPropertiesEntity().stream()
							.filter(prop -> prop.getProperty_name().equals(key)).findFirst().orElseGet(() -> {
								pageAttrPropertiesEntity newProp = new pageAttrPropertiesEntity();
								newProp.setAttribute_id(pageAttributesEntity.getAttribute_id());
								newProp.setProperty_name(key);
								newProp.setProperty_tag(key);
								if (List.of("onClick", "disabled", "form", "formAction", "formMethod", "formTarget")
										.contains(key)) {
									newProp.setProperty_type("EVENT");
								}else {
									newProp.setProperty_type("VISUAL");									
								}
								pageAttributesEntity.getPageAttrPropertiesEntity().add(newProp);
								logger.info("Added new property with name: {} and type: {}", key,
										newProp.getProperty_type());
								return newProp;
							});
					property.setProperty_value(value.toString());
					logger.info("Updated property with name: {} and value: {}", key, value);
				});
				updatedAttributes.add(pageAttributesEntity);
			});
			logger.info("Saving updated pages entity");
			return pagesRepo.save(pagesEntity);

		} catch (JsonMappingException e) {
			logger.error("Error mapping JSON to Java objects: {}", e.getMessage());
			throw new RuntimeException("Error mapping JSON to Java objects", e);
		} catch (JsonProcessingException e) {
			logger.error("Error processing JSON: {}", e.getMessage());
			throw new RuntimeException("Error processing JSON", e);
		} catch (Exception e) {
			logger.error("An unexpected error occurred: {}", e.getMessage());
			throw new RuntimeException("An unexpected error occurred while processing the request", e);
		}
	}
}
