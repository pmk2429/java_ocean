package misc;

import java.util.*;

public class ReverseString {
	public static void main(String[] args) {
		ReverseString rs = new ReverseString();
		System.out.println("Enter the string to reverse:");
		System.out.print("> ");
		Scanner input = new Scanner(System.in);
		String inputString = input.nextLine();
		input.close();

		// reverse entire string
		String reverseString = rs.reverseWholeString(inputString);
		rs.printReversedString(reverseString);

		// reverse words in string
		String reverseWords = rs.reverseWordsInString(inputString);
		rs.printReversedString(reverseWords);
	}

	/**
	 * reverseWholeString() method will take a String as an input and will
	 * reverse the entire string character by character. For eg: inputString: my
	 * name is pavitra kansara arasnak artivap si eman ym.
	 * 
	 * 
	 * @param inputString
	 * @return
	 */
	private String reverseWholeString(String inputString) {
		String reversed = "";
		int length = inputString.length();
		for (int i = length - 1; i >= 0; i--) {
			reversed = reversed + inputString.charAt(i);
		}
		return reversed;
	}

	/**
	 * reverseWordsinString() method will reverse each word in the string
	 * 
	 * For eg: input String: my name is pavitra kasnara output String: ym eman
	 * si artivap aransak
	 * 
	 * So this method will call the reverseString method for each word in the
	 * String.
	 * 
	 * @param inputString
	 * @return
	 */
	public String reverseWordsInString(String inputString) {
		String[] words = inputString.split(" ");
		ReverseString stringObj = new ReverseString();
		String reversedString = "";
		String[] reversedWords = new String[words.length];
		for (int i = 0; i < words.length; i++) {
			reversedWords[i] = stringObj.reverseWholeString(words[i]);
			reversedString = reversedString + " " + reversedWords[i];
		}
		return reversedString;
	}

	private void printReversedString(String reverseString) {
		System.out.println("\nReverse of input String: " + reverseString);

	}
}
