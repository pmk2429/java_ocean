package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorProperties {

	public static void main(String[] args) {
		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person("Demo", 55));
		personList.add(new Person("Milin", 22));
		personList.add(new Person("Bhargav", 22));
		personList.add(new Person("Ruchir", 25));
		personList.add(new Person("Nana", 24));
		personList.add(new Person("PMK", 23));

		Iterator<Person> iterator = personList.iterator();
		if (iterator.hasNext()) {
			Person personObj = iterator.next();
			personObj.name = "Pavitra";
			personObj.age = 18;
		}

		printList(personList);

		ListIterator<Person> personListIterator = personList.listIterator();

		if (personListIterator.hasNext()) {
			personListIterator.next();
			personListIterator.set(new Person("Jobs", 65));
		}

		printList(personList);
	}

	private static void printList(List<Person> personList) {
		Iterator<?> iterator = personList.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println();

	}

	private static class Person {
		int age;
		String name;

		public Person(String name, int age) {
			this.age = age;
			this.name = name;
		}

		@Override
		public String toString() {
			return "Person ->  " + name + ": " + age;
		}
	}
}
