package com.javacode.bestbuy.service;

import com.javacode.bestbuy.models.SubCategory;
import com.javacode.bestbuy.repository.SubCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCatService {

    @Autowired
    SubCategoryRepo subCategoryRepo;

    public List<SubCategory> getAll(){
        return subCategoryRepo.findAll();
    }

    public SubCategory save(SubCategory subcategory) {
        return subCategoryRepo.save(subcategory);
    }
}
