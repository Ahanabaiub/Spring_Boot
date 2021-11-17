package com.javacode.bestbuy.controller;

import com.javacode.bestbuy.models.Product;
import com.javacode.bestbuy.models.SpecificatioDetails;
import com.javacode.bestbuy.models.Specification;
import com.javacode.bestbuy.service.CatagoryService;
import com.javacode.bestbuy.service.ProductService;
import com.javacode.bestbuy.service.SpecificationDetailsService;
import com.javacode.bestbuy.service.SubCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    CatagoryService catagoryService;

    @Autowired
    SubCatService subCatService;

    @Autowired
    private SpecificationDetailsService specificationDetailsService;

    @GetMapping
    public String getAll(Model model){
        List<Product> products =  productService.findAll();

        model.addAttribute("products",products);
        model.addAttribute("categories",catagoryService.getall());
        model.addAttribute("subCategories",subCatService.getAll());

//        for(Product p : products){
//            System.out.println(p);
//        }

        return "viewProducts";
    }

    @GetMapping("/{catid}/{subcatid}")
    public String getSubProducts(@PathVariable("catid")Long catid
            ,@PathVariable("subcatid")Long subcatid , Model model){
       // System.out.println(catid+"   "+subcatid);
        List<Product> products = productService.findByCatIdAndSubCatId(catid,subcatid);

        model.addAttribute("categories",catagoryService.getall());
        model.addAttribute("subCategories",subCatService.getAll());
        model.addAttribute("products",products);

        return "viewProducts";
    }

    @GetMapping("/details/{id}")
    public String productDetails(@PathVariable("id")Long id,Model model){

        Product product = productService.findProductById(id);
        model.addAttribute("product",product);

        Set<Specification> specifications = new TreeSet<>();

        for(SpecificatioDetails sd : product.getSpecificatioDetails()){
            specifications.add(sd.getSpecification());
        }


        model.addAttribute("categories",catagoryService.getall());
        model.addAttribute("subCategories",subCatService.getAll());


        model.addAttribute("specifications",specifications);

        return "viewProductDetails";
    }


}
