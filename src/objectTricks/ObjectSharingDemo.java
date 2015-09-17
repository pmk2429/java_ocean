package objectTricks;

public class ObjectSharingDemo {
	public static void main(String[] args) {
		BarClass theBar = new BarClass();
		FooClass theFoo = new FooClass(theBar);
		System.out.println("a: " + theFoo.a);
		System.out.println("b: " + theFoo.b);
		// change the value of 'a' in FooClass using theBar reference.
		theBar.foo.a = 234;

		System.out.println("changed a: " + theFoo.a);
	}
}

class BarClass {
	FooClass foo = null;

	public BarClass() {
	}

	public void setFoo(FooClass foo) {
		this.foo = foo;
	}
}

class FooClass {
	BarClass bar = null;
	int a = 0;
	int b = 1;
	int c = 2;

	public FooClass(BarClass bar) {
		this.bar = bar;
		bar.setFoo(this);
	}
}