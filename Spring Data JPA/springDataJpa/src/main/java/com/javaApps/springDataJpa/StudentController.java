package com.javaApps.springDataJpa;

import com.javaApps.springDataJpa.domain.Book;
import com.javaApps.springDataJpa.domain.Student;
import com.javaApps.springDataJpa.service.BookService;
import com.javaApps.springDataJpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

    StudentService studentService;
    BookService bookService;

    public StudentController(StudentService studentService,BookService bookService) {
        this.studentService = studentService;
        this.bookService = bookService;
    }

    @GetMapping("/student")
    public String saveStudent(){

//        Book book =bookService.getBook((long) 1);
//
//        Student student =new Student();
//        student.setId(2);
//        student.setName("Anil Kumarhhh");
//        student.setRollNo(20);
//        student.setBook(book);
//
//        studentService.save(student);

        return "Saved";
    }
}
