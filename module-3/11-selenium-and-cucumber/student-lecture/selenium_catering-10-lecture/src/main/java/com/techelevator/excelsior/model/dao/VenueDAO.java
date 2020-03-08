package com.techelevator.excelsior.model.dao;

import java.util.List;

import com.techelevator.excelsior.model.Venue;
import com.techelevator.excelsior.model.dao.jdbc.JDBCCategoryDAO;
import com.techelevator.excelsior.model.dao.jdbc.JDBCSpaceDAO;

public interface VenueDAO {

	public List<Venue> getVenues(JDBCSpaceDAO spaceDAO, JDBCCategoryDAO categoryDAO);

}
