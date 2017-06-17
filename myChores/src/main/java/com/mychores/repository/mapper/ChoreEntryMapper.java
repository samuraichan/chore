package com.mychores.repository.mapper;

import com.mychores.model.ChoreEntrySummary;
import com.mychores.model.pagination.PageableRequest;
import com.mychores.repository.PagingRepository;

public interface ChoreEntryMapper extends PagingRepository<ChoreEntrySummary> {

  public Integer findRecordCount(PageableRequest request);
}
