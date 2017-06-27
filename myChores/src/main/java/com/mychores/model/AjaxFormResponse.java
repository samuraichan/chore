package com.mychores.model;

import java.util.ArrayList;
import java.util.Collection;

public class AjaxFormResponse {

  private String type;
  
  private Collection<AjaxFieldError> fieldErrors;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Collection<AjaxFieldError> getFieldErrors() {
    return fieldErrors;
  }

  public void addErrorMessage(String field, String message) {
    if (fieldErrors == null) {
      fieldErrors = new ArrayList<AjaxFieldError>();
    }
    fieldErrors.add(new AjaxFieldError(field, message));
  }
}
