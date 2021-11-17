package com.javacode.bestbuy.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class SpecificatioDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String details;

    @ManyToOne
    private Specification specification;

    @ManyToOne
    @JsonBackReference(value = "product-sd")
    private Product product;

    public SpecificatioDetails() {
    }

    public SpecificatioDetails(String title, String details, Specification specification, Product product) {
        this.title = title;
        this.details = details;
        this.specification = specification;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Specification getSpecification() {
        return specification;
    }

    public void setSpecification(Specification specification) {
        this.specification = specification;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "SpecificatioDetails{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", details='" + details + '\'' +
                ", specification=" + specification +
               // ", product=" + product +
                '}';
    }
}
