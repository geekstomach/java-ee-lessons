package com.geekstomach.service;

import com.geekstomach.entity.Product;

import javax.ejb.Local;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@Local
@WebService
public interface ProductServiceWs {
    @WebMethod
    List<Product> findAll();
    @WebMethod
    void insert(Product product);
}
