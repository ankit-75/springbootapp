package com.example.demo.repository;

import com.example.demo.model.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
   // @EntityGraph( type = EntityGraph.EntityGraphType.FETCH, value = "company_entity_graph")
    @EntityGraph( type = EntityGraph.EntityGraphType.FETCH, attributePaths = "employees")
    List<Company> findAll();

    @EntityGraph( type = EntityGraph.EntityGraphType.FETCH, attributePaths = "employees")
    Page<Company> findAll(Pageable pageable);

    @EntityGraph( type = EntityGraph.EntityGraphType.FETCH, attributePaths = "employees")
    List<Company> findAll(Sort sort);


}
