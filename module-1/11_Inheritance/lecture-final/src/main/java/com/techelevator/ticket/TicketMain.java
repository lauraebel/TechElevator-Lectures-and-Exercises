package com.techelevator.ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketMain {

	public static void main(String[] args) {
		
//		Ticket regularTicket = new Ticket( 10 );
//		
//		System.out.println("Price: " + regularTicket.getPrice());
//		System.out.println("Fee: " + regularTicket.getFee());
//		System.out.println("Total: " + regularTicket.getTotalPrice());
//		
//		WillCallTicket willCallTicket = new WillCallTicket( 10 , "Joe" );
//		
//		System.out.println("Price: " + willCallTicket.getPrice());
//		System.out.println("Fee: " + willCallTicket.getFee());
//		System.out.println("Total: " + willCallTicket.getTotalPrice());
//		System.out.println("Name: " + willCallTicket.getTicketHolderName());
//		
//		
//		UnderAgeTicket underAgeTicket = new UnderAgeTicket( 10, 2 );
//		
//		System.out.println("Price: " + underAgeTicket.getPrice());
//		System.out.println("Fee: " + underAgeTicket.getFee());
//		System.out.println("Total: " + underAgeTicket.getTotalPrice());

		
		Ticket regularTicket = new Ticket( 10 );
		Ticket willCallTicket = new WillCallTicket( 10 , "Joe" );
		Ticket underAgeTicket = new UnderAgeTicket( 10, 2 );
		
		List<Ticket> tickets = new ArrayList<Ticket>();
		tickets.add(regularTicket);
		tickets.add(willCallTicket);
		tickets.add(underAgeTicket);
		
		for (Ticket ticket : tickets) {
			System.out.println("Ticket Type: " + ticket.getType() + " Ticket");
			System.out.println("Price: " + ticket.getPrice());
			System.out.println("Fee: " + ticket.getFee());
			System.out.println("Total: " + ticket.getTotalPrice());
			
			if ( ticket instanceof WillCallTicket) {
				
				WillCallTicket wct = (WillCallTicket) ticket;
				
				System.out.println("Name: " + wct.getTicketHolderName());
			}
			
		}
		
		
	}

}
