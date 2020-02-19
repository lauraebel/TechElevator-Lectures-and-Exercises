package com.techelevator.contacts;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class JdbcPersonDaoIntegrationTest {

	private PersonDao dao;
	
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
	// ^ "private static SingleConnectionDataSource dataSource;" through "@After" will be the same for every 
	// integration class you write

	@Before
	public void setup() {
		dao = new JdbcPersonDao(dataSource);
	}
	
	//Testing SELECT
	@Test
	public void select_person_by_id() {
		//Arrange
		Person person = getPerson();
		
		dao.save(person); //inserts the person so we can select it for our test
		
		//Act/Test
		Person actualPerson = dao.getById(person.getPersonId());
		
		//Assert
		Assert.assertNotNull("Person returned null", actualPerson); //comments to determine which assert failed if 
		//there is a failure
		
		Assert.assertEquals("Actual Person does not equal expected person", person, actualPerson);
	}
	
	//Testing INSERT
	@Test
	public void insert_person() {
		//Arrange
		Person person = getPerson();
		
		//Act
		dao.save(person);
		
		//Assert
		Assert.assertNotEquals("Id not set", 0, person.getPersonId()); 
		Person actualPerson = dao.getById(person.getPersonId());
		//Asserts that the save changed the automatic ID from the Integer of 0 to something else
		
		Assert.assertNotNull("null", actualPerson);
		Assert.assertEquals("person not as expected", person, actualPerson);

	}
	
	//Testing UPDATE
	@Test
	public void update_person() {
		//Arrange
		Person person = getPerson();
		dao.save(person); //Inserts the person
		
		person.setFirstName("updatedfirst");
		person.setLastName("updatedlast");
		person.setDateOfBirth(LocalDate.parse("1980-10-24", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		
		//Act
		dao.update(person);
		
		//Assert
		Person updated = dao.getById(person.getPersonId()); //gets values from DB
		Assert.assertNotNull(updated);
		Assert.assertEquals(person, updated);
	}
	
	//Testing DELETE
	@Test
	public void delete_person() {
		//Arrange
		Person person = getPerson();
		dao.save(person);
		
		//Act
		dao.delete(person.getPersonId());
		
		//Assert
		Person actual = dao.getById(person.getPersonId());
		Assert.assertNull(actual);
		
	}
	
	//Reusable Arrange
	private Person getPerson() {
	Person person = new Person();
	person.setFirstName("testfirstname");
	person.setLastName("testlastname");
	person.setDateOfBirth(LocalDate.now());
	return person;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
