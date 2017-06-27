package com.mychores.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mychores.model.AjaxFormResponse;
import com.mychores.model.ChoreEntrySummary;
import com.mychores.model.form.ChoreEntry;
import com.mychores.model.pagination.PageableRequest;
import com.mychores.model.pagination.PageableResponse;
import com.mychores.repository.jpa.CategoryRepository;
import com.mychores.repository.jpa.StatusRepository;

import come.mychores.service.ChoreSummaryService;

@Controller
public class ChoreSummaryController {
  
  @Autowired
  private CategoryRepository categoryRepository;
  
  @Autowired
  private StatusRepository statusRepository;
  
  @Autowired
  private ChoreSummaryService service;
  
  @RequestMapping(value = "/chores", method = RequestMethod.GET)
  public String get(Model model) {
    model.addAttribute("categories", categoryRepository.findAllIdAndNames());
    model.addAttribute("statuses", statusRepository.findAllIdAndNames());
    return "choreSummary";
  }
  
  @ResponseBody
  @RequestMapping(value = "/summary", method = RequestMethod.POST)
  public PageableResponse<ChoreEntrySummary> findPagination(PageableRequest request, BindingResult bindingResult) {
    return service.findDataTablesOutput(request);
  }
  
  @ResponseBody
  @RequestMapping(value = "/chore/add", method = RequestMethod.POST, headers="Accept=application/json")
  public AjaxFormResponse getSearchResultViaAjax(@RequestBody @Valid ChoreEntry form, BindingResult result) {

    AjaxFormResponse response = new AjaxFormResponse();
    if (result.hasErrors()) {
      response.setType("error");
      for (FieldError fieldError: result.getFieldErrors()) {
        response.addErrorMessage(fieldError.getField(), fieldError.getDefaultMessage());
      }
    }
    return response;
  }
}
