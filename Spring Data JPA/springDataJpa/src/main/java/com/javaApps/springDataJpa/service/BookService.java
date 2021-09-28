package com.javaApps.springDataJpa.service;

import com.javaApps.springDataJpa.domain.Book;
import com.javaApps.springDataJpa.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {
    final
    BookRepo repo;

    public BookService(BookRepo repo) {
        this.repo = repo;
    }


    public Book save(Book book){
        return repo.save(book);
    }

    public Book getBook(Long id){
        Optional<Book> book =  repo.findById(id);
        return book.get();
    }
}
