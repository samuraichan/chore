package com.mychores.model;

public class AjaxFieldError {

  private String field;
  
  private String message;
  
  public AjaxFieldError(String field, String message) {
    this.field = field;
    this.message = message;
  }

  public String getField() {
    return field;
  }

  public String getMessage() {
    return message;
  }
}
