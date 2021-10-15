package com.javacode.bestbuy.repository;

import com.javacode.bestbuy.models.SpecificatioDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecificationDetailsRepo extends JpaRepository<SpecificatioDetails,Long> {

    List<SpecificatioDetails> findSpecificatioDetailsByProductId(Long id);
}
