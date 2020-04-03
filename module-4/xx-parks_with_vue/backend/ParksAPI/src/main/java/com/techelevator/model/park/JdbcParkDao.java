package com.techelevator.model.park;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcParkDao implements ParkDao {

	private static final String SQL_SELECT_PARK = "select parkcode, parkname, state, acreage, elevationinfeet, "
			+ "milesoftrail, numberofcampsites, climate, yearfounded, annualvisitorcount, inspirationalquote, "
			+ "inspirationalquotesource, parkdescription, entryfee, numberofanimalspecies "
			+ "from park";
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcParkDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	@Override
	public List<Park> getAllParks() {
		
		List<Park> parks = new ArrayList<Park>();
		SqlRowSet result = jdbcTemplate.queryForRowSet(SQL_SELECT_PARK);
		
		while (result.next()) {
			parks.add(mapRowToPark(result));
		}
		
		return parks;
	}
	
	@Override
	public Park getParkByParkCode(String parkCode) {
		Park park = new Park();
		String sql = SQL_SELECT_PARK + " WHERE parkcode=?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql, parkCode);
		if (result.next()) {
			park = mapRowToPark(result);
		}
		return park;
	}

	private Park mapRowToPark(SqlRowSet row) {
		Park park = new Park();
		
		park.setParkCode(row.getString("parkcode"));
		park.setParkName(row.getString("parkname"));
		park.setState(row.getString("state"));
		park.setAcreage(row.getInt("acreage"));
		park.setElevationInFeet(row.getInt("elevationinfeet"));
		park.setMilesOfTrail(row.getFloat("milesoftrail"));
		park.setNumberOfCampsites(row.getInt("numberofcampsites"));
		park.setClimate(row.getString("climate"));
		park.setYearFounded(row.getInt("yearfounded"));
		park.setAnnualVisitorCount(row.getInt("annualvisitorcount"));
		park.setInspirationalQuote(row.getString("inspirationalquote"));
		park.setInspirationalQuoteSource(row.getString("inspirationalQuoteSource"));
		park.setParkDescription(row.getString("parkdescription"));
		park.setEntryFee(row.getInt("entryfee"));
		park.setNumberOfAnimalSpecies(row.getInt("numberofanimalspecies"));
		return park;
	}



}
