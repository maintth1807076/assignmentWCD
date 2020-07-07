package com.heleyquin.model;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
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

    public Category(HttpServletRequest req) {
        this.name = req.getParameter("name");
    }

    public Map<String, String> validate() {
        Map<String, String> result = new HashMap<String, String>();
        if (this.name == null) {
            result.put("name", "Vui lòng nhập tên Category");
        }
        return result;
    }
}
