package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Lecture {
  
   
	   /*
	   8. Return true if the given non-negative number is a multiple of 3 or a multiple of 5.
	   (Hint: Think "mod".)
	   or35(3) → true
	   or35(10) → true
	   or35(8) → false
	   */
	  public boolean or35(int n) {
	      return (n % 3 == 0) || (n % 5 == 0);
	  }
	  
	  
	    /*
	     19. You are driving a little too fast, and a police officer stops you. Write code to compute the result,
	     encoded as an int value: 0=no ticket, 1=small ticket, 2=big ticket. If speed is 60 or less, the
	     result is 0. If speed is between 61 and 80 inclusive, the result is 1. If speed is 81 or more, the
	     result is 2. Unless it is your birthday -- on that day, your speed can be 5 higher in all cases.
	     caughtSpeeding(60, false) → 0
	     caughtSpeeding(65, false) → 1
	     caughtSpeeding(65, true) → 0
	     */
	    public int caughtSpeeding(int speed, boolean isBirthday) {
	        int adjustedSpeed = isBirthday ? speed - 5 : speed;

	        int result = 0;

	        if (adjustedSpeed > 60 && adjustedSpeed <= 80) {
	            result = 1;
	        } else if (adjustedSpeed >= 81) {
	            result = 2;
	        }

	        return result;

	    }
	    
		/*
		 Given a string, return the string made of its first two chars, so the String "Hello" yields "He". If the
		 string is shorter than length 2, return whatever there is, so "X" yields "X", and the empty string ""
		 yields the empty string "". Note that str.length() returns the length of a string.
		 firstTwo("Hello") → "He"
		 firstTwo("abcdefg") → "ab"
		 firstTwo("ab") → "ab"
		 */
		public String firstTwo(String str) {
			if (str.length() < 2) return str;
			return str.substring(0, 2);
		}
	    
		/*
		 Given an array of Strings, return an ArrayList containing the same Strings in the same order
		 except for any words that contain exactly 4 characters.
		 no4LetterWords( {"Train", "Boat", "Car"} )  ->  ["Train", "Car"]
		 no4LetterWords( {"Red", "White", "Blue"} )  ->  ["Red", "White"]
		 no4LetterWords( {"Jack", "Jill", "Jane", "John", "Jim"} )  ->  ["Jim"]
		 */
		public List<String> no4LetterWords(String[] stringArray) {
			List<String> no4LetterWordList = new ArrayList<>();
			for (int i = 0; i < stringArray.length; i++) {
				if (stringArray[i].length() != 4) {
					no4LetterWordList.add(stringArray[i]);
				}
			}
			return no4LetterWordList;
		}
		
		/*
		 * Modify and return the given Map as follows: if "Peter" has more than 0 money, transfer half of it to "Paul",
		 * but only if Paul has less than $10s.
		 *
		 * Note, monetary amounts are specified in cents: penny=1, nickel=5, ... $1=100, ... $10=1000, ...
		 *
		 * robPeterToPayPaul({"Peter": 2000, "Paul": 99}) → {"Peter": 1000, "Paul": 1099}
		 * robPeterToPayPaul({"Peter": 2000, "Paul": 30000}) → {"Peter": 2000, "Paul": 30000}
		 *
		 */
		public Map<String, Integer> robPeterToPayPaul(Map<String, Integer> peterPaul) {
			int petersMoney = peterPaul.get("Peter");
			int paulsMoney = peterPaul.get("Paul");

			if (petersMoney > 0 && paulsMoney < 1000) {
				int moneyToPayPaul = petersMoney / 2;
				peterPaul.put("Paul", moneyToPayPaul + paulsMoney);
				peterPaul.put("Peter", petersMoney - moneyToPayPaul);
			}

			return peterPaul;
		}
		
		public double thirdDouble(double num) {
			return num / 3;
		}
		
		public Dog returnOurDog(Dog dog) {
			return new Dog(dog.getName(), dog.getBreed(), dog.getAge());
		}
}
