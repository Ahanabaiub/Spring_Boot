package com.javaApps.springDataJpa;

import com.javaApps.springDataJpa.domain.Book;
import com.javaApps.springDataJpa.repository.BookRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
    BookRepo repo;

    public BookController(BookRepo repo) {
        this.repo = repo;
    }

    @GetMapping("/addbook")
    public String addBook(){
        Book book = new Book();
        book.setAuthor("A.N.M kjahsdk");
        book.setTitle("Java");
        book.setId(1);
        repo.save(book);

        return "book";
    }
}
