package encoding;

import java.util.Scanner;

public class BinaryText {
	public static void main(String[] args) {
		System.out.println("Enter the input Text to convert to Binary:");
		System.out.print("> ");
		Scanner input = new Scanner(System.in);
		String inputText = input.nextLine();
		input.close();

		BinaryText bTextObj = new BinaryText();

		// Convert Simple text to Binary Text;
		String binaryText = bTextObj.convertTextToBinary(inputText);
		bTextObj.printBinaryText(binaryText);

		// Convert Binary text to Simple Text;
		String simpleText = bTextObj.convertBinaryToText(binaryText);
		bTextObj.printSimpleText(simpleText);

	}

	public String convertTextToBinary(String simpleText) {
		String s = simpleText;
		byte[] bytes = s.getBytes();
		StringBuilder binary = new StringBuilder();
		for (byte b : bytes) {
			int val = b;
			for (int i = 0; i < 8; i++) {
				binary.append((val & 128) == 0 ? 0 : 1);
				val <<= 1;
			}
			binary.append(' ');
		}
		return binary.toString();
	}

	public void printBinaryText(String binaryText) {
		System.out.println("\nEquvivalent Binary Text:");
		System.out.println(binaryText);

	}

	public String convertBinaryToText(String binaryText) {
		String simpleText = "";
		for (int i = 0; i <= binaryText.length() - 8; i += 9) {
			int k = Integer.parseInt(binaryText.substring(i, i + 8), 2);
			simpleText += (char) k;
		}
		return simpleText;
	}

	public void printSimpleText(String simpleText) {
		System.out.println("\nOriginal simple Text:");
		System.out.println(simpleText);

	}

}
