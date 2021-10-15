package com.javacode.bestbuy.repository;

import com.javacode.bestbuy.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Long> {

    @Query("select p from Product p where p.category.id = :catId and  p.subCategory.id = :subCatId")
    List<Product> getProductsFromDb(@Param("catId") Long catId,@Param("subCatId") Long subCatId);

    Product findProductById(Long id);

}
