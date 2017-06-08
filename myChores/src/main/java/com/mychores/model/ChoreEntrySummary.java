package com.mychores.model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChoreEntrySummary {

  private Integer id;
  
  private String category;
  
  private Date choreDate;
  
  private BigDecimal amount;
  
  private String memo;
  
  private boolean notified;
  
  private boolean paid;
  
  private Integer version;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public Date getChoreDate() {
    return choreDate;
  }
  
  public String getChoreDateDisplay() {
    SimpleDateFormat format1 = new SimpleDateFormat("dd MMM yyyy");
    return format1.format(choreDate);
  }

  public void setChoreDate(Date choreDate) {
    this.choreDate = choreDate;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }

  public boolean isNotified() {
    return notified;
  }

  public void setNotified(boolean notified) {
    this.notified = notified;
  }

  public boolean isPaid() {
    return paid;
  }

  public void setPaid(boolean paid) {
    this.paid = paid;
  }

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }
}