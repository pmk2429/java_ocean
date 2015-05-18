package designPattern.decoratorPattern.abstraction;

import designPattern.decoratorPattern.interfaces.Shape;

public class ShapeDecorator implements Shape {

	protected Shape decoratedShape;

	public ShapeDecorator(Shape decoratedShape) {
		this.decoratedShape = decoratedShape;
	}

	public void draw() {
		decoratedShape.draw();
	}

}
