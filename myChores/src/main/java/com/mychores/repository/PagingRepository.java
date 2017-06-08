package com.mychores.repository;

import com.mychores.model.pagination.PageableRequest;
import com.mychores.model.pagination.PageableResponse;

public interface PagingRepository<T> {

  public PageableResponse<T> findDataTablesOutput(PageableRequest request);
}
