package strings;

/**
 * StringPermutations class is used to find all PERMUTATIONS of a given string
 * 
 */

import java.util.HashSet;
import java.util.Set;

/**
 * @author Pavitra
 * 
 */

public class StringPermutations {

	public static void main(String[] args) {
		String s = "ABC";
		String s1 = "EBAY";
		String s2 = "PMK";
		System.out.println("\nString " + s + ":\nPermutations: "
				+ stringPermutation(s));
		System.out.println("\nString " + s1 + ":\nPermutations: "
				+ stringPermutation(s1));
		System.out.println("\nString " + s2 + ":\nPermutations: "
				+ stringPermutation(s2));
	}

	public static Set<String> stringPermutation(String str) {
		Set<String> result = new HashSet<String>();
		if (str == null) {
			return null;
		} else if (str.length() == 0) {
			result.add("");
			return result;
		}

		char firstChar = str.charAt(0);
		String rem = str.substring(1);
		Set<String> words = stringPermutation(rem);
		for (String newString : words) {
			for (int i = 0; i <= newString.length(); i++) {
				result.add(addChar(newString, firstChar, i));
			}
		}
		return result;
	}

	public static String addChar(String str, char c, int j) {
		String first = str.substring(0, j);
		String last = str.substring(j);
		return first + c + last;
	}

}
