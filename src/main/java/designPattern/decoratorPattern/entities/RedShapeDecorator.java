package designPattern.decoratorPattern.entities;

import designPattern.decoratorPattern.abstraction.ShapeDecorator;
import designPattern.decoratorPattern.interfaces.Shape;

public class RedShapeDecorator extends ShapeDecorator {

	public RedShapeDecorator(Shape decoratedShape) {
		super(decoratedShape);
	}

	@Override
	public void draw() {
		decoratedShape.draw();
		setRedBorder(decoratedShape);
	}

	private void setRedBorder(Shape decoratedShape) {
		System.out.println("Border Color: Red");
	}

}
