package com.javacode.bestbuy.controller;

import com.javacode.bestbuy.models.*;
import com.javacode.bestbuy.service.*;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductService productService;

    @Autowired
    CatagoryService catagoryService;

    @Autowired
    SubCatService subCatService;

    @Autowired
    private SubSubCatService subSubCatService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private SpecificationService specificationService;

    @Autowired
    private SpecificationDetailsService specificationDetailsService;


    @GetMapping
    public String home(Model model){

        model.addAttribute("categories",catagoryService.getall());
        model.addAttribute("subCategories",subCatService.getAll());


        return "Admin/adminHome";
    }

    @GetMapping("/addproduct")
    public String addProduct(Model model){
        model.addAttribute("product",new Product());
        //model.addAttribute("spDetails",new SpecificatioDetails());
        model.addAttribute("specifications",specificationService.getAll());

        model.addAttribute("categories",catagoryService.getall());
        model.addAttribute("subCategories",subCatService.getAll());
        model.addAttribute("subsubCategories", subSubCatService.getAllSubSubCat());
        model.addAttribute("brands", brandService.getAllBrand());

        return "Admin/createProduct";

    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product){
        System.out.println(product);
        productService.save(product);
        return "redirect:";

        //System.out.println(specificatioDetails.getTitle()+" "+specificatioDetails.getDetails());
        //return product;
    }


    ///////..........Specification............
    @GetMapping("/addspecification")
    public String addSpecificationDetails(Model model){
        model.addAttribute("specificationDetails", new SpecificatioDetails());
        model.addAttribute("products",productService.findAll());
        model.addAttribute("specifications",specificationService.getAll());
        return "Admin/addSpecificationDetails";
    }

    @PostMapping("/savespecification")
    public String saveSpecificationDetails(@ModelAttribute SpecificatioDetails specificatioDetails){

        //System.out.println(specificatioDetails);
        specificationDetailsService.save(specificatioDetails);

        return "redirect:/admin/addspecification";
    }


    //////.....Category.......
    @GetMapping("/addcategory")
    public String addCategory(Model model){
        model.addAttribute("category",new Category());

        model.addAttribute("categories",catagoryService.getall());
        model.addAttribute("subCategories",subCatService.getAll());

        return "Admin/createCategory";
    }

    @PostMapping("/saveCategory")
    public String saveCategory(@ModelAttribute Category category){

        //System.out.println(category);
        catagoryService.save(category);
        return "redirect:";

    }


    ///...........sub Category........
    @GetMapping("/addsubcategory")
    public String addSubCategory(Model model){
        model.addAttribute("subcategory",new SubCategory());

        model.addAttribute("categories",catagoryService.getall());
        model.addAttribute("subCategories",subCatService.getAll());

        return "Admin/createSubCat";
    }

    @PostMapping("/saveSubCategory")
    public String saveSubCategory(@ModelAttribute SubCategory subcategory){

        //System.out.println(subcategory);
        subCatService.save(subcategory);
        return "redirect:";

    }

    ////..........sub sub category........
    @GetMapping("/addsubsubcategory")
    public String addSubSubCategory(Model model){
        model.addAttribute("subsubcategory",new SubSubCategory());

        model.addAttribute("categories",catagoryService.getall());
        model.addAttribute("subCategories",subCatService.getAll());

        return "Admin/createSubSubCat";
    }

    @PostMapping("/saveSubSubCategory")
    public String saveSubSubCategory(@ModelAttribute SubSubCategory subsubcategory){

        subSubCatService.save(subsubcategory);
        return "redirect:";

    }




}
