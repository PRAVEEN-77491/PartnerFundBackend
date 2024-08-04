package com.PartnersFunds.service;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomPageDTO {

	@JsonProperty("id")
	private Integer id;
	
	@JsonProperty("JsonElements")
	private List<CustomJsonElementsDTO> JsonElements;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<CustomJsonElementsDTO> getJsonElements() {
		return JsonElements;
	}

	public void setJsonElements(List<CustomJsonElementsDTO> jsonElements) {
		JsonElements = jsonElements;
	}
	
	
	
}


