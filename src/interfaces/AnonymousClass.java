package interfaces;

public class AnonymousClass {
	interface DemoInterface {
		public void greet();

		public void meet(String someone);
	}

	public void sayHello() {
		class EnglishGreeting implements DemoInterface {

			public void greet() {
				meet("English Greeting world");
			}

			@Override
			public void meet(String someone) {
				System.out.println(someone);
			}
		}

		DemoInterface englishGreeting = new EnglishGreeting();

		DemoInterface frenchGreeting = new DemoInterface() {
			String name = "tout le monde";

			public void greet() {
				meet("tout le monde");
			}

			@Override
			public void meet(String someone) {
				name = someone;
				System.out.println("Salut " + name);

			}
		};
		englishGreeting.greet();
		frenchGreeting.greet();
	}

	public static void main(String... args) {
		AnonymousClass myApp = new AnonymousClass();
		myApp.sayHello();
	}
}
