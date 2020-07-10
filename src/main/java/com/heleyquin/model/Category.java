package com.heleyquin.model;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "createdAt")
    private Timestamp createdAt;

    @Column(name = "updatedAt")
    private Timestamp updatedAt;

    @Column(name = "deletedAt")
    private Timestamp deletedAt;

    public Integer getId() {
        return id;
    }

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Product> productList;

    public Category(Integer id, String name, List<Product> productList) {
        this.id = id;
        this.name = name;
        this.productList = productList;
    }

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public HashMap<String, ArrayList<String>> getErrors() {
        HashMap<String, ArrayList<String>> errors = new HashMap<>();
        if (name == null || name.isEmpty()) {
            ArrayList<String> nameErrors = new ArrayList<>();
            if (errors.containsKey("name")) {
                nameErrors = errors.get("name");
            }
            nameErrors.add("Category name is required!");
            errors.put("name", nameErrors);
        }
        return errors;
    }
}
