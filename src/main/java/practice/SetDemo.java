package practice;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {
	public static void main(String[] args) {
		Set<String> shots = new HashSet<String>();

		shots.add("add");
		shots.add("subtract");
		shots.add("divide");
		shots.add("multiply");
		shots.add("zero");

		if (shots.contains("dcjk")) {
			System.out.println("Yeah baby");
		}

	}
}
