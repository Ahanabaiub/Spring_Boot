package com.javacode.bestbuy.service;

import com.javacode.bestbuy.models.SpecificatioDetails;
import com.javacode.bestbuy.repository.SpecificationDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecificationDetailsService {

    @Autowired
    private SpecificationDetailsRepo specificationDetailsRepo;

    public SpecificatioDetails save(SpecificatioDetails specificatioDetails){
        return specificationDetailsRepo.save(specificatioDetails);
    }

    public List<SpecificatioDetails> findbyProductId(Long pid){

        return specificationDetailsRepo.findSpecificatioDetailsByProductId(pid);
    }
}
