package com.PartnersFunds.Entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="xxpf_page_attr_properties")
public class pageAttrPropertiesEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "xxpf_page_attr_properties_s")
    @SequenceGenerator(name = "xxpf_page_attr_properties_s", sequenceName = "xxpf_page_attr_properties_s", allocationSize = 1)
	@Column(name = "property_id")
	private Integer property_id;
	
	@Column(name = "attribute_id")
	private Integer attribute_id;
	
	@Column(name = "property_name")
	private String property_name;

	@Column(name = "property_tag")
	private String property_tag;
	
	@Column(name = "property_value")
	private String property_value;
	
	@Column(name = "property_type")
	private String property_type;
	
	@Column(name = "created_by")
	private  String created_by;
	
	@Column(name = "creation_date")
	private Date creation_date;
	
	@Column(name = "last_updated_by")
	private String last_updated_by;
	
	@Column(name = "last_update_date")
	private Date last_update_date;
    
	@ManyToOne
    @JoinColumn(name = "attribute_id", insertable = false, updatable = false)
    private pageAttributesEntity pageAttributesEntity;

	public pageAttrPropertiesEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public pageAttrPropertiesEntity(Integer property_id, Integer attribute_id, String property_name, String property_tag,
			String property_value, String property_type, String created_by, Date creation_date, String last_updated_by,
			Date last_update_date) {
		super();
		this.property_id = property_id;
		this.attribute_id = attribute_id;
		this.property_name = property_name;
		this.property_tag = property_tag;
		this.property_value = property_value;
		this.property_type = property_type;
		this.created_by = created_by;
		this.creation_date = creation_date;
		this.last_updated_by = last_updated_by;
		this.last_update_date = last_update_date;
	}

	public Integer getProperty_id() {
		return property_id;
	}

	public void setProperty_id(Integer property_id) {
		this.property_id = property_id;
	}

	public Integer getAttribute_id() {
		return attribute_id;
	}

	public void setAttribute_id(Integer attribute_id) {
		this.attribute_id = attribute_id;
	}

	public String getProperty_name() {
		return property_name;
	}

	public void setProperty_name(String property_name) {
		this.property_name = property_name;
	}

	public String getProperty_tag() {
		return property_tag;
	}

	public void setProperty_tag(String property_tag) {
		this.property_tag = property_tag;
	}

	public String getProperty_value() {
		return property_value;
	}

	public void setProperty_value(String property_value) {
		this.property_value = property_value;
	}

	public String getProperty_type() {
		return property_type;
	}

	public void setProperty_type(String property_type) {
		this.property_type = property_type;
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
