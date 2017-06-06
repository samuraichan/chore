package com.mychores.entity.listener;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.mychores.entity.BaseEntity;

public class BaseEntityListener {

  @PrePersist
  public void setPrePersistance(BaseEntity baseEntity) {
    baseEntity.setCreatedDate(new Date());
    baseEntity.setActiveFlag(true);
  }
  
  @PreUpdate
  public void setUpdatedDate(BaseEntity baseEntity) {
    baseEntity.setUpdatedDate(new Date());
  }
}
