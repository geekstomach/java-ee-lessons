package com.geekstomach.service;


import com.geekstomach.entity.Product;
import com.geekstomach.repository.ProductRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import java.util.List;
import java.util.stream.Collectors;
//http://localhost:8080/webapp/ProductService/ProductService?WSDL
@Stateless
@WebService(endpointInterface = "com.geekstomach.service.ProductServiceWs", serviceName = "ProductService")

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
