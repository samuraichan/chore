package com.mychores.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mychores.model.ChoreEntrySummary;
import com.mychores.model.pagination.PageableRequest;
import com.mychores.model.pagination.PageableResponse;
import com.mychores.repository.jpa.CategoryRepository;
import come.mychores.service.ChoreSummaryService;

@Controller
public class ChoreSummaryController {
  
  @Autowired
  private CategoryRepository categoryRepository;
  
  @Autowired
  private ChoreSummaryService service;

  @RequestMapping(value = "/chores", method = RequestMethod.GET)
  public String get(Model model) {
    model.addAttribute("categories", categoryRepository.findAllIdAndNames());
    return "choreSummary";
  }
  
  @ResponseBody
  @RequestMapping(value = "/summary", method = RequestMethod.POST)
  public PageableResponse<ChoreEntrySummary> findPagination(PageableRequest request, BindingResult bindingResult) {
    return service.findDataTablesOutput(request);
  }
}
