package com.techelevator.shopping.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bouncycastle.util.test.Test;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.shopping.model.Item;

@Component
public class ItemDao implements IItemDao {

	private Map<Integer, Item> groceries = new HashMap<>();
	private int itemId = 0;
	
	public ItemDao() throws JsonParseException, JsonMappingException, IOException {
		loadJSON();
	}

	@Override
	public List<Item> list() {
		List<Item> allitems = new ArrayList<>();
		groceries.forEach((k, v) -> allitems.add(v));
		return allitems;
	}

	@Override
	public Item create(Item item) {
		groceries.put(++itemId, item);
		item.setId(itemId);
		return item;
	}

	@Override
	public Item read(int id) {
		return groceries.get(id);
	}

	@Override
	public Item update(Item item) {
		groceries.put(item.getId(), item);
		return item;
	}

	@Override
	public void delete(int id) {
		groceries.remove(id);
	}

	private void loadJSON() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		InputStream inputStream = Test.class.getResourceAsStream("/data.json");
		Item[] jsondata = mapper.readValue(inputStream, Item[].class);
		for (Item item : jsondata) {
			if (item.getId() > itemId) {
				itemId = item.getId();
			}
			groceries.put(item.getId(), item);
		}
	}

}
