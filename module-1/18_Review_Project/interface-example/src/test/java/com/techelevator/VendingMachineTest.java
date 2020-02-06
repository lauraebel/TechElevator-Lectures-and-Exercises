package com.techelevator;

import java.io.FileNotFoundException;

import org.junit.*;

public class VendingMachineTest {

	private static final String INVENTORY_FILENAME = "vendingmachine.csv";
	private VendingMachine vm;
	
	@Before
	public void setup() throws FileNotFoundException {
		//vm = new VendingMachine(INVENTORY_FILENAME);
	}
	
	@Test
	public void vendingmachine_has_inventory() {
		Assert.assertEquals(16, vm.getInventory().size());
	}
}
