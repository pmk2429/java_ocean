package pattern;

import java.util.*;
import java.util.regex.Pattern;

public class PatternMatchDemo {
	public static void main(String[] args) {
		System.out.println("Enter the String to split using Pattern class");
		System.out.print("> ");
		Scanner input = new Scanner(System.in);
		String inputString = input.nextLine();
		input.close();
		PatternMatchDemo patternObj = new PatternMatchDemo();
		String[] arrayWords = patternObj.splitStringToWords(inputString);
		patternObj.printWords(arrayWords);

		// matches() method
		boolean matches = patternObj
				.matchStringPattern(
						"This is the text to be searched for occurrences of the pattern.",
						" is ");
		if (matches == true) {
			System.out.println("\nYES, the pattern matches");
		} else {
			System.out.println("\nNO, the pattern does not match");
		}
	}

	private void printWords(String[] arrayWords) {
		for (int i = 0; i < arrayWords.length; i++) {
			System.out.println(arrayWords[i]);
		}
	}

	/**
	 * splitStringToWords() is used to split the string into distinct words
	 * using a compile() method. The regex passed as parameter in the compile()
	 * method is "\\W+" which indicates that the compile method splits the words
	 * containing only the alphabets in the String and no special sequence
	 * characters like Whitespace or special symbols.
	 * 
	 * @param inputString
	 *            returns String array
	 */
	public String[] splitStringToWords(String inputString) {
		Pattern pattern = Pattern.compile("\\W+");
		String[] words = pattern.split(inputString);
		return words;
	}

	/**
	 * Another way to check the regular expression pattern matches a text is to
	 * use the static Pattern.matches() method.
	 */
	public boolean matchStringPattern(String text, String pattern) {
		boolean matches = Pattern.matches(text, pattern);
		return matches;
	}

}
