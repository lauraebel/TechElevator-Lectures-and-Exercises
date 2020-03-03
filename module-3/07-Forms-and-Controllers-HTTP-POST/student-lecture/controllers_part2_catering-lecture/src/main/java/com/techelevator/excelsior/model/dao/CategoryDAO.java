package com.techelevator.excelsior.model.dao;

import java.util.List;

public interface CategoryDAO {

	public List<String> getCategoriesByVenueId(long venueId);

	public List<String> getAllCategories();

}
