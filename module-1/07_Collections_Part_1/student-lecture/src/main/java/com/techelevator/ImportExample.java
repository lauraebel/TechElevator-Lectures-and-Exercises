package com.techelevator;

import java.util.Scanner;
import com.techelevator.data.NumberCruncher;

import java.util.*;

public class ImportExample {
	
	public static void main(String[] args) {
		
		//Now we can just say Scanner from here on out since we put the fully qualified name above
		Scanner in = new Scanner(System.in);
		
		System.out.println("Pick a whole number:");
		
		String userChoice = in.nextLine();
		int number = Integer.parseInt(userChoice);
		
		//Now we can just say NumberCruncher from here on out since we put the fully qualified name above
		NumberCruncher numberCruncher = new NumberCruncher();
		Integer newNumber = numberCruncher.multiplyNumberBy10(number);
		
		System.out.println("Your number multiplied by 10 is " + newNumber);

	}

}
