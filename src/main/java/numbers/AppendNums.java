package numbers;

import java.util.Scanner;

public class AppendNums {
    public static void main(String[] args) {
        long number1 = 0, number2 = 0;
        System.out.println("Enter 2 numbers:");
        System.out.print("Number1> ");
        Scanner input = new Scanner(System.in);
        number1 = input.nextInt();
        System.out.print("Number2> ");
        Scanner input2 = new Scanner(System.in);
        number2 = input2.nextInt();
        input.close();
        input2.close();

        AppendNums appendObj = new AppendNums();

        // Append 2 numbers.
        long appendedNumber = appendObj.appendNumbers(number1, number2);
        System.out.println("\nAppended number: " + appendedNumber);

    }

    private long appendNumbers(long number1, long number2) {
        long numOfDigits = (long) (Math.log10(number2) + 1);
        long multiplier = (long) Math.pow(10, numOfDigits);
        long appendedNumber = (number1 * multiplier) + number2;
        return appendedNumber;
    }
}
