package com.heleyquin.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "productSize")
public class ProductSize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "productId")
    private Integer productId;

    @Column(name = "sizeId")
    private Integer sizeId;

    @Column(name = "pricePlus")
    private float pricePlus;

    @ManyToOne()
    @JoinColumn(name = "productId", updatable = false, insertable = false)
    private Product product;

    @ManyToOne()
    @JoinColumn(name = "sizeId", updatable = false, insertable = false)
    private Size size;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getSizeId() {
        return sizeId;
    }

    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public float getPricePlus() {
        return pricePlus;
    }

    public void setPricePlus(float pricePlus) {
        this.pricePlus = pricePlus;
    }

    public ProductSize(Integer id, Integer productId, Integer sizeId, float pricePlus, Product product, Size size) {
        this.id = id;
        this.productId = productId;
        this.sizeId = sizeId;
        this.pricePlus = pricePlus;
        this.product = product;
        this.size = size;
    }

    public ProductSize() {
    }
}