package com.mychores.model.pagination;

import java.util.Date;
import java.util.List;

public class PagingFilter {
 
  private Date start;
  
  private Date end;
  
  private List<Integer> statuses;

  public Date getStart() {
    return start;
  }

  public void setStart(Date start) {
    this.start = start;
  }

  public Date getEnd() {
    return end;
  }

  public void setEnd(Date end) {
    this.end = end;
  }

  public List<Integer> getStatuses() {
    return statuses;
  }

  public void setStatuses(List<Integer> statuses) {
    this.statuses = statuses;
  }
}