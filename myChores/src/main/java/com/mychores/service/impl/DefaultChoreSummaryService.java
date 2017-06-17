package com.mychores.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mychores.model.ChoreEntrySummary;
import com.mychores.model.pagination.PageableRequest;
import com.mychores.model.pagination.PageableResponse;
import com.mychores.repository.mapper.ChoreEntryMapper;
import come.mychores.service.ChoreSummaryService;

@Service
public class DefaultChoreSummaryService implements ChoreSummaryService {
  
  @Autowired
  private ChoreEntryMapper mapper;

  @Override
  public PageableResponse<ChoreEntrySummary> findDataTablesOutput(PageableRequest request) {
    PageableResponse<ChoreEntrySummary> response = mapper.findDataTablesOutput(request);
    if (response == null) {
      response = new PageableResponse<ChoreEntrySummary>();
      response.setRecordsTotal(mapper.findRecordCount(request));
    }
    return response;
  }
}
