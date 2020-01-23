package com.techelevator;

import org.junit.Test;

import com.techelevator.product.Product;

public class ProductTest extends ClassDefinitionTest<Product> {

	public ProductTest() {
		super(Product.class);
	}

	@Test
	public void nameHasGetterAndSetter() {
		assertThatDataMemberIsReadWrite("name", "Premium Coffee Mug");
	}

	@Test
	public void priceHasGetterAndSetter() {
		assertThatDataMemberIsReadWrite("price", 15.99d);
	}

	@Test
	public void weightInOuncesHasGetterAndSetter() {
		assertThatDataMemberIsReadWrite("weightInOunces", 5.1001d);
	}

}
