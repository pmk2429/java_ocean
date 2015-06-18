package iterator;

import java.util.Iterator;

import iterator.Bag.BagIterator;

public class BagDemo {
	public static void main(String[] args) {
		Animal lion = new Animal(25, "Lion");
		Animal tiger = new Animal(11, "Tiger");
		Animal dog = new Animal(19, "Dog");
		Animal cat = new Animal(48, "Cat");
		Animal elephant = new Animal(14, "Elephant");

		Bag<Animal> animalBag = new Bag<Animal>();
		animalBag.add(elephant);
		animalBag.add(tiger);
		animalBag.add(cat);
		animalBag.add(dog);
		animalBag.add(lion);

		for (Iterator<Animal> it = animalBag.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
	}
}

class Animal {
	int age;
	String name;

	public Animal(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Animal: " + age + " ; " + name;
	}

}