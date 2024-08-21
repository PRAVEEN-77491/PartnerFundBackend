package com.PartnersFunds.utils;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class QueryBuilder {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	 Logger logger = LoggerFactory.getLogger(getClass());
	 
	public List<String> buildInsertQuery(Map<String, List<Map<String, String>>> queryToValue, String sequenceName) throws SQLException {

	    List<String> queries = new LinkedList<>();
	    
	    System.out.println("queryToValue ======>>>>> " + queryToValue);

	    for (Map.Entry<String, List<Map<String, String>>> entry : queryToValue.entrySet()) {
	    	logger.info("Logging : execution started ");
	        logger.info("entry.getKey() : " + entry.getKey());

	        logger.info("entry.getValue() : " + entry.getValue());

	        String tableName = entry.getKey();
	        List<Map<String, String>> records = entry.getValue();

	        // Initialize a map to hold all columns and corresponding values for the INSERT
	        Map<String, String> combinedRecord = new LinkedHashMap<>();

	        // Combine all entries from the list of maps into a single map
	        for (Map<String, String> record : records) {
	            combinedRecord.putAll(record);
	        }
	        
//	        // Retrieve column names and data types of the table
//	        DatabaseMetaData metaData = jdbcTemplate.getDataSource().getConnection().getMetaData();
//	        ResultSet res = metaData.getColumns(null, null, tableName, null);
//	        System.out.println("res ====> " + res);
//	        String primaryKeyColumnName = null;
//	        while (res.next()) {
//	          String columnName = res.getString("COLUMN_NAME");
//	          System.out.println("columnName ======> " + columnName);
//	          int dataType = Integer.parseInt(res.getString("DATA_TYPE"));
//	          System.out.println("dataType ======> " + dataType);
//	          if (dataType == Types.NUMERIC) {
//	            primaryKeyColumnName = columnName;
//	            break; // assume only one primary key column
//	          }
//	        }
//	        System.out.println("primaryKeyColumnName ===> " + primaryKeyColumnName);
	        // Insert the sequence name as the value for the ID column
//	        combinedRecord.put(entityObjectsTableName, sequenceName + ".NEXTVAL");

	        // Now create the SQL query with all columns and values combined
	        StringBuilder sqlQuery = new StringBuilder();
	        sqlQuery.append("INSERT INTO ").append(tableName).append(" (");

	        // Append all column names
	        logger.info("combinedRecord.keySet() : " + combinedRecord.keySet());
	        String columns = String.join(", ", combinedRecord.keySet());
	        sqlQuery.append(columns).append(") VALUES (");

	        // Append all values corresponding to the columns, handling the sequence separately
	        String values = combinedRecord.values().stream()
	                .map(value -> value.equals("0") ? value.replace("0",sequenceName + ".NEXTVAL") : "'" + value.replace("'", "''") + "'")
	                .collect(Collectors.joining(", "));

	        sqlQuery.append(values).append(")");

	        // Add the final SQL query to the list
	        queries.add(sqlQuery.toString());
	    }
	    return queries;
	}
}
