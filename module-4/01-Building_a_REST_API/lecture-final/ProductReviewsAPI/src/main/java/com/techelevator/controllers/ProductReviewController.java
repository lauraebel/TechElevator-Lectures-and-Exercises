package com.techelevator.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.reviews.dao.IProductReviewDao;
import com.techelevator.reviews.exception.ProductReviewNotFoundException;
import com.techelevator.reviews.model.ProductReview;

// Swagger Documentation available at:  http://localhost:8080/product-reviews-api/swagger-ui.html

@RequestMapping("/api/reviews")
@RestController
@CrossOrigin  // Allows access from other locations with JavaScript
public class ProductReviewController {
	
	@Autowired
	private IProductReviewDao productReviewDao;
	
	
	// GET /api/reviews
	@GetMapping
	public List<ProductReview> list() {
		return productReviewDao.list();
	}
	
	// GET /api/reviews/:id
	// {name} signifies a path variable
	@GetMapping("/{id}")
	public ProductReview read(@PathVariable int id) {
		ProductReview productReview = productReviewDao.read(id);
		if (productReview != null) {  // If review found, return it
			return productReview;
		} else {  // review not found, return a 404 - error status codes are returned by throwing the relevant exception
			throw new ProductReviewNotFoundException(id, "Product Review Not Found");
		}
		
	}
	
	// POST /api/reviews
	// @RequestBody allows JSON to data bind to a Java object  (similar to RequestParam)
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)  // sets the response status to be returned when successful
	public ProductReview create(@RequestBody ProductReview productReview) {
		return productReviewDao.create(productReview);
	}
	
	// PUT /api/reviews/:id
	@PutMapping("/{id}")
	public ProductReview update(@RequestBody ProductReview productReview, @PathVariable int id) {
		ProductReview requestedReview = productReviewDao.read(id); // Get the review to make sure it exists
		if (requestedReview != null) {
			return productReviewDao.update(productReview); // If it exists then update it
		} else {
			throw new ProductReviewNotFoundException(id, "Product Review Not Found");  // If does not exist, return 404
		}
	}
	
	// DELETE /api/reviews/:id
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		ProductReview requestedReview = productReviewDao.read(id); // Get the review to make sure it exists
		if (requestedReview != null) {
			productReviewDao.delete(id); // If it exists then update it
		} else {
			throw new ProductReviewNotFoundException(id, "Product Review Not Found");  // If does not exist, return 404
		}
	}
	
}
