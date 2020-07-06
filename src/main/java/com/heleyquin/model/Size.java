package com.heleyquin.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Size")
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "size")
    private List<ProductSize> productSizeList;

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

    public List<ProductSize> getProductSizeList() {
        return productSizeList;
    }

    public void setProductSizeList(List<ProductSize> productSizeList) {
        this.productSizeList = productSizeList;
    }

    public Size() {
    }
}
