package com.techelevator.money;

import java.util.Map;

import org.junit.*;

import com.techelevator.money.denominations.*;

public class ChangeMakerTest {

	private static final Money[] monies = new Money[] { new TwentyDollar(), new TenDollar(), new FiveDollar(), new OneDollar(), new Quarter(), new Dime(), new Nickel() };
	
	private ChangeMaker changeMaker;
	
	@Before
	public void setup() {
		changeMaker = new ChangeMaker(monies);
	}
	
	@Test
	public void get_change_for_0() {
		Map<Money, Integer> change = changeMaker.makeChange(0.00);
		
		Assert.assertNotNull(change);
		Assert.assertEquals(0, change.size());
	}
	
	@Test
	public void get_change_for_negative() {
		Map<Money, Integer> change = changeMaker.makeChange(-10.05);
		
		Assert.assertNotNull(change);
		Assert.assertEquals(0, change.size());
	}
	
	@Test
	public void get_change_for_20_dollars() {
		Map<Money, Integer> change = changeMaker.makeChange(20.00);
		
		Assert.assertNotNull(change);
		Assert.assertEquals(1, change.size());
		Assert.assertEquals(new Integer(1), change.get(new TwentyDollar()));
	}
	
	@Test
	public void get_change_for_10_dollars() {
		Map<Money, Integer> change = changeMaker.makeChange(10.00);
		
		Assert.assertNotNull(change);
		Assert.assertEquals(1, change.size());
		Assert.assertEquals(new Integer(1), change.get(new TenDollar()));
	}
	
	@Test
	public void get_change_for_5_dollars() {
		Map<Money, Integer> change = changeMaker.makeChange(5.00);
		
		Assert.assertNotNull(change);
		Assert.assertEquals(1, change.size());
		Assert.assertEquals(new Integer(1), change.get(new FiveDollar()));
	}
	
	@Test
	public void get_change_for_1_dollars() {
		Map<Money, Integer> change = changeMaker.makeChange(1.00);
		
		Assert.assertNotNull(change);
		Assert.assertEquals(1, change.size());
		Assert.assertEquals(new Integer(1), change.get(new OneDollar()));
	}
	
	@Test
	public void get_change_for_25_cents() {
		Map<Money, Integer> change = changeMaker.makeChange(0.25);
		
		Assert.assertNotNull(change);
		Assert.assertEquals(1, change.size());
		Assert.assertEquals(new Integer(1), change.get(new Quarter()));
	}
	
	@Test
	public void get_change_for_10_cents() {
		Map<Money, Integer> change = changeMaker.makeChange(0.10);
		
		Assert.assertNotNull(change);
		Assert.assertEquals(1, change.size());
		Assert.assertEquals(new Integer(1), change.get(new Dime()));
	}
	
	@Test
	public void get_change_for_5_cents() {
		Map<Money, Integer> change = changeMaker.makeChange(0.05);
		
		Assert.assertNotNull(change);
		Assert.assertEquals(1, change.size());
		Assert.assertEquals(new Integer(1), change.get(new Nickel()));
	}
	
	@Test
	public void get_change_with_all_dollar_types() {
		Map<Money, Integer> change = changeMaker.makeChange(36.00);
		
		Assert.assertNotNull(change);
		Assert.assertEquals(4, change.size());
		Assert.assertEquals(new Integer(1), change.get(new TwentyDollar()));
		Assert.assertEquals(new Integer(1), change.get(new TenDollar()));
		Assert.assertEquals(new Integer(1), change.get(new FiveDollar()));
		Assert.assertEquals(new Integer(1), change.get(new OneDollar()));
	}
	
	@Test
	public void get_change_with_all_coin_types() {
		Map<Money, Integer> change = changeMaker.makeChange(0.40);
		
		Assert.assertNotNull(change);
		Assert.assertEquals(3, change.size());
		Assert.assertEquals(new Integer(1), change.get(new Quarter()));
		Assert.assertEquals(new Integer(1), change.get(new Dime()));
		Assert.assertEquals(new Integer(1), change.get(new Nickel()));
	}
	
	@Test
	public void get_change_with_all_types() {
		Map<Money, Integer> change = changeMaker.makeChange(36.40);
		
		Assert.assertNotNull(change);
		Assert.assertEquals(7, change.size());
		Assert.assertEquals(new Integer(1), change.get(new TwentyDollar()));
		Assert.assertEquals(new Integer(1), change.get(new TenDollar()));
		Assert.assertEquals(new Integer(1), change.get(new FiveDollar()));
		Assert.assertEquals(new Integer(1), change.get(new OneDollar()));
		Assert.assertEquals(new Integer(1), change.get(new Quarter()));
		Assert.assertEquals(new Integer(1), change.get(new Dime()));
		Assert.assertEquals(new Integer(1), change.get(new Nickel()));
	}
	
