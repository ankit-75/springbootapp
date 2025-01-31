package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAll();

  //  @Query("select e from employee e where e.name= ?1")
    List<Employee> findByName(String name);

    @EntityGraph( type = EntityGraph.EntityGraphType.FETCH, attributePaths = "company")
    List<Employee> findByCompanyNameIsLike(String name);

}
