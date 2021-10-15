package com.javacode.bestbuy.repository;

import com.javacode.bestbuy.models.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubCategoryRepo extends JpaRepository<SubCategory,Long> {
}
