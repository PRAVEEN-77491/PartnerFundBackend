package com.PartnersFunds.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ManageFundBpaRbacRolesDTO {

    @JsonProperty("rbacRoleId")
    private Integer rbacRoleId;

    @JsonProperty("fundBpaId")
    private Integer fundBpaId;

    @JsonProperty("roleId")
    private Integer roleId;

    @JsonProperty("userId")
    private Integer userId;

    @JsonProperty("status")
    private String status;

    @JsonProperty("message")
    private String message;

    // Getters and Setters
    public Integer getRbacRoleId() {
        return rbacRoleId;
    }

    public void setRbacRoleId(Integer rbacRoleId) {
        this.rbacRoleId = rbacRoleId;
    }

    public Integer getFundBpaId() {
        return fundBpaId;
    }

    public void setFundBpaId(Integer fundBpaId) {
        this.fundBpaId = fundBpaId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
