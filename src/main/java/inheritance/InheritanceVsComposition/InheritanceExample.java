package inheritance.InheritanceVsComposition;

class Shape {
	int size, length;
	String color;

	public void area() {
		System.out.println("AREA in SHAPE class...");
	}

	public void volume() {
		System.out.println("VOLUME in SHAPE class...");
	}
}

class Rectangle extends Shape {
	public void area() {
		System.out.println("AREA in RECTANGLE shape...");
	}

	public void volume() {
		System.out.println("VOLUME in RECTANGLE class...");
	}
}

class Default extends Shape {
	public void area(){
		System.out.println(65654);
	}
}

public class InheritanceExample {
	public static void main(String[] args) {
		Shape shape = new Rectangle();
		shape.area();

		Shape def = new Default();
		def.area();
	}
}
