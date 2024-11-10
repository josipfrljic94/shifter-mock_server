package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Organization {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique = true)
    private String name;
    @OneToMany(
            mappedBy = "organization"
    )
    @JsonManagedReference
    private List<Branch> branches;

    public Organization() {
    }

    public Organization(List<Branch> branches, String adress, String name) {
        this.branches = branches;
        this.address = adress;
        this.name = name;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }





    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }
}
