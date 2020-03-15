package com.techelevator.shopping.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.shopping.model.Item;


public class JdbcItemDao implements IItemDao {

	private final static String SELECT_SQL = "SELECT id, name, completed FROM groceries";
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcItemDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Item> list() {
		List<Item> items = new ArrayList<Item>();
		SqlRowSet rows = jdbcTemplate.queryForRowSet(SELECT_SQL + " ORDER BY id ASC");
		while(rows.next()) {
			items.add(mapRowToItem(rows));
		}
		return items;
	}

	@Override
	public Item create(Item item) {
		String insertSql = "INSERT INTO groceries (id, name, completed) VALUES (DEFAULT, ?, ?) RETURNING id";
		int id = jdbcTemplate.queryForObject(insertSql, Integer.class, item.getName(), item.isCompleted());
		item.setId(id);	
		return item;
	}

	@Override
	public Item read(int id) {
		Item item = null;
		String sql = SELECT_SQL + " WHERE id = ?";
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, id);
		if (rows.next()) {
			item = mapRowToItem(rows);
		}
		return item;
	}

	@Override
	public Item update(Item item) {
		String updateSql = "UPDATE groceries SET name = ?, completed = ? WHERE id = ?";
		jdbcTemplate.update(updateSql, item.getName(), item.isCompleted(), item.getId());
		return item;
	}

	@Override
	public void delete(int id) {
		String deleteSql = "DELETE FROM groceries WHERE id = ?";
		jdbcTemplate.update(deleteSql, id);
		
	}
	
	private Item mapRowToItem(SqlRowSet row) {
		Item item = new Item();
		
		item.setId(row.getInt("id"));
		item.setName(row.getString("name"));
		item.setCompleted(row.getBoolean("completed"));
		
		return item;
	}

}
