package com.javacode.bestbuy.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Specification implements Comparable<Specification> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;


    @OneToMany(mappedBy = "specification")
    @JsonBackReference
    private List<SpecificatioDetails> specificatioDetails;

    public Specification() {
    }

    public List<SpecificatioDetails> getSpecificatioDetails() {
        return specificatioDetails;
    }

    public void setSpecificatioDetails(List<SpecificatioDetails> specificatioDetails) {
        this.specificatioDetails = specificatioDetails;
    }

    public Specification(String name, List<SpecificatioDetails> specificatioDetails) {
        this.name = name;
        this.specificatioDetails = specificatioDetails;
    }

    public Specification(String name) {
        this.id = id;
        this.name = name;
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


    @Override
    public int compareTo(Specification s) {

        Long n = this.id - s.id;
        return n.intValue();
    }

    @Override
    public String toString() {
        return "Specification{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specificatioDetails=" + specificatioDetails +
                '}';
    }



}
