package com.PartnersFunds.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserCredentialsDTO {

    @JsonProperty("ciscoCecId")
    private String ciscoCecId;

    @JsonProperty("password")
    private String password;

	public String getCiscoCecId() {
		return ciscoCecId;
	}

	public void setCiscoCecId(String ciscoCecId) {
		this.ciscoCecId = ciscoCecId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserCredentialsDTO [username=" + ciscoCecId + ", password=" + password + "]";
	}
	
}
