package com.PartnersFunds.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ManagePageFeaturesDTO {

	@JsonProperty("featureId")
	private Integer p_feature_id;
	
	@JsonProperty("pageId")
	private Integer p_page_id;
		
	@JsonProperty("featureName")
	private Integer p_feature_name;
	
	@JsonProperty("userId")
	private Integer p_user_id;

	public Integer getP_feature_id() {
		return p_feature_id;
	}

	public void setP_feature_id(Integer p_feature_id) {
		this.p_feature_id = p_feature_id;
	}

	public Integer getP_page_id() {
		return p_page_id;
	}

	public void setP_page_id(Integer p_page_id) {
		this.p_page_id = p_page_id;
	}

	public Integer getP_feature_name() {
		return p_feature_name;
	}

	public void setP_feature_name(Integer p_feature_name) {
		this.p_feature_name = p_feature_name;
	}

	public Integer getP_user_id() {
		return p_user_id;
	}

	public void setP_user_id(Integer p_user_id) {
		this.p_user_id = p_user_id;
	}
	
	
}
