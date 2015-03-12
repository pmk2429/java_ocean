package InheritanceVsComposition;

class Peel {
	int peelCount;

	public Peel(int peelCount) {
		this.peelCount = peelCount;
	}

	public int getPeelCount() {
		return peelCount;
	}
}

class Fruit {
	// Return a Peel object that
	// results from the peeling activity.
	public int peel() {
		System.out.println("Peeling is appealing.");
		return 2429;
	}
}

// Apple still compiles and works fine
class Apple extends Fruit {
	private Fruit fruit = new Fruit();

	public int peel() {
		// return fruit.peel();
		return super.peel();
	}
}

public class FruitInheritance {
	public static void main(String[] args) {
		Apple apple = new Apple();
		int pieces = apple.peel();
		System.out.println(pieces);
	}
}
