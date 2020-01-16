package com.techelevator;

public class LectureLoops {

	public static void main(String[] args) {
		
		/*
		 * FOR LOOP
		 */
		
		// Sum all the numbers between 1 and 10
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			//int sum = 0; this just keeps creating the variable as 0 to move outside block
			sum += i;
		}
		
		System.out.println("Sum of numbers [0-10]: " + sum);

		
		// Sum all Even numbers in the range [0-100] using 3 different methods
		System.out.println();
		System.out.println("Sum all even numbers - 3 different ways");
		
		// Sum All Even numbers using modulus
		int sumEvenOne = 0;

		for (int i = 0; i <= 100; i++) {
			if (i % 2 == 0) {
				sumEvenOne =+ i;
			}
		}
		System.out.println("Sum of Even (first way)= " + sumEvenOne);
		
		
		// Sum All Even numbers by counting by 2s
		int sumEvenTwo = 0;
		
		for (int i = 2; i <= 100; i += 2)
			sumEvenTwo += i;

		System.out.println("Sum of Even (second way)= " + sumEvenTwo);
		
		
		// Sum All Even numbers by continuing on odds
		int sumEvenThree = 0;
		for (int i = 0; i < 101; i++) {
			if (i % 2 != 0) {
				continue;
			}
			sumEvenThree +=i;
		}
		System.out.println("Sum of Even (third way)= " + sumEvenThree);
		
		
		// Print all 50 to 100 in reverse
		System.out.println();
		System.out.println("The numbers [50-100] printed in reverse");

		for (int i = 100; i >= 0; i--) {
			if (i < 50) {
				break;
			}
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i = 100; i >= 50; i--) {
			System.out.print(i + " ");
		}
		
		/*
		 * FOR LOOP WITH ARRAYS
		 */
		/* The instructors Array will be used for the following problems */
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
		
		for (int i = 0; i < instructors.length; i++) {
			System.out.println(instructors[i]);
		}
		
		// Print all the odd instructors
		System.out.println();
		System.out.println("All the odd instructors");
		
		for (int i = 0; i < instructors.length; i++) {
			if (i % 2 == 1) {
				System.out.println(instructors[i]);
			}
		}
		
		// Mark all the instructors in the Array as ODD or NOT ODD and print them in reverse
		System.out.println();
		System.out.println("The instructors marked as ODD or NOT ODD and Printed in Reverse");

		for (int i = 0; i < instructors.length; i++) {
			if (i % 2 == 0) {
				instructors[i] = instructors[i] + " NOT ODD";
			} else {
				instructors[i] = instructors[i] + " ODD";
			}
		} 
		for (int i = 0; i < instructors.length; i++) {
			System.out.println(instructors[i]);
		}
		
		// Print the first odd instructor
		System.out.println();
		System.out.println("The oddest instructor is ");
		
		for (int i = 0; i < instructors.length; i++) {
			if (i % 2 == 1) {
				System.out.println(instructors[i]);
				break;
			}
		}		
		
		/* The numbers Array will be used to for the following problems */
		int[] numbers = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 , 10 };
		
		
		// Double every number in the Array
		
		System.out.println();
		System.out.println("The doubled numbers in the array are:");
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = numbers[i] * 2;
					System.out.println(numbers[i]);
		}
		//Double values and put them in a new array
		
		int[] doubleNumbers = new int [numbers.length];
		for (int i = 0; i <numbers.length; i++) {
			doubleNumbers[i] = numbers[i] *2;
		}
		
		// Print just the first half of the Array
		System.out.println();
		System.out.println();
		System.out.println("The first half of the array is:");

		for (int i = 0; i < numbers.length / 2; i++) {
			System.out.println(numbers[i] + " ");
		}
		
		// Print the Second half of numbers in the Array
		System.out.println();
		System.out.println();
		System.out.println("The second half of the array is:");

		            //below is the second half of the array
		for (int i = numbers.length / 2; i < numbers.length; i++) {
			System.out.println(numbers[i] + " ");
		}
		
		
		/* The num2 Array will be used to for the following problems */
		int[] nums2 = new int[] { 1, 20, 3, 40, 5, 60, 7, 80, 9 , 10 };
		
		
		// Sum of all numbers that are 20 or larger in the nums2 array
		System.out.println();
		System.out.println();
		int sumOfGreaterThan20 = 0; 

		// Here we don't care about the INDEX but the VALUE
		for (int i = 0; i < nums2.length; i++) {
			if (nums2[i] >= 20) {
				sumOfGreaterThan20 += nums2[i];
			}
		}
		System.out.println("Sum of numbers 20 or greater in nums2: " + sumOfGreaterThan20);
		
		// CHALLENGE: Print all the numbers, but if we find a number >=20, then don't print the NEXT number
		System.out.println();
		System.out.println("Nums2 without the numbers after numbers 20 or greater");
		// Here we care about the VALUES and then we need to CHANGE the index depending on the value
		
		for (int i = 0; i < nums2.length; i++) {
			System.out.println(nums2[i] + " ");
			if (nums2[i] >= 20) {
				i++; //increment again if >=20
			}
		}
		
		// CHALLENGE: Triple every number that is divisible by 3 and print them
		System.out.println();
		System.out.println();
		System.out.println("Nums2 with every number divisible by 3 tripled");
		// Here we care about the INDEX AND the VALUE
		
		for (int i = 0; i < nums2.length; i++) {
			if (nums2[i] % 3 == 0) {
				System.out.println(nums2[i] * 3 + " ");
			} else {
				System.out.println(nums2[i] + " ");
			}
		}
		
		/* Use the instructors array for the following problem */
		// CHALLENGE: Print all the instructors in the Array using a break statement
		System.out.println();
		System.out.println();
		System.out.println("All the instructors printing using a break");
		
		int i = 0;
		for ( ; true ; ) {
			System.out.println(instructors[i]);
			i++;
			if (i >= instructors.length) {
				break;
			}
		}
		
	}

}
