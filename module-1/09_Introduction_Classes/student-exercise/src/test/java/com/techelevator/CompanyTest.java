package com.techelevator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.lang.reflect.Method;

import org.junit.Test;

import com.techelevator.company.Company;

public class CompanyTest extends ClassDefinitionTest<Company> {

	public CompanyTest() {
		super(Company.class);
	}

	@Test
	public void nameHasGetterAndSetter() {
		assertThatDataMemberIsReadWrite("name", "My Company");
	}

	@Test
	public void numberOfEmployeesHashGetterAndSetter() {
		assertThatDataMemberIsReadWrite("numberOfEmployees", 37);
	}

	@Test
	public void revenueHasGetterAndSetter() {
		assertThatDataMemberIsReadWrite("revenue", 100.0d);
	}

	@Test
	public void expensesHasGetterAndSetter() {
		assertThatDataMemberIsReadWrite("expenses", 99.99d);
	}

	@Test
	public void getCompanySizeMethodExists() {
		assertThatMethodExists("getCompanySize", String.class);
	}

	@Test
	public void getProfitMethodExists() {
		assertThatMethodExists("getProfit", Double.TYPE);
	}

	@Test
	public void companyCompanySizeTests() throws Exception {
		String assertionFailureMessageTemplate = "Company size should be '%s' when employees are %s";
		Company company = getInstanceOfSubject();

		Method setNumberOfEmployees = getMethod("setNumberOfEmployees", Integer.TYPE);
		Method getCompanySize = getMethod("getCompanySize");

		String expectedCompanySize = "small";
		setNumberOfEmployees.invoke(company, 49);
		assertThat(String.format(assertionFailureMessageTemplate, expectedCompanySize, "50 or less"),
				getCompanySize.invoke(company), is(expectedCompanySize));

		setNumberOfEmployees.invoke(company, 50);
		assertThat(String.format(assertionFailureMessageTemplate, expectedCompanySize, "50 or less"),
				getCompanySize.invoke(company), is(expectedCompanySize));

		expectedCompanySize = "medium";
		setNumberOfEmployees.invoke(company, 51);
		assertThat(String.format(assertionFailureMessageTemplate, expectedCompanySize, "between 51 and 250 inclusive"),
				getCompanySize.invoke(company), is(expectedCompanySize));

		setNumberOfEmployees.invoke(company, 250);
		assertThat(String.format(assertionFailureMessageTemplate, expectedCompanySize, "between 51 and 250 inclusive"),
				getCompanySize.invoke(company), is(expectedCompanySize));

		expectedCompanySize = "large";
		setNumberOfEmployees.invoke(company, 251);
		assertThat(String.format(assertionFailureMessageTemplate, expectedCompanySize, "over 250 inclusive"),
				getCompanySize.invoke(company), is(expectedCompanySize));

	}

	@Test
	public void companyProfitTests() throws Exception {
		Company company = getInstanceOfSubject();

		Method setRevenue = getMethod("setRevenue", Double.TYPE);
		Method setExpenses = getMethod("setExpenses", Double.TYPE);
		Method getProfit = getMethod("getProfit");

		setRevenue.invoke(company, 6543.21d);
		setExpenses.invoke(company, 1234.56d);
		assertThat("Revenue: 6543.21 - Expenses: 1234.56 = Profit: 5308.65", getProfit.invoke(company), is(5308.65d));
	}

}
