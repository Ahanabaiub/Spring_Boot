package com.javacode.bestbuy.service;

import com.javacode.bestbuy.models.SubSubCategory;
import com.javacode.bestbuy.repository.SubSubCatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubSubCatService {

    @Autowired
    private SubSubCatRepo subSubCatRepo;

    public List<SubSubCategory> getAllSubSubCat(){
        return subSubCatRepo.findAll();

    }

    public SubSubCategory save(SubSubCategory subSubCategory){
        return subSubCatRepo.save(subSubCategory);
    }
}
