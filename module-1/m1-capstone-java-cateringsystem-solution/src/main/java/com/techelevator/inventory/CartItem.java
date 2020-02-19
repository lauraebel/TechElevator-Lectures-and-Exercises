package com.techelevator.inventory;

import com.techelevator.inventory.items.Item;

public class CartItem {

	private int quantity;
	private Item item;
	
	
	public CartItem(Item item, int quantity) throws InventoryException {
		this.item = item;
		if (validateQuanity(quantity)) {
			this.quantity = quantity;
		} else {
			throw new InventoryException("Invalid Quantity", "", quantity);
		}

	}
	
	public void addQuantity(int quantityToAdd) throws InventoryException {
		if (validateQuanity(quantityToAdd)) {
			this.quantity += quantityToAdd;
		} else {
			throw new InventoryException("Invalid Quantity", "", quantityToAdd);
		}
	}
		
	private boolean validateQuanity(int quantity) {
		return quantity > 0;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public Item getItem() {
		return item;
	}
	
	public double getTotalAmount() {
		return item.getPrice() * quantity;
	}
	
	
}
