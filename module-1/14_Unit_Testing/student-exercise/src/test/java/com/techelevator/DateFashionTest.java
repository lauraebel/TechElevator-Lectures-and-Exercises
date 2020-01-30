package com.techelevator;

import org.junit.*;


/*
You and your date are trying to get a table at a restaurant. The parameter "you" is the stylishness
of your clothes, in the range 0..10, and "date" is the stylishness of your date's clothes. The result
getting the table is encoded as an int value with 0=no, 1=maybe, 2=yes. If either of you is very
stylish, 8 or more, then the result is 2 (yes). With the exception that if either of you has style of
2 or less, then the result is 0 (no). Otherwise the result is 1 (maybe).
dateFashion(5, 10) → 2
dateFashion(5, 2) → 0
dateFashion(5, 5) → 1
*/

//Style 0-10
//my style 8-10 - 2
//date style 8-10 - 2
//my style 3-7 - 1
//date style 3-7 -1 
//my style 0-2 - 0
//date style 0-2 - 0

public class DateFashionTest {
	
	private DateFashion date;

	@Before
	public void setup() {
		date = new DateFashion();
	}
	@Test
	public void if_both_people_have_fashion_of_8_we_will_get_a_table() {
		int result = date.getATable(8, 8);
		Assert.assertEquals(2, result);
	}
	@Test
	public void if_both_people_have_fashion_of_10_we_will_get_a_table() {
		int result = date.getATable(10, 10);
		Assert.assertEquals(2, result);
	}
	@Test
	public void if_both_people_have_fashion_of_9_we_will_get_a_table() {
		int result = date.getATable(9, 9);
		Assert.assertEquals(2, result);
	}
	@Test
	public void if_both_people_have_fashion_of_7_we_might_get_a_table() {
		int result = date.getATable(7, 7);
		Assert.assertEquals(1, result);
	}
	@Test
	public void if_both_people_have_fashion_of_6_we_might_get_a_table() {
		int result = date.getATable(6, 6);
		Assert.assertEquals(1, result);
	}
	@Test
	public void if_both_people_have_fashion_of_3_we_might_get_a_table() {
		int result = date.getATable(3, 3);
		Assert.assertEquals(1, result);
	}
	@Test
	public void if_both_people_have_fashion_of_2_we_will_not_get_a_table() {
		int result = date.getATable(2, 2);
		Assert.assertEquals(0, result);
	}
	@Test
	public void if_both_people_have_fashion_of_1_we_will_not_get_a_table() {
		int result = date.getATable(1, 1);
		Assert.assertEquals(0, result);
	}
	@Test
	public void if_both_people_have_fashion_of_0_we_will_not_get_a_table() {
		int result = date.getATable(0, 0);
		Assert.assertEquals(0, result);
	}
	@Test
	public void if_both_people_have_fashion_of_negative_numbers_we_will_not_get_a_table() {
		int result = date.getATable(-2, -9);
		Assert.assertEquals(0, result);
	}
	@Test
	public void if_one_person_fashion_of_10_and_other_person_has_fashion_of_7_we_will_get_a_table() {
		int result = date.getATable(10, 7);
		Assert.assertEquals(2, result);
	}
	@Test
	public void if_one_person_has_fashion_of_10_and_other_person_has_fashion_of_3_we_will_get_a_table() {
		int result = date.getATable(10, 3);
		Assert.assertEquals(2, result);
	}
	@Test
	public void if_one_person_has_fashion_of_10_and_other_person_has_fashion_of_2_we_will_not_get_a_table() {
		int result = date.getATable(10, 2);
		Assert.assertEquals(0, result);
	}
	@Test
	public void if_one_person_has_fashion_of_10_and_other_person_has_fashion_of_negative_we_will_not_get_a_table() {
		int result = date.getATable(10, -2);
		Assert.assertEquals(0, result);
	}
	@Test
	public void if_both_people_have_fashion_of_11_we_will_get_a_table() {
		int result = date.getATable(11, 11);
		Assert.assertEquals(2, result);
	}//technically the above should not pass per the question (0-10) but the code allows it
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
