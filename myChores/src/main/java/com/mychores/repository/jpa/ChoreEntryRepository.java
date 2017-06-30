package com.mychores.repository.jpa;

import org.springframework.data.repository.CrudRepository;

import com.mychores.entity.ChoreEntry;

public interface ChoreEntryRepository extends CrudRepository<ChoreEntry, Integer> {

}
