package com.mychores.model;

public class IdAndName {

  private Integer id;
  
  private String name;
  
  public IdAndName() {}
  
  public IdAndName(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
