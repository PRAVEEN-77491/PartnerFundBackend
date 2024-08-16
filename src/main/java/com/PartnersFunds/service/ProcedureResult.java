package com.PartnersFunds.service;

public class ProcedureResult {
   private String status;
   private String message;

   public ProcedureResult(String status, String message) {
      this.status = status;
      this.message = message;
   }

   public String getStatus() {
      return this.status;
   }

   public String getMessage() {
      return this.message;
   }

   public ProcedureResult() {
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public void setMessage(String message) {
      this.message = message;
   }
}
