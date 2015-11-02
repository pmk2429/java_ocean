package inheritance;

public class Rectangle extends Shape{
	double length ;
	double width;
	
	public Rectangle(){
		length = 2.0;
		width = 2.5;
	}
	
	public Rectangle(double width, double length){
		
	}
	
	public Rectangle(double width, double length, String name, String color, boolean filled){
		super(name, color, filled);
		setLength(length);
		setWidth(width);
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getArea(){
		return (length * width);
	}
	
	public double getPerimeter(){
		return ((length + width) * 2);
	}
	
	public String toString(){
		return "";
	}
}
