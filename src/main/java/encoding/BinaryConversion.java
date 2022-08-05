package encoding;

import java.util.Scanner;
import java.util.Stack;

public class BinaryConversion {
    public static void main(String[] args) {
        BinaryConversion dtb = new BinaryConversion();

        System.out.println("Enter Decimal number: ");
        System.out.print("> ");
        Scanner input = new Scanner(System.in);
        int decimalNumber = input.nextInt();
        input.close();

        Stack<Integer> binaryData = dtb.convertToBinary(decimalNumber);
        dtb.printBinary(binaryData);
    }

    /**
     * convertToBinary(int) method receives integer as an input parameter and
     * converts the number to its equivalent binary representation.
     */
    public Stack<Integer> convertToBinary(int decimalNumber) {
        int remainder;
        Stack<Integer> binaryData = new Stack<>();

        do {
            remainder = decimalNumber % 2;
            decimalNumber = decimalNumber / 2;
            binaryData.push(remainder);
        } while (decimalNumber >= 1);

        return binaryData;
    }

    /**
     * convertToBinary(String) method receives String as an input parameter and
     * converts the String to its equivalent binary conversion.
     */
    public String convertToBinary(String simpleText) {
        byte[] bytes = simpleText.getBytes();
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

    private void printBinary(Stack<Integer> binaryInfo) {
        System.out.println("\nThe Binary representation of number is:");
        while (!binaryInfo.isEmpty()) {
            int data = binaryInfo.pop();
            System.out.print(data);
        }
    }
}
