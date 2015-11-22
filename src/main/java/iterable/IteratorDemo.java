package iterable;

import java.util.ArrayList;

public class IteratorDemo {
	public static void main(String args[]) {
		ArrayList<String> animalList = new ArrayList<String>();
		animalList.add("Horse");
		animalList.add("Lion");
		animalList.add("Tiger");
		animalList.add("Cat");
		animalList.add("Dog");
		animalList.add("Polar Bear");
		Animal animal = new Animal(animalList);
		for (String animalObj : animal) {
			System.out.println(animalObj);
		}
		
		

	}
}
