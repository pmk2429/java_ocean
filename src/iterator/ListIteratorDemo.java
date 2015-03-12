package iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class ListIteratorDemo {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("merc");
		list.add("audi");
		list.add("bmw");
		list.add("ford");
		list.add("bentley");

		for (Iterator<String> it = list.iterator(); it.hasNext();) {
			String listItem = it.next();
			System.out.println(listItem);
		}
		System.out.println("-----------------");
		System.out.println("removing elements using iterator");
		int i = 0;
		for (String listItem : list) {
			if (listItem.equals("ford")) {
				list.remove(i);
			} else {
				i++;
			}
		}
		System.out.println("-----------------");
		for (Iterator<String> it = list.iterator(); it.hasNext();) {
			String listItem = it.next();
			System.out.println(listItem);
		}
	}
}
