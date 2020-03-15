package com.techelevator.shopping.model;

public class Item {

	private int id;
	private String name;
	private boolean completed;

	public Item() {

	}

	public Item(int id, String name, boolean completed) {
		super();
		this.id = id;
		this.name = name;
		this.completed = completed;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", completed=" + completed + "]";
	}

}
