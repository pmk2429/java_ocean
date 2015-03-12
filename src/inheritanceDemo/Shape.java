package inheritanceDemo;

public abstract class Shape {
	String color = "red";
	boolean filled = true;
	String name;
	
	public Shape(){}
	
	public Shape(String name, String color, boolean filled){
		setName(name);
		setColor(color);
		setFilled(filled);
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 *  Abstract methods
	 */
	public abstract String toString();
	
	public abstract double getArea();
	
	public abstract double getPerimeter();
	
	
	
}
