package com.mychores.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Status {
  
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  protected Integer id;
  
  private String name;
  
  public Status() {}
  
  public Status(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
