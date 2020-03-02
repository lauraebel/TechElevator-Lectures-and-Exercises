package com.techelevator.inventory.reader;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.inventory.InvalidInventoryFileException;
import com.techelevator.inventory.Stock;
import com.techelevator.inventory.items.Appetizer;
import com.techelevator.inventory.items.Beverage;
import com.techelevator.inventory.items.Dessert;
import com.techelevator.inventory.items.Entree;
import com.techelevator.inventory.items.Item;

public class JdbcInventoryReader implements InventoryReader {

	private final static int INVENTORY_START_QUANTITY = 50;
	
	private JdbcTemplate db;
	
	public JdbcInventoryReader(DataSource dataSource) {
		this.db = new JdbcTemplate(dataSource);
	}

	@Override
	public Map<String, Stock> read() throws InventoryReaderException {
		
		Map<String, Stock> inventory = new LinkedHashMap<String, Stock>();
		
		SqlRowSet rows = db.queryForRowSet("SELECT code, name, price, type FROM inventory");
		
		while (rows.next()) {
			inventory.put(rows.getString("code"), mapRowToItem(rows));
		}
		
		return inventory;
	}

	private Stock mapRowToItem(SqlRowSet rows) {
		Item item = null;
		String type = rows.getString("type");
		switch (type.toUpperCase()) {
		case "B":
			item = new Beverage(rows.getString("name"), rows.getDouble("price"));
			break;
		case "A":
			item = new Appetizer(rows.getString("name"), rows.getDouble("price"));
			break;
		case "E":
			item = new Entree(rows.getString("name"), rows.getDouble("price"));
			break;
		case "D":
			item = new Dessert(rows.getString("name"), rows.getDouble("price"));
			break;
		default:
			throw new InvalidInventoryFileException(type + " is not a valid item type");
	}
		
		return new Stock(item, INVENTORY_START_QUANTITY);
	}
	
}
