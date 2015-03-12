package linkedlist;

import java.util.LinkedList;
import java.util.List;

public class AddLinkedList {
	public static void main(String[] args) {
		List<Integer> list1 = new LinkedList<Integer>();
		List<Integer> list2 = new LinkedList<Integer>();
		AddLinkedList addListObj = new AddLinkedList();

		list1.add(3);
		list1.add(5);
		list1.add(5);

		list2.add(5);
		list2.add(9);
		list2.add(2);

		LinkedList<Integer> listSum = new LinkedList<Integer>();
		listSum = addListObj.addLinkedList(list1, list2);
		System.out.println(listSum);

	}

	public LinkedList<Integer> addLinkedList(List<Integer> list1, List<Integer> list2) {
		LinkedList<Integer> listSum = new LinkedList<Integer>();
		int length = list1.size();
		int remainder = 0, temp = 0, carry = 0;
		for (int i = 0; i < length; i++) {
			temp = list1.get(i) + list2.get(i);
			if (temp > 9) {
				remainder = temp - 10;
				temp = remainder;
				carry = 1;
			} else {
				temp = list1.get(i) + list2.get(i) + carry;
			}
			listSum.add(temp);
		}
		return listSum;
	}
}
