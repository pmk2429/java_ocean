package polymorphism;

public class Animal implements LivingBeing{

	@Override
	public void breathe() {
		System.out.println("Animal is breathing");
		
	}

	@Override
	public void walk() {
		System.out.println("Animal is Walking");
		
	}

	@Override
	public void eat() {
		System.out.println("Animal is Eating");
		
	}

	@Override
	public void drink() {
		System.out.println("Animal is Drinking");
		
	}

	@Override
	public void sleep() {
		System.out.println("Animal is Sleeping");
		
	}

}
