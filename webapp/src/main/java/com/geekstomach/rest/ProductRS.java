package com.geekstomach.rest;

import com.geekstomach.controller.ProductBean;
import com.geekstomach.entity.Product;
import com.geekstomach.repository.ProductRepository;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("product")
public class ProductRS {
    @EJB
    private ProductRepository productRepository;
    @GET
    @Path("/{id}")
    public Product getProduct(@PathParam("id") Long id){

        return productRepository.findById(id);//orElseThrow(() ->  new WebApplicationException(Response.Status.NOT_FOUND));
    }



    @GET
    @Produces("application/json")
    @Path("/all")
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }
}
