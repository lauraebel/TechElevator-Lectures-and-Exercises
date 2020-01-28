package com.techelevator.farm;

public class OldMacdonald {
	public static void main(String[] args) {

		Singable[] singers = new Singable[] { new MusicBox(), new Tractor(), new Sheep(), new Cow(), new Chicken(),
				new Dog() };

		for (Singable singer : singers) {
			String name = singer.getName();
			String sound = singer.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();
		}

		Sellable[] items = { new MusicBox(), new Chicken(), new Sheep(), new Cow() };

		for (Sellable item : items) {
			System.out.println("The " + item.getName() + " costs $" + item.getPrice());
		}
		System.out.println();

		for (Singable singer : singers) {
			System.out.print("The " + singer.getName());

			if (singer instanceof FarmAnimal) {
				System.out.print(" is a Farm Animal");
			} else {
				System.out.print(" is not a Farm Animal");
			}
			if (singer instanceof Sellable) {
				Sellable item = (Sellable) singer;
				System.out.print(" and can be sold for $" + item.getPrice());
			}
			System.out.println();
		}
	}
}