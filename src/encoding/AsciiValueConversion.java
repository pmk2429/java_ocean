package encoding;

public class AsciiValueConversion {
	public static void main(String[] args) {
		char[] largeAlphabets = new char[26];
		int j = 65;
		for (int i = 0; i < largeAlphabets.length; i++) {
			largeAlphabets[i] = (char) j;
			j++;
		}
		System.out.print(largeAlphabets);
		System.out.println("");
		char[] smallAlphabets = new char[26];
		int sA = 97;
		for (int i = 0; i < smallAlphabets.length; i++) {
			smallAlphabets[i] = (char) sA;
			sA++;
		}
		System.out.print(smallAlphabets);
	}
}