	@Test
	public void get_change_with_multiple_dollar_types() {
		Map<Money, Integer> change = changeMaker.makeChange(77.00);
		
		Assert.assertNotNull(change);
		Assert.assertEquals(4, change.size());
		Assert.assertEquals(new Integer(3), change.get(new TwentyDollar()));
		Assert.assertEquals(new Integer(1), change.get(new TenDollar()));
		Assert.assertEquals(new Integer(1), change.get(new FiveDollar()));
		Assert.assertEquals(new Integer(2), change.get(new OneDollar()));
	}
	
	@Test
	public void get_change_with_multiple_coin_types() {
		Map<Money, Integer> change = changeMaker.makeChange(0.65);
		
		Assert.assertNotNull(change);
		Assert.assertEquals(3, change.size());
		Assert.assertEquals(new Integer(2), change.get(new Quarter()));
		Assert.assertEquals(new Integer(1), change.get(new Dime()));
		Assert.assertEquals(new Integer(1), change.get(new Nickel()));
	}
	
	@Test
	public void get_change_for_60_dollars_75_cents() {
		Map<Money, Integer> change = changeMaker.makeChange(60.75);
		
		Assert.assertNotNull(change);
		Assert.assertEquals(2, change.size());
		Assert.assertEquals(new Integer(3), change.get(new TwentyDollar()));
		Assert.assertEquals(new Integer(3), change.get(new Quarter()));
	}
	
	@Test
	public void get_change_for_3_dollars_15_cents() {
		Map<Money, Integer> change = changeMaker.makeChange(3.15);
		
		Assert.assertNotNull(change);
		Assert.assertEquals(3, change.size());
		Assert.assertEquals(new Integer(3), change.get(new OneDollar()));
		Assert.assertEquals(new Integer(1), change.get(new Dime()));
		Assert.assertEquals(new Integer(1), change.get(new Nickel()));
	}
	
	@Test
	public void get_change_for_5000_dollars() {
		Map<Money, Integer> change = changeMaker.makeChange(5000.00);
		
		Assert.assertNotNull(change);
		Assert.assertEquals(1, change.size());
		Assert.assertEquals(new Integer(250), change.get(new TwentyDollar()));
	}
	
	@Test
	public void get_change_for_4999_dollars_95_cents() {
		Map<Money, Integer> change = changeMaker.makeChange(4999.95);
		
		Assert.assertNotNull(change);
		Assert.assertEquals(6, change.size());
		Assert.assertEquals(new Integer(249), change.get(new TwentyDollar()));
		Assert.assertEquals(new Integer(1), change.get(new TenDollar()));
		Assert.assertEquals(new Integer(1), change.get(new FiveDollar()));
		Assert.assertEquals(new Integer(4), change.get(new OneDollar()));
		Assert.assertEquals(new Integer(3), change.get(new Quarter()));
		Assert.assertEquals(new Integer(2), change.get(new Dime()));
	}
	
	@Test
	public void get_change_for_1537_dollars_5_cents() {
		Map<Money, Integer> change = changeMaker.makeChange(1537.05);
		
		Assert.assertNotNull(change);
		Assert.assertEquals(5, change.size());
		Assert.assertEquals(new Integer(76), change.get(new TwentyDollar()));
		Assert.assertEquals(new Integer(1), change.get(new TenDollar()));
		Assert.assertEquals(new Integer(2), change.get(new OneDollar()));
		Assert.assertEquals(new Integer(1), change.get(new Nickel()));
	}
	
	@Test
	public void get_change_for_116_dollars_40_cents() {
		Map<Money, Integer> change = changeMaker.makeChange(116.40);
		
		Assert.assertNotNull(change);
		Assert.assertEquals(7, change.size());
		Assert.assertEquals(new Integer(5), change.get(new TwentyDollar()));
		Assert.assertEquals(new Integer(1), change.get(new TenDollar()));
		Assert.assertEquals(new Integer(1), change.get(new FiveDollar()));
		Assert.assertEquals(new Integer(1), change.get(new OneDollar()));
		Assert.assertEquals(new Integer(1), change.get(new Quarter()));
		Assert.assertEquals(new Integer(1), change.get(new Dime()));
		Assert.assertEquals(new Integer(1), change.get(new Nickel()));
	}
	
	@Test
	public void get_change_for_20_cents() {
		Map<Money, Integer> change = changeMaker.makeChange(0.20);
		
		Assert.assertNotNull(change);
		Assert.assertEquals(1, change.size());
		Assert.assertEquals(new Integer(2), change.get(new Dime()));
	}
}
