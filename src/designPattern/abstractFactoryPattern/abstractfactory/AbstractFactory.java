package designPattern.abstractFactoryPattern.abstractfactory;

import designPattern.abstractFactoryPattern.color.Color;
import designPattern.abstractFactoryPattern.shape.Shape;

public abstract class AbstractFactory {
	public abstract Color getColor(String color);

	public abstract Shape getShape(String shape);
}