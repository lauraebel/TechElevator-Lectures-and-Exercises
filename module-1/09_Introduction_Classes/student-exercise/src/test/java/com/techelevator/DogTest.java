package com.techelevator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.techelevator.dog.Dog;

public class DogTest extends ClassDefinitionTest<Dog> {

	public DogTest() {
		super(Dog.class);
	}

	@Test
	public void isSleepingOnlyHasGetter() {
		assertThatMethodExists("isSleeping", Boolean.TYPE);
		assertThatMethodDoesNotExist("setIsSleeping", Boolean.TYPE);
	}

	@Test
	public void makeSoundMethodExists() {
		assertThatMethodExists("makeSound", String.class);
	}

	@Test
	public void sleepMethodExists() {
		assertThatMethodExists("sleep", Void.TYPE);
	}

	@Test
	public void wakeUpMethodExists() {
		assertThatMethodExists("wakeUp", Void.TYPE);
	}

	@Test
	public void defaultDogTest() throws Exception {
		Dog dog = getInstanceOfSubject();
		assertThat("New dogs should be awake by default", isDogSleeping(dog), is(false));
	}

	@Test
	public void makeSoundMethodReturnsExpectedResults() throws Exception {
		Dog dog = getInstanceOfSubject();

		Method makeSoundMethod = getMethod("makeSound");

		Map<Boolean, String> tests = new HashMap<>();
		tests.put(true, "Zzzzz...");
		tests.put(false, "Woof!");

		for (Map.Entry<Boolean, String> entry : tests.entrySet()) {
			boolean isSleeping = entry.getKey();
			String expectedSound = entry.getValue();

			if (isSleeping) {
				makeDogSleep(dog);
			} else {
				makeDogWakeUp(dog);
			}

			assertThat(
					String.format("The dog should say \"%s\" when %s.", expectedSound, isSleeping ? "asleep" : "awake"),
					makeSoundMethod.invoke(dog), is(expectedSound));
		}
	}

	@Test
	public void sleepTest() throws Exception {
		Dog dog = getInstanceOfSubject();

		makeDogSleep(dog);
		assertThat("The dog should be sleeping after sleep() is called.", isDogSleeping(dog), is(true));
	}

	@Test
	public void wakeUpTest() throws Exception {
		Dog dog = getInstanceOfSubject();

		makeDogWakeUp(dog);
		assertThat("The dog should be awake after wakeUp() is called.", isDogSleeping(dog), is(false));

	}

	private boolean isDogSleeping(Dog dog) throws Exception {
		Method isSleepingMethod = getMethod("isSleeping");
		return (boolean) isSleepingMethod.invoke(dog);
	}

	private void makeDogSleep(Dog dog) throws Exception {
		Method sleepMethod = getMethod("sleep");
		sleepMethod.invoke(dog);
	}

	private void makeDogWakeUp(Dog dog) throws Exception {
		Method wakeUpMethod = getMethod("wakeUp");
		wakeUpMethod.invoke(dog);
	}

}
