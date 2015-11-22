package practice;

import java.util.HashSet;

public class AnotherDemo {
	public static void main(String[] args) {
		int[] arrayInt = { 2, 4, 5, 77, 88, 59, 63, 4, 77 };
		AnotherDemo anotherObj = new AnotherDemo();
		int repeat = anotherObj.getRepeatedNos(arrayInt);
		System.out.println("No repeated: " + repeat);
	}

	private int getRepeatedNos(int[] arrayInt) {
		HashSet<Integer> set = new HashSet<Integer>();
		int duplicate = 0;
		for (int i = 0; i < arrayInt.length; i++) {
			if (set.contains(arrayInt[i])) {
				duplicate = arrayInt[i];
			} else {
				set.add(arrayInt[i]);
			}
		}
		return duplicate;
	}
}
