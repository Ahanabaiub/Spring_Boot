package com.javaApps.manageProducts.service;

import com.javaApps.manageProducts.models.Product;
import com.javaApps.manageProducts.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public List<Product> getAll(){

        return (List<Product>) productRepo.findAll();
    }

}
