package com.techelevator;

import org.junit.*;

public class AnimalGroupNameTest {

	private AnimalGroupName animal;
	
	@Before
	public void setup() {
		animal = new AnimalGroupName();
	}
	//getHerd
	@Test
	public void if_the_animal_is_not_in_the_map_it_will_return_unkown() {
		String group = animal.getHerd("pig");
		Assert.assertEquals("unknown", group);
	}
	@Test
	public void if_the_animal_name_is_spelled_wrong_it_is_unknown() {
		String group = animal.getHerd("rino");
		Assert.assertEquals("unknown", group);
	}
	@Test
	public void if_the_animal_name_is_in_all_capital_letters_the_group_will_still_return_correctly() {
		String group = animal.getHerd("CROW");
		Assert.assertEquals("Murder", group);
	}
	@Test
	public void if_the_animal_name_is_in_all_lowercase_letters_the_group_will_still_return_correctly() {
		String group = animal.getHerd("dog");
		Assert.assertEquals("Pack", group);
	}
	@Test
	public void if_the_animal_name_has_a_mix_of_lowercase_and_capital_letters_the_group_will_still_return_correctly() {
		String group = animal.getHerd("RhInO");
		Assert.assertEquals("Crash", group);
	}
	@Test
	public void if_the_name_is_plural_it_will_return_unknown() {
		String group = animal.getHerd("giraffes");
		Assert.assertEquals("unknown", group);
	}
	@Test
	public void if_animal_name_string_is_empty_it_will_return_unknown() {
		String group = animal.getHerd("");
		Assert.assertEquals("unknown", group);
	}
	@Test
	public void giraffe_returns_the_correct_group() {
		String group = animal.getHerd("giraffe");
		Assert.assertEquals("Tower", group);
	}
	@Test
	public void elephant_returns_the_correct_group() {
		String group = animal.getHerd("elephant");
		Assert.assertEquals("Herd", group);
	}
	@Test
	public void pigeon_returns_the_correct_group() {
		String group = animal.getHerd("pigeon");
		Assert.assertEquals("Kit", group);
	}
	@Test
	public void flamingo_returns_the_correct_group() {
		String group = animal.getHerd("flamingo");
		Assert.assertEquals("Pat", group);
	}
	@Test
	public void deer_returns_the_correct_group() {
		String group = animal.getHerd("deer");
		Assert.assertEquals("Herd", group);
	}
	@Test
	public void crocodile_returns_the_correct_group() {
		String group = animal.getHerd("crocodile");
		Assert.assertEquals("Float", group);
	}
	@Test
	public void lion_returns_the_correct_group() {
		String group = animal.getHerd("lion");
		Assert.assertEquals("Pride", group);
	}
	//^^^Error in code- lions are listed as being in herds in the map but supposed to be prides
	//So this test fails
	
	
	
	
	
	
	
	
	
	

}
