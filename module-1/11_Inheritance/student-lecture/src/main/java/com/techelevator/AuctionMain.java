package com.techelevator;
import java.util.Scanner;
public class AuctionMain {

	public static void main(String[] args) {

		BuyoutAuction auction = new BuyoutAuction("book", 12);

		Scanner in = new Scanner(System.in);

		System.out.println("Buy my " + auction.getItemForSale());

		while (true) {
			System.out.println("Enter your name >>>");
			String bidder = in.nextLine();

			System.out.println("Place a bid >>>");
			int amount = Integer.parseInt(in.nextLine());

			boolean isWinning = auction.placeBid(new Bid(bidder, amount));

			if (auction.getHighBid().getBidAmount() > 0) {
				System.out.println(auction.getHighBid().getBidder() + " is winning with a bid of "
						+ auction.getHighBid().getBidAmount());
			} else {
				System.out.println("No winning bid");
			}

		}

	}

}
