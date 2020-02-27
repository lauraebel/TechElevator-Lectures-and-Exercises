package com.techelevator;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.techelevator.dao.ProductDao;
import com.techelevator.dao.model.Product;
import com.techelevator.dao.model.ProductFilter;
import com.techelevator.dao.model.ProductSortOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

	@Autowired
	private ProductDao productDao;

	@RequestMapping("/products")
	public String showProductList(HttpServletRequest request) {
		List<Product> products = getProducts(request);

		request.setAttribute("products", products);

		return "productList";
	}

	@RequestMapping("/products/tiles")
	public String showProductTiles(HttpServletRequest request) {
		List<Product> products = getProducts(request);
		request.setAttribute("products", products);
		return "productTiles";
	}

	@RequestMapping("/products/detail")
	public String showProductDetail(HttpServletRequest request) {
		int productId = Integer.parseInt(request.getParameter("id"));
		Product product = productDao.getById(productId);

		request.setAttribute("product", product);

		return "productDetail";
	}

	private List<Product> getProducts(HttpServletRequest request) {
		ProductFilter filter = getFilters(request);
		ProductSortOrder sortOrder = getSortOrder(request);

		List<Product> products = productDao.getAll(filter, sortOrder);

		return products;
	}

	private ProductFilter getFilters(HttpServletRequest request) {
		ProductFilter filter = new ProductFilter();

		if (request.getParameter("minRating") != null) {
			filter.setMinRating(Double.parseDouble(request.getParameter("minRating")));
		}

		if (request.getParameter("minPrice") != null) {
			Double minPrice = Double.valueOf(request.getParameter("minPrice"));
			filter.setMinPrice(minPrice);
		}

		if (request.getParameter("maxPrice") != null) {
			Double maxPrice = Double.valueOf(request.getParameter("maxPrice"));
			filter.setMaxPrice(maxPrice);
		}

		filter.setCategoryName(request.getParameter("category"));

		return filter;
	}

	private ProductSortOrder getSortOrder(HttpServletRequest request) {
		return ProductSortOrder.valueOfLabel(request.getParameter("sortOrder"));
	}

}
