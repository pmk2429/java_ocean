package memory;

import java.util.ArrayList;
import java.util.List;
import java.lang.Runtime;

public class PerformanceTest {
	private static final long MEGABYTE = 1024L * 1024L;

	public static long bytesToMegabytes(long bytes) {
		return bytes / MEGABYTE;
	}

	public static void main(String[] args) {
		// I assume you will know how to create a object Person yourself...
		List<Person> list = new ArrayList<Person>();
		for (int i = 0; i <= 100000; i++) {
			list.add(new Person("Jim", "Knopf"));
		}
		// Get the Java runtime
		Runtime runtime = Runtime.getRuntime();
		// Run the garbage collector
		runtime.gc();
		// Calculate the used memory
		long memory = runtime.totalMemory() - runtime.freeMemory();
		System.out.println("Used memory is bytes: " + memory);
		System.out.println("Used memory is megabytes: "
				+ bytesToMegabytes(memory));
	}
}

class Person {
	String first, last;
	int age;

	public Person(String first, String last) {
		this.first = first;
		this.last = last;
	}

	public String getFirst() {
		return first;
	}

	public void seFirst(String first) {
		this.first = first;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}