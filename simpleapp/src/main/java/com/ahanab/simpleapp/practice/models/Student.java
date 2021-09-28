package com.ahanab.simpleapp.practice.models;

import java.util.List;

public class Student {
    private String name;
    private Long id;
    private List<String> courses;
    private List<Book> books;

    public List<String> getCourses() {
        return courses;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", courses=" + courses +
                ", books=" + books +
                '}';
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

}
