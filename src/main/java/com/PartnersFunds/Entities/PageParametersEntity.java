package com.PartnersFunds.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="XXPF_PAGE_PARAMETERS")
public class PageParametersEntity {

	@Id
	@Column(name = "parameter_id")
	private Integer parameter_id;
	
	@Column(name="page_id")
	private Integer page_id;
	
	@Column(name="parameter_name")
	private String parameter_name;
	
	@Column(name="attribute_name")
	private String attribute_name;
	
	@Column(name="default_value")
	private String default_value;

	public PageParametersEntity() {
		super();
	}
	
	public PageParametersEntity(Integer parameter_id, Integer page_id, String parameter_name, String attribute_name,
			String default_value) {
		super();
		this.parameter_id = parameter_id;
		this.page_id = page_id;
		this.parameter_name = parameter_name;
		this.attribute_name = attribute_name;
		this.default_value = default_value;
	}

	public Integer getParameter_id() {
		return parameter_id;
	}

	public void setParameter_id(Integer parameter_id) {
		this.parameter_id = parameter_id;
	}

	public Integer getPage_id() {
		return page_id;
	}

	public void setPage_id(Integer page_id) {
		this.page_id = page_id;
	}

	public String getParameter_name() {
		return parameter_name;
	}

	public void setParameter_name(String parameter_name) {
		this.parameter_name = parameter_name;
	}

	public String getAttribute_name() {
		return attribute_name;
	}

	public void setAttribute_name(String attribute_name) {
		this.attribute_name = attribute_name;
	}

	public String getDefault_value() {
		return default_value;
	}

	public void setDefault_value(String default_value) {
		this.default_value = default_value;
	}

	
}
