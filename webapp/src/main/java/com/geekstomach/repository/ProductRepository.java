package com.geekstomach.repository;

import com.geekstomach.entity.Product;
import com.geekstomach.util.LoggerForWebapp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Stateless

public class ProductRepository implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(ProductRepository.class);

    @PersistenceContext(unitName = "ds")
    private EntityManager entityManager;


    @PostConstruct
    public void init(){
/*        if (this.findAll().isEmpty()) {
            this.insert(new Product(-1L, "First", new BigDecimal("100.0")));
            this.insert(new Product(-1L, "Second", new BigDecimal("200.0")));
            this.insert(new Product(-1L, "Third", new BigDecimal("300.0")));
        }*/
    }

    @TransactionAttribute
    public void insert(Product product) {
        entityManager.persist(product);
    }

    @TransactionAttribute
    public void update(Product product) {
        entityManager.merge(product);
    }

    @TransactionAttribute
    public void delete(long id) {
        Product product = entityManager.find(Product.class, id);
        if (product != null) {
            entityManager.remove(product);

        }
    }

    public Product findById(long id) {
        return entityManager.find(Product.class, id);
    }

@Interceptors({LoggerForWebapp.class})
    public List<Product> findAll() {
        return entityManager.createQuery("from Product", Product.class).getResultList();
    }
}

