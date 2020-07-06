package com.heleyquin.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "thumbnail")
    private String thumbnail;

    @Column(name = "description")
    private String description;

    @Column(name= "status")
    private Integer status;

    @Column(name = "categoryId")
    private Integer categoryId;

    @ManyToOne()
    @JoinColumn(name = "categoryId", updatable = false, insertable = false)
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<ProductSize> productSizeList;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<ProductSize> getProductSizeList() {
        return productSizeList;
    }

    public void setProductSizeList(List<ProductSize> productSizeList) {
        this.productSizeList = productSizeList;
    }

    public Product(Integer id, String name, Double price, String thumbnail, String description, Integer categoryId, Category category, List<ProductSize> productSizeList) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.thumbnail = thumbnail;
        this.description = description;
        this.categoryId = categoryId;
        this.category = category;
        this.productSizeList = productSizeList;
    }

    public Product() {
    }

    public Product(String name, Double price, String thumbnail, String description, Integer categoryId, Integer status) {
        this.name = name;
        this.price = price;
        this.thumbnail = thumbnail;
        this.description = description;
        this.categoryId = categoryId;
        this.status = status;
    }

    public Product(String name, Double price, String thumbnail, String description, Integer categoryId) {
        this.name = name;
        this.price = price;
        this.thumbnail = thumbnail;
        this.description = description;
        this.categoryId = categoryId;
    }
}
