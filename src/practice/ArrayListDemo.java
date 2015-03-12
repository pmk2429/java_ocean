package practice;

import java.util.ArrayList;

public class ArrayListDemo {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add(null);

		System.out.println("List is null? " + (list == null));
		System.out.println("Size of list: " + list.size());
		System.out.println("List content: " + list.get(0));
		System.out.println("Is List empty? " + list.isEmpty());
	}
}
