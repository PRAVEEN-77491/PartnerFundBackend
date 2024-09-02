package com.PartnersFunds.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ManageWorkflowTransitionsDTO {

	@JsonProperty("transitionId")
	private Integer p_transition_id;
	
	@JsonProperty("activityId")
	private String p_activity_id;
	
	@JsonProperty("transitionActivityId")
	private String p_transition_activity_id;
	
	@JsonProperty("outcomeValue")
	private String p_outcome_value;
	
	@JsonProperty("userId")
	private String p_user_id;

	public Integer getP_transition_id() {
		return p_transition_id;
	}

	public void setP_transition_id(Integer p_transition_id) {
		this.p_transition_id = p_transition_id;
	}

	public String getP_activity_id() {
		return p_activity_id;
	}

	public void setP_activity_id(String p_activity_id) {
		this.p_activity_id = p_activity_id;
	}

	public String getP_transition_activity_id() {
		return p_transition_activity_id;
	}

	public void setP_transition_activity_id(String p_transition_activity_id) {
		this.p_transition_activity_id = p_transition_activity_id;
	}

	public String getP_outcome_value() {
		return p_outcome_value;
	}

	public void setP_outcome_value(String p_outcome_value) {
		this.p_outcome_value = p_outcome_value;
	}

	public String getP_user_id() {
		return p_user_id;
	}

	public void setP_user_id(String p_user_id) {
		this.p_user_id = p_user_id;
	}
	
	
	
}
