package strings;

import java.util.Scanner;

/**
 * Created by Pavitra on 11/12/2015.
 */
public class AllSubstrings {
    public static void main(String[] args) {
        String string, sub;
        int i, c, length;

        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string to print it's all substrings");
        string = in.nextLine();

        length = string.length();

        System.out.println("Substrings of \"" + string + "\" are :-");

        for (c = 0; c < length; c++) {
            for (i = 1; i <= length - c; i++) {
                if (i >= 3) {
                    sub = string.substring(c, c + i);
                    System.out.println(sub);
                }
            }
        }
    }
}
