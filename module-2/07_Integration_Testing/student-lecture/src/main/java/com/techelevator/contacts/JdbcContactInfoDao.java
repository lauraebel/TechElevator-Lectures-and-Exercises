package com.techelevator.contacts;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcContactInfoDao implements ContactInfoDao {
	
	private final static String SQL_SELECT_CONTACT = "SELECT contact_id, contact_type, contact_method, contact, contact_method_other FROM contact_info";
	private JdbcTemplate jdbcTemplate;

	public JdbcContactInfoDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	
	@Override
	public ContactInfo getById(int contactId) {
		ContactInfo contact = null;
		String sql = SQL_SELECT_CONTACT + " WHERE contact_id = ?";
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, contactId);
		if (rows.next()) {
			contact = mapRowToContactInfo( rows );
		}
		return contact;
	}

	@Override
	public List<ContactInfo> getByPersonId(int personId) {
		
		String sql = "SELECT c.contact_id, contact_type, contact_method, contact, contact_method_other " + 
				"FROM contact_info c " + 
				"JOIN person_contact_info ON c.contact_id = person_contact_info.contact_id " + 
				"WHERE person_contact_info.person_id = ?";
		
		List<ContactInfo> contacts = new ArrayList<ContactInfo>();
		
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, personId);
		while (rows.next()) {
			contacts.add(mapRowToContactInfo(rows));
		}
		
		return contacts;
	}

	@Override
	public void save(ContactInfo contact, int personId) {
		String sql = "INSERT INTO contact_info (contact_id, contact_type, contact_method, contact, contact_method_other) VALUES (DEFAULT, ?, ?, ?, ?) RETURNING contact_id";
		Integer contactId = jdbcTemplate.queryForObject(sql, Integer.class, 
				contact.getContactType(), contact.getContactMethod(), 
				contact.getContact(), contact.getContactMethodOther());
		contact.setContactId(contactId);
		savePersonContact(personId, contactId);
	}

	private void savePersonContact(int personId, int contactId) {
		String sql = "INSERT INTO person_contact_info (person_id, contact_id) VALUES (?, ?)";
		jdbcTemplate.update(sql, personId, contactId);
	}
	
	@Override
	public void update(ContactInfo contact) {
		String sql = "UPDATE contact_info SET contact_type = ?, contact_method = ?, contact = ?, contact_method_other = ? WHERE contact_id = ?";
		jdbcTemplate.update(sql, contact.getContactType(), contact.getContactMethod(), 
				contact.getContact(), contact.getContactMethodOther(), contact.getContactId());
	}

	@Override
	public void deleteFromPerson(int contactId, int personId) {

		deletePersonContactInfo(contactId, personId);
		
		// Only delete the Contact if it has not remaining relationships
		if (!hasAdditionalRelationships(contactId)) {
			String sql = "DELETE FROM contact_info WHERE contact_id = ?";
			jdbcTemplate.update(sql, contactId);
		}
	}
	
	private boolean hasAdditionalRelationships(int contactId) {
		String sql = "SELECT * FROM person_contact_info WHERE contact_id = ?";
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, contactId);
		if (rows.next()) {
			return true;
		}
		return false;
	}
	
	private void deletePersonContactInfo(int contactId, int personId) {
		String sql = "DELETE FROM person_contact_info WHERE contact_id = ? AND person_id = ?";
		jdbcTemplate.update(sql);
	}
	
	private ContactInfo mapRowToContactInfo(SqlRowSet row) {
		ContactInfo contact = new ContactInfo();
		
		contact.setContactId( row.getInt("contact_id") );
		contact.setContactType( row.getString("contact_type") );
		contact.setContactMethod( row.getString("contact_method") );
		contact.setContact( row.getString("contact") );
		contact.setContactMethodOther( row.getString("contact_method_other") );
		
		return contact;
	}

}
