package misc;

import java.util.*;

public class RemoveCharFromString {
	char[] stringArray;

	public static void main(String[] args) {
		System.out.println("Enter a string: ");
		System.out.print("> ");
		Scanner stringInput = new Scanner(System.in);
		String original = stringInput.nextLine();

		System.out.println("\nEnter the char to remove from the String: ");
		System.out.print("> ");
		Scanner charInput = new Scanner(System.in);
		String character = charInput.next();
		char charac = character.charAt(0);
		RemoveCharFromString rcs = new RemoveCharFromString();
		rcs.removeCharFromString(original, charac);
		rcs.displayCharArray();
	}

	/**
	 * <h1>removeCharFromString(String, char)</h1> method is used to remove the
	 * specified char from the String. This method converts the input String
	 * into a Character Array and then it iterates each element of the Character
	 * Array to check whether the specified char is in the Character Array or
	 * not. If match is found then the char is replaced with a null and a count
	 * is incremented to make sure how many characters were replaced(removed).
	 * Otherwise the message is printed that the specified character was not
	 * found in the String.
	 * 
	 * @param original
	 * @param character
	 */
	private void removeCharFromString(String original, char character) {
		String mainString = original;
		char characterToRemove = character;
		int count = 0;
		for (int i = 0; i < mainString.length(); i++) {
			stringArray = mainString.toCharArray();
		}
		for (int i = 0; i < stringArray.length; i++) {
			if (characterToRemove == stringArray[i]) {
				stringArray[i] = '*';
				count++;
			}
		}
		if (count > 0) {
			System.out.printf("\n> '" + characterToRemove + "' was Successfully removed from String.\n");
		} else if (count == 0) {
			System.out.printf("\n> Sorry! '" + characterToRemove + "' was not found in input String.\n");
		}
	}

	/**
	 * displayCharArray() method prints the modified array after the specified
	 * character was removed from the String.
	 */
	private void displayCharArray() {
		System.out.print("\nFinal String: ");
		for (int i = 0; i < stringArray.length; i++) {
			System.out.print(stringArray[i] + " ");
		}
	}
}