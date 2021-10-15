package com.javacode.bestbuy.service;


import com.javacode.bestbuy.models.Specification;
import com.javacode.bestbuy.repository.SpecificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecificationService {

    @Autowired
    private SpecificationRepo specificationRepo;

    public List<Specification> getAll(){
        return specificationRepo.findAll();
    }

    public Specification save(Specification specification){
        return specificationRepo.save(specification);
    }
}
