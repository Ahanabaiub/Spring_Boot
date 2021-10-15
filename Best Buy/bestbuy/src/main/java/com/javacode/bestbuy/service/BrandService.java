package com.javacode.bestbuy.service;

import com.javacode.bestbuy.models.Brand;
import com.javacode.bestbuy.repository.BrandRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
    @Autowired
    private BrandRepo brandRepo;


    public List<Brand> getAllBrand(){
        return brandRepo.findAll();
    }
}
