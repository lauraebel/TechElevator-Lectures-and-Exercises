package com.techelevator;

public class LectureLoops {

	public static void main(String[] args) {
		
		/*
		 * FOR LOOP
		 */
		
		// Sum all the numbers between 1 and 10

		System.out.println("Sum of numbers [0-10]: " + 0);

		
		// Sum all Even numbers in the range [0-100] using 3 different methods
		System.out.println();
		System.out.println("Sum all even numbers - 3 different ways");
		
		// Sum All Even numbers using modulus
		int sumEvenOne = 0;

		System.out.println("Sum of Even (first way)= " + sumEvenOne);
		
		
		// Sum All Even numbers by counting by 2s
		int sumEvenTwo = 0;

		System.out.println("Sum of Even (second way)= " + sumEvenTwo);
		
		
		// Sum All Even numbers by continuing on odds
		int sumEvenThree = 0;

		System.out.println("Sum of Even (third way)= " + sumEvenThree);
		
		
		// Print all 0 to 100 in reverse
		System.out.println();
		System.out.println("The numbers [0-100] printed in reverse");

		
		
		/*
		 * FOR LOOP WITH ARRAYS
		 */
		/* The instructors Array will be used to for the following problems */
		String[] instructors = new String[6];
		instructors[0] = "Steve";
		instructors[1] = "Rachelle";
		instructors[2] = "Stephanie";
		instructors[3] = "John";
		instructors[4] = "Andrew";
		instructors[5] = "Carson";
		
		// Print all the instructors
		System.out.println();
		System.out.println("\nPrint all the instructors");
		

		
		// Print all the odd instructors
		System.out.println();
		System.out.println("All the odd instructors");
		

		
		// Mark all the instructors in the Array as ODD or NOT ODD and print them in reverse
		System.out.println();
		System.out.println("The instructors marked as ODD or NOT ODD and Printed in Reverse");

		
		
		// Print all the first odd instructor
		System.out.println();
		System.out.println("The oddest instructor is ");
		

		
		
		/* The numbers Array will be used to for the following problems */
		int[] numbers = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 , 10 };
		
		
		// Double every number in the Array
		System.out.println();
		System.out.println("The doubled numbers in the array are:");
		

		
		// Print just the first half of the Array
		System.out.println();
		System.out.println();
		System.out.println("The first half of the array is:");

		
		// Print the Second half of numbers in the Array
		System.out.println();
		System.out.println();
		System.out.println("The second half of the array is:");

		
		
		
		
		/* The num2 Array will be used to for the following problems */
		int[] nums2 = new int[] { 1, 20, 3, 40, 5, 60, 7, 80, 9 , 10 };
		
		
		// Sum of all numbers that are 20 or larger in the nums2 array
		System.out.println();
		System.out.println();
		int sumOfGreaterThan20 = 0; 

		System.out.println("Sum of numbers 20 or greater in nums2: " + sumOfGreaterThan20);
		
		
		// CHALLENGE: Print all the numbers, but if we find a number >=20, then don't print the next number
		System.out.println();
		System.out.println("Nums2 without the numbers after numbers 20 or greater");

		
		// CHALLENGE: Triple every number that is divisible by 3 and print them
		System.out.println();
		System.out.println();
		System.out.println("Nums2 with every number divisible by 3 trippled");
		

		
		
		/* Use the instructors array for the following problem */
		// CHALLENGE: Print all the instructors in the Array using a break statement
		System.out.println();
		System.out.println();
		System.out.println("All the instructors printing using a break");
		

		
	}

}
