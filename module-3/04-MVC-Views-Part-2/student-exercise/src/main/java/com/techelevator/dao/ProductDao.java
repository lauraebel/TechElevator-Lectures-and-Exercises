package com.techelevator.dao;

import java.util.List;

import com.techelevator.dao.model.Product;
import com.techelevator.dao.model.ProductFilter;
import com.techelevator.dao.model.ProductSortOrder;

public interface ProductDao {

    Product getById(int id);

    List<Product> getAll();

    List<Product> getAll(ProductFilter filter, ProductSortOrder sortOrder);
}