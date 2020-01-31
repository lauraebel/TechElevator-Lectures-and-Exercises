package com.techelevator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.*;

public class LectureTest {

	private Lecture lecture;
	
	@Before
	public void setup() {
		lecture = new Lecture();
	}
	
	/*
	   8. Return true if the given non-negative number is a multiple of 3 or a multiple of 5.
	   (Hint: Think "mod".)
	   or35(3) → true
	   or35(10) → true
	   or35(8) → false
	   */
	

	// negative multiple of 3
	// 0 
	@Test
	public void multiple_of_3_but_not_5_returns_true() {
		boolean result = lecture.or35( 9 );
		Assert.assertTrue( result );
	}
	
	@Test
	public void multiple_of_5_but_not_3_return_true() {
		boolean result = lecture.or35( 25 );
		Assert.assertTrue( result );
	}
	
	@Test
	public void multiple_of_3_and_5_returns_true() {
		boolean result = lecture.or35( 15 );
		Assert.assertTrue( result );
	}
	
	@Test
	public void not_a_multiple_of_3_or_5_returns_false() {
		boolean result = lecture.or35( 7 );
		Assert.assertFalse( result );
	}
	
	@Test
	public void zero_returns_true() {
		Assert.assertTrue( lecture.or35(0) );
	}
	
	@Test
	public void negative_multiple_3_return_false() {
		Assert.assertFalse( lecture.or35( -9 ) );
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
	// Birthday - 85 - returns 1
	// 61-80 - return 1
	// 
	@Test
	public void not_birthday_85_results_in_large_ticket() {
		int result = lecture.caughtSpeeding( 85, false );
		Assert.assertEquals("Did not get large ticket", 2, result);
	}
	
	@Test
	public void birthday_and_85_results_in_medium_ticket() {
		int result = lecture.caughtSpeeding( 85, true );
		Assert.assertEquals(1, result);
	}
	
	/*
	 Given a string, return the string made of its first two chars, so the String "Hello" yields "He". If the
	 string is shorter than length 2, return whatever there is, so "X" yields "X", and the empty string ""
	 yields the empty string "". Note that str.length() returns the length of a string.
	 firstTwo("Hello") → "He"
	 firstTwo("abcdefg") → "ab"
	 firstTwo("ab") → "ab"
	 */
	
	@Test
	public void string_longer_than_2() {
		String result = lecture.firstTwo( "Hello" );
		Assert.assertEquals("He", result);
	}
	
	@Test
	public void string_of_length_1() {
		Assert.assertEquals( "+", lecture.firstTwo("+") );
	}
	
	/* Using Assert Fails */
	public void empty_string() {
		String result = lecture.firstTwo("");
		if (result.equals("")) {
			// Test passes
		} else {
			Assert.fail("Empty string did not return empty string");
		}
	}
	
	/*
	 Given an array of Strings, return an ArrayList containing the same Strings in the same order
	 except for any words that contain exactly 4 characters.
	 no4LetterWords( {"Train", "Boat", "Car"} )  ->  ["Train", "Car"]
	 no4LetterWords( {"Red", "White", "Blue"} )  ->  ["Red", "White"]
	 no4LetterWords( {"Jack", "Jill", "Jane", "John", "Jim"} )  ->  ["Jim"]
	 */
	@Test
	public void list_does_not_include_4_letter_words() {
		
		// Arrange
		String[] words = {"Train", "Boat", "Car" };
		String[] wordsNo4Letters = { "Train", "Car" };
		
		// Act
		List<String> resultList = lecture.no4LetterWords( words );
		
		// Assert
		Assert.assertTrue( resultList instanceof List );
		String[] resultAsArray = resultList.toArray( new String[resultList.size()]);
		
		Assert.assertArrayEquals( wordsNo4Letters, resultAsArray );
		
		
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
	@Test
	public void give_half_of_peters_money_to_paul() {
		
		// Arrange
		Map<String, Integer> peterPaul = new HashMap<String, Integer>();
		peterPaul.put("Peter", 2000);
		peterPaul.put("Paul", 99);
		
		// Act
		Map<String, Integer> resultMap = lecture.robPeterToPayPaul(peterPaul);
		
		// Assert
		Assert.assertEquals(new Integer(1000), resultMap.get("Peter"));
		Assert.assertEquals(new Integer(1099), resultMap.get("Paul"));
		
	}
	
	/* Assert with Double */
	@Test
	public void third_of_9_is_3() {
		double result = lecture.thirdDouble( 9 );
		Assert.assertEquals(3, result, 0);
	}
	
	@Test
	public void third_of_5_is_1_66() {
		double result = lecture.thirdDouble( 5 );
		Assert.assertEquals(1.66, result, 2);
	}
	
	/* Testing with custom objects */
	@Test
	public void returns_correct_dog() {
		Dog ourDog = new Dog("Fiddo", "Mutt", 7);
		Dog returnedDog = lecture.returnOurDog(ourDog);
		
		// Require .equals Override in Dog class
		// Assert.assertEquals(ourDog, returnedDog);
		
		assertDogsEquals(ourDog, returnedDog);

	}
	
	private void assertDogsEquals(Dog expected, Dog actual) {
		Assert.assertEquals(expected.getName(), actual.getName());
		Assert.assertEquals(expected.getBreed(), actual.getBreed());
		Assert.assertEquals(expected.getAge(), actual.getAge());
	}
	

	@Test
	public void returns_correct_dog_with_equals() {
		Dog ourDog = new Dog("Fiddo", "Mutt", 7);
		Dog returnedDog = lecture.returnOurDog(ourDog);
		
		// Require .equals Override in Dog class
		Assert.assertEquals(ourDog, returnedDog);

	}
}