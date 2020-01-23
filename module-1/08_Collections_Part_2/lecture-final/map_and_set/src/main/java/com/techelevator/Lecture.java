package com.techelevator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("       MAPS");
		System.out.println("####################");
		System.out.println();
		
		/* DECLARING AND INSTANTIATING A MAP */
		Map<String, String> animalNoises = new HashMap<String, String>();
		
		/* ADDING ITEMS TO A MAP */
		animalNoises.put( "Cow", "Moo" );
		animalNoises.put( "Chicken", "Cluck" );
		animalNoises.put( "Dog", "Bark" );
		animalNoises.put( "Cat", "Meow" );
		// Keys must be unique, but the values do not
		animalNoises.put( "Lion", "Roar" );
		animalNoises.put( "Duck", "Roar" );
		
		/* UPDATING AN ITEM IN A MAP */
		// Can update an existing value by using the same key
		animalNoises.put( "Duck", "Quack" );

		/* RETRIEVING AN ITEM FROM A MAP */
		// Retrieve values from the map using the key and the get() method
		// When the key is a String, CASE is important
		String catNoise = animalNoises.get( "Cat" );
		
		System.out.println(catNoise);

		System.out.println( animalNoises.get("Duck") );
		
		// If key does not exist in the map, then get() returns null
		String owlNoise = animalNoises.get( "Owl" );
		System.out.println( owlNoise );
			
		/* REMOVING AN ITEM FROM A MAP */
		// When an item is removed using the key, .remove( key ), if the key 
		// exists the value is returned
		String lionNoise = animalNoises.remove( "Lion" );
		System.out.println(lionNoise);
		
		animalNoises.remove( "Duck" );
		
		// If the key does not exists, the null returned
		System.out.println( "Lion afer remove: " + animalNoises.remove( "Lion") );
		
		
		/* CHECK IF AN ITEM EXISTS */
		// containsKey(key) returns TRUE if the KEY exists in the Map
		System.out.println( "Does Cat Exist: " + animalNoises.containsKey( "Cat" ) );
		// containsValue(value) returns TRUE if the VALUE exists in the Map
		System.out.println( "Does Meow Exist: " + animalNoises.containsValue( "Meow" ) );
		
		System.out.println();
		
		
		/* LOOPING OVER A MAP */
		// Loop through a map by looping through the Keys
		// Then using the keys to get the value
		for (String animal : animalNoises.keySet()) {
			String noise = animalNoises.get( animal );
			System.out.println("The " + animal + " says " + noise);
		}

		
		System.out.println();
		
		/* THE MAP KEY AND VALUE DATA TYPES */
		// Key and Value do not need to be the same type, but both must be Reference Types
		for( Entry<String, String> entry : animalNoises.entrySet() ) {
			System.out.println("The " + entry.getKey() + " says " + entry.getValue() );
		}
		
		
		System.out.println();
		System.out.println("####################");
		System.out.println("      MAP ORDER     ");
		System.out.println("####################");
		System.out.println();
	
		/*
		 * The Order that a Map stores the keys is dependent on the Implementation class used.
		 * 
		 * HashMap - does not retain order
		 * LinkedHashMap - retains the order of insertion
		 * TreeMap - maintains Natural Order for the Data Type of the key
		 */
		
		System.out.println("The values where inserted in the following order: 2, 10, 25, 1");
		
		System.out.println();
		System.out.println("  HASHMAP");
		System.out.println("Does not retain any order.  Instead it uses it's own internal ordering");
		
		Map<Integer, String> hashMapNumbersToWords = new HashMap<Integer, String>();
		
		hashMapNumbersToWords.put(2,  "Two");
		hashMapNumbersToWords.put(10, "Ten");
		hashMapNumbersToWords.put(25, "Twenty-Five");
		hashMapNumbersToWords.put(1,  "One");
		
		for (Integer number : hashMapNumbersToWords.keySet()) {
			System.out.println(number + " is " + hashMapNumbersToWords.get(number));
		}		
		
		
		System.out.println();
		System.out.println("  LINKED HASHMAP");
		System.out.println("Retains the Order of Insertion");

		Map<Integer, String> linkedHashMapNumbersToWords = new LinkedHashMap<Integer, String>();
		
		linkedHashMapNumbersToWords.put(2,  "Two");
		linkedHashMapNumbersToWords.put(10, "Ten");
		linkedHashMapNumbersToWords.put(25, "Twenty-Five");
		linkedHashMapNumbersToWords.put(1,  "One");
		
		for (Integer number : linkedHashMapNumbersToWords.keySet()) {
			System.out.println(number + " is " + linkedHashMapNumbersToWords.get(number));
		}	
		
		
		System.out.println();
		System.out.println("  TREEMAP");
		System.out.println("Maintains the Natural Order of the Data Type");
		System.out.println();
		System.out.println("Natural Order when numbers are Integer");
		
		Map<Integer, String> treeMapNumbersToWords = new TreeMap<Integer, String>();
		
		treeMapNumbersToWords.put(2,  "Two");
		treeMapNumbersToWords.put(10, "Ten");
		treeMapNumbersToWords.put(25, "Twenty-Five");
		treeMapNumbersToWords.put(1,  "One");
		
		for (Integer number : treeMapNumbersToWords.keySet()) {
			System.out.println(number + " is " + treeMapNumbersToWords.get(number));
		}	


		System.out.println();
		System.out.println("TreeMap Natural Order when numbers are String");

		Map<String, String> treeMapNumbersAsStrings = new TreeMap<String, String>();
		
		treeMapNumbersAsStrings.put("2",  "Two");
		treeMapNumbersAsStrings.put("10", "Ten");
		treeMapNumbersAsStrings.put("25", "Twenty-Five");
		treeMapNumbersAsStrings.put("1",  "One");
		
		for (String number : treeMapNumbersAsStrings.keySet()) {
			System.out.println(number + " is " + treeMapNumbersAsStrings.get(number));
		}	

	
		
		System.out.println();		
		System.out.println("####################");
		System.out.println("       SETS");
		System.out.println("####################");
		System.out.println();

		/* DECLARE AND INSTANTIATE A SET */
			// HashSet - No order, no duplicates, allows null
		//Set<Integer> setOfNumbers = new HashSet<Integer>();
		
			// LinkedHashSet - Order of insertion, no duplications, allows null
		//Set<Integer> setOfNumbers = new LinkedHashSet<Integer>();
		
			// TreeSet - Natural Order of Data Type, no duplicates, does not allow null
		Set<Integer> setOfNumbers = new TreeSet<Integer>();
		
		
		
		/* ADD ITEMS TO THE SET */
		// Elements are added with add()
		setOfNumbers.add(1);
		setOfNumbers.add(10);
		setOfNumbers.add(301);
		// Duplicates will be ignored
		setOfNumbers.add(301);
		setOfNumbers.add(42);
		setOfNumbers.add(5708);

		
		/* LOOP OVER A SET */
		for (Integer number : setOfNumbers) {
			System.out.println(number);
		}

		
		/*USE CASE:  USE A SET TO REMOVE DUPLICATES AND ORDER THE ARRAY */
		String[] instructors = {"Rachelle", "John", "Andrew", "John", "Stephanie", "Rachelle", "Steve", "John", "Steve" };
		
		Set<String> instructorSet = new TreeSet<String>();
		for (String instructor : instructors) {
			instructorSet.add(instructor);
		}
		
		for (String instructor: instructorSet) {
			System.out.println(instructor);
		}


		

	}

}
