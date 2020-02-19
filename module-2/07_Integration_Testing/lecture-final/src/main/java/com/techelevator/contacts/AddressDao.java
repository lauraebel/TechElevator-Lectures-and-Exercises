package com.techelevator.contacts;

import java.util.List;

public interface AddressDao {

	Address getById(int addressId);
	List<Address> getByPersonId(int personId);
	void save(Address address, int personId);
	void update(Address address);
	void deleteFromPerson(int addressId, int personId);
	
}
