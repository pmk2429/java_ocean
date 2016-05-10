package strings;

import java.util.Scanner;

/**
 * Created by Pavitra on 5/6/2016.
 */
public class StringTokenUsingRegex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        if (s.matches("[A-Za-z !,?.\\_'@]+")) {

            s = s.trim();
            if (s.length() == 0) {
                System.out.println("0");
                return;
            }

            if (s.length() > 400000) {
                // not valid
                return;
            }

//            String delims = "[ !,?._'@]+";
            String delims = "[_\\@ !,?.']+";
            String[] words = s.split(delims);
            System.out.println(words.length);
            for (String word : words) {
                System.out.println(word);
            }
        }
    }
}
