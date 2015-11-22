package practice;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
	public static void main(String[] args) {
		List<List<String>> listOfList = new ArrayList<>();

		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		List<String> list3 = new ArrayList<String>();

		List<String> demo = new ArrayList<String>();

		list1.add("list1-a");
		list1.add("list1-b");

		list2.add("list2-a");
		list2.add("list2-b");

		list3.add("list3-a");
		list3.add("list3-b");

		demo.add("demo-1");
		demo.add("demo-2");

		listOfList.add(list1);
		listOfList.add(list2);
		listOfList.add(list3);

		listOfList.set(0, demo);

		System.out.println(listOfList.get(0).get(0));
		System.out.println(listOfList.get(0).get(1));
		System.out.println(listOfList.get(1).get(1));

	}
}
