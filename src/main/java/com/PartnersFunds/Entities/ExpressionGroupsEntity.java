package com.PartnersFunds.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "XXPF_EXPRESSIONS_GROUPS")
public class ExpressionGroupsEntity {

	 @Id
	   @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "XXPF_EXPRESSIONS_GROUPS_S")
	   @SequenceGenerator(name = "XXPF_EXPRESSIONS_GROUPS_S",sequenceName = "XXPF_EXPRESSIONS_GROUPS_S",allocationSize = 1)
	   @Column(name = "GROUP_ID")
	   private Integer GROUP_ID;
	 
	   @Column(name = "EXPRESSION_ID")
	   private Integer EXPRESSION_ID;
	   @Column(name = "GROUP_SEQUENCE")
	   private Integer GROUP_SEQUENCE;
	   @Column(name = "LOGICAL_OPERATOR")
	   private String LOGICAL_OPERATOR;
	   
		public ExpressionGroupsEntity() {
			super();
			// TODO Auto-generated constructor stub
		}

		public ExpressionGroupsEntity(Integer gROUP_ID, Integer eXPRESSION_ID, Integer gROUP_SEQUENCE,
				String lOGICAL_OPERATOR) {
			super();
			GROUP_ID = gROUP_ID;
			EXPRESSION_ID = eXPRESSION_ID;
			GROUP_SEQUENCE = gROUP_SEQUENCE;
			LOGICAL_OPERATOR = lOGICAL_OPERATOR;
		}

		public Integer getGROUP_ID() {
			return GROUP_ID;
		}

		public void setGROUP_ID(Integer gROUP_ID) {
			GROUP_ID = gROUP_ID;
		}

		public Integer getEXPRESSION_ID() {
			return EXPRESSION_ID;
		}

		public void setEXPRESSION_ID(Integer eXPRESSION_ID) {
			EXPRESSION_ID = eXPRESSION_ID;
		}

		public Integer getGROUP_SEQUENCE() {
			return GROUP_SEQUENCE;
		}

		public void setGROUP_SEQUENCE(Integer gROUP_SEQUENCE) {
			GROUP_SEQUENCE = gROUP_SEQUENCE;
		}

		public String getLOGICAL_OPERATOR() {
			return LOGICAL_OPERATOR;
		}

		public void setLOGICAL_OPERATOR(String lOGICAL_OPERATOR) {
			LOGICAL_OPERATOR = lOGICAL_OPERATOR;
		}
		
	 
}
