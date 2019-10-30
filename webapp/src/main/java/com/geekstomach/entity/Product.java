package com.geekstomach.entity;


import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "products")
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String productName;
    @Column
    private BigDecimal price;

    public Product() {
    }

    public Product(Long id, String productName, BigDecimal price) {
        this.id = id;
        this.productName = productName;
        this.price = price;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


}
