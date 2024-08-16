package com.PartnersFunds.utils;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class QueryBuilder {

	public List<String> buildInsertQuery(Map<String, List<Map<String, String>>> queryToValue, String sequenceName) {
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

	        // Insert the sequence name as the value for the ID column
	        combinedRecord.put("distirubutor_id", sequenceName + ".NEXTVAL");

	        // Now create the SQL query with all columns and values combined
	        StringBuilder sqlQuery = new StringBuilder();
	        sqlQuery.append("INSERT INTO ").append(tableName).append(" (");

	        // Append all column names
	        System.out.println("combinedRecord.keySet() : " + combinedRecord.keySet());
	        String columns = String.join(", ", combinedRecord.keySet());
	        sqlQuery.append(columns).append(") VALUES (");

	        // Append all values corresponding to the columns, handling the sequence separately
	        String values = combinedRecord.values().stream()
	                .map(value -> value.equals(sequenceName + ".NEXTVAL") ? value : "'" + value.replace("'", "''") + "'")
	                .collect(Collectors.joining(", "));

	        sqlQuery.append(values).append(")");

	        // Add the final SQL query to the list
	        queries.add(sqlQuery.toString());
	    }
	    return queries;
	} 
}
