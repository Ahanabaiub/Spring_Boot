package com.javacode.bestbuy.repository;

import com.javacode.bestbuy.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepo extends JpaRepository<Brand,Long> {
}
