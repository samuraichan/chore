package com.mychores.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.envers.AuditOverride;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mychores.propertyeditors.CustomDateDeserializer;

@Entity
@Table(name = "chore_entry")
@AuditOverride(forClass = BaseEntity.class, isAudited = true)
public class ChoreEntry extends BaseEntity {

  @NotNull
  private Integer category;
  
  @NotNull
  private Integer status;
  
  @NotNull
  private BigDecimal amount;
  
  private String memo;
  
  @JsonDeserialize(using=CustomDateDeserializer.class)
  @NotNull
  @Column(name="chore_date")
  @Temporal(TemporalType.TIMESTAMP)
  private Date choreDate;

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

  public Date getChoreDate() {
    return choreDate;
  }

  public void setChoreDate(Date choreDate) {
    this.choreDate = choreDate;
  }
}
