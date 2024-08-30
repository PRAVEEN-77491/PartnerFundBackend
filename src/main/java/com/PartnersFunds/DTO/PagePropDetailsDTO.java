package com.PartnersFunds.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
public class PagePropDetailsDTO {

	@JsonProperty("id")
	private int page_id;
	
    @JsonProperty("JsonElements")
    private String jsonElements;

	public int getPage_id() {
		return page_id;
	}

	public void setPage_id(int page_id) {
		this.page_id = page_id;
	}

	public String getJsonElements() {
		return jsonElements;
	}

	public void setJsonElements(String jsonElements) {
		this.jsonElements = jsonElements;
	}
	
}
