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
@Table(name="xxpf_view_objects")
public class ViewObjectsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "xxpf_view_objects_s")
    @SequenceGenerator(name = "xxpf_view_objects_s", sequenceName = "xxpf_view_objects_s", allocationSize = 1)
	@Column(name="view_object_id")
	private Integer view_object_id;
	
	@Column(name="view_object_name")
	private String view_object_name;
	
	@Column(name="view_object_sql_query")
	private String view_object_sql_query;
	
	@Column(name="event_type")
	private String event_type;
	
	@Column(name = "created_by")
	private  String created_by;
	
	@Column(name = "creation_date")
	private Date creation_date;
	
	@Column(name = "last_updated_by")
	private String last_updated_by;
	
	@Column(name = "last_update_date")
	private Date last_update_date;

	public ViewObjectsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ViewObjectsEntity(Integer view_object_id, String view_object_name, String view_object_sql_query, String event_type,
			String created_by, Date creation_date, String last_updated_by, Date last_update_date) {
		super();
		this.view_object_id = view_object_id;
		this.view_object_name = view_object_name;
		this.view_object_sql_query = view_object_sql_query;
		this.event_type = event_type;
		this.created_by = created_by;
		this.creation_date = creation_date;
		this.last_updated_by = last_updated_by;
		this.last_update_date = last_update_date;
	}

	public Integer getView_object_id() {
		return view_object_id;
	}

	public void setView_object_id(Integer view_object_id) {
		this.view_object_id = view_object_id;
	}

	public String getView_object_name() {
		return view_object_name;
	}

	public void setView_object_name(String view_object_name) {
		this.view_object_name = view_object_name;
	}

	public String getView_object_sql_query() {
		return view_object_sql_query;
	}

	public void setView_object_sql_query(String view_object_sql_query) {
		this.view_object_sql_query = view_object_sql_query;
	}

	public String getEvent_type() {
		return event_type;
	}

	public void setEvent_type(String event_type) {
		this.event_type = event_type;
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
