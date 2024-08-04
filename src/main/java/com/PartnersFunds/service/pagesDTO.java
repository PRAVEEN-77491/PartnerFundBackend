package com.PartnersFunds.service;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.Map;

public class pagesDTO {
    private Integer id;
    private String type;
    private Map<String, JsonNode> properties;

    // Getters and setters
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

    public Map<String, JsonNode> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, JsonNode> properties) {
        this.properties = properties;
    }
}
