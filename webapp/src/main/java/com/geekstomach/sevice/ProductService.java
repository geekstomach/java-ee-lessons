package com.geekstomach.sevice;


import com.geekstomach.entity.Product;
import com.geekstomach.repository.ProductRepository;

import javax.ejb.EJB;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {


    @EJB
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll()
                .stream()
                .map(t -> new Product(t.getId(), t.getProductName(),t.getPrice()))
                .collect(Collectors.toList());
    }
    public void insert(Product product) {
        Product temp = new Product();
        temp.setProductName(product.getProductName());
        temp.setPrice(product.getPrice());
        productRepository.insert(temp);
    }
}
