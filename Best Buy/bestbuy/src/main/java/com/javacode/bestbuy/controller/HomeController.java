package com.javacode.bestbuy.controller;

import com.javacode.bestbuy.models.Category;
import com.javacode.bestbuy.service.CatagoryService;
import com.javacode.bestbuy.service.SubCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CatagoryService catagoryService;

    @Autowired
    SubCatService subCatService;

    @GetMapping("/home")
    public String home(Model model){

        model.addAttribute("categories",catagoryService.getall());
        model.addAttribute("subCategories",subCatService.getAll());
        return "homePage";
    }
}
