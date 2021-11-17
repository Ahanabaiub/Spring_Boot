package com.javacode.bestbuy.controller;

import com.javacode.bestbuy.models.Category;
import com.javacode.bestbuy.service.CatagoryService;
import com.javacode.bestbuy.service.SubCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CatagoryService catagoryService;

    @Autowired
    SubCatService subCatService;



    @GetMapping("/")
    public String home(Model model){

        model.addAttribute("categories",catagoryService.getall());
        model.addAttribute("subCategories",subCatService.getAll());
        //model.addAttribute("userName",principal.getName());

//        Object pnc = SecurityContextHolder.getContext().getAuthentication()
//                .getPrincipal();

//        if(pnc instanceof UserDetails){
//            String username = ((UserDetails)pnc).getUsername();
//            String pass = ((UserDetails)pnc).getPassword();
//            Collection<? extends GrantedAuthority> authorities = ((UserDetails) pnc).getAuthorities();
//            System.out.println("1 "+username);
//            System.out.println("1 "+pass);
//            System.out.println("1 "+authorities);
//        } else {
//            String username = pnc.toString();
//            System.out.println("2 "+username);
//        }

        return "homePage";
    }
}
