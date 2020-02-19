package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.inventory.Inventory;
import com.techelevator.inventory.InventoryException;
import com.techelevator.inventory.Stock;
import com.techelevator.inventory.reader.CsvInventoryReader;
import com.techelevator.inventory.reader.InventoryReader;
import com.techelevator.inventory.reader.InventoryReaderException;
import com.techelevator.inventory.report.TextLogWriter;
import com.techelevator.inventory.report.TextSalesReportWriter;
import com.techelevator.mock.InventoryFileMock;
import com.techelevator.money.ChangeMaker;
import com.techelevator.money.InvalidAmountException;
import com.techelevator.money.MoneyHandler;
import com.techelevator.money.denominations.Dime;
import com.techelevator.money.denominations.FiveDollar;
import com.techelevator.money.denominations.Money;
import com.techelevator.money.denominations.Nickel;
import com.techelevator.money.denominations.OneDollar;
import com.techelevator.money.denominations.Quarter;
import com.techelevator.money.denominations.TenDollar;
import com.techelevator.money.denominations.TwentyDollar;
import com.techelevator.transaction.TransactionResult;

public class CateringSystemTest {

	private static final Money[] monies = new Money[] { new TwentyDollar(), new TenDollar(), new FiveDollar(), new OneDollar(), new Quarter(), new Dime(), new Nickel() };
	private final static String TEST_lOG_FILE = "testlog.txt";
	private final static String TEST_REPORT_FILE = "testreport.txt";
	
	private CateringSystem cateringSystem;
	
	@Before
	public void setup() throws IOException, InventoryReaderException {
		File mockInventoryFile = InventoryFileMock.getMockInventoryFile();
		InventoryReader reader = new CsvInventoryReader(mockInventoryFile);
		Inventory inventory = new Inventory(reader);
		cateringSystem = new CateringSystem( inventory,  new MoneyHandler(new ChangeMaker(monies)), 
				new TextLogWriter(TEST_lOG_FILE), new TextSalesReportWriter(TEST_REPORT_FILE));
	}
	
	@After
	public void cleanup_logs() {
		File log = new File(TEST_lOG_FILE);
		if (log.exists()) {
			log.delete();
		}
		File report = new File(TEST_REPORT_FILE);
		if (report.exists()) {
			report.delete();
		}
	}
	
	@Test
	public void can_get_stock() {
		Map<String, Stock> stock = cateringSystem.getStock();
		Assert.assertNotNull(stock);
		Assert.assertEquals(InventoryFileMock.getItemCount(), stock.size());
	}
	
	@Test
	public void can_get_customer_balance() throws InvalidAmountException {
		cateringSystem.addMoney(100);
		Assert.assertEquals(100, cateringSystem.getCustomerBalance(), 2);
	}
	
	@Test
	public void can_add_money() throws InvalidAmountException {
		Assert.assertTrue(cateringSystem.addMoney(4999));
		Assert.assertEquals(4999.00, cateringSystem.getCustomerBalance(), 2);
	}
	
	@Test
	public void can_add_money_multiple_times() throws InvalidAmountException {
		Assert.assertTrue(cateringSystem.addMoney(101));
		Assert.assertTrue(cateringSystem.addMoney(3050));
		Assert.assertEquals(3151.00, cateringSystem.getCustomerBalance(), 2);
	}
	
	@Test
	public void can_add_5000() throws InvalidAmountException {
		Assert.assertTrue(cateringSystem.addMoney(5000));
		Assert.assertEquals(5000.00, cateringSystem.getCustomerBalance(), 2);
	}
	
	@Test
	public void can_add_5000_in_multiples () throws InvalidAmountException {
		Assert.assertTrue(cateringSystem.addMoney(1000));
		Assert.assertTrue(cateringSystem.addMoney(2500));
		Assert.assertTrue(cateringSystem.addMoney(1500));
		Assert.assertEquals(5000.00, cateringSystem.getCustomerBalance(), 2);
	}
	
