package com.techelevator.contacts;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.*;
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
	
	@Before
	public void setup() {
		dao = new JdbcPersonDao(dataSource);
	}
	
	@Test  // SELECT
	public void select_person_by_id() {
		// Arrange
		Person person = getPerson();
		
		dao.save(person);  // insert the person so we can select it for our test
		
		// Act
		Person actualPerson = dao.getById( person.getPersonId() );
		
		// Assert
		Assert.assertNotNull("Person returned null", actualPerson);
		Assert.assertEquals("Actual person does not equal expected person", person, actualPerson);
	}
	
	@Test  // INSERT
	public void insert_person() {
		// Arrange
		Person person = getPerson();
		
		// Act
		dao.save(person);
		
		// Assert
		Assert.assertNotEquals("Id not set", 0, person.getPersonId());
		Person actualPerson = dao.getById( person.getPersonId() );
		
		Assert.assertNotNull("person returned null",  actualPerson );
		Assert.assertEquals("person not as expected",  person, actualPerson );
	}
	
	@Test // UPDATE
	public void update_person() {
		// Arrange
		Person person = getPerson();
		dao.save( person );  // insert the person
		person.setFirstName("UpdatedFirstName");  // change the values
		person.setLastName("UpdatedLastName");
		person.setDateOfBirth(  LocalDate.parse("1980-10-24", DateTimeFormatter.ofPattern("yyyy-MM-dd")) );
		
		// Act
		dao.update( person );
		
		// Assert
		Person updated = dao.getById( person.getPersonId() );  // Get the values from the database
		Assert.assertNotNull(updated);
		Assert.assertEquals(person, updated);
	}
	
	
	@Test //DELETE
	public void delete_person() {
		// Arrange
		Person person = getPerson();
		dao.save( person );
		
		// Act
		dao.delete( person.getPersonId() );
		
		// Assert
		Person actual = dao.getById( person.getPersonId() );
		Assert.assertNull( actual );
		
	}
	
	private Person getPerson() {
		Person person = new Person();
		person.setFirstName("testFirstName");
		person.setLastName("testLastName");
		person.setDateOfBirth( LocalDate.now() );
		return person;
	}
	
}
