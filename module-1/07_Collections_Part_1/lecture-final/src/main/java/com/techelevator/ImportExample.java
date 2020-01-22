package com.techelevator;

import java.util.Scanner;
import com.techelevator.data.NumberCruncher;

import java.util.*;

public class ImportExample {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Pick a whole number?");
		
		String userChoice = in.nextLine();
		int number = Integer.parseInt(userChoice);
		
		NumberCruncher numberCruncher = new NumberCruncher();
		Integer newNumber = numberCruncher.multiplyNumberBy10(number);
		
		System.out.println("Your number multiplied by 10 is " + newNumber);

	}

}
