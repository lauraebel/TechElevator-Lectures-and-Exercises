package com.techelevator;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.lang.reflect.Method;

import org.junit.Test;

import com.techelevator.shoppingcart.ShoppingCart;

public class ShoppingCartTest extends ClassDefinitionTest<ShoppingCart> {

	public ShoppingCartTest() {
		super(ShoppingCart.class);
	}

	@Test
	public void totalNumberOfItemsShouldOnlyHaveAGetter() {
		assertThatDataMemberIsReadOnly("totalNumberOfItems", Integer.TYPE);
	}

	@Test
	public void totalAmountOwedShouldOnlyHaveAGetter() {
		assertThatDataMemberIsReadOnly("totalAmountOwed", Double.TYPE);
	}

	@Test
	public void getAveragePriceMethodExists() {
		assertThatDataMemberIsReadOnly("averagePricePerItem", Double.TYPE);
	}

	@Test
	public void addItemsMethodExists() {
		assertThatMethodExists("addItems", Void.TYPE, Integer.TYPE, Double.TYPE);
	}

	@Test
	public void emptyMethodExists() {
		assertThatMethodExists("empty", Void.TYPE);
	}

	@Test
	public void defaultShoppingCart() throws Exception {
		ShoppingCart shoppingCart = getInstanceOfSubject();

		assertThatShoppingCartHasCorrectNumberOfItems(shoppingCart, 0);
		assertThatShoppingCartHasCorrectAmountOwed(shoppingCart, 0.00d);
	}

	@Test
	public void getAveragePricePerItemReturnsExpectedValue() throws Exception {
		ShoppingCart shoppingCart = getInstanceOfSubject();
		Method getAveragePricePerItemMethod = getMethod("getAveragePricePerItem");

		assertThat("Initial average price per item should 0.00", getAveragePricePerItemMethod.invoke(shoppingCart),
				is(0.0d));

		addItemsToShoppingCart(shoppingCart, 2, 5.00d);

		assertThatShoppingCartHasCorrectNumberOfItems(shoppingCart, 2);
		assertThatShoppingCartHasCorrectAmountOwed(shoppingCart, 10.00d);

		assertThat("The average price per item should be 5.00", getAveragePricePerItemMethod.invoke(shoppingCart),
				is(5.0d));
	}

	@Test
	public void addItemsMethodIncreaseQuantityOfItemsAndUpdatesAmountOwed() throws Exception {
		ShoppingCart shoppingCart = getInstanceOfSubject();

		addItemsToShoppingCart(shoppingCart, 5, 2.50d);
		assertThatShoppingCartHasCorrectNumberOfItems(shoppingCart, 5);
		assertThatShoppingCartHasCorrectAmountOwed(shoppingCart, 12.50d);
	}

	@Test
	public void emptyMethodResetsTheShoppingCart() throws Exception {
		ShoppingCart shoppingCart = getInstanceOfSubject();
		Method emptyMethod = getMethod("empty");

		addItemsToShoppingCart(shoppingCart, 12, 2.25d);

		assertThatShoppingCartHasCorrectNumberOfItems(shoppingCart, 12);
		assertThatShoppingCartHasCorrectAmountOwed(shoppingCart, 27.00d);

		emptyMethod.invoke(shoppingCart);

		assertThatShoppingCartHasCorrectNumberOfItems(shoppingCart, 0);
		assertThatShoppingCartHasCorrectAmountOwed(shoppingCart, 0.00d);
	}

	private void addItemsToShoppingCart(ShoppingCart shoppingCart, int numberOfItems, double pricePerItem)
			throws Exception {
		Method addItemsMethod = getMethod("addItems", Integer.TYPE, Double.TYPE);
		addItemsMethod.invoke(shoppingCart, numberOfItems, pricePerItem);
	}

	private void assertThatShoppingCartHasCorrectNumberOfItems(ShoppingCart shoppingCart, int expectedNumberOfItems)
			throws Exception {
		Method getTotalNumberOfItemsMethod = getMethod("getTotalNumberOfItems");
		assertThat("Total number of items should be " + expectedNumberOfItems,
				getTotalNumberOfItemsMethod.invoke(shoppingCart), is(expectedNumberOfItems));
	}

	private void assertThatShoppingCartHasCorrectAmountOwed(ShoppingCart shoppingCart, double expectedAmountOwed)
			throws Exception {
		Method getTotalAmountOwedMethod = getMethod("getTotalAmountOwed");
		assertThat("Total amount owed should be " + expectedAmountOwed, getTotalAmountOwedMethod.invoke(shoppingCart),
				is(expectedAmountOwed));
	}

}
