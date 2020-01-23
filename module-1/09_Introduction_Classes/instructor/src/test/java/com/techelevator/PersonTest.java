package com.techelevator;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import com.techelevator.person.Person;

public class PersonTest extends ClassDefinitionTest<Person> {

	public PersonTest() {
		super(Person.class);
	}

	@Test
	public void firstNameHasGetterAndSetter() {
		assertThatDataMemberIsReadWrite("firstName", "Melinda");
	}

	@Test
	public void lastNameHasGetterAndSetter() {
		assertThatDataMemberIsReadWrite("lastName", "Scott");
	}

	@Test
	public void ageHasGetterAndSetter() {
		assertThatDataMemberIsReadWrite("age", 12);
	}

	@Test
	public void getFullNameMethodExists() {
		assertThatMethodExists("getFullName", String.class);
	}

	@Test
	public void isAdultMethodExists() {
		assertThatMethodExists("isAdult", Boolean.TYPE);
	}

	@Test
	public void getFullNameTests() throws Exception {
		Person person = getInstanceOfSubject();

		Method getFullName = getMethod("getFullName");
		Method setFirstName = getMethod("setFirstName", String.class);
		Method setLastName = getMethod("setLastName", String.class);

		setFirstName.invoke(person, "John");
		setLastName.invoke(person, "Doe");

		String fullName = (String) getFullName.invoke(person);
		assertThat("The getFullName() method was expected to return \"John Doe\" (firstName lastName)", fullName,
				is("John Doe"));

	}

	@Test
	public void isAdultTests() throws Exception {
		Person person = getInstanceOfSubject();

		Method isAdult = getMethod("isAdult");
		Method setAge = getMethod("setAge", Integer.TYPE);

		Map<Integer, Boolean> tests = new HashMap<>();
		tests.put(17, false);
		tests.put(18, true);
		tests.put(19, true);

		for (Map.Entry<Integer, Boolean> entry : tests.entrySet()) {
			int age = entry.getKey();
			boolean expectedResult = entry.getValue();

			setAge.invoke(person, age);
			assertThat(String.format("isAdult() should return %s for %s year old", expectedResult, age),
					isAdult.invoke(person), is(expectedResult));
		}
	}
}
