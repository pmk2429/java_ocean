package generics;

public class GenericsSingleDemo {
	public static void main(String[] args) {
		SimpleGeneric<String> sgs = new SimpleGeneric<String>(
				"Pavitra M Kansara");
		sgs.printType();

		SimpleGeneric<Boolean> sgb = new SimpleGeneric<Boolean>(Boolean.TRUE);
		sgb.printType();

		SimpleGeneric<Integer> sgi = new SimpleGeneric<Integer>(new Integer(5));
		sgi.printType();

		Person2 person2 = new Person2();
		SimpleGeneric<Person2> sgPerson = new SimpleGeneric<Person2>(person2);
		sgPerson.printType();
		String name = sgPerson.getObj().getName();
		System.out.println("Name of person : " + name + " is "
				+ sgPerson.getObj().getAge() + " years old");

		sgPerson.getObj().setAge(25);
		System.out.println("New age: " + sgPerson.getObj().getAge());
	}
}

class SimpleGeneric<T> {
	private T obj = null;

	public SimpleGeneric(T param) {
		this.obj = param;
	}

	public T getObj() {
		return this.obj;
	}

	public void printType() {
		System.out.println("Type: " + obj.getClass().getName());
	}
}

class Person {
	String name;
	int age;

	Person() {
		name = "pmk";
		age = 2429;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}

class Animal {
	String type;
	int weight;

	Animal() {
		type = "tiger";
		weight = 10;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
