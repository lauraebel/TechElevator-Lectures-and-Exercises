package com.techelevator.ticket;

import java.math.BigDecimal;

//underage tickets will have an upcharge due to not being able to buy drinks - more money for the venue

public class UnderAgeTicket extends Ticket {
	
	private BigDecimal upCharge;
	
	public UnderAgeTicket(double price, double noDrinkCharge) {
		super(price, "Under Age");
		upCharge = new BigDecimal(noDrinkCharge);
	}
	
	@Override
	
	public BigDecimal getFee() {
		return super.getFee().add(upCharge);
		}
}
