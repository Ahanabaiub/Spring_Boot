package com.javacode.bestbuy.repository;

import com.javacode.bestbuy.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatagoryRepo extends JpaRepository<Category,Long> {
}
