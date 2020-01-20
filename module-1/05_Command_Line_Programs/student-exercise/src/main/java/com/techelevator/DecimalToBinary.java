package com.techelevator;
import java.util.Scanner;

//Write a command line program which prompts the user for a series of decimal integer values separated by spaces. 
//Each decimal integer is displayed along with its equivalent binary value

//460 in binary is 111001100
//8218 in binary is 10000000011010
//1 in binary is 1
//31313 in binary is 111101001010001
//987654321 in binary is 111010110111100110100010110001

// while number / 2 does not equal 0, keep dividing
// once the number/2 ==0, stop and enter 1 and 0s in reverse

// if userInt%2 == 1, 1 returns
// if userInt%2 == 0, 0 returns

public class DecimalToBinary {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Please enter a number: ");
		String userInput = in.nextLine();
		
	    int userInteger = Integer.parseInt(userInput);

		for (int i = userInteger; i > 0; i /= 2) {

			if (i%2 == 1) {
			System.out.print(1);
			
			} if (i%2 == 0) {
			System.out.print(0);

	}
		}
}
}