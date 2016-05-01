package strings;

public class StringFun {

	public static void JavaHungry(String s) {
		System.out.println("String");
	}

	public static void JavaHungry(Object o) {
		System.out.println("Object");
	}

	public static void main(String[] args) {
		short s = 0;
		int x = 07;
		int y = 8;
		int z = 123456;
		s += x;
		System.out.println(s );
		System.out.println("" + x + y + z);
	}

}
