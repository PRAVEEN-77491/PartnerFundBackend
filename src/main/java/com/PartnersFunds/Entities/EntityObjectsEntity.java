package com.PartnersFunds.Entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="xxpf_entity_objects")
public class EntityObjectsEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "xxpf_entity_objects_s")
    @SequenceGenerator(name = "xxpf_entity_objects_s", sequenceName = "xxpf_entity_objects_s", allocationSize = 1)
	@Column(name="entity_object_id")
	private Integer entity_object_id;
	
	@Column(name="entity_object_name")
	private String entity_object_name;
	
	@Column(name="entity_table_name")
	private String entity_table_name;
	
	@Column(name = "created_by")
	private  String created_by;
	
	@Column(name = "creation_date")
	private Date creation_date;
	
	@Column(name = "last_updated_by")
	private String last_updated_by;
	
	@Column(name = "last_update_date")
	private Date last_update_date;

	public EntityObjectsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EntityObjectsEntity(Integer entity_object_id, String entity_object_name, String entity_table_name,
			String created_by, Date creation_date, String last_updated_by, Date last_update_date) {
		super();
		this.entity_object_id = entity_object_id;
		this.entity_object_name = entity_object_name;
		this.entity_table_name = entity_table_name;
		this.created_by = created_by;
		this.creation_date = creation_date;
		this.last_updated_by = last_updated_by;
		this.last_update_date = last_update_date;
	}

	public Integer getEntity_object_id() {
		return entity_object_id;
	}

	public void setEntity_object_id(Integer entity_object_id) {
		this.entity_object_id = entity_object_id;
	}

	public String getEntity_object_name() {
		return entity_object_name;
	}

	public void setEntity_object_name(String entity_object_name) {
		this.entity_object_name = entity_object_name;
	}

	public String getEntity_table_name() {
		return entity_table_name;
	}

	public void setEntity_table_name(String entity_table_name) {
		this.entity_table_name = entity_table_name;
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

	@Override
	public String toString() {
		return "entityObjectsEntity [entity_object_id=" + entity_object_id + ", entity_object_name="
				+ entity_object_name + ", entity_table_name=" + entity_table_name + ", created_by=" + created_by
				+ ", creation_date=" + creation_date + ", last_updated_by=" + last_updated_by + ", last_update_date="
				+ last_update_date + "]";
	}
	
}
