package com.PartnersFunds.Entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="xxpf_page_attr_prop_conditions")
public class pageAttrPropConditionsEntity {

	@Id
	@Column(name="condition_id")
	private Integer condition_id;
	
	@Column(name="property_id")
	private Integer property_id;
	
	@Column(name="condition_sequence")
	private Integer condition_sequence;
	
	@Column(name="condition_attribute_name")
	private String condition_attribute_name;
	
	@Column(name="condition_operator")
	private String condition_operator;
	
	@Column(name="low_value")
	private String low_value;
	
	@Column(name="high_value")
	private String high_value;
	
	@Column(name="parent_condition_operator")
	private String parent_condition_operator;

	@Column(name = "created_by")
	private  String created_by;
	
	@Column(name = "creation_date")
	private Date creation_date;
	
	@Column(name = "last_updated_by")
	private String last_updated_by;
	
	@Column(name = "last_update_date")
	private Date last_update_date;

	public pageAttrPropConditionsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public pageAttrPropConditionsEntity(Integer condition_id, Integer property_id, Integer condition_sequence,
			String condition_attribute_name, String condition_operator, String low_value, String high_value,
			String parent_condition_operator, String created_by, Date creation_date, String last_updated_by,
			Date last_update_date) {
		super();
		this.condition_id = condition_id;
		this.property_id = property_id;
		this.condition_sequence = condition_sequence;
		this.condition_attribute_name = condition_attribute_name;
		this.condition_operator = condition_operator;
		this.low_value = low_value;
		this.high_value = high_value;
		this.parent_condition_operator = parent_condition_operator;
		this.created_by = created_by;
		this.creation_date = creation_date;
		this.last_updated_by = last_updated_by;
		this.last_update_date = last_update_date;
	}

	public Integer getCondition_id() {
		return condition_id;
	}

	public void setCondition_id(Integer condition_id) {
		this.condition_id = condition_id;
	}

	public Integer getProperty_id() {
		return property_id;
	}

	public void setProperty_id(Integer property_id) {
		this.property_id = property_id;
	}

	public Integer getCondition_sequence() {
		return condition_sequence;
	}

	public void setCondition_sequence(Integer condition_sequence) {
		this.condition_sequence = condition_sequence;
	}

	public String getCondition_attribute_name() {
		return condition_attribute_name;
	}

	public void setCondition_attribute_name(String condition_attribute_name) {
		this.condition_attribute_name = condition_attribute_name;
	}

	public String getCondition_operator() {
		return condition_operator;
	}

	public void setCondition_operator(String condition_operator) {
		this.condition_operator = condition_operator;
	}

	public String getLow_value() {
		return low_value;
	}

	public void setLow_value(String low_value) {
		this.low_value = low_value;
	}

	public String getHigh_value() {
		return high_value;
	}

	public void setHigh_value(String high_value) {
		this.high_value = high_value;
	}

	public String getParent_condition_operator() {
		return parent_condition_operator;
	}

	public void setParent_condition_operator(String parent_condition_operator) {
		this.parent_condition_operator = parent_condition_operator;
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
