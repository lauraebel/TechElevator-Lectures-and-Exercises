package com.techelevator;
    /*
     When squirrels get together for a party, they like to have cigars. A squirrel party is successful
     when the number of cigars is between 40 and 60, inclusive. Unless it is the weekend, in which case
     there is no upper bound on the number of cigars. Return true if the party with the given values is
     successful, or false otherwise.
     haveParty(30, false) → false
     haveParty(50, false) → true
     haveParty(70, true) → true
     */
import org.junit.*;

public class CigarPartyTest {
	
	private CigarParty cigar;
	
	@Before
	public void setup() {
		cigar = new CigarParty();
	}
	@Test
	public void weekday_party_with_40_cigars_is_successful() {
		boolean result = cigar.haveParty(40, false);
		Assert.assertTrue(result);
	}
	@Test 
	public void weekday_party_with_50_cigars_is_successful() {
		boolean result = cigar.haveParty(50, false);
		Assert.assertTrue(result);
	}
	@Test
	public void weekday_party_with_60_cigars_is_successful() {
		boolean result = cigar.haveParty(60, false);
		Assert.assertTrue(result);
	}
	@Test
	public void weekday_party_with_70_cigars_is_not_successful() {
		boolean result = cigar.haveParty(70, false);
		Assert.assertFalse(result);
	}
	@Test 
	public void weekday_party_with_200_cigars_is_not_successful() {
		boolean result = cigar.haveParty(200, false);
		Assert.assertFalse(result);
	}
	@Test
	public void weekday_party_with_negative_cigars_is_not_succesful() {
		boolean result = cigar.haveParty(-10, false);
		Assert.assertFalse(result);
	}
	@Test
	public void weekday_party_with_below_40_cigars_is_not_successful() {
		boolean result = cigar.haveParty(20, false);
		Assert.assertFalse(result);
	}
	@Test
	public void weekend_party_with_40_cigars_is_successful() {
		boolean result = cigar.haveParty(40, true);
		Assert.assertTrue(result);
	}
	@Test
	public void weekend_party_with_50_cigars_is_successful() {
		boolean result = cigar.haveParty(50, true);
		Assert.assertTrue(result);
	}
	@Test
	public void weekend_party_with_60_cigars_is_successful() {
		boolean result = cigar.haveParty(60, true);
		Assert.assertTrue(result);
	}
	@Test
	public void weekend_party_with_200_cigars_is_successful() {
		boolean result = cigar.haveParty(200, true);
		Assert.assertTrue(result);
	}
	@Test
	public void weekend_party_with_negative_cigars_is_not_successful() {
		boolean result = cigar.haveParty(-20, true);
		Assert.assertFalse(result);
	}
	@Test
	public void weekend_party_with_no_cigars_is_not_successful() {
		boolean result = cigar.haveParty(0, true);
		Assert.assertFalse(result);
	}
	@Test
	public void weekday_party_with_no_cigars_is_not_successful() {
		boolean result = cigar.haveParty(0, false);
		Assert.assertFalse(result);
	}
	
	
	
	
}

