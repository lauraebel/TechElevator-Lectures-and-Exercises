package com.techelevator.inventory;

import com.techelevator.inventory.items.Item;

public class Stock {

	private Item item;
	private int quantity;
	
	public Stock(Item item, int quantity) {
		this.item = item;
		this.quantity = quantity;
	}
	
	public Item getItem() {
		return item;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public boolean removeQuanity(int quantityToRemove) {
		if (quantity < 0 || quantity - quantityToRemove < 0 ) {
			return false;
		}
		this.quantity -= quantityToRemove;
		return true;
	}
	
	public boolean isSoldOut() {
		return quantity <= 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + quantity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stock other = (Stock) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}
	
	
	
	
}
