package com.javacode.bestbuy.repository;

import com.javacode.bestbuy.models.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecificationRepo extends JpaRepository<Specification,Long> {

}
