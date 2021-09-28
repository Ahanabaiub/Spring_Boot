package com.javaApps.springDataJpa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class Student {

    @Id
    private long id;
    private String name;
    private int rollNo;

    @OneToMany(mappedBy = "student")
    private List<Book> Books;

    public List<Book> getBook() {
        return Books;
    }

    public void setBook(List<Book> book) {
        this.Books = book;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
}
