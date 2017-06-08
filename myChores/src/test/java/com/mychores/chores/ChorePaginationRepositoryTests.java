package com.mychores.chores;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.mychores.repository.mapper.ChoreEntryMapper;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class ChorePaginationRepositoryTests {

  @Autowired
  private ChoreEntryMapper mapper;
  
  @Test
  public void testMe() {
    assertThat(mapper).isNotNull();
    
    assertThat(mapper.findDataTablesOutput(null)).isNotNull();
  }
}
