package strings;

public class Anagrams {
	public static void main(String[] args) {
		String s1 = "human";
		String s2 = "manuh";

		Anagrams anagramObj = new Anagrams();
		boolean isAnagram = anagramObj.anagram(s1, s2);
		if (isAnagram) {
			System.out.println("Yes, strings are anagram");
		} else {
			System.out.println("No, strings are not anagram");
		}
	}

	public boolean anagram(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}

		int[] letters = new int[256];
		int numOfUniqueChars = 0;
		int numCompletedInS2 = 0;
		char[] s1_array = s1.toCharArray();
		for (char c : s1_array) {
			if (letters[c] == 0) {
				++numOfUniqueChars;
			}
			++letters[c];
		}

		for (int i = 0; i < s2.length(); ++i) {
			int c = (int) s2.charAt(i);
			if (letters[c] == 0) {
				return false;
			}
			--letters[c];
			if (letters[c] == 0) {
				++numCompletedInS2;
				if (numCompletedInS2 == numOfUniqueChars) {
					return i == s2.length() - 1;
				}
			}
		}
		return false;
	}
}
