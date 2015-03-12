package polymorphism;

public class Humans implements LivingBeing {

	@Override
	public void breathe() {
		System.out.println("Human is breathing");

	}

	@Override
	public void walk() {
		System.out.println("Human is Walking");

	}

	@Override
	public void eat() {
		System.out.println("Human is Eating");

	}

	@Override
	public void drink() {
		System.out.println("Human is Drinking");

	}

	@Override
	public void sleep() {
		System.out.println("Human is Sleeping");

	}

}
