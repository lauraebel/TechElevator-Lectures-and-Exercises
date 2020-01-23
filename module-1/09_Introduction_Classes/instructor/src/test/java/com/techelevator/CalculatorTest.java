package com.techelevator;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

import java.lang.reflect.Method;

import org.junit.Test;

import com.techelevator.calculator.Calculator;

public class CalculatorTest extends ClassDefinitionTest<Calculator> {

	public CalculatorTest() {
		super(Calculator.class);
	}

	@Test
	public void resultDataMemberOnlyHasGetter() {
		assertThatDataMemberIsReadOnly("result", Integer.TYPE);
	}

	@Test
	public void addMethodExists() {
		assertThatMethodExists("add", Integer.TYPE, Integer.TYPE);
	}

	@Test
	public void subtractMethodExists() {
		assertThatMethodExists("subtract", Integer.TYPE, Integer.TYPE);
	}

	@Test
	public void multiplyMethodExists() {
		assertThatMethodExists("multiply", Integer.TYPE, Integer.TYPE);
	}

	@Test
	public void powerMethodExists() {
		assertThatMethodExists("power", Integer.TYPE, Integer.TYPE);
	}

	@Test
	public void resetMethodExists() {
		assertThatMethodExists("reset", Void.TYPE);
	}

	@Test
	public void defaultCalculator() {
		Calculator calculator = getInstanceOfSubject();

		try {
			assertThatCalculatorResultIs(calculator, 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail(String.format("An exception occurred while executing the test. (%s)", e.getMessage()));
		}
	}

	@Test
	public void resetMethodResetsResult() throws Exception {
		Calculator calculator = getInstanceOfSubject();
		Method resetMethod = getMethod("reset");

		addValueToCalculator(calculator, 10);
		assertThatCalculatorResultIs(calculator, 10);

		resetMethod.invoke(calculator);

		assertThatCalculatorResultIs(calculator, 0);
	}

	@Test
	public void addMethodTest() throws Exception {
		Calculator calculator = getInstanceOfSubject();

		assertThat("add(5) should return 5", addValueToCalculator(calculator, 5), is(5));
		assertThat("add(7) should return 12", addValueToCalculator(calculator, 7), is(12));
		assertThatCalculatorResultIs(calculator, 12);
	}

	@Test
	public void multiplyMethodTest() throws Exception {
		Calculator calculator = getInstanceOfSubject();
		Method multiplyMethod = getMethod("multiply", Integer.TYPE);

		assertThat("add(3) should return 3", addValueToCalculator(calculator, 3), is(3));
		assertThat("multiply(3) should return 9", multiplyMethod.invoke(calculator, 3), is(9));
		assertThat("multiply(5) should return 45", multiplyMethod.invoke(calculator, 5), is(45));
		assertThatCalculatorResultIs(calculator, 45);
	}

	@Test
	public void subtractMethodTest() throws Exception {
		Calculator calculator = getInstanceOfSubject();
		Method subtractMethod = getMethod("subtract", Integer.TYPE);

		assertThat("subtract(5) should return -5", subtractMethod.invoke(calculator, 5), is(-5));
		assertThat("subtract(8) should return -13", subtractMethod.invoke(calculator, 8), is(-13));
		assertThatCalculatorResultIs(calculator, -13);
	}

	@Test
	public void powerMethodTest() throws Exception {
		Calculator calculator = getInstanceOfSubject();
		Method powerMethod = getMethod("power", Integer.TYPE);

		addValueToCalculator(calculator, 7);
		assertThat("power(2) should return 49", powerMethod.invoke(calculator, 2), is(49));
		assertThat("power(4) should return 117649", powerMethod.invoke(calculator, 3), is(49 * 49 * 49));
		assertThatCalculatorResultIs(calculator, 49 * 49 * 49);
	}

	private int addValueToCalculator(Calculator calculator, int valueToAdd) throws Exception {
		Method addMethod = getMethod("add", Integer.TYPE);
		return (int) addMethod.invoke(calculator, valueToAdd);
	}

	private void assertThatCalculatorResultIs(Calculator calculator, int expectedResult) throws Exception {
		Method getResultMethod = getMethod("getResult");
		assertThat("result should be " + expectedResult, getResultMethod.invoke(calculator), is(expectedResult));
	}

}
