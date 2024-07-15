package com.PartnersFunds.service;


public class PageDetailsDTO {
	
	private String page_name;
	
	private String page_file_name;
	
	private String Page_title;
	
	private String attribute_name;
	
	private String attribute_type;
	
	private String json_data;

	public PageDetailsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PageDetailsDTO(String page_name, String page_file_name, String page_title, String attribute_name,
			String attribute_type, String json_data) {
		super();
		this.page_name = page_name;
		this.page_file_name = page_file_name;
		Page_title = page_title;
		this.attribute_name = attribute_name;
		this.attribute_type = attribute_type;
		this.json_data = json_data;
	}

	public String getPage_name() {
		return page_name;
	}

	public void setPage_name(String page_name) {
		this.page_name = page_name;
	}

	public String getPage_file_name() {
		return page_file_name;
	}

	public void setPage_file_name(String page_file_name) {
		this.page_file_name = page_file_name;
	}

	public String getPage_title() {
		return Page_title;
	}

	public void setPage_title(String page_title) {
		Page_title = page_title;
	}

	public String getAttribute_name() {
		return attribute_name;
	}

	public void setAttribute_name(String attribute_name) {
		this.attribute_name = attribute_name;
	}

	public String getAttribute_type() {
		return attribute_type;
	}

	public void setAttribute_type(String attribute_type) {
		this.attribute_type = attribute_type;
	}

	public String getJson_data() {
		return json_data;
	}

	public void setJson_data(String json_data) {
		this.json_data = json_data;
	}
	
	

}
