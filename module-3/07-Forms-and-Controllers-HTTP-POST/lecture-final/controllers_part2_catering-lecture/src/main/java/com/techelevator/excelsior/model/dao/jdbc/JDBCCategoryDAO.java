package com.techelevator.excelsior.model.dao.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.excelsior.model.dao.CategoryDAO;

@Component
public class JDBCCategoryDAO implements CategoryDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCCategoryDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<String> getCategoriesByVenueId(long venueId) {
		String sql = "SELECT category.name AS category_name FROM category "
				+ "JOIN category_venue ON category.id = category_venue.category_id "
				+ "WHERE category_venue.venue_id = ?";
		SqlRowSet categoryResults = jdbcTemplate.queryForRowSet(sql, venueId);

		return mapCategoryRowSetToList(categoryResults);
	}

	@Override
	public List<String> getAllCategories() {
		String sql = "SELECT category.name AS category_name FROM category";
		SqlRowSet categoryResults = jdbcTemplate.queryForRowSet(sql);

		return mapCategoryRowSetToList(categoryResults);
	}

	private List<String> mapCategoryRowSetToList(SqlRowSet result) {
		List<String> categories = new ArrayList<>();
		while (result.next()) {
			categories.add(result.getString("category_name"));
		}
		return categories;
	}

}
