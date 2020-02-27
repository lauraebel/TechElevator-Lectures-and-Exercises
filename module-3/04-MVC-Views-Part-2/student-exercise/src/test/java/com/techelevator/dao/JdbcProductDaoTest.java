package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import com.techelevator.dao.model.Product;
import com.techelevator.dao.model.ProductFilter;
import com.techelevator.dao.model.ProductSortOrder;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcProductDaoTest extends DaoIntegrationTest {

        private JdbcTemplate jdbcTemplate;
        private JdbcProductDao productDao;

        @Before
        public void setup() {
                jdbcTemplate = new JdbcTemplate(super.getDataSource());
                productDao = new JdbcProductDao(super.getDataSource());

                jdbcTemplate.execute("INSERT INTO categories (id, name) VALUES (1, 'TEST1')");
        }

        @Test
        public void getAll_returns_all_products() {
                List<Product> products = new ArrayList<>();

                for (int i = 1; i <= 10; i++) {
                        Product product = createProduct("TEST PRODUCT " + i, 1, i + ".png",
                                        "Test product " + i + "is wonderful!", 0, false, i, 5.00);
                        products.add(product);
                        insertProduct(product);
                }

                List<Product> actualProducts = productDao.getAll();
                assertThat(actualProducts, hasSize(10));
                assertThat(actualProducts, equalTo(products));
        }

        @Test
        public void getAll_returns_products_within_priceRange() {
                Product productBelowMinPrice = createProduct("$0.99 Product", 1, "99-cent-product",
                                "Product that costs $0.99", 1, false, 0, 0.99);
                insertProduct(productBelowMinPrice);

                Product productAtMinPrice = createProduct("$1.00 Product", 1, "1-dollar-product",
                                "Product that costs $1.00", 1, false, 0, 1.00);
                insertProduct(productAtMinPrice);

                Product productAtMaxPrice = createProduct("$2.00 Product", 1, "2-dollar-product",
                                "Product that costs $2.00", 1, false, 0, 2.00);
                insertProduct(productAtMaxPrice);

                Product productAboveMaxPrice = createProduct("$2.01 Product", 1, "2-01-dollar-product",
                                "Product that costs $2.01", 1, false, 0, 2.01);
                insertProduct(productAboveMaxPrice);

                ProductFilter filter = new ProductFilter();
                filter.setMinPrice(1.00);
                filter.setMaxPrice(2.00);

                List<Product> actualProducts = productDao.getAll(filter, null);

                assertThat(actualProducts, hasSize(2));
                assertThat(actualProducts, containsInAnyOrder(new Product[] { productAtMinPrice, productAtMaxPrice }));
        }

        @Test
        public void getAll_returns_products_greater_than_or_equal_to_minPrice() {
                Product productBelowMinPrice = createProduct("$0.99 Product", 1, "99-cent-product",
                                "Product that costs $0.99", 1, false, 0, 0.99);
                insertProduct(productBelowMinPrice);

                Product productAtMinPrice = createProduct("$1.00 Product", 1, "1-dollar-product",
                                "Product that costs $1.00", 1, false, 0, 1.00);
                insertProduct(productAtMinPrice);

                Product productAtMaxPrice = createProduct("$2.00 Product", 1, "2-dollar-product",
                                "Product that costs $2.00", 1, false, 0, 2.00);
                insertProduct(productAtMaxPrice);

                Product productAboveMaxPrice = createProduct("$2.01 Product", 1, "2-01-dollar-product",
                                "Product that costs $2.01", 1, false, 0, 2.01);
                insertProduct(productAboveMaxPrice);

                ProductFilter filter = new ProductFilter();
                filter.setMinPrice(2.0);

                List<Product> actualProducts = productDao.getAll(filter, null);

                assertThat(actualProducts, hasSize(2));
                assertThat(actualProducts,
                                containsInAnyOrder(new Product[] { productAtMaxPrice, productAboveMaxPrice }));
        }

        @Test
        public void getAll_returns_products_less_than_or_equal_to_maxPrice() {
                Product productBelowMinPrice = createProduct("$0.99 Product", 1, "99-cent-product",
                                "Product that costs $0.99", 1, false, 0, 0.99);
                insertProduct(productBelowMinPrice);

                Product productAtMinPrice = createProduct("$1.00 Product", 1, "1-dollar-product",
                                "Product that costs $1.00", 1, false, 0, 1.00);
                insertProduct(productAtMinPrice);

                Product productAtMaxPrice = createProduct("$2.00 Product", 1, "2-dollar-product",
                                "Product that costs $2.00", 1, false, 0, 2.00);
                insertProduct(productAtMaxPrice);

                Product productAboveMaxPrice = createProduct("$2.01 Product", 1, "2-01-dollar-product",
                                "Product that costs $2.01", 1, false, 0, 2.01);
                insertProduct(productAboveMaxPrice);

                ProductFilter filter = new ProductFilter();
                filter.setMaxPrice(1.0);

                List<Product> actualProducts = productDao.getAll(filter, null);

                assertThat(actualProducts, hasSize(2));
                assertThat(actualProducts,
                                containsInAnyOrder(new Product[] { productAtMinPrice, productBelowMinPrice }));
        }

        @Test
        public void getAll_returns_all_products_if_no_filters_are_provided() {
                List<Product> products = new ArrayList<>();

                for (int i = 1; i <= 10; i++) {
                        Product product = createProduct("TEST PRODUCT " + i, 1, i + ".png",
                                        "Test product " + i + "is wonderful!", 0, false, i, 5.00);
                        products.add(product);
                        insertProduct(product);
                }

                List<Product> actualProducts = productDao.getAll(null, null);
                assertThat(actualProducts, hasSize(10));
                assertThat(actualProducts, equalTo(products));
        }

        @Test
        public void getAll_returns_products_filtered_by_category() {
                jdbcTemplate.execute("INSERT INTO categories (id, name) VALUES (2, 'TEST-CATEGORY-2')");
                Product productNotInCategory = createProduct("Not in category", 1, "not-in-category",
                                "Not in the category", 0, false, 0, 0);
                insertProduct(productNotInCategory);

                Product productInCategory = createProduct("In category", 2, "in-category", "In the category", 0, false,
                                0, 0);
                insertProduct(productInCategory);

                ProductFilter filter = new ProductFilter();
                filter.setCategoryName("TEST-CATEGORY-2");

                List<Product> actualProducts = productDao.getAll(filter, null);

                assertThat(actualProducts, hasSize(1));
                assertThat(actualProducts, contains(productInCategory));
        }

        @Test
        public void getAll_returns_products_filtered_by_rating() {
                Product productAtMinRating = createProduct("At min rating", 1, "at min rating", "At the min rating",
                                1.0, false, 0, 0);
                insertProduct(productAtMinRating);

                Product productAboveMinRating = createProduct("Above min rating", 1, "above min rating",
                                "Above the min rating", 1.1, false, 0, 0);
                insertProduct(productAboveMinRating);

                Product productBelowMinRating = createProduct("Below min rating", 1, "below min rating",
                                "Below the min rating", 0.9, false, 0, 0);
                insertProduct(productBelowMinRating);

                ProductFilter filter = new ProductFilter();
                filter.setMinRating(1.0);

                List<Product> actualProducts = productDao.getAll(filter, null);

                assertThat(actualProducts, hasSize(2));
                assertThat(actualProducts, contains(new Product[] { productAtMinRating, productAboveMinRating }));
        }

        @Test
        public void getAll_with_multiple_filters_returns_expected_results() {
                jdbcTemplate.execute("INSERT INTO categories (id, name) VALUES (2, 'TEST-CATEGORY-2')");
                Product productNotInCategory = createProduct("Not in category", 1, "not-in-category",
                                "Not in the category", 0, false, 0, 0);
                insertProduct(productNotInCategory);

                Product productInCategory = createProduct("In category", 2, "in-category", "In the category", 0, false,
                                0, 0);
                insertProduct(productInCategory);

                Product productBelowMinPrice = createProduct("$0.99 Product", 1, "99-cent-product",
                                "Product that costs $0.99", 1, false, 0, 0.99);
                insertProduct(productBelowMinPrice);

                Product productAtMinPrice = createProduct("$1.00 Product", 2, "1-dollar-product",
                                "Product that costs $1.00", 1, false, 0, 1.00);
                insertProduct(productAtMinPrice);

                Product productAtMaxPrice = createProduct("$2.00 Product", 1, "2-dollar-product",
                                "Product that costs $2.00", 1, false, 0, 2.00);
                insertProduct(productAtMaxPrice);

                Product productAboveMaxPrice = createProduct("$2.01 Product", 1, "2-01-dollar-product",
                                "Product that costs $2.01", 2, false, 0, 2.01);
                insertProduct(productAboveMaxPrice);

                ProductFilter filter = new ProductFilter();
                filter.setMinPrice(1.00);
                filter.setMaxPrice(2.00);
                filter.setCategoryName("TEST-CATEGORY-2");

                List<Product> actualProducts = productDao.getAll(filter, null);

                assertThat(actualProducts, hasSize(1));
                assertThat(actualProducts, contains(productAtMinPrice));
        }

        @Test
        public void getById_returns_the_product_with_the_associated_id() {
                Product product = createProduct("PRODUCT 1", 1, "PRODUCT-1", "PRODUCT 1 DESC", 0.5, true, 1, 59.95);
                insertProduct(product);

                Product actualProduct = productDao.getById(product.getId());

                assertThat(actualProduct, equalTo(product));
        }

        @Test
        public void getById_returns_null_if_the_product_id_is_not_valid() {
                Product product = createProduct("PRODUCT 1", 1, "PRODUCT-1", "PRODUCT 1 DESC", 0.5, true, 1, 59.95);
                insertProduct(product);

                Product actualProduct = productDao.getById(product.getId() + 1);

                assertThat(actualProduct, nullValue());
        }

        @Test
        public void getAll_returns_products_sorted_by_priceHighToLow() {
                Product productBelowMinPrice = createProduct("$0.99 Product", 1, "99-cent-product",
                                "Product that costs $0.99", 1, false, 0, 0.99);
                insertProduct(productBelowMinPrice);

                Product productAtMinPrice = createProduct("$1.00 Product", 1, "1-dollar-product",
                                "Product that costs $1.00", 1, false, 0, 1.00);
                insertProduct(productAtMinPrice);

                Product productAtMaxPrice = createProduct("$2.00 Product", 1, "2-dollar-product",
                                "Product that costs $2.00", 1, false, 0, 2.00);
                insertProduct(productAtMaxPrice);

                ProductSortOrder sortOrder = ProductSortOrder.PRICE_HIGH_TO_LOW;
                List<Product> actualProducts = productDao.getAll(null, sortOrder);

                assertThat(actualProducts, containsInRelativeOrder(
                                new Product[] { productAtMaxPrice, productAtMinPrice, productBelowMinPrice }));
        }

        @Test
        public void getAll_returns_products_sorted_by_priceLowToHigh() {
                Product productBelowMinPrice = createProduct("$0.99 Product", 1, "99-cent-product",
                                "Product that costs $0.99", 1, false, 0, 0.99);
                insertProduct(productBelowMinPrice);

                Product productAtMinPrice = createProduct("$1.00 Product", 1, "1-dollar-product",
                                "Product that costs $1.00", 1, false, 0, 1.00);
                insertProduct(productAtMinPrice);

                Product productAtMaxPrice = createProduct("$2.00 Product", 1, "2-dollar-product",
                                "Product that costs $2.00", 1, false, 0, 2.00);
                insertProduct(productAtMaxPrice);

                ProductSortOrder sortOrder = ProductSortOrder.PRICE_LOW_TO_HIGH;
                List<Product> actualProducts = productDao.getAll(null, sortOrder);

                assertThat(actualProducts, containsInRelativeOrder(
                                new Product[] { productBelowMinPrice, productAtMinPrice, productAtMaxPrice }));
        }

        @Test
        public void getAll_returns_products_sorted_by_ratingHighToLow() {
                List<Product> products = new ArrayList<>();

                for (int i = 1; i <= 3; i++) {
                        Product product = createProduct("TEST PRODUCT " + i, 1, i + ".png",
                                        "Test product " + i + " is wonderful!", i, false, i, 5.00);
                        products.add(product);
                        insertProduct(product);
                }

                ProductSortOrder sortOrder = ProductSortOrder.RATING_HIGH_TO_LOW;
                List<Product> actualProducts = productDao.getAll(null, sortOrder);

                assertThat(actualProducts, containsInRelativeOrder(products.get(2), products.get(1), products.get(0)));
        }

        private Product createProduct(String name, int categoryId, String imageName, String description,
                        double averageRating, boolean isTopSeller, int quantity, double price) {
                Product product = new Product();
                product.setName(name);
                product.setCategoryId(categoryId);
                product.setImageName(imageName);
                product.setDescription(description);
                product.setAverageRating(averageRating);
                product.setTopSeller(isTopSeller);
                product.setRemainingStock(quantity);
                product.setPrice(price);

                return product;
        }

        private Product insertProduct(Product product) {
                SqlRowSet results = jdbcTemplate.queryForRowSet(
                                "INSERT INTO products (category_id, name, image_name, description, average_rating, is_top_seller, quantity, price) VALUES "
                                                + "(?, ?, ?, ?, ?, ?, ?, ?) RETURNING id",
                                product.getCategoryId(), product.getName(), product.getImageName(),
                                product.getDescription(), product.getAverageRating(), product.isTopSeller(),
                                product.getRemainingStock(), product.getPrice());

                if (results.next()) {
                        product.setId(results.getInt("id"));
                }

                return product;
        }
}