package com.javacode.bestbuy.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.javacode.bestbuy.DTO.ProductDto;
import com.javacode.bestbuy.models.Product;
import com.javacode.bestbuy.service.CatagoryService;
import com.javacode.bestbuy.service.ProductService;
import com.javacode.bestbuy.service.SubCatService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.converter.json.GsonFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/cart")
//@SessionAttributes("cart")
public class CartController {

    @Autowired
    private ProductService productService;

    @Autowired
    CatagoryService catagoryService;

    @Autowired
    SubCatService subCatService;


    private ModelMapper mapper = new ModelMapper();
    @GetMapping("/product/{id}")
    public String addToCart(@PathVariable("id") Long id, Model model,HttpSession session) throws IOException {

        Product product= productService.findProductById(id);
        ProductDto productDto = mapper.map(product,ProductDto.class);
        productDto.setQuantity(1);

        if(session.getAttribute("cart")!=null){

            //String json =(String) model.getAttribute("cart");
            String json =(String)session.getAttribute("cart");

           List<ProductDto> products = new ObjectMapper().readValue(json,
                    new TypeReference<>() {});


                    boolean flag=false;

                  for(ProductDto p : products){
                      if(p.getId().equals(productDto.getId())){
                          p.setQuantity(p.getQuantity()+1);
                          flag=true;
                          break;
                      }
                  }

              if(!flag){

                  products.add(productDto);
              }

           // model.addAttribute("cart",
                   // new ObjectMapper().writeValueAsString(products));

            session.setAttribute("cart",
                    new ObjectMapper().writeValueAsString(products));

            //System.out.println(" CraT : "+model.getAttribute("cart"));
        }
        else {

            List<ProductDto> products = Arrays.asList(productDto);
           // model.addAttribute("cart",new ObjectMapper().writeValueAsString(products));
            session.setAttribute("cart",new ObjectMapper().writeValueAsString(products));
            //model.addAttribute("cart",products);
            //System.out.println("My Cart : "+model.getAttribute("cart"));
        }


         return "redirect:/product";
        //return (String)session.getAttribute("cart");
    }

    @GetMapping("/view-cart")
    public String viewCart(Model model,HttpSession session) throws JsonProcessingException {
        String json = (String)session.getAttribute("cart");
        List<ProductDto> products = new ArrayList<>();
       if(json!=null){
            products = new ObjectMapper().readValue(json,
                   new TypeReference<>() {
                   });

       }
        model.addAttribute("productDtos",products);
        model.addAttribute("categories",catagoryService.getall());
        model.addAttribute("subCategories",subCatService.getAll());


        return "viewCart";
    }
}
