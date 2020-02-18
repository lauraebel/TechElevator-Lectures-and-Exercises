package com.techelevator.contacts;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcPersonDao implements PersonDao {

	private static final String SQL_SELECT_PERSON = "SELECT person_id, first_name, last_name, date_of_birth FROM person";
	private JdbcTemplate jdbcTemplate;

	public JdbcPersonDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Person> getAll() {
		List<Person> persons = new ArrayList<Person>();
		SqlRowSet rows = jdbcTemplate.queryForRowSet(SQL_SELECT_PERSON);
		
		while (rows.next()) {
			persons.add(mapRowToPerson(rows));
		}
		
		return persons;
	}

	@Override
	public Person getById(int personId) {
		Person person = null;
		String sql = SQL_SELECT_PERSON + " WHERE person_id = ?";
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, personId);
		
		if (rows.next()) {
			person = mapRowToPerson(rows);
		}
		
		return person;
	}

	@Override
	public void save(Person person) {
		String sql = "INSERT INTO person (person_id, first_name, last_name, date_of_birth) VALUES (DEFAULT, ?, ?, ?) RETURNING person_id";
		Integer personId = jdbcTemplate.queryForObject(sql, Integer.class, person.getFirstName(), person.getLastName(), Date.valueOf(person.getDateOfBirth()));
		person.setPersonId(personId);
	}

	@Override
	public void update(Person person) {
		String sql = "UPDATE person SET first_name = ?, last_name = ?, date_of_birth = ? WHERE person_id = ?";
		jdbcTemplate.update(sql, person.getFirstName(), person.getLastName(), Date.valueOf( person.getDateOfBirth()), person.getPersonId());
	}

	@Override
	public void delete(int personId) {
		String sql = "DELETE FROM person WHERE person_id = ?";
		jdbcTemplate.update(sql, personId);
		
	}
	
	private Person mapRowToPerson(SqlRowSet row) {
		Person person = new Person();
		person.setPersonId( row.getInt("person_id"));
		person.setFirstName( row.getString("first_name"));
		person.setLastName( row.getString("last_name"));
		if ( row.getDate("date_of_birth")  != null) {
			person.setDateOfBirth( row.getDate("date_of_birth").toLocalDate() );
		}
		return person;
	}
	
}
