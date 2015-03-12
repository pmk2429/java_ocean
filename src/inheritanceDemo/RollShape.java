package inheritanceDemo;

public class RollShape {
	public static void main(String[] args) {
		
		/** 
		 * We are assigning SuperClass reference to Subclass object.
		 * since we have Shape as Super class and Circle, Rectangle as our
		 * subclass, we are assigning s1(Shape Reference), Circle and Rectangle
		 * Objects.
		 * By doing this, s1 will have the knowledge of all the Subclass members?
		 *  NO
		 * A superclass cannot know ever, what are the members of its subclass.
		 * This is how we need to use Inheritance and Polymorphism.  
		 */
		
		System.out.println("---------- 1) Upcast Circle, Rectangle to Shape");
		// UPCAST Circle to Shape.
		Shape s1 = new Circle(5.5, "Circle", "red", true);
		System.out.println("Color of " + s1.getName() + " : " + s1.getColor());
		System.out.println("Area of " + s1.getName() + " : " + s1.getArea());
		System.out.println("Perimeter of " + s1.getName() + " : " + s1.getPerimeter());
		System.out.println("--------------------------------------");
		
		// UPCAST Rectangle to Shape.
		Shape s2 = new Rectangle(7, 5, "Rectangle", "blue", true);
		System.out.println("Color of " + s2.getName() + " : " + s2.getColor());
		System.out.println("Area of " + s2.getName() + " : " + s2.getArea());
		System.out.println("Perimeter of " + s2.getName() + " : "+ s2.getPerimeter());

		System.out.println("\n\n");
		System.out.println("---------- 2) DOWNCAST back to Circle, Rectangle");
		// DOWNCAST Circle to Shape.
		// Downcast only after the original Shape object has been upcast by Circle.
		Circle c1 = (Circle)s1;
		System.out.println("Color of " + c1.getName() + " : " + c1.getColor());
		System.out.println("Area of " + c1.getName() + " : " + c1.getArea());
		System.out.println("Perimeter of " + c1.getName() + " : " + c1.getPerimeter());
		
		System.out.println("--------------------------------------");
		// DOWNCAST Rectangle to Shape.
		// Downcast only after the original Shape object has been upcast by Rectangle.
		Rectangle r1 = (Rectangle)s2;
		System.out.println("Color of " + r1.getName() + " : " + r1.getColor());
		System.out.println("Area of " + r1.getName() + " : " + r1.getArea());
		System.out.println("Perimeter of " + r1.getName() + " : "+ r1.getPerimeter());
		
		
		
		
		
		
	}
}
