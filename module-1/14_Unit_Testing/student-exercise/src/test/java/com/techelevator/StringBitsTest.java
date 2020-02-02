package com.techelevator;

import org.junit.*;

/*
Given a string, return a new string made of every other char starting with the first, so "Hello" yields "Hlo".
GetBits("Hello") → "Hlo"
GetBits("Hi") → "H"
GetBits("Heeololeo") → "Hello"
*/

public class StringBitsTest {
		
		private StringBits stringBits;
		
		@Before
		public void setup() {
			stringBits = new StringBits();
		}
		@Test
		public void returns_every_other_for_string_of_9_letters() {
			String result = stringBits.getBits("Heeololeo");
			Assert.assertEquals("Hello", result);
		}
		@Test
		public void returns_every_other_for_string_of_3_letters() {
			String result = stringBits.getBits("Pie");
			Assert.assertEquals("Pe", result);
		}
		@Test
		public void returns_every_other_for_string_of_15_letters() {
			String result = stringBits.getBits("Congratulations");
			Assert.assertEquals("Cnrtltos", result);
		}
		@Test
		public void returns_that_letter_for_string_of_1_letter() {
			String result = stringBits.getBits("A");
			Assert.assertEquals("A", result);
		}
		@Test
		public void returns_every_other_for_string_of_all_uppercase_letters() {
			String result = stringBits.getBits("HELLO");
			Assert.assertEquals("HLO", result);
		}
		@Test
		public void returns_every_other_for_string_of_all_lowercase_letters() {
			String result = stringBits.getBits("laura");
			Assert.assertEquals("lua", result);
		}
		@Test
		public void returns_empty_string_for_string_with_no_letters() {
			String result = stringBits.getBits("");
			Assert.assertEquals("", result);
		}
		
		
		
		
}
