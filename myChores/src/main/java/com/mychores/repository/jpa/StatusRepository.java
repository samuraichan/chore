package com.mychores.repository.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mychores.entity.Status;
import com.mychores.model.IdAndName;

public interface StatusRepository extends CrudRepository<Status, Integer> {

  @Query("select new com.mychores.model.IdAndName(st.id, st.name) from Status st order by st.id")
  public Iterable<IdAndName> findAllIdAndNames();
}
