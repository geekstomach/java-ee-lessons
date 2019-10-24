package com.geekstomach.repository;

import com.geekstomach.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@ApplicationScoped
@Named //бинами управляет контейнер, а точнее CLI
public class ProductRepository {

    private static final Logger logger = LoggerFactory.getLogger(ProductRepository.class);

    @PersistenceContext(unitName = "ds")
    private EntityManager entityManager;

    @PostConstruct
    public void init(){
        if (this.findAll().isEmpty()) {
            this.insert(new Product(-1L, "First", new BigDecimal("100.0")));
            this.insert(new Product(-1L, "Second", new BigDecimal("200.0")));
            this.insert(new Product(-1L, "Third", new BigDecimal("300.0")));
        }
    }

    @Transactional
    public void insert(Product product) {
        entityManager.persist(product);
    }

    @Transactional
    public void update(Product product) {
        entityManager.merge(product);
    }

    @Transactional
    public void delete(long id) {
        Product product = entityManager.find(Product.class, id);
        if (product != null) {
            entityManager.remove(product);
        }
    }

    public Product findById(long id) {
        return entityManager.find(Product.class, id);
    }


    public List<Product> findAll() {
        return entityManager.createQuery("from Product" , Product.class).getResultList();
    }
}

