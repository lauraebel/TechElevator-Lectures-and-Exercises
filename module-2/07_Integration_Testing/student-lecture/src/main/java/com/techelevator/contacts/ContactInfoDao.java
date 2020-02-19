package com.techelevator.contacts;

import java.util.List;

public interface ContactInfoDao {

	ContactInfo getById(int contactId);
	List<ContactInfo> getByPersonId(int personId);
	void save(ContactInfo contact, int personId);
	void update(ContactInfo contact);
	void deleteFromPerson(int contactId, int personId);
}
