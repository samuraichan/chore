package com.mychores.repository.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mychores.entity.Category;
import com.mychores.model.IdAndName;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

  public Category findByName(String name);
  
  @Query("select new com.mychores.model.IdAndName(ca.id, ca.name) from Category ca")
  public Iterable<IdAndName> findAllIdAndNames();
}
