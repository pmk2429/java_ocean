package practice;

import java.util.Scanner;

public class Demo1 {
	static {
		System.out.println("This is first static block");
	}

	static {
		System.out.println("Amigoes");
	}

	public Demo1() {
		System.out.println("This is constructor");
	}

	public static String staticString = "Static Variable";

	static {
		System.out.println("This is second static block and " + staticString);
	}

	public static void main(String[] args) {
		Demo1 statEx = new Demo1();
		Demo1.staticMethod2();
	}

	static {
		staticMethod();
		System.out.println("This is third static block");
	}

	public static void staticMethod() {
		System.out.println("This is static method");
	}

	public static void staticMethod2() {
		System.out.println("This is static method2");
	}
}
