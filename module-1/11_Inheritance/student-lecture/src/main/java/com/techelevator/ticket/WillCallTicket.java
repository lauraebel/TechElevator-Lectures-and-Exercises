package com.techelevator.ticket;

import java.math.BigDecimal;

public class WillCallTicket extends Ticket {
	
	private String ticketHolderName;
	// ^more specific type of ticket
	
	public WillCallTicket(double price, String ticketHolderName) {
		super(price, "Will Call");
		this.ticketHolderName = ticketHolderName;
	}

	public String getTicketHolderName() {
		return this.ticketHolderName;
	}
	
	@Override
	public BigDecimal getFee() {
		return super.getPrice().multiply(new BigDecimal(.10));
	}
	// ^changes the automatic ticket fee from 20% in the parent class to 10%

	
}
