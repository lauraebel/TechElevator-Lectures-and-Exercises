package com.techelevator.money;

import java.util.Map;

import org.junit.*;

import com.techelevator.money.denominations.Dime;
import com.techelevator.money.denominations.FiveDollar;
import com.techelevator.money.denominations.Money;
import com.techelevator.money.denominations.Nickel;
import com.techelevator.money.denominations.OneDollar;
import com.techelevator.money.denominations.Quarter;
import com.techelevator.money.denominations.TenDollar;
import com.techelevator.money.denominations.TwentyDollar;

public class MoneyHandlerTest {

	private static final Money[] monies = new Money[] { new TwentyDollar(), new TenDollar(), new FiveDollar(), new OneDollar(), new Quarter(), new Dime(), new Nickel() };
	
	private MoneyHandler moneyHandler;
	
	@Before
	public void setup() {
		moneyHandler = new MoneyHandler( new ChangeMaker(monies) );
	}
	
	@Test
	public void balance_starts_at_zero() {
		Assert.assertEquals(0.00, moneyHandler.getBalance(), 2);
	}
	
	@Test
	public void add_money() {
		Assert.assertTrue(moneyHandler.addMoney(100));
		Assert.assertEquals(100.00, moneyHandler.getBalance(), 2);
	}
	
	@Test
	public void add_money_twice() {
		Assert.assertTrue(moneyHandler.addMoney(100));
		Assert.assertTrue(moneyHandler.addMoney(1000));
		Assert.assertEquals(1100.00, moneyHandler.getBalance(), 2);
	}
	
	@Test
	public void cannot_add_negative_money() {
		moneyHandler.addMoney(1000);
		Assert.assertFalse(moneyHandler.addMoney(-100));
		Assert.assertEquals(1000, moneyHandler.getBalance(), 2);
	}
	
	@Test
	public void enough_money_to_purchase() {
		moneyHandler.addMoney(1000);
		Assert.assertTrue(moneyHandler.enoughBalanceForPurchase( 999 ));
	}
	
	@Test
	public void enough_money_to_purchase_when_zero_remains() {
		moneyHandler.addMoney(1000);
		Assert.assertTrue(moneyHandler.enoughBalanceForPurchase( 1000 ));
	}
	
	@Test
	public void not_enough_money_to_purchase() {
		moneyHandler.addMoney(1000);
		Assert.assertFalse(moneyHandler.enoughBalanceForPurchase( 1001 ));
	}
	
	@Test
	public void can_remove_money() {
		moneyHandler.addMoney( 1000 );
		Assert.assertTrue( moneyHandler.removeMoney( 999 ) );
		Assert.assertEquals( 1.00, moneyHandler.getBalance(), 2);
	}
	
	@Test
	public void can_remove_money_to_0() {
		moneyHandler.addMoney( 1000 );
		Assert.assertTrue( moneyHandler.removeMoney( 1000 ) );
		Assert.assertEquals( 0.00, moneyHandler.getBalance(), 2);
	}
	
	@Test
	public void can_not_remove_money_below_0() {
		moneyHandler.addMoney( 1000 );
		Assert.assertFalse( moneyHandler.removeMoney( 1001 ) );
		Assert.assertEquals( 1000.00, moneyHandler.getBalance(), 2);
	}
	
	@Test
	public void can_not_remove_negative_money() {
		moneyHandler.addMoney( 1000 );
		Assert.assertFalse( moneyHandler.removeMoney( -100 ) );
		Assert.assertEquals( 1000.00, moneyHandler.getBalance(), 2);
	}
	
	@Test
	public void can_remove_0_money() {
		moneyHandler.addMoney( 1000 );
		Assert.assertTrue( moneyHandler.removeMoney( 0 ) );
		Assert.assertEquals( 1000.00, moneyHandler.getBalance(), 2);
	}
	
	@Test
	public void cashout_resets_balance() {
		moneyHandler.addMoney( 100 );
		Map<Money, Integer> change = moneyHandler.cashOut();
		
		Assert.assertNotNull( change );
		Assert.assertEquals(0.00, moneyHandler.getBalance(), 2);
		Assert.assertEquals(1, change.size());
		Assert.assertEquals(new Integer(5), change.get( new TwentyDollar() ));
	}
	
	@Test
	public void cashout_0_resets_balance() {
		Map<Money, Integer> change = moneyHandler.cashOut();
		
		Assert.assertNotNull( change );
		Assert.assertEquals(0.00, moneyHandler.getBalance(), 2);
		Assert.assertEquals(0, change.size());
	}
}
