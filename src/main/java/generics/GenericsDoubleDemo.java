package generics;

public class GenericsDoubleDemo {
	public static void main(String[] args) {
		MultipleGenerics<String, Integer> multipleObj1 = new MultipleGenerics<String, Integer>(
				"pmk", 2429);
		multipleObj1.printType();

		Person2 personObj = new Person2();
		Animal2 animalObj = new Animal2();

		MultipleGenerics<Person2, Animal2> multipleObj2 = new MultipleGenerics<Person2, Animal2>(
				personObj, animalObj);
		multipleObj2.printType();
		String name = "", type = "";
		int age = 0, weight = 0;
		System.out.println();
		if (multipleObj2.getObjU().getClass().getName()
				.equals(personObj.getClass().getName())) {
			name = multipleObj2.getObjU().getName();
			age = multipleObj2.getObjU().getAge();
			System.out.println(name + " is " + age + " years old!!!");
		}
		if (multipleObj2.getObjV().getClass().getName()
				.equals(animalObj.getClass().getName())) {
			name = multipleObj2.getObjV().getName();
			type = multipleObj2.getObjV().getType();
			weight = multipleObj2.getObjV().getWeight();
			System.out.println(name + " is " + type + " weighing " + weight
					+ " pounds!!!");
		}

	}
}

class MultipleGenerics<U, V> {
	private U objU = null;
	private V objV = null;

	public MultipleGenerics(U objU, V objV) {
		this.objU = objU;
		this.objV = objV;
	}

	public U getObjU() {
		return this.objU;
	}

	public V getObjV() {
		return this.objV;
	}

	public void printType() {
		System.out.println("First Type: " + objU.getClass().getName());
		System.out.println("Second Type: " + objV.getClass().getName());
	}
}

class Person2 {
	String name;
	int age;

	Person2() {
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

class Animal2 {
	String type, name;
	int weight;

	Animal2() {
		name = "Dan";
		type = "tiger";
		weight = 10;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
