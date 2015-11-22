package polymorphism;

public class PolymorphismTest {
	public static void main(String[] args) {
		LivingBeing livingBeing = new Humans();
		livingBeing.breathe();

		livingBeing = new Animal();
		livingBeing.breathe();
	}
}
