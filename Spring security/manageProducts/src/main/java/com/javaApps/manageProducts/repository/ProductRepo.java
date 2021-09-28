package com.javaApps.manageProducts.repository;

import com.javaApps.manageProducts.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends CrudRepository<Product,Long> {
}
