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

    @OneToOne(mappedBy = "productSize")
    private ProductSize productSize;

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

    public Size(Integer id, String name, ProductSize productSize) {
        this.id = id;
        this.name = name;
        this.productSize = productSize;
    }

    public Size() {
    }
}