	@Test
	public void can_not_exceed_5000() {
		boolean exceptionThrown = false;
		try {
			cateringSystem.addMoney(5001);
		} catch (InvalidAmountException e) {
			Assert.assertEquals("Money added when should have failed", 0.00, cateringSystem.getCustomerBalance(), 2);
			Assert.assertEquals("Exeption has invalid amount", 5001, e.getNewAmount(), 2);
			exceptionThrown = true;
		}
		Assert.assertTrue("InvalidAmountException not thrown", exceptionThrown);
	}
	
	@Test
	public void can_not_exceed_5000_in_multiples() {
		boolean exceptionThrown = false;
		try {
			cateringSystem.addMoney(4000);
			cateringSystem.addMoney(1111);
		} catch (InvalidAmountException e) {
			Assert.assertEquals("Money added when should have failed", 4000.00, cateringSystem.getCustomerBalance(), 2);
			Assert.assertEquals("Exeption has invalid amount", 5111, e.getNewAmount(), 2);
			exceptionThrown = true;
		}
		Assert.assertTrue("InvalidAmountException not thrown", exceptionThrown);
	}
	
	@Test
	public void can_add_item_to_cart() throws InventoryException, InvalidAmountException {
		String itemCode = "A1";
		cateringSystem.addMoney(1000);
		cateringSystem.addItemToCart(itemCode, 10);
		Assert.assertEquals("Wrong number of items in Cart", 1, cateringSystem.getTotalItemsInCart());
		Assert.assertEquals("Wrong item in Cart", InventoryFileMock.getMockInvetory().get(itemCode).getItem(), cateringSystem.getCartItems().get(0).getItem());
	}
	
	@Test
	public void can_not_add_items_to_cart_when_not_enough_money() throws InventoryException, InvalidAmountException {
		String itemCode = "A1";
		cateringSystem.addMoney(10);
		boolean exceptionThrown = false;
		try {
			cateringSystem.addItemToCart(itemCode, 10);
		} catch (InvalidAmountException e) {
			exceptionThrown = true;
			Assert.assertEquals("Not enough balance remains to purchase items", e.getMessage());
		}
		Assert.assertEquals("Item added to cart", 0, cateringSystem.getTotalItemsInCart());
		Assert.assertTrue("InvalidAmountException not thrown", exceptionThrown);
	}
	
	@Test
	public void can_end_transaction() throws InvalidAmountException, InventoryException {
		
		String itemOneCode = "A1";
		double itemOneCost = 3.50;
		int itemOneCount = 10;
		String itemTwoCode = "B1";
		double itemTwoCost = 1.50;
		int itemTwoCount = 12;
		double expectedTotal = (itemOneCount * itemOneCost) + (itemTwoCount * itemTwoCost);
		int startingBalance = 100;

		cateringSystem.addMoney(startingBalance);
		cateringSystem.addItemToCart(itemOneCode, itemOneCount); 
		cateringSystem.addItemToCart(itemTwoCode, itemTwoCount); 
		
		TransactionResult result = cateringSystem.endTransaction();
		
		Assert.assertNotNull("result was null", result);
		Assert.assertEquals("wrong number of items in transaction", 2, result.getPurchasedItems().size());
		Assert.assertEquals("Cart total incorrect value", expectedTotal, result.getTransactionTotal(), 2);
		Assert.assertEquals("Cart Items was not reset", 0, cateringSystem.getTotalItemsInCart());
		Assert.assertEquals("Customer balance was not reset", 0.00, cateringSystem.getCustomerBalance(), 2);
		
		Assert.assertEquals("Wrong number of money returned", 3, result.getChange().size());
		Assert.assertEquals("Wrong number of twenties returned", new Integer(2), result.getChange().get(new TwentyDollar()));
		Assert.assertEquals("Wrong number of twenties returned", new Integer(1), result.getChange().get(new FiveDollar()));
		Assert.assertEquals("Wrong number of dollars returned", new Integer(2), result.getChange().get(new OneDollar()));
		
	}
	
}
