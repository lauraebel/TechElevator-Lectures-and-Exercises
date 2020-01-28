package com.techelevator.ticket;

import java.math.BigDecimal;

public class UnderAgeTicket extends Ticket {

	private BigDecimal upCharge;
	
	public UnderAgeTicket( double price, double noDrinkCharge ) {
		super( price , "Under Age");
		upCharge = new BigDecimal( noDrinkCharge );
	}
	
	@Override
	public BigDecimal getFee() {
		return super.getFee().add( upCharge );
	}
}
