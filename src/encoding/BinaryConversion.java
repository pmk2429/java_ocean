package encoding;

import java.util.*;

public class BinaryConversion {
	public static void main(String[] args) {
		BinaryConversion dtb = new BinaryConversion();
		// List<Integer> binary = new ArrayList<Integer>();
		Stack<Integer> binaryData = new Stack<Integer>();

		System.out.println("Enter Decimal number: ");
		System.out.print("> ");
		Scanner input = new Scanner(System.in);
		int decimalNumber = input.nextInt();
		input.close();

		binaryData = dtb.convertToBinary(decimalNumber);
		dtb.printBinary(binaryData);
	}

	/**
	 * convertToBinary(int) method receives integer as an input parameter and
	 * converts the number to its equivalent binary representation.
	 * 
	 * @param decimalNumber
	 * @return
	 */
	public Stack<Integer> convertToBinary(int decimalNumber) {
		int remainder = 0;
		Stack<Integer> binaryData = new Stack<Integer>();

		do {
			remainder = decimalNumber % 2;
			decimalNumber = decimalNumber / 2;
			// binary.add(remainder);
			binaryData.push(remainder);
		} while (decimalNumber >= 1);

		// return reverseBinaryList(binary);
		return binaryData;
	}

	/**
	 * convertToBinary(String) method receives String as an input parameter and
	 * converts the String to its equivalent binary conversion.
	 * 
	 * @param str
	 * @return
	 */
	public String convertToBinary(String simpleText) {
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

	// print the Binary data.
	private void printBinary(Stack<Integer> binaryInfo) {

		System.out.println("\nThe Binary representation of number is:");
		// for (int i = 0; i < binaryInfo.size() - 1; i++) {
		// int data = binaryInfo.pop();
		// System.out.print(data);
		// }
		while (!binaryInfo.isEmpty()) {
			int data = binaryInfo.pop();
			System.out.print(data);
		}

	}

}
