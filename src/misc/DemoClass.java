package misc;

public class DemoClass {
	int a = 10;

	public static void main(String[] args) {
		DemoClass obj = new DemoClass();

		Class classType = obj.getClass();
		System.out.println("Type of class: " + classType.getName());
	}
}

class Demo2 extends DemoClass {
	int b = 15;
}
