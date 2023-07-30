package misc;

import java.util.Scanner;

public class PowerOfTwo {
    private boolean checkNumberPowerTwo(int number) {
        int temp = 0;
        boolean check = false;
        do {
            if (number % 2 == 0) {
                number = number / 2;
                temp = number;
                if (temp == 1) {
                    check = true;
                    break;
                }
            }
            else {
                break;
            }
        } while (temp > 0);

        return check;
    }

    public static void main(String[] args) {
        System.out.println("Enter the number to check:");
        System.out.println("> ");
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        input.close();
        PowerOfTwo p2 = new PowerOfTwo();
        boolean checkNumber = p2.checkNumberPowerTwo(number);
        if (checkNumber)
            System.out.println("YES, the number is power of 2.");
        else
            System.out.println("NO, the number is not a power of 2.");
    }
}
