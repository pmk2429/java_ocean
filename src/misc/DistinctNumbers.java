package misc;

/**
 * DistinctNumbers method is used to find Distinct number from a ArrayList.
 * The class implements Map<K,V> for storing and looking up the distinct numbers
 * Since ArrayList takes O(1) for insertion and also Map<K,V> takes constant order time
 * O(1) for insertion, the total time required to look for distinct numbers
 * is constant by the function of length of collection list.
 */

import java.util.*;
import java.util.concurrent.TimeUnit;

public class DistinctNumbers {
	public static void main(String[] args) {
		ArrayList<Integer> listItems = new ArrayList<Integer>();
		System.out.println("Enter the numbers to add to list");
		System.out.print("> ");
		Scanner input = new Scanner(System.in);
		while (input.hasNextInt()) {
			listItems.add(input.nextInt());
		}
		input.close();
		System.out.println("\nItems in the list are: ");
		for (int i = 0; i < listItems.size(); i++) {
			System.out.print(listItems.get(i) + " ");
		}
		DistinctNumbers dnObj = new DistinctNumbers();
		Map<Integer, Integer> mapUniqueOrdered = new HashMap<Integer, Integer>();
		Map<Integer, Integer> mapUnique = new HashMap<Integer, Integer>();

		final long startTime = System.nanoTime();
		// Print all Distinct numbers in sequential ascending order.
		mapUniqueOrdered = dnObj.findDistinctNumbersInOrder(listItems);
		dnObj.printDistinctNumbers(mapUniqueOrdered);

		final long duration = System.nanoTime() - startTime;

		long msDuration = TimeUnit.MILLISECONDS.convert(duration,
				TimeUnit.NANOSECONDS);
		long secDuration = TimeUnit.SECONDS.convert(duration,
				TimeUnit.NANOSECONDS);
		// Print out the running time of program.
		System.out.println("\n-----------------------------------\n");
		System.out.println("Running time: " + msDuration + " milliseconds");
		System.out.println("Running time: " + secDuration + " seconds");
		System.out.println("\n-----------------------------------\n");

		// Print all Distinct numbers in the insertion order. mapUnique =
		mapUnique = dnObj.findDistinctNumbers(listItems);
		dnObj.printDistinctNumbers(mapUnique);
	}

	// Method to find distinct numbers and maintaining the insertion order.
	private Map<Integer, Integer> findDistinctNumbers(
			ArrayList<Integer> listItems) {
		int count = 1;
		Map<Integer, Integer> mapNumbers = new HashMap<Integer, Integer>();
		for (int i = 0; i < listItems.size(); i++) {
			if (mapNumbers.containsKey(listItems.get(i))) {
				mapNumbers.put(listItems.get(i), count + 1);
			} else {
				mapNumbers.put(listItems.get(i), count);
			}
		}
		return mapNumbers;
	}

	// Method to find the distinct numbers in the List.
	private Map<Integer, Integer> findDistinctNumbersInOrder(
			ArrayList<Integer> listItems) {
		int count = 1;
		Map<Integer, Integer> mapNumbers = new HashMap<Integer, Integer>();
		Map<Integer, Integer> mapOrdered = new HashMap<Integer, Integer>();
		for (int i = 0; i < listItems.size(); i++) {
			if (mapNumbers.containsKey(listItems.get(i))) {
				mapNumbers.put(listItems.get(i), count + 1);
			} else {
				mapNumbers.put(listItems.get(i), count);
			}
		}
		// Passing the HashMap to TreeMap will remove all the duplicate elements
		// and also will order the map in ascending order.
		mapOrdered = new TreeMap<Integer, Integer>(mapNumbers);

		return mapOrdered;
	}

	// Print the distinct numbers from the map.
	private void printDistinctNumbers(Map<Integer, Integer> mapUnique) {
		System.out.println("\n\nDistinct numbers for Unordered Map: ");
		Set<?> setMap = mapUnique.entrySet();
		Iterator<?> iter = setMap.iterator();
		while (iter.hasNext()) {
			Map.Entry<?, ?> mapData = (Map.Entry<?, ?>) iter.next();
			if ((Integer) mapData.getValue() == 1) {
				System.out.print(mapData.getKey() + " ");
			}
		}
	}

	// Print the distinct numbers from the map which is already ordered
	private void printDistinctNumbersInOrder(Map<Integer, Integer> mapUnique) {
		System.out.println("\n\nDistinct numbers in entered for Ordered Map: ");
		Set setMap = mapUnique.entrySet();
		Iterator iter = setMap.iterator();
		while (iter.hasNext()) {
			Map.Entry mapData = (Map.Entry) iter.next();
			System.out.print(mapData.getKey() + " ");
		}
	}

}
