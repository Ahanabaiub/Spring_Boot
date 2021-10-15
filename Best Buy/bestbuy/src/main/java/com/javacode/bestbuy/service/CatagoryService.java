package com.javacode.bestbuy.service;

import com.javacode.bestbuy.models.Category;
import com.javacode.bestbuy.repository.CatagoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatagoryService {

    @Autowired
    CatagoryRepo catagoryRepo;

    public List<Category> getall(){
        return catagoryRepo.findAll();
    }


    public Category save(Category category) {
        return catagoryRepo.save(category);
    }
}
