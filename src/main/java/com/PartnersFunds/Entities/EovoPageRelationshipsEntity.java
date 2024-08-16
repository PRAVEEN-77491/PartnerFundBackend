package com.PartnersFunds.Entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="eo_vo_page_relationships")
public class EovoPageRelationshipsEntity {

	@Id
	@Column(name="relationship_id")
	private Integer relationship_id;
	
	@Column(name="object_type")
	private String object_type;
	
	@Column(name="object_id")
	private Integer object_id;
	
	@Column(name="page_id")
	private Integer page_id;
	
	@Column(name = "created_by")
	private  String created_by;
	
	@Column(name = "creation_date")
	private Date creation_date;
	
	@Column(name = "last_updated_by")
	private String last_updated_by;
	
	@Column(name = "last_update_date")
	private Date last_update_date;

	public EovoPageRelationshipsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EovoPageRelationshipsEntity(Integer relationship_id, String object_type, Integer object_id, Integer page_id,
			String created_by, Date creation_date, String last_updated_by, Date last_update_date) {
		super();
		this.relationship_id = relationship_id;
		this.object_type = object_type;
		this.object_id = object_id;
		this.page_id = page_id;
		this.created_by = created_by;
		this.creation_date = creation_date;
		this.last_updated_by = last_updated_by;
		this.last_update_date = last_update_date;
	}

	public Integer getRelationship_id() {
		return relationship_id;
	}

	public void setRelationship_id(Integer relationship_id) {
		this.relationship_id = relationship_id;
	}

	public String getObject_type() {
		return object_type;
	}

	public void setObject_type(String object_type) {
		this.object_type = object_type;
	}

	public Integer getObject_id() {
		return object_id;
	}

	public void setObject_id(Integer object_id) {
		this.object_id = object_id;
	}

	public Integer getPage_id() {
		return page_id;
	}

	public void setPage_id(Integer page_id) {
		this.page_id = page_id;
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
