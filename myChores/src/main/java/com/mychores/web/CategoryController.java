package com.mychores.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mychores.model.IdAndName;
import com.mychores.repository.jpa.CategoryRepository;

@Controller
public class CategoryController {

  @Autowired
  private CategoryRepository categoryRepository;
  
  @RequestMapping(value = "/api/categories", method = RequestMethod.GET, produces = "application/json")
  @ResponseBody 
  public Iterable<IdAndName> getAllCategories(Object model) {
    return categoryRepository.findAllIdAndNames();
  }
}
