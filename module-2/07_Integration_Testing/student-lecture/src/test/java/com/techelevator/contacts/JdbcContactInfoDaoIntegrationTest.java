package com.techelevator.contacts;

import java.sql.SQLException;
import java.util.List;

import org.junit.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcContactInfoDaoIntegrationTest {
	
	private ContactInfoDao dao;
	private int personId;
	private JdbcTemplate jdbcTemplate;
	private static SingleConnectionDataSource dataSource;

	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/contacts");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		dataSource.setAutoCommit(false);
	}
	
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}

	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@Before
	public void setup() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "INSERT INTO person(person_id, first_name, last_name, date_of_birth) VALUES (DEFAULT, 'firstname', 'lastname', null) RETURNING person_id";
		
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);
		rows.next();
		personId = rows.getInt("person_id");
		
		dao = new JdbcContactInfoDao(dataSource);
	}
	
	//Testing INSERT
	@Test
	public void insert_contact() {
		//Arrange
		ContactInfo contact = new ContactInfo();
		contact.setContact("email@something.com");
		contact.setContactMethod("Email");
		contact.setContactType("Home");
		
		//Act
		dao.save(contact, personId);
		
		//Assert
		
		//Verify save set the contact id
		Assert.assertNotEquals(0, contact.getContactId());
		
		//get the contact and verify it's equal to the one we inserted
		ContactInfo actual = dao.getById(contact.getContactId());
		Assert.assertEquals(contact, actual);
		
		//verify person_contact relationship created
		String sql = "SELECT * FROM person_contact_info WHERE person_id = ? AND contact_id = ?";
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, personId, contact.getContactId());
		Assert.assertTrue(rows.next());
	}
	
	@Test
	public void get_contacts_by_person_id() {
		//Arrange
		truncateContacts();
		
		ContactInfo contact = new ContactInfo();
		contact.setContact("email@something.com");
		contact.setContactMethod("Email");
		contact.setContactType("Home");
		
		ContactInfo contact2 = new ContactInfo();
		contact2.setContact("12345");
		contact2.setContactMethod("Phone");
		contact2.setContactType("Work");
		
		dao.save(contact, personId);
		dao.save(contact2, personId);
		
		//Act
		List<ContactInfo> contacts = dao.getByPersonId(personId);
		
		//Assert
		Assert.assertNotNull(contacts);
		Assert.assertEquals(2, contacts.size());
	}
	
	private void truncateContacts() {
		String sql ="TRUNCATE contact_info CASCADE";
		jdbcTemplate.batchUpdate(sql);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
