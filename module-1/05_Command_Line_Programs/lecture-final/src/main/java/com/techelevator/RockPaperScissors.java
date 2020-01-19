package com.techelevator;

import java.util.Scanner;

public class RockPaperScissors {

	/*
	 * Command Line programs follow this structure:  Take Input, Calculate Data, Give Output
	 * 
	 * How could we use this structure, with what we know of Java, so far, to write a simple game
	 * like Rock, Paper, Scissors?
	 */
	public static void main(String[] args) {
		
		String[] choices = { "Rock", "Paper", "Scissors" };
		
		Scanner in = new Scanner( System.in );
		
		int computerWins = 0;
		int playerWins = 0;
		
		while (true) {
			System.out.println("Select (1) Rock, (2) Paper, (3) Scissors, or (0) to Quit >>>");
			
			int userChoice = in.nextInt();
			in.nextLine();
			
			if (userChoice < 0 || userChoice > 3) {
				System.out.println("Invalid Choice");
				continue;
			}
			
			if (userChoice == 0) {
				break;
			}
			
			
			int computerChoice = (int) (Math.random() * 3) + 1;
			
			System.out.println("You choose " + choices[userChoice - 1] + 
					" The computer choose " + choices[computerChoice - 1]);
			
			if (userChoice == computerChoice) {
				// Tie
				System.out.println("Tie!");
			} else if ( (userChoice == 1 && computerChoice == 3) ||
							(userChoice == 2 && computerChoice == 1) ||
							(userChoice == 3 && computerChoice == 2)) {
				System.out.println("You Win... Congratulations!");
				playerWins++;
			} else {
				System.out.println("The Computer Won!");
				computerWins++;
			}
		}
		
		System.out.println("Total Player Wins: " + playerWins);
		System.out.println("Total Computer Wins: " + computerWins);
		System.out.println("Thank you for playing!");
		
	}
}
