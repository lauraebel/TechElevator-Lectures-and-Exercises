package com.techelevator.dao;

import com.techelevator.dao.model.Customer;
import com.techelevator.dao.model.Film;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

/**
 * JDBCCustomerDao
 */
@Component
public class JDBCCustomerDao implements CustomerDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCCustomerDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

	@Override
	public List<Customer> searchAndSortCustomers(String search, String sort) {
		List<Customer> matchingCustomers = new ArrayList<>();

        String customerSearchSql = "SELECT first_name, last_name, email, activebool FROM customer "
                + "WHERE (first_name = ? OR last_name = ?) ORDER BY ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(customerSearchSql, search, search, sort);
        while (results.next()) {
        	matchingCustomers.add(mapRowToCustomer(results));
        }
        return matchingCustomers;
	}

private Customer mapRowToCustomer(SqlRowSet results) {
    Customer customerRow = new Customer();
    customerRow.setFirstName(results.getString("first_name"));
    customerRow.setLastName(results.getString("last_name"));
    customerRow.setEmail(results.getString("email"));
    customerRow.setActive(results.getBoolean("activebool"));
    return customerRow;
}

}