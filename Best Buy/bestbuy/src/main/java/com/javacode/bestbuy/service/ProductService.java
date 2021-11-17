package com.javacode.bestbuy.service;

import com.javacode.bestbuy.models.Product;
import com.javacode.bestbuy.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public List<Product> findAll(){
        return productRepo.findAll();
    }

    public List<Product> findByCatIdAndSubCatId(Long catId, Long subCatId){

        return productRepo.getProductsFromDb(catId,subCatId);

    }

    public Product findProductById(Long id){
        return productRepo.findProductById(id);
    }


    public Product save(Product product){
        return productRepo.save(product);
    }
    public void delete(Long id){
         productRepo.deleteById(id);
    }
}
