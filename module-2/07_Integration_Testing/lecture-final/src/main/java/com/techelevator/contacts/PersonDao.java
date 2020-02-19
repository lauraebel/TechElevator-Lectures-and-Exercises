package com.techelevator.contacts;

import java.util.List;

public interface PersonDao {

	List<Person> getAll();
	Person getById(int personId);
	void save(Person person);
	void update(Person person);
	void delete(int personId);
}
