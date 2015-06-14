package practice;

import java.util.ArrayList;

interface Shape {
	public Shape getShape();
}

class Circle implements Shape {

	@Override
	public Shape getShape() {
		return this;
	}

	@Override
	public String toString() {
		return "Circle []";
	}

}

class Rectangle implements Shape {

	@Override
	public Shape getShape() {
		return this;
	}

	@Override
	public String toString() {
		return "Rectangle []";
	}

}

class ShapeTest {

	ArrayList<Shape> shapes = new ArrayList<Shape>();

	public void addShapes(Shape shape) {
		shapes.add(shape);
	}

	public ArrayList<Shape> getShapes() {
		return shapes;
	}
}

public class PolyTest {
	public static void main(String[] args) {

		ShapeTest shapeObj = new ShapeTest();
		Rectangle rectangle = new Rectangle();
		Circle circle = new Circle();
		shapeObj.addShapes(circle);
		shapeObj.addShapes(rectangle);

		ArrayList<Shape> shapes = shapeObj.getShapes();
		for (Shape shape : shapes) {
			// if (shape.getClass().isInstance(new Circle())) {
			// System.out.println(shape.toString());
			// }
			if (shape.getShape().equals(rectangle)) {
				System.out.println("Rectangle is present");
			}
		}

	}
}
