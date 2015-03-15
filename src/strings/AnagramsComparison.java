package strings;

import java.util.*;

/**
 * AnagramsComparison class is used to decide if two strings are anagrams or
 * not.
 * 
 * @author Pavitra
 *
 */

public class AnagramsComparison {

	List<Character> wordList = new ArrayList<Character>();
	List<Character> anagramList = new ArrayList<Character>();

	public static void main(String[] args) {
		String word = "mother-in-law";
		String anagram = "woman hitler";
		AnagramsComparison comparisonObj = new AnagramsComparison();
		comparisonObj.createList(word, anagram);

	}

	public void createList(String word, String anagram) {
		for (int i = 0; i < word.length(); i++) {
			if (Character.isAlphabetic(word.charAt(i))) {
				wordList.add(word.charAt(i));
			}
		}
		for (int i = 0; i < anagram.length(); i++) {
			if (Character.isAlphabetic(anagram.charAt(i))) {
				anagramList.add(anagram.charAt(i));
			}
		}

		Collections.sort(wordList);
		Collections.sort(anagramList);

		System.out.print("WordList : ");
		for (int i = 0; i < wordList.size(); i++) {
			System.out.print(wordList.get(i) + " ");
		}
		System.out.println();
		System.out.print("AnagramList : ");
		for (int i = 0; i < wordList.size(); i++) {
			System.out.print(wordList.get(i) + " ");
		}

		System.out.println("\n");
		System.out.println("Comparing 2 lists:");
		System.out.println(wordList.equals(anagramList));

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anagramList == null) ? 0 : anagramList.hashCode());
		result = prime * result + ((wordList == null) ? 0 : wordList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		AnagramsComparison other = (AnagramsComparison) obj;

		if (anagramList == null) {
			if (other.anagramList != null)
				return false;
		} else if (!anagramList.equals(other.anagramList))
			return false;
		if (wordList == null) {
			if (other.wordList != null)
				return false;
		} else if (!wordList.equals(other.wordList))
			return false;
		return true;
	}

}
