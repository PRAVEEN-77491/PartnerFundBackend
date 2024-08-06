package com.PartnersFunds.service;

import java.util.Map;

public class JsonElementDTO {
	
    private Integer id;
    private String type;
    private Map<String, Object> properties;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	@Override
	public String toString() {
		return "JsonElementDTO [id=" + id + ", type=" + type + ", properties=" + properties + ", getId()=" + getId()
				+ ", getType()=" + getType() + ", getProperties()=" + getProperties() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
    
	
}