package strings;

import java.util.*;

public class SubstringAll {
    public static void main(String[] args) {
        String string, sub;
        int i, c, length, count = 0;

        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string to print it's all substrings");
        string = in.nextLine();

        length = string.length();

        System.out.println("Substrings of \"" + string + "\" are :-");

        for (c = 0; c < length; c++) {
            for (i = 1; i <= length - c; i++) {
                sub = string.substring(c, c + i);
                count++;
                System.out.print(sub + " ");
            }
        }
        System.out.println();
        System.out.println();
        System.out.println(count);

        String str = "helloslkhellodjladfj";
        String findStr = "hello";
        int lastIndex = 0;
        int count1 = 0;

        while (lastIndex != -1) {

            lastIndex = str.indexOf(findStr, lastIndex);
            if (lastIndex != -1) {
                count1++;
                lastIndex += findStr.length();
            }
        }
        System.out.println(count1);
    }
}
