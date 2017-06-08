package com.mychores.model.pagination;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.util.StringUtils;

public class PageableRequest {
  /**
   * Draw counter. This is used by DataTables to ensure that the Ajax returns
   * from server-side processing requests are drawn in sequence by DataTables
   * (Ajax requests are asynchronous and thus can return out of sequence). This
   * is used as part of the draw return parameter (see below).
   */
  private Integer draw;

  /**
   * Paging first record indicator. This is the start point in the current data
   * set (0 index based - i.e. 0 is the first record).
   */
  private Integer start;

  /**
   * Number of records that the table can display in the current draw. It is
   * expected that the number of records returned will be equal to this number,
   * unless the server has fewer records to return. Note that this can be -1 to
   * indicate that all records should be returned (although that negates any
   * benefits of server-side processing!)
   */
  private Integer length;
  
  private String search;
  
  private Collection<PagingOrder> order = new ArrayList<PagingOrder>();
  
  private PagingFilter searchFilter;
  
  public PageableRequest() {}
  
  public PageableRequest(Integer draw, Integer start, Integer length, String search, PagingFilter searchFilter) {
    this.draw = draw;
    this.start = start;
    this.length = length;
    this.search = search;
    this.searchFilter = searchFilter;
  }

  public Integer getDraw() {
    return draw;
  }

  public void setDraw(Integer draw) {
    this.draw = draw;
  }

  public Integer getStart() {
    return start;
  }

  public void setStart(Integer start) {
    this.start = start;
  }

  public Integer getLength() {
    return length;
  }

  public void setLength(Integer length) {
    this.length = length;
  }

  public PagingFilter getSearchFilter() {
    return searchFilter;
  }

  public void setSearchFilter(PagingFilter searchFilter) {
    this.searchFilter = searchFilter;
  }

  public String getSearch() {
    return search;
  }

  public void setSearch(String search) {
    this.search = search;
  }
  
  public Collection<PagingOrder> getOrder() {
    return order;
  }

  public void setOrder(Collection<PagingOrder> order) {
    this.order = order;
  }
}