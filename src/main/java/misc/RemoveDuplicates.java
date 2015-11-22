package misc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RemoveDuplicates {
	public static void main(String[] args) {
		List<Integer> listNos = new LinkedList<Integer>();
		RemoveDuplicates rdObj = new RemoveDuplicates();
		Integer[] array = { 18, 14, 96, 25, 15, 25, 25, 18 };
		listNos.addAll(Arrays.asList(array));
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.addAll(Arrays.asList(array));
		System.out.println("List: " + list.getFirst());

		// List<Integer> updatedList = rdObj.removeDuplicates(listNos);
		// System.out.println(updatedList);
	}

	private List<Integer> removeDuplicates(List<Integer> listNos) {
		for (int i = 0; i < listNos.size(); i++) {
			int temp = listNos.get(i);
			for (int j = i; j < listNos.size() - 1; j++) {
				int temp2 = listNos.get(j + 1);
				if (temp != temp2) {
					continue;
				} else {
					// listNos.remove(j + 1);
					listNos.remove(i);
				}
			}
		}
		return listNos;
	}
}
