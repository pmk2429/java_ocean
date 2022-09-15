package numbers;

import java.util.Scanner;

public class SumOfDigits {
    static int inputNumber;

    public static void main(String[] args) {
        System.out.println("Enter the number to find the sum of its digits:");
        System.out.print("> ");
        Scanner input = new Scanner(System.in);
        inputNumber = input.nextInt();
        input.close();
        SumOfDigits sumObj = new SumOfDigits();
        int sumOfDigits = sumObj.calculateSumOfDigits(inputNumber, 0);
        sumObj.printTotal(sumOfDigits);

    }

    private void printTotal(int sumOfDigits) {
        System.out.println("\nTotal of " + SumOfDigits.inputNumber + "(each digit) is: " + sumOfDigits);
    }

    private int calculateSumOfDigits(int inputNumber, int total) {
        int sumOfDigits = total;
        if (inputNumber != 0) {
            int originalNumber = inputNumber;
            int temp = originalNumber % 10;
            sumOfDigits += temp;
            originalNumber = originalNumber / 10;
            return calculateSumOfDigits(originalNumber, sumOfDigits);
        }
        else {
            return sumOfDigits;
        }

    }

    private int length(int num) {
        int length = 0;
        long temp = 1;
        while (temp <= num) {
            length++;
            temp *= 10;
        }
        return length;
    }

    private int addDigits(int num) {
        int finalSum = 0;
        while (length(num) != 1) {
            finalSum = 0;
            while (num % 10 != 0) {
                finalSum += num % 10;
                num = num / 10;
            }
            finalSum += num;
            num = finalSum;
        }
        return finalSum;
    }

    /**
     * #SHORTCUT - Sum of Digits
     */
    private int addAllDigits(int num) {
        return 1 + (num - 1) % 9;
    }
}
