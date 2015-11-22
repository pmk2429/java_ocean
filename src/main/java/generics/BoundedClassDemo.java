package generics;

/**
 * Created by Pavitra on 10/19/2014.
 */
public class BoundedClassDemo {
	public static void main(String a[]) {
		// Creating object of sub class C and
		// passing it to BoundEx as a type parameter.
		BoundEx<C> bec = new BoundEx<C>(new C());
		bec.doRunTest();

		// Creating object of sub class B and
		// passing it to BoundEx as a type parameter.
		BoundEx<B> beb = new BoundEx<B>(new B());
		beb.doRunTest();

		// similarly passing super class A
		
		BoundEx<A<String>> bea = new BoundEx<A<String>>(new A());
		bea.doRunTest();
		
		
		// If you uncomment below code it will throw compiler error
		// because we restricted to only of type A and its sub classes.

		// BoundEx<String> bes = new BoundEx<String>(new String());
		// bea.doRunTest();
	}

}

/**
 * This class only accepts type parameters as any class which extends class A or
 * class A itself. Passing any other type will cause compiler time error
 */
class BoundEx<T extends A> {

	private T objRef;

	public BoundEx(T obj) {
		this.objRef = obj;
	}

	
	
	public void doRunTest() {
		this.objRef.printClass();
	}
}

class A<T> {
	T t;

	public void printClass() {
		System.out.println("I am in super class A");
	}

	public void set(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}
}

class B extends A {
	public void printClass() {
		System.out.println("I am in sub class B");
	}
}

class C extends A {
	public void printClass() {
		System.out.println("I am in sub class C");
	}
}
