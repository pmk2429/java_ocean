package InheritanceVsComposition;

public class InheritanceVSComposition {
	public static void main(String[] args) {
		Insect i = new Bee(1, "red");
		i.attack();

		System.out.println(i.getColor());

		System.out.println("==============");

		// Insect i2 = new Insect(5, "green");
		// i2.attack();
	}
}

class Bee extends Insect {
	public Bee(int size, String color) {
		super(size, color);
	}

	public void move() {
		System.out.println("Fly in Bee");
	}

	public void attack() {
		move();
		System.out.println("Attack in Bee");
		super.attack();
	}

	public void doSomething() {
		System.out.println("Did something");
	}
}

class Insect {
	private int size;
	private String color;

	public Insect(int size, String color) {
		this.size = size;
		this.color = color;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void move() {
		System.out.println("Move in Insect");
	}

	public void attack() {
		move(); // assuming an insect needs to move before attacking
		System.out.println("Attack in Insect");
	}

}
