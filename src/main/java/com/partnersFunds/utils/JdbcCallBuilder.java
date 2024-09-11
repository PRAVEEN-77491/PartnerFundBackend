package com.partnersFunds.utils;

import javax.sql.DataSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

@Component
public class JdbcCallBuilder {

	public SimpleJdbcCall buildSimpleJdbcCall(DataSource dataSource, final String schemaName, String packageName,
            String procedureName) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource).withSchemaName(schemaName)
                .withCatalogName(packageName).withProcedureName(procedureName).withoutProcedureColumnMetaDataAccess();
        return simpleJdbcCall;
    } 

}