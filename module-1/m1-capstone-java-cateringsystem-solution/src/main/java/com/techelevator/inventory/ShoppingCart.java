package com.techelevator.inventory;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	private List<CartItem> cart = new ArrayList<CartItem>();
	
	public int getNumberOfItems() {
		return cart.size();
	}
	
	public List<CartItem> getItems() {
		return cart;
	}
	
	public void add(CartItem item) {
		cart.add(item);
	}
	
	public List<CartItem> clear() {
		List<CartItem> purchasedItems = new ArrayList<CartItem>();
		purchasedItems.addAll(cart);
		cart.clear();
		return purchasedItems;
	}
	
}
