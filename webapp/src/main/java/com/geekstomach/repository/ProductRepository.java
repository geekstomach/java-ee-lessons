package com.geekstomach.repository;

import com.geekstomach.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Named //бинами управляет контейнер, а точнее CLI
public class ProductRepository {

    private static final Logger logger = LoggerFactory.getLogger(ProductRepository.class);
    @Inject
    private DataSource dataSource;

    private Connection connection;


    @PostConstruct
    public void init() throws SQLException {
        this.connection = dataSource.getConnection();

        if (this.findAll().isEmpty()) {
            this.insert(new Product(-1L, "First", new BigDecimal("100.0")));
            this.insert(new Product(-1L, "Second",new BigDecimal("200.0")));
            this.insert(new Product(-1L, "Third", new BigDecimal("300.0")));
        }
        createTableIfNotExists(connection);

    }

    public void insert(Product product) throws SQLException{
        try(PreparedStatement statement = connection.prepareStatement(
                "insert into products(productName , price) value (?,?);"
        )){
            statement.setString(1,product.getProductName());
            statement.setBigDecimal(2,product.getPrice());
            statement.execute();
        }
}
    public void update(Product product) throws SQLException{
        try(PreparedStatement statement = connection.prepareStatement(
                "update products set productName = ?, price = ? where id = ?;"
        )){
            statement.setString(1,product.getProductName());
            statement.setBigDecimal(2,product.getPrice());
            statement.setLong(3, product.getId());
            statement.execute();
        }
    }
    public void delete(long id) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(
                "delete from products where id = ?;")) {
            statement.setLong(1, id);
            statement.execute();
        }
    }
    public Product findById(long id) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(
                "select id, productName, price from products where id = ?")) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Product(resultSet.getLong(1), resultSet.getString(2), resultSet.getBigDecimal(3));
            }
        }
        return new Product(-1L, "", null);
    }



    public List<Product> findAll() throws SQLException {
        List<Product> products = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet resultSet = stmt.executeQuery("select id, productName, price from products");

            while (resultSet.next()) {
                products.add(new Product(resultSet.getLong(1), resultSet.getString(2), resultSet.getBigDecimal(3)));
            }
        }
        return products;
    }

    private void createTableIfNotExists(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("create table if not exists products (\n" +
                    "\tid int auto_increment primary key,\n" +
                    "    productName varchar(25),\n" +
                    "    price decimal \n" +
                    ");");
        }
    }
}
