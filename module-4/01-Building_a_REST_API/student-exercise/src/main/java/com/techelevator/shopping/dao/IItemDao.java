package com.techelevator.shopping.dao;

import java.util.List;

import com.techelevator.shopping.model.Item;

public interface IItemDao {

	public List<Item> list();

	public Item create(Item item);

	public Item read(int id);

	public Item update(Item item);

	public void delete(int id);
}
