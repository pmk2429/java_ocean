package designPattern.factoryPattern;

public class FactoryDemo {
	public static void main(String[] args) {
		Human human = HumanFactory.createHuman("boy");
		human.Walk();
		human.Talk();
	}
}
