package com.geekstomach.entity;

import com.geekstomach.servlet.CatalogServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductsList {
private List<Product> productsList;
    private static Logger logger = LoggerFactory.getLogger(ProductsList.class);

    public ProductsList() {
    }


    public List<Product> getProductsList() {
        return productsList;
    }


    public ProductsList(int size) {
        this.productsList = new ArrayList<>();
        for (int i = 0; i < size; i++) {

            productsList.add(new Product((long) i,"Селедка "+i, new BigDecimal(1000*i)));
            logger.info("Добавлен "+i+"-ый элемент");
        }
logger.info("Конструтор сработал");
    }


}
