package com.techelevator;


public class Lecture {

	public static void main(String[] args) {

		/* Object Instantiation */
		//public House(double area, String address, String color) {

		House houseAt443WinstonSt = new House(1800, "443 Winston St", "Cornflower Blue");
		House houseTwo = new House(2000, "123 Way St", "Orange");
		House houseFour = new House(2000, "123 Way St", "Orange");

		
		houseAt443WinstonSt.setNumberOfRooms(5);
		
		/* Value Type */
		int x = 10;
		
		double amount = 2.56d;
		
		int y = x;
		x = 20;
		
		/* Reference Type */
		int[] numbers = { 10, 20, 30 , 40 };
		int[] otherNumbers = numbers;
		numbers[1] = 99;
		otherNumbers[3] = 42;
		
		House houseThree = houseTwo;
		houseThree.setNumberOfRooms(10);
		houseTwo.setNumberOfRooms(20);
		
		if (houseTwo == houseFour) {
			System.out.print("they are equal"); //not equal so will not print
		};
		
		
		String firstName = "joe";		
		// firstName.toUpperCase(); - won't work because "joe" is immutable
		String upperCaseFirstName = firstName.toUpperCase(); //have to make a new variable
		
		
		String anotherFirstName = "sally";
		anotherFirstName = anotherFirstName.toUpperCase(); 
		//creates a copy, changes it to SALLY, and returns the location of this new object-updates anotherFirstName

		
		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");
		
		/* The String class gets special treatment in the Java language.  One 
		 * example of this is that there is a literal representation of a 
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes */
		
		String greeting = "Hello, World!";  // creates a new instance of String using a literal
		System.out.println("greeting : " + greeting);
		
		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();
		
		/* Below are examples of calling various String methods */
		
		System.out.println("***** charAt *****");
		
		String name = "Tech Elevator";
		char first = name.charAt(0);   // 'T' - charAt returns the character at the selected index in the array
		char fourth = name.charAt(3);  // 'h'
		System.out.println(name);
		System.out.println(first);
		System.out.println(fourth);
		
		/* length */
		int nameLength = name.length();
		System.out.println("The length of the String "  + name + " is " + nameLength);
		
		/* SubString */
		String s = "Tech Elevator";
		String subStringOfs = s.substring(5, 11);
		System.out.println(subStringOfs);
		
		String subStringToEnd = s.substring(5);
		System.out.println(subStringToEnd);
		
		/* Contains */
		System.out.println("***** contains *****");
		String hello = "Hello World!";
		System.out.println("hello : " + hello);
		
		boolean containsHello = hello.contains("Hello"); //case sensitive 
		System.out.println("containsHello : " + containsHello); //returns true
		
		boolean containsBogus = hello.contains("bogus");
		System.out.println("containsBogus : " + containsBogus); //returns false because the string does not have this word
		
		/* Other commonly used methods:
		 * 
		 * endsWith() // these are booleans
		 * startsWith() // these are booleans
		 */
		System.out.println("Hello starts with Hello:" + hello.startsWith("Hello")); 
		
		/* indexOf() - Gives the index of the first occurrence of this string
		 * lastIndexOf() - Gives us the index of the last time this string exists
		 */ 
		
		int index = hello.indexOf("l");
		System.out.println("Index of l in Hello World is: " + index);
		
		int lastIndex = hello.lastIndexOf("l");
		System.out.println("Last Index of l: " + lastIndex);
		
		 /* 
		 * replace()
		 */
		
		String q = "abcdef";
		q = q.replace("d", "T");
		System.out.println("Changed: " + q);
		
		/*
		 * toLowerCase()
		 * toUpperCase()
		 */
		
		 // equals and equalsIgnoreCase()
		
		 // split() - divides a string 
		String countDown = "one two three four five";
		String[] splitCountDown = countDown.split(" ");
		System.out.println("New stuff: " + countDown);
		
		 // trim() - Removes white space from the end
		
		// String.join()  <-- available only on the String class and not the string object
		// creates a new string out of other strings 
		// Not used a lot in Java
		 
		String joinedString = String.join("--->", "Five", "Four", "Three");
		System.out.println(joinedString);
		
		
		
		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();
		
		
		char[] helloArray = new char[] { 'H', 'e', 'l', 'l', 'o' };
		String hello1 = new String(helloArray);
		String hello2 = new String(helloArray);
		

		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? */
		
		if(hello1 == hello2) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1+" is not equal to "+hello2);
		}
		
		String hello3 = hello1;
		if(hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}
		
		
		/* So, to compare the values of two objects, we need to use the equals method (.equals)
		 * Every object type has an equals method */
		
		// contain the same test but DO NOT reference the same thing
		
		if(hello1.equals(hello2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1+" is not equal to "+hello2);
		}
		
	}
}
