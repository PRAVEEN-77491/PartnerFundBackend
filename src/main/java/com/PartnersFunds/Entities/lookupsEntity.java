package com.PartnersFunds.Entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="lookups")
public class lookupsEntity {

	@Id
	@Column(name="lookup_type")
	private String lookup_type;
	
	@Column(name="lookup_code")
	private String lookup_code;
	
	@Column(name="meaning")
	private String meaning;
	
	@Column(name="enabled_flag")
	private String enabled_flag;
	
	@Column(name = "created_by")
	private  String created_by;
	
	@Column(name = "creation_date")
	private Date creation_date;
	
	@Column(name = "last_updated_by")
	private String last_updated_by;
	
	@Column(name = "last_update_date")
	private Date last_update_date;

	public lookupsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public lookupsEntity(String lookup_type, String lookup_code, String meaning, String enabled_flag, String created_by,
			Date creation_date, String last_updated_by, Date last_update_date) {
		super();
		this.lookup_type = lookup_type;
		this.lookup_code = lookup_code;
		this.meaning = meaning;
		this.enabled_flag = enabled_flag;
		this.created_by = created_by;
		this.creation_date = creation_date;
		this.last_updated_by = last_updated_by;
		this.last_update_date = last_update_date;
	}

	public String getLookup_type() {
		return lookup_type;
	}

	public void setLookup_type(String lookup_type) {
		this.lookup_type = lookup_type;
	}

	public String getLookup_code() {
		return lookup_code;
	}

	public void setLookup_code(String lookup_code) {
		this.lookup_code = lookup_code;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public String getEnabled_flag() {
		return enabled_flag;
	}

	public void setEnabled_flag(String enabled_flag) {
		this.enabled_flag = enabled_flag;
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
