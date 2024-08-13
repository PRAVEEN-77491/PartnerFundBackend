package com.PartnersFunds.service;

import com.PartnersFunds.Entities.entityObjectsEntity;
import com.PartnersFunds.Entities.pageAttrPropertiesEntity;
import com.PartnersFunds.Entities.pageAttributesEntity;
import com.PartnersFunds.Entities.pagesEntity;
import com.PartnersFunds.Entities.viewObjectsEntity;
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
import com.PartnersFunds.Repo.viewObjectsRepo;

import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.StringReader;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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
	@Autowired
	viewObjectsRepo viewObjectsRepo;
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

			System.out.println(pagesEntity);

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

	public String deleteRemovedAttr(Integer removedAttrId) {
		pageAttributeRepo.deleteById(removedAttrId);
		return "Attribute deleted having id : " + removedAttrId.toString();
	}

	public entityObjectsEntity saveEntityObject(entityObjectsEntity entityObject) {
		entityObjectsEntity entityObjectsEntity = entityObjectsRepo.save(entityObject);
		return entityObjectsEntity;
	}

	public viewObjectsEntity saveViewObject(viewObjectsEntity viewObject) {
		viewObjectsEntity viewObjectsEntity = viewObjectsRepo.save(viewObject);
		return viewObjectsEntity;
	}

	@Transactional
	public pageAttributesEntity saveEOData(List<Map<String, String>> attributes) throws IOException, SQLException {

		// Extract all attribute IDs from the input JSON
		List<Integer> attributeIds = attributes.stream().map(attr -> Integer.parseInt(attr.get("attid")))
				.collect(Collectors.toList());

		Map<Integer, String> attributeMapValues = attributes.stream()
				.collect(Collectors.toMap(attr -> Integer.parseInt(attr.get("attid")), attr -> attr.get("value")));

		// Fetch all attributes in one go
		List<pageAttributesEntity> attributesEntities = pageAttributeRepo.findAllByAttributeIds(attributeIds);

		Map<String, List<Map<String, String>>> queryToValue = new HashMap<>();

		// Process each attribute entity
		for (pageAttributesEntity attributesEntity : attributesEntities) {
			Map<String, String> attributeToValuesMap = new HashMap<>();
			List<String> eoValues = new ArrayList<>();
			List<Integer> colId = new ArrayList<>();

			for (pageAttrPropertiesEntity p : attributesEntity.getPageAttrPropertiesEntity()) {
				if ("eovo".equals(p.getProperty_name()) || "select".equals(p.getProperty_value())) {
					eoValues.add(p.getProperty_value());
					colId.add(p.getAttribute_id());
				}

			}

			// Pattern to match EO and VO values
			Pattern pattern = Pattern.compile(
					"EO=\\{entityobject=\"(.*?)\", entityattribute=(.*?)\\}, VO=\\{viewobject=\"(.*?)\", viewattribute=(.*?)\\}");
			Matcher matcher = pattern.matcher(eoValues.toString());

			if (matcher.find()) {
				String eoEntityObject = matcher.group(1);
				String eoEntityAttribute = matcher.group(2);
				String voViewObject = matcher.group(3);
				String voViewAttribute = matcher.group(4);

				String entityObjectsTableName = entityObjectsRepo.findByObjectName(eoEntityObject);

				if (entityObjectsTableName != null && !eoValues.isEmpty()) {

					for (int i : colId) {
						attributeToValuesMap.put(eoEntityAttribute, attributeMapValues.get(i));
					}
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

		System.out.println(buildInsertQuery(queryToValue));
		List<String> finalSQLQueries = buildInsertQuery(queryToValue);

		// Execute each query
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

		return new pageAttributesEntity(); // Or return a meaningful response if needed
	}

	public static List<String> buildInsertQuery(Map<String, List<Map<String, String>>> queryToValue) {
		List<String> queries = new LinkedList<>();
		for (Map.Entry<String, List<Map<String, String>>> entry : queryToValue.entrySet()) {
			System.out.println("entry.getKey() : " + entry.getKey());
			System.out.println("entry.getValue() : " + entry.getValue());

			String tableName = entry.getKey();
			List<Map<String, String>> records = entry.getValue();

			// Initialize a map to hold all columns and corresponding values for the INSERT
			Map<String, String> combinedRecord = new LinkedHashMap<>();

			// Combine all entries from the list of maps into a single map
			for (Map<String, String> record : records) {
				combinedRecord.putAll(record);
			}

			// Now create the SQL query with all columns and values combined
			StringBuilder sqlQuery = new StringBuilder();
			sqlQuery.append("INSERT INTO ").append(tableName).append(" (");

			// Append all column names
			System.out.println("combinedRecord.keySet() : " + combinedRecord.keySet());
			String columns = String.join(", ", combinedRecord.keySet());
			sqlQuery.append(columns).append(") VALUES (");

			// Append all values corresponding to the columns
			String values = combinedRecord.values().stream().map(value -> "'" + value.replace("'", "''") + "'") 
					.collect(Collectors.joining(", "));

			sqlQuery.append(values).append(")");

			// Add the final SQL query to the list
			queries.add(sqlQuery.toString());
		}
		return queries;
	}

}
