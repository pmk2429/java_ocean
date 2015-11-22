package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavitra on 10/19/2014.
 */
public class GenericsMethods {

	public static <T> boolean isEqual(GenericsType<T> g1, GenericsType<T> g2) {
		return g1.get().equals(g2.get());
	}

	public static <T> void printAll(T[] tObj) {
		for (T b : tObj) {
			System.out.printf("%s", b);
		}
		System.out.println();
	}
	
	public static void loopList(List<? extends GenericsType<String>> list){
		
	}
	

	public static void main(String args[]) {
		GenericsType<String> g1 = new GenericsType<>();
		g1.set("Pavitra");
		
		GenericsType<String> g2 = new GenericsType<>();
		g2.set("2429");
		
		List<String> lst = new ArrayList<String>();
		boolean isEqual;// = GenericsMethods.<String>isEqual(g1, g2);
		// above statement can be written simply as
		isEqual = GenericsMethods.isEqual(g1, g2);
		
		// This feature, known as type inference, allows you to invoke a generic
		// method as an ordinary method, without specifying a type between angle
		// brackets.
		// Compiler will infer the type that is needed
		System.out.println(isEqual);
		GenericsMethods gm = new GenericsMethods();

		Integer[] iArray = { 1, 2, 3, 4, 5 };
		Character[] cArray = { 'a', 'b', 'c' };
		GenericsMethods.printAll(iArray);
		GenericsMethods.printAll(cArray);
		
	}

}

class GenericsType<T> {

	private T tObj;

	public T get() {
		return this.tObj;
	}

	public void set(T t1) {
		this.tObj = t1;
	}
}
