package com.mychores.model.form;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mychores.propertyeditors.CustomDateDeserializer;

public class ChoreEntry {

  @JsonDeserialize(using=CustomDateDeserializer.class)
  @NotNull
  private Date start;
  
  @NotNull
  private BigDecimal amount;
  
  @NotNull
  private Integer category;
  
  @NotNull
  private Integer status;
  
  private boolean notification;
  
  private String memo;

  public Date getStart() {
    return start;
  }

  public void setStart(Date start) {
    this.start = start;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public Integer getCategory() {
    return category;
  }

  public void setCategory(Integer category) {
    this.category = category;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public boolean isNotification() {
    return notification;
  }

  public void setNotification(boolean notification) {
    this.notification = notification;
  }

  public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  } 
}
