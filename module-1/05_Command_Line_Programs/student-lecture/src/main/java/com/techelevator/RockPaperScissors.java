package com.techelevator;

import java.util.Scanner;

public class RockPaperScissors {

	/*
	 * Command Line programs follow this structure:  Take Input, Calculate Data, Give Output
	 * 
	 * How could we use this structure, with what we know of Java, so far, to write a simple game
	 * like Rock, Paper, Scissors?
	 */
	
	// One game features needed: 1.Get user input 2.Computer's choice 3.Display choices 4.Determine winner 
	// 5.Display winner (congratulate)
	// 1.To get user input, import scanner
	
	// Multiple names: 1.Keep score 2.A way to stop 3.Display score
	
	public static void main(String[] args) {
		
		
		String[] choices = {"Rock", "Paper", "Scissors"};
		
		//Above changes it so it doesn't just show numbers but the actual words
		
		Scanner in = new Scanner(System.in);
		
		// To keep score, create a counter outside the loop so it is always adding
		int computerWins = 0;
		int playerWins = 0;
		
		// To play multiple games, use a loop and add an option that the User can select to quit
		while (true) {
			System.out.println("Select (1) Rock, (2) Paper, (3) Scissors, or (0) to Quit >>>");
		
		int userChoice = in.nextInt();
		in.nextLine(); //carriage return
		
		//below will populate if the User selects anything other than 1 2 or 3, the continue line brings 
		//up the possible choices again
		if (userChoice < 0 || userChoice > 3) {
			System.out.println("Invalid Choice, Plese Choose Again");
			continue;
		}
		
		if (userChoice == 0) {
			break;
		}
		// Step 1 is done above
		
		// To get computer's choice, below
		int computerChoice = (int) (Math.random() * 3) + 1;
		
		//Display choices 
		System.out.println("You chose " + choices[userChoice - 1] +
				" and the computer chose " + choices[computerChoice - 1]);
		
		if (userChoice == computerChoice) {
			//Tie
			System.out.println("Tie!");
			
		} else if ((userChoice == 1 && computerChoice == 3) ||
				   (userChoice == 2 && computerChoice == 1) ||
			    	(userChoice == 3 && computerChoice == 2)) {
			System.out.println("You win!... Congrats!");
			playerWins++;
			//above adds one to counter if player wins
			
			//only other option is that the computer won so use an else statement
		} else {
		System.out.println("Computer won...Sorry!");
		computerWins ++;
		}
		}
		//Below outside the while loop so if the User selects 0, it stops running and shows scores
		System.out.println("Total Player Wins: " + playerWins);
		System.out.println("Total Computer Wins: " + computerWins);
		System.out.println("Thank you for playing!"); 
	}
	}

