package designPattern.decoratorPattern;

import designPattern.decoratorPattern.entities.Circle;
import designPattern.decoratorPattern.entities.Rectangle;
import designPattern.decoratorPattern.entities.RedShapeDecorator;
import designPattern.decoratorPattern.interfaces.Shape;

public class DecoratorPatternDemo {
	public static void main(String[] args) {

		Shape circle = new Circle();

		Shape redCircle = new RedShapeDecorator(new Circle());

		Shape redRectangle = new RedShapeDecorator(new Rectangle());
		System.out.println("Circle with normal border");
		circle.draw();

		System.out.println("\nCircle of red border");
		redCircle.draw();

		System.out.println("\nRectangle of red border");
		redRectangle.draw();
	}
}
