package com.techelevator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.contacts.*;

public class ContactsDemo {

	public static void main(String[] args) {
		
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/contacts");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		
		PersonDao personDao = new JdbcPersonDao(dataSource);
		ContactInfoDao contactDao = new JdbcContactInfoDao(dataSource);
		AddressDao addressDao = new JdbcAddressDao(dataSource);
		
		Person person = new Person();
		person.setFirstName("Dave");
		person.setLastName("Smith");
		person.setDateOfBirth( LocalDate.parse("1980-10-22", DateTimeFormatter.ofPattern("yyyy-MM-dd")) );
		
		personDao.save( person );
		
		ContactInfo contact = new ContactInfo();
		contact.setContact("dave@someplace.com");
		contact.setContactMethod("Email");
		contact.setContactType("Home");
		
		contactDao.save(contact, person.getPersonId());
		
		List<ContactInfo> contacts = contactDao.getByPersonId( person.getPersonId() );
		
		System.out.println(contacts);
		
		Address address = new Address();
		address.setStreetLineOne("123 Street");
		address.setCity("Columbus");
		address.setDistrict("Ohio");
		address.setPostalCode("43201");
		address.setCountry("USA");
		address.setType("Home");
		
		addressDao.save(address, person.getPersonId());
		
		List<Address> addresses = addressDao.getByPersonId( person.getPersonId() );
		
		System.out.println(addresses);
		
	}

}
