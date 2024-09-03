package com.PartnersFunds.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ManagePartnershipGeographyDTO {

    @JsonProperty("geographyId")
    private Integer geographyId;

    @JsonProperty("partnershipId")
    private Integer partnershipId;

    @JsonProperty("localName")
    private String localName;

    @JsonProperty("territory")
    private String territory;

    @JsonProperty("country")
    private String country;

    @JsonProperty("geoName")
    private String geoName;

    @JsonProperty("theater")
    private String theater;

    @JsonProperty("userId")
    private Integer userId;

    // Getters and Setters
    public Integer getGeographyId() {
        return geographyId;
    }

    public void setGeographyId(Integer geographyId) {
        this.geographyId = geographyId;
    }

    public Integer getPartnershipId() {
        return partnershipId;
    }

    public void setPartnershipId(Integer partnershipId) {
        this.partnershipId = partnershipId;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getTerritory() {
        return territory;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGeoName() {
        return geoName;
    }

    public void setGeoName(String geoName) {
        this.geoName = geoName;
    }

    public String getTheater() {
        return theater;
    }

    public void setTheater(String theater) {
        this.theater = theater;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
