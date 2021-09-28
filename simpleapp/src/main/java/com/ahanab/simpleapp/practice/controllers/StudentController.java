package com.ahanab.simpleapp.practice.controllers;

import com.ahanab.simpleapp.practice.models.Book;
import com.ahanab.simpleapp.practice.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Controller
public class StudentController {

    @GetMapping("/student")
    public String studentForm(Model model){

        model.addAttribute("student", new Student());
        List <Book> books = Arrays.asList(
                new Book("Physics1","a.k khan"),
                new Book("Math1","Obaidul karim"),
                new Book("Java Core","Bazlur Rahman")
        );

       model.addAttribute("books",books);

        return "studentForm";
    }

    @PostMapping("/student")
    public String processForm(@ModelAttribute Student student, Model model){
//        for (String s: student.getCourses()
//             ) {
//            System.out.println(s);
//
//        }

        System.out.println(student);
        model.addAttribute("student",student);
        return "showResult";
    }
}
