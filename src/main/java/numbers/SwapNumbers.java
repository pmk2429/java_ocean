package numbers;

import java.util.Scanner;

/**
 * Swamp 2 numbers without using the 3rd variable.
 */
public class SwapNumbers {

    private void swampNumbers(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("\nNumbers after swap:");
        System.out.println("a: " + a + " and b: " + b);

    }

    public static void main(String[] args) {
        System.out.print("a: ");
        Scanner inputA = new Scanner(System.in);
        int a = inputA.nextInt();
        System.out.print("b: ");
        Scanner inputB = new Scanner(System.in);
        int b = inputB.nextInt();
        inputA.close();
        inputB.close();

        System.out.println(" \nNumbers before swap:");
        System.out.println("a: " + a + " and b: " + b);
        SwapNumbers swapnosObj = new SwapNumbers();
        swapnosObj.swampNumbers(a, b);
    }
}
