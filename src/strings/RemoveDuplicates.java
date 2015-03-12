package strings;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RemoveDuplicates {
	public static void main(String[] args) {
		List<Character> noDuplicate = new ArrayList<Character>();
		System.out.println("Enter the String: ");
		System.out.print("> ");
		Scanner input = new Scanner(System.in);
		String inputString = input.next();
		input.close();

		RemoveDuplicates removeObj = new RemoveDuplicates();
		noDuplicate = removeObj.removeDuplicates(inputString);
		removeObj.printModifiedString(noDuplicate);
	}

	private void printModifiedString(List<Character> noDuplicate) {
		for (int i = 0; i < noDuplicate.size(); i++) {
			System.out.print(noDuplicate.get(i) + ", ");
		}

	}

	private List<Character> removeDuplicates(String inputString) {
		Map<Character, Integer> mapCharacters = new HashMap<Character, Integer>();
		List<Character> removedChars = new ArrayList<Character>();
		List<Character> singleChars = new ArrayList<Character>();

		for (int i = 0; i < inputString.length(); i++) {
			// if the HashMap contains the character already, then
			// simply increase its count to 2 and add that character
			// to removedChars[] array.
			if (mapCharacters.containsKey(inputString.charAt(i))) {
				mapCharacters.put(inputString.charAt(i),
						mapCharacters.get((inputString.charAt(i)) + 1));
				removedChars.add(inputString.charAt(i));
			} else {
				// if the HashMap encounters the character for the first time,
				// then add it to HashMap with count 1 and add that character
				// to singleChars[] array.
				mapCharacters.put(inputString.charAt(i), 1);
				singleChars.add(inputString.charAt(i));
			}
		}

		return singleChars;
	}
}
