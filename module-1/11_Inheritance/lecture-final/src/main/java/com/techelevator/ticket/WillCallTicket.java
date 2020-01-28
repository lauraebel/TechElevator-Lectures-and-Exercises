package com.techelevator.ticket;

import java.math.BigDecimal;

public class WillCallTicket extends Ticket {

	private String ticketHolderName;
	
	public WillCallTicket(double price, String ticketHolderName) {
		super(price, "Will Call");
		this.ticketHolderName = ticketHolderName;
	}
	
	public String getTicketHolderName() {
		return this.ticketHolderName;
	}
	
	@Override
	public BigDecimal getFee() {
		return super.getPrice().multiply( new BigDecimal( .10 ) );
	}
	
}
