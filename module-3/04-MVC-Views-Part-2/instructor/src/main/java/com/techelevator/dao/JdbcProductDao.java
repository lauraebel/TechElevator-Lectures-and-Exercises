package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.techelevator.dao.model.Product;
import com.techelevator.dao.model.ProductFilter;
import com.techelevator.dao.model.ProductSortOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcProductDao implements ProductDao {

    private static final String SELECT_PRODUCTS_SQL = "SELECT products.id, products.category_id, products.name, products.image_name, products.description, products.average_rating, products.is_top_seller, products.quantity, products.price FROM products";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcProductDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Product getById(int id) {
        SqlRowSet result = jdbcTemplate.queryForRowSet(SELECT_PRODUCTS_SQL + " WHERE id = ?", id);
        if (result.next()) {
            return mapRowSetToProduct(result);
        }
        return null;
    }

    @Override
    public List<Product> getAll() {
        return getAll(null, null);
    }

    @Override
    public List<Product> getAll(ProductFilter filter, ProductSortOrder sortOrder) {
        if (filter == null) {
            filter = new ProductFilter();
        }

        String sql = SELECT_PRODUCTS_SQL;

        List<String> filters = new ArrayList<>();
        List<Object> queryParameters = new ArrayList<>();

        if (filter.getMinPrice() != null) {
            filters.add(" price >= ? ");
            queryParameters.add(filter.getMinPrice());
        }

        if (filter.getMaxPrice() != null) {
            filters.add(" price <= ? ");
            queryParameters.add(filter.getMaxPrice());
        }

        if (filter.getCategoryName() != null) {
            sql += " INNER JOIN categories ON categories.id = products.category_id ";
            filters.add(" categories.name = ? ");
            queryParameters.add(filter.getCategoryName());
        }

        filters.add(" average_rating >= ? ");
        queryParameters.add(filter.getMinRating());

        if (!filters.isEmpty()) {
            sql += " WHERE ";
            sql += String.join(" AND ", filters);
        }

        sql += " ORDER BY ";
        if (sortOrder == ProductSortOrder.PRICE_HIGH_TO_LOW) {
            sql += " price DESC ";
        } else if (sortOrder == ProductSortOrder.PRICE_LOW_TO_HIGH) {
            sql += " price ASC ";
        } else if (sortOrder == ProductSortOrder.RATING_HIGH_TO_LOW) {
            sql += " average_rating DESC ";
        } else {
            sql += " id ASC ";
        }

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, queryParameters.toArray());

        return mapRowSetToProducts(results);
    }

    private List<Product> mapRowSetToProducts(SqlRowSet results) {
        List<Product> products = new ArrayList<>();
        while (results.next()) {
            products.add(mapRowSetToProduct(results));
        }
        return products;
    }

    private Product mapRowSetToProduct(SqlRowSet results) {
        Product product = new Product();
        product.setId(results.getInt("id"));
        product.setName(results.getString("name"));
        product.setCategoryId(results.getInt("category_id"));
        product.setDescription(results.getString("description"));
        product.setImageName(results.getString("image_name"));
        product.setAverageRating(results.getDouble("average_rating"));
        product.setTopSeller(results.getBoolean("is_top_seller"));
        product.setRemainingStock(results.getInt("quantity"));
        product.setPrice(results.getDouble("price"));

        return product;
    }

}