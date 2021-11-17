package com.javacode.bestbuy.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne
    @JsonBackReference(value = "cat-subcat")
    private Category category;

    @OneToMany(mappedBy = "subCategory")
    private List<SubSubCategory> subSubCategoryList;

    public SubCategory() {
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public SubCategory(String name, List<SubSubCategory> subSubCategoryList) {
        this.name = name;
        this.subSubCategoryList = subSubCategoryList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubSubCategory> getSubSubCategoryList() {
        return subSubCategoryList;
    }

    public void setSubSubCategoryList(List<SubSubCategory> subSubCategoryList) {
        this.subSubCategoryList = subSubCategoryList;
    }

    @Override
    public String toString() {
        return "SubCategory{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
