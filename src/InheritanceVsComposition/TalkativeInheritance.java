package InheritanceVsComposition;

interface Talkative {
	void talk();

	String getData();
}

abstract class Animal implements Talkative {
	abstract public void talk();

	Animal animal;

	public Animal(Animal animal) {
		this.animal = animal;
	}

}

class Dog extends Animal {
	public Dog(Animal animal) {
		super(animal);
	}

	public void talk() {
		System.out.println("Woof!");
	}

	@Override
	public String getData() {
		return "tyson";
	}
}

class Interrogator {
	static void makeItTalk(Talkative subject) {
		subject.talk();
	}
}

class CuckooClock implements Talkative {
	public void talk() {
		System.out.println("Cuckoo, cuckoo!");
	}

	@Override
	public String getData() {
		return "bee bee";
	}
}

// ======================== Main class.
public class TalkativeInheritance {
	public static void main(String[] args) {
		CuckooClock cc = new CuckooClock();

	}
}
