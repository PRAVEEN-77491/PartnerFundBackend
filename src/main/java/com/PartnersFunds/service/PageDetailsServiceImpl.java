package com.PartnersFunds.service;

import com.PartnersFunds.Entities.EntityObjectsEntity;
import com.PartnersFunds.Entities.PageAttrPropertiesEntity;
import com.PartnersFunds.Entities.PageAttributesEntity;
import com.PartnersFunds.Entities.PagesEntity;
import com.PartnersFunds.Entities.ViewObjectsEntity;
import com.PartnersFunds.FieldsEntites.CodeGeneratorTemplate;
import com.PartnersFunds.Repo.PageDetailsRepo;
import com.PartnersFunds.Repo.EntityObjectsRepo;
import com.PartnersFunds.Repo.PageAttrPropertiesRepo;
import com.PartnersFunds.Repo.PageAttributesRepo;
import com.PartnersFunds.Repo.PagesRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.PartnersFunds.Repo.ViewObjectsRepo;
import com.PartnersFunds.utils.QueryBuilder;

import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class PageDetailsServiceImpl implements PageDetailsService {

	@Autowired
	PageDetailsRepo pageRepo;
	@Autowired
	PageAttributesRepo pageAttributeRepo;
	@Autowired
	PageAttrPropertiesRepo pageAttrPropertiesRepo;
	@Autowired
	PagesRepo pagesRepo;
	@Autowired
	JdbcTemplate template;
	@Autowired
	DataSource datasource;
	@Autowired
	EntityObjectsRepo entityObjectsRepo;
	@Autowired
	ViewObjectsRepo viewObjectsRepo;
	@Autowired
	QueryBuilder queryBuilder;

	String status;
	String message;
	String pageGeneratedCode=null;

	private final ObjectMapper objectMapper = new ObjectMapper();
	Logger logger = LoggerFactory.getLogger(getClass());

	public List<Object[]> getAllDetails() {
		return this.pageRepo.allDetails();
	}

	public boolean validPageOrNot(String pageName) {
		return pagesRepo.findbyPageName(pageName);
	}

	public Integer savePageDetails(PagesEntity page) {
		try {
			PagesEntity savedData = (PagesEntity) this.pageRepo.save(page);
			System.out.println(savedData.getPage_id());
			return savedData.getPage_id();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public PageAttributesEntity savePageAttributeDetails(PageAttributesEntity pageAttribute) {
		try {
			return (PageAttributesEntity) this.pageAttributeRepo.save(pageAttribute);
		} catch (Exception var3) {
			throw new RuntimeException("Failed to save page attribute details", var3);
		}
	}

	public String savePageAttributePropertiesDetails(List<PageAttrPropertiesEntity> pageAttrPropertiesList) {
		try {
			Iterator<PageAttrPropertiesEntity> pageList = pageAttrPropertiesList.iterator();

			while (pageList.hasNext()) {
				PageAttrPropertiesEntity pageAttrProperties = (PageAttrPropertiesEntity) pageList.next();
				this.pageAttrPropertiesRepo.save(pageAttrProperties);
			}

			return "Success";
		} catch (Exception e) {
			return "Error: " + e.getMessage();
		}
	}

	public ProcedureResult callFunction(Integer attribute_id, Map<String, Object> parameters) {
		String funcNameWithParams = this.pageAttrPropertiesRepo.dBFuncName(attribute_id);
		String formattedFuncNameWithParams = this.replaceFunctionParameters(funcNameWithParams, parameters);
		System.out.println("formattedFuncName: " + formattedFuncNameWithParams);
		String callableSql = this.createCallableSql(formattedFuncNameWithParams);
		System.out.println("callableSql" + callableSql);

		try {
			template = new JdbcTemplate(this.datasource);
			return template.execute((ConnectionCallback<ProcedureResult>) (conn) -> {
				System.out.println(callableSql);
				CallableStatement callableStatement = conn.prepareCall(callableSql);
				callableStatement.registerOutParameter(1, 12);
				callableStatement.execute();

				JSONObject jsonObject = new JSONObject(callableStatement.getString(1));
				String status = jsonObject.getString("status");
				String message = jsonObject.getString("message");
				return new ProcedureResult(status, message);
			});
		} catch (Exception var7) {
			System.err.println("Error executing stored Function: " + var7.getMessage());
			var7.printStackTrace();
			return new ProcedureResult("FAILURE", var7.getMessage());
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
	public ResponseEntity<Map<String, Object>> addPagePropDetails(PagePropDetailsDTO pagePropDetailsJSON)
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
			PagesEntity pagesEntity = pagesRepo.findByPageIdAndAttributeIds(pagePropDetailsJSON.getPage_id(),
					attributeIds);

			System.out.println(pagesEntity);

			// Deserialize JSON elements into a list of DTOs
			logger.info("Deserializing JSON elements into a list of DTOs");
			List<JsonElementDTO> pagePropDetailsJsonElements = objectMapper
					.readValue(pagePropDetailsJSON.getJsonElements(), new TypeReference<List<JsonElementDTO>>() {
					});

			// Create a map of existing attributes for faster lookup
			logger.info("Creating a map of existing attributes for faster lookup");
			Map<Integer, PageAttributesEntity> existingAttributes = pagesEntity.getPageAttributes().stream()
					.collect(Collectors.toMap(PageAttributesEntity::getAttribute_id, Function.identity()));

			// Create a list to hold the updated attribute details
			List<PageAttributesEntity> updatedAttributes = new ArrayList<>();
			
			// Iterate over JSON elements and update attributes and properties
			pagePropDetailsJsonElements.forEach(element -> {
				PageAttributesEntity pageAttributesEntity = existingAttributes.get(element.getId());
				logger.info("Processing element with ID: {}", element.getId());

				// Update attribute properties
				element.getProperties().forEach((key, value) -> {
					PageAttrPropertiesEntity property = pageAttributesEntity.getPageAttrPropertiesEntity().stream()
							.filter(prop -> prop.getProperty_name().equals(key)).findFirst().orElseGet(() -> {
								PageAttrPropertiesEntity newProp = new PageAttrPropertiesEntity();
								newProp.setAttribute_id(pageAttributesEntity.getAttribute_id());
								newProp.setProperty_name(key);
								newProp.setProperty_tag(key);
								newProp.setCreated_by(pageAttributesEntity.getCreated_by());
								newProp.setLast_updated_by(pageAttributesEntity.getLast_updated_by());

								Date currentDate = new Date(System.currentTimeMillis());

								newProp.setCreation_date(currentDate);
								newProp.setLast_updated_date(currentDate);

								if (List.of("onClick", "disabled", "form", "formAction", "formMethod", "formTarget")
										.contains(key)) {
									newProp.setProperty_type("EVENT");
								} else {
									newProp.setProperty_type("VISUAL");
								}
								pageAttributesEntity.getPageAttrPropertiesEntity().add(newProp);
								logger.info("Added new property with name: {} and type: {}", key,
										newProp.getProperty_type());
								return newProp;
							});
					property.setProperty_value(value.toString());
//					logger.info("Updated property with name: {} and value: {}", key, value);

					Date now = new Date(System.currentTimeMillis());
					property.setLast_updated_date(now);
//			        logger.info("Updated property with Last_Updated_Date: {}", now);
					
				});
				updatedAttributes.add(pageAttributesEntity);
				pageGeneratedCode = CodeGeneratorTemplate.generateReactComponent(pagesEntity, updatedAttributes);
			});
			logger.info("Saving updated pages entity");
			
			System.out.println(pageGeneratedCode);
	        // Prepare the response with both saved entity and generated code
	        Map<String, Object> response = new HashMap<>();
	        response.put("PageEntity", pagesRepo.save(pagesEntity));
	        response.put("generatedPageCode", pageGeneratedCode);

	        return ResponseEntity.ok(response);

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

	public String deleteRemovedAttr(Integer removedAttrId) {
		pageAttributeRepo.deleteById(removedAttrId);
		return "Attribute deleted having id : " + removedAttrId.toString();
	}

	public EntityObjectsEntity saveEntityObject(EntityObjectsEntity entityObject) {
		EntityObjectsEntity entityObjectsEntity = entityObjectsRepo.save(entityObject);
		return entityObjectsEntity;
	}

	public ViewObjectsEntity saveViewObject(ViewObjectsEntity viewObject) {
		ViewObjectsEntity viewObjectsEntity = viewObjectsRepo.save(viewObject);
		return viewObjectsEntity;
	}

	@Transactional
	public PageAttributesEntity saveEOData(List<Map<String, String>> attributes) throws IOException, SQLException {

		// Extract all attribute IDs from the input JSON
		List<Integer> attributeIds = attributes.stream().map(attr -> Integer.parseInt(attr.get("attid")))
				.collect(Collectors.toList());

		
		
		Map<Integer, String> attributeMapValues = attributes.stream()
				.collect(Collectors.toMap(attr -> Integer.parseInt(attr.get("attid")), attr -> attr.get("value")));
		
		
		
		// Fetch all attributes in one go
		List<Object[]> attributesEntities = pageAttributeRepo.findAllEOVOByAttributeIds(attributeIds);

		Map<String, List<Map<String, String>>> queryToValue = new HashMap<>();

		// Process each attribute entity
		for (Object[] attributesEntity : attributesEntities) {
			Map<String, String> attributeToValuesMap = new HashMap<>();

			// Pattern to match EO and VO values
			Pattern pattern = Pattern.compile(
					"EO=\\{entityobject=\"(.*?)\", entityattribute=(.*?)\\}");
			Matcher matcher = pattern.matcher(String.valueOf(attributesEntity[1]));

			if (matcher.find()) {
				String eoEntityObject = matcher.group(1);
				String eoEntityAttribute = matcher.group(2);
				System.out.println("eoEntityAttribute =====> " + eoEntityAttribute);
				String entityObjectsTableName = entityObjectsRepo.findByObjectName(eoEntityObject);

				if (entityObjectsTableName != null && !String.valueOf(attributesEntity[1]).isEmpty()) {

					attributeToValuesMap.put(eoEntityAttribute,
							attributeMapValues.get(Integer.parseInt(String.valueOf(attributesEntity[0]))));

					System.out.println("attributeToValuesMap : " + attributeToValuesMap);
					if (queryToValue.containsKey(entityObjectsTableName)) {
						// Get the current list of records
						List<Map<String, String>> existingRecords = queryToValue.get(entityObjectsTableName);

						// Convert to mutable list if it's not already
						if (!(existingRecords instanceof ArrayList)) {
							existingRecords = new ArrayList<>(existingRecords);
							queryToValue.put(entityObjectsTableName, existingRecords);
						}

						// Add the new record
						existingRecords.add(attributeToValuesMap);
					} else {
						// Create a new mutable list with the new record and put it in the map
						List<Map<String, String>> newList = new ArrayList<>();
						newList.add(attributeToValuesMap);
						queryToValue.put(entityObjectsTableName, newList);
					}
				} else {
					System.out.println("Entity objects table name or EO list is empty.");
				}
			}
		}
		
		Map<Integer, String> attIdToSequenceMap = attributes.stream()

				.collect(Collectors.toMap(
							attr -> Integer.parseInt(attr.get("attid")),
							attr -> attr.get("sequenceName")));
		
		System.out.println("MAP VALUE -==> "+ attIdToSequenceMap);
		
		//Getting sequenceName
//		String sequreceName = attIdToSequenceMap.get()
		String sequenceName = "";
		List<String> finalSQLQueries = new ArrayList<>();
		
		for (Map.Entry<Integer, String> entry : attIdToSequenceMap.entrySet()) {
			sequenceName = entry.getValue();
			System.out.println(queryBuilder.buildInsertQuery(queryToValue,sequenceName));
			finalSQLQueries = queryBuilder.buildInsertQuery(queryToValue,sequenceName);
		}
//		 Execute each query
		for (String query : finalSQLQueries) {
			try {
				// Print the query for debugging purposes
				System.out.println("Executing SQL Query: " + query);

				// Execute the query using JdbcTemplate
				int rowsAffected = template.update(query);

				// Print the number of rows affected for confirmation
				System.out.println("Rows affected: " + rowsAffected);
			} catch (Exception e) {
				// Handle any exceptions that occur during query execution
				System.err.println("Error executing query: " + query);
				e.printStackTrace();
			}
		}
		return new PageAttributesEntity(); // Or return a meaningful response if needed
	}

	@Transactional
	public List<Map<String, Object>> getVOData(List<Map<String, String>> voMapList) {
		// Extract all attribute IDs from the input JSON
		List<Integer> attributeIds = voMapList.stream().map(attr -> Integer.parseInt(attr.get("attid"))).collect(Collectors.toList());

		System.out.println("attributeIds="+attributeIds);
		// Fetch all attributes in one go
		List<Object[]> attributesEntities = pageAttributeRepo.findAllEOVOByAttributeIds(attributeIds);
		System.out.println("attributesEntities="+attributesEntities);
		List<Map<String, Object>> result = new ArrayList<>();

		// Process each attribute entity
		int counter = 0;
		for (Object[] attributesEntity : attributesEntities) {
			
			Integer attributeId = Integer.parseInt(String.valueOf(attributesEntity[0]));
			
			// Pattern to match EO and VO values
			Pattern pattern = Pattern.compile(
					"EO=\\{entityobject=\"(.*?)\", entityattribute=(.*?)\\}, VO=\\{viewobject=\"(.*?)\", viewattribute=(.*?)\\}");
			Matcher matcher = pattern.matcher(String.valueOf(attributesEntity[1]));

			if (matcher.find()) {
				String eoEntityAttribute = matcher.group(2);  // eoEntityAttribute
				String voEntityObject = matcher.group(3);    //voEntityObject
				String voEntityAttribute = matcher.group(4);// voEntityAttribute

				Map<String, Object> parameters = new HashMap<>();
				parameters.put(voEntityAttribute, eoEntityAttribute);

				if (voMapList.get(counter).get("viewObjectName").equals(voEntityObject)) {
					String res = replaceFieldsWithEOValues2(voMapList.get(counter).get("viewObjectQuery"), parameters);
					System.out.println("res="+res);
					List<Map<String, Object>> queryResult = template.queryForList(res);
					System.out.println("queryResult : " + queryResult);
					// Replace column names with voEntityAttribute values and include attributeId
	                for (Map<String, Object> row : queryResult) {
	                    Map<String, Object> modifiedRow = new HashMap<>();
	                    modifiedRow.put("attid", attributeId);
	                    modifiedRow.put("placeHolder_column", voEntityAttribute);
	                    modifiedRow.put("attrValue", row.get(eoEntityAttribute));
	                    result.add(modifiedRow);
	                }
					counter++;
				}
			}
		}
		return result;
	}

	private String replaceFieldsWithEOValues2(String query, Map<String, Object> parameters) {

		Pattern pattern = Pattern.compile("\\$(.*?)\\$");
		Matcher matcher = pattern.matcher(query);
		StringBuffer updatedQuery = new StringBuffer();

		while (matcher.find()) {
			String fieldName = matcher.group(1);
			if (parameters.containsKey(fieldName)) {
				matcher.appendReplacement(updatedQuery, String.valueOf(parameters.get(fieldName)));
			}
		}
		matcher.appendTail(updatedQuery);
		return updatedQuery.toString();
	}

}