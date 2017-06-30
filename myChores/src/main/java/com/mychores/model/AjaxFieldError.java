package com.mychores.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AjaxFieldError {

  private Map<String, List<String>> errors;
  
  private Map<String, Object> properties;

  public Map<String, List<String>> getErrors() {
    return errors;
  }

  public void addError(String field, String message) {
    if (errors == null) errors = new LinkedHashMap<String, List<String>>();
    if (errors.get(field) == null) errors.put(field, new ArrayList<String>());
    errors.get(field).add(message);
  }

  public Map<String, Object> getProperties() {
    return properties;
  }

  public void setProperties(Map<String, Object> properties) {
    this.properties = properties;
  }
}
