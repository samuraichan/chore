package com.mychores.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import com.mychores.repository.CategoryRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class CategoryRepositoryTests {

  @Autowired
  private CategoryRepository repository;
  
  @Test
  public void testFindAll() {
    assertThat(repository.findAll()).isNotEmpty();
  }
  
  @Test
  public void testInsertAndRemoval() {
    long size = repository.count();
    assertThat(repository.save(new Category("example")));
    assertThat(repository.count()).isEqualTo(size+1);
    
    Category category = repository.findByName("example");
    assertThat(category).isNotNull();
    
    category.setActiveFlag(false);
    repository.save(category);
    assertThat(repository.findByName("example")).isNull();
  }
  
  @Test
  public void testUniqueConstraintViolation() {
    assertThat(repository.save(new Category("dude")));
    
    assertThatThrownBy(() -> { repository.save(new Category("dude")); }).isInstanceOf(DataIntegrityViolationException.class)
    .hasMessageContaining("could not execute statement");
  }
}
