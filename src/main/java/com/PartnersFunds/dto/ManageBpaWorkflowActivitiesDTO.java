package com.partnersFunds.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ManageBpaWorkflowActivitiesDTO {

	    @JsonProperty("activityId")
	    private Integer p_activity_id;

	    @JsonProperty("sequence")
	    private Integer p_sequence;

	    @JsonProperty("fundBpaId")
	    private Integer p_fund_bpa_id;

	    @JsonProperty("activityLabel")
	    private String p_activity_label;

	    @JsonProperty("activityType")
	    private String p_activity_type;

	    @JsonProperty("processFunc")
	    private String p_process_func;

	    @JsonProperty("notifSubject")
	    private String p_notif_subject;

	    @JsonProperty("notifBody")
	    private String p_notif_body;

	    @JsonProperty("approvalLevel")
	    private String p_approval_level;

	    @JsonProperty("approvers")
	    private String p_approvers;

	    @JsonProperty("userId")
	    private Integer p_user_id;

		public Integer getP_activity_id() {
			return p_activity_id;
		}

		public void setP_activity_id(Integer p_activity_id) {
			this.p_activity_id = p_activity_id;
		}

		public Integer getP_sequence() {
			return p_sequence;
		}

		public void setP_sequence(Integer p_sequence) {
			this.p_sequence = p_sequence;
		}

		public Integer getP_fund_bpa_id() {
			return p_fund_bpa_id;
		}

		public void setP_fund_bpa_id(Integer p_fund_bpa_id) {
			this.p_fund_bpa_id = p_fund_bpa_id;
		}

		public String getP_activity_label() {
			return p_activity_label;
		}

		public void setP_activity_label(String p_activity_label) {
			this.p_activity_label = p_activity_label;
		}

		public String getP_activity_type() {
			return p_activity_type;
		}

		public void setP_activity_type(String p_activity_type) {
			this.p_activity_type = p_activity_type;
		}

		public String getP_process_func() {
			return p_process_func;
		}

		public void setP_process_func(String p_process_func) {
			this.p_process_func = p_process_func;
		}

		public String getP_notif_subject() {
			return p_notif_subject;
		}

		public void setP_notif_subject(String p_notif_subject) {
			this.p_notif_subject = p_notif_subject;
		}

		public String getP_notif_body() {
			return p_notif_body;
		}

		public void setP_notif_body(String p_notif_body) {
			this.p_notif_body = p_notif_body;
		}

		public String getP_approval_level() {
			return p_approval_level;
		}

		public void setP_approval_level(String p_approval_level) {
			this.p_approval_level = p_approval_level;
		}

		public String getP_approvers() {
			return p_approvers;
		}

		public void setP_approvers(String p_approvers) {
			this.p_approvers = p_approvers;
		}

		public Integer getP_user_id() {
			return p_user_id;
		}

		public void setP_user_id(Integer p_user_id) {
			this.p_user_id = p_user_id;
		}
	    
}
