package inheritance;

public class Circle extends Shape {

	double radius;

	public Circle() {
		radius = 1.0;
	}

	public Circle(double radius) {
		setRadius(radius);
	}

	public Circle(double radius, String name, String color, boolean filled) {
		super(name, color, filled);
		setRadius(radius);
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getArea() {
		return (3.14 * radius * radius);
	}

	public double getPerimeter() {
		return (2 * 3.14 * radius);
	}

	public String toString() {
		return "";
	}
}
