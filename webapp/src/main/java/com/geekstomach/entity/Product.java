package com.geekstomach.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import java.math.BigDecimal;

@Slf4j
@Data
public class Product {
    private Long id;
    private String productName;
    private BigDecimal price;

    public Product(Long id, String productName, BigDecimal price) {
        this.id = id;
        this.productName = productName;
        this.price = price;
    }

    public Product() {

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
