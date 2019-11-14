package com.geekstomach;



import com.geekstomach.service.Product;
import com.geekstomach.service.ProductService;
import com.geekstomach.service.ProductServiceWs;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;

public class WsClient {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/webapp/ProductService/ProductService?WSDL");
        ProductService productService = new ProductService(url);

        ProductServiceWs productServicePort = productService.getProductServicePort();

        Product product = new Product();
        product.setProductName("From SOAP service 1");
        product.setPrice(new BigDecimal(100));

        productServicePort.insert(product);

        productServicePort.findAll()
                .forEach(t -> System.out.println(t.getProductName()));
    }
    }

