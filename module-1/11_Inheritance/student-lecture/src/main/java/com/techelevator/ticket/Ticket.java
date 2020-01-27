package com.techelevator.ticket;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ticket {
	
	private BigDecimal price;
	private String type;
	
	public Ticket(double price) {
		this(price, "Regular");
	}
	
	public Ticket(double price, String type)  {
		this.price = new BigDecimal(price);
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
	
	public BigDecimal getPrice() {
		return this.price;
	}
	
	public BigDecimal getFee() {
		return price.multiply(new BigDecimal(.20));
	}
	
	public BigDecimal getTotalPrice() {
		BigDecimal totalCost = price.add(getFee());
		totalCost = totalCost.setScale(2, RoundingMode.HALF_UP);
		return totalCost;
	}

}
