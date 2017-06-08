package com.mychores.model.pagination;

public class PagingOrder {
  
  private Integer column;
  
  private String dir;
  
  public Integer getColumn() {
    return column;
  }

  public void setColumn(Integer column) {
    this.column = column;
  }

  public String getDir() {
    return dir;
  }

  public void setDir(String dir) {
    this.dir = dir;
  }

}
