package com.mychores.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

@Entity
@Table
@Where(clause="active_flag = 'Y'")
public class Category extends BaseEntity {
  
  private String name;
  
  public Category() {}
  
  public Category(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
