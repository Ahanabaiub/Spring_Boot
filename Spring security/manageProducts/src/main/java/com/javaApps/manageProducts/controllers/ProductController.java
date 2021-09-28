package com.javaApps.manageProducts.controllers;

import com.javaApps.manageProducts.models.Product;
import com.javaApps.manageProducts.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/allProducts")
    public String getAll(Model model){
        List<Product> products = productService.getAll();
        model.addAttribute("products",products);
//        System.out.println(products.get(0).getName());
        return "allProducts";
    }
}
