package com.PartnersFunds.Entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="xxpf_page_attributes")
public class pageAttributesEntity {

	
	@Id
	@Column(name="attribute_id")
	private Integer attribute_id;
	
	@Column(name="page_id")
	private Integer page_id;
	
	@Column(name="attribute_name")
	private String attribuute_name;
	
	@Column(name="attribute_type")
	private String attribute_type;
	
	@Column(name = "created_by")
	private  String created_by;
	
	@Column(name = "creation_date")
	private Date creation_date;
	
	@Column(name = "last_updated_by")
	private String last_updated_by;
	
	@Column(name = "last_update_date")
	private Date last_update_date;

	public pageAttributesEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public pageAttributesEntity(Integer attribute_id, Integer page_id, String attribuute_name, String attribute_type,
			String created_by, Date creation_date, String last_updated_by, Date last_update_date) {
		super();
		this.attribute_id = attribute_id;
		this.page_id = page_id;
		this.attribuute_name = attribuute_name;
		this.attribute_type = attribute_type;
		this.created_by = created_by;
		this.creation_date = creation_date;
		this.last_updated_by = last_updated_by;
		this.last_update_date = last_update_date;
	}

	public Integer getAttribute_id() {
		return attribute_id;
	}

	public void setAttribute_id(Integer attribute_id) {
		this.attribute_id = attribute_id;
	}

	public Integer getPage_id() {
		return page_id;
	}

	public void setPage_id(Integer page_id) {
		this.page_id = page_id;
	}

	public String getAttribuute_name() {
		return attribuute_name;
	}

	public void setAttribuute_name(String attribuute_name) {
		this.attribuute_name = attribuute_name;
	}

	public String getAttribute_type() {
		return attribute_type;
	}

	public void setAttribute_type(String attribute_type) {
		this.attribute_type = attribute_type;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public String getLast_updated_by() {
		return last_updated_by;
	}

	public void setLast_updated_by(String last_updated_by) {
		this.last_updated_by = last_updated_by;
	}

	public Date getLast_update_date() {
		return last_update_date;
	}

	public void setLast_updated_date(Date last_update_date) {
		this.last_update_date = last_update_date;
	}

	
}

