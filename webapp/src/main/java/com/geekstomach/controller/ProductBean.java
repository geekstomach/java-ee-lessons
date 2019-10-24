package com.geekstomach.controller;

import com.geekstomach.entity.Product;
import com.geekstomach.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@SessionScoped
@Named
public class ProductBean implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(ProductBean.class);

    @Inject
    private ProductRepository productRepository;

    private Product product;

    private List<Product> productList;

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }

    public void preloadProductList(ComponentSystemEvent componentSystemEvent){
        this.productList = productRepository.findAll();
}

    public List<Product> getAllProduct() throws SQLException {
        return productList;

    }

    public String createProduct(){
        this.product = new Product();
        return "/product.xhtml?face-redirect=true";
    }

    public String saveProduct() throws SQLException {
        if (product.getId() == null) {
            productRepository.insert(product);
        }else {
            productRepository.update(product);
        }
        return "/index.xhtml?face-redirect=true";
    }

    public void deleteProduct (Product product) throws SQLException {
        logger.info("Deleting product...");
        productRepository.delete(product.getId());
    }

    public String editProduct(Product product){
        this.product = product;
        return "/product.xhtml?face-redirect=true";
    }

}
