package com.javacode.bestbuy.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long productCode;
    private String name;
    private Float price;
    private Float regularPrice;
    private Integer quantity;
    private String status;
    private String description;

    private String image;

    @ManyToOne
    @JsonManagedReference
    private Brand brand;

    @ManyToOne
    private Category category;

    @ManyToOne
    private SubCategory subCategory;

    @ManyToOne
    private SubSubCategory subSubCategory;

    @OneToMany(mappedBy = "product")
    @JsonManagedReference
    private List<SpecificatioDetails> specificatioDetails;

    public Product() {
    }

    public List<SpecificatioDetails> getSpecificatioDetails() {
        return specificatioDetails;
    }

    public void setSpecificatioDetails(List<SpecificatioDetails> specificatioDetails) {
        this.specificatioDetails = specificatioDetails;
    }

    public Product(Long id, Long productCode, String name, Float price, Float regularPrice, Integer quantity, String status, String description, String image, Brand brand, Category category,
                   SubCategory subCategory, SubSubCategory subSubCategory) {
        this.id = id;
        this.productCode = productCode;
        this.name = name;
        this.price = price;
        this.regularPrice = regularPrice;
        this.quantity = quantity;
        this.status = status;
        this.description = description;
        this.image = image;
        this.brand = brand;
        this.category = category;
        this.subCategory = subCategory;
        this.subSubCategory = subSubCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductCode() {
        return productCode;
    }

    public void setProductCode(Long productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(Float regularPrice) {
        this.regularPrice = regularPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public SubSubCategory getSubSubCategory() {
        return subSubCategory;
    }

    public void setSubSubCategory(SubSubCategory subSubCategory) {
        this.subSubCategory = subSubCategory;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productCode=" + productCode +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", regularPrice=" + regularPrice +
                ", quantity=" + quantity +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", brand=" + brand +
                ", category=" + category +
                ", subCategory=" + subCategory +
                ", subSubCategory=" + subSubCategory +
                ", specificatioDetails=" + specificatioDetails +
                '}';
    }
}
