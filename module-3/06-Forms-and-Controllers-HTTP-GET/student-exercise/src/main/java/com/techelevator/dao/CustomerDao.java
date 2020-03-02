package com.techelevator.dao;

import com.techelevator.dao.model.Customer;
import java.util.List;

public interface CustomerDao {
    public List<Customer> searchAndSortCustomers(String search, String sort);
    
}