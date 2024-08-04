package com.PartnersFunds.service;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomJsonElementsDTO {

	   @JsonProperty("id")
	   private String id;
	   @JsonProperty("type")
	   private String type;
	   @JsonProperty("properties")
	   private Map<String, Object> properties;
	   
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Map<String, Object> getProperties() {
		return properties;
	}
	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}
	   
	   
}

 

