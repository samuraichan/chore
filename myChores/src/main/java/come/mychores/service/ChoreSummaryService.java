package come.mychores.service;

import com.mychores.model.ChoreEntrySummary;
import com.mychores.model.pagination.PageableRequest;
import com.mychores.model.pagination.PageableResponse;

public interface ChoreSummaryService {

  public PageableResponse<ChoreEntrySummary> findDataTablesOutput(PageableRequest request);
}
