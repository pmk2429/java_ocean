package strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Pavitra on 5/6/2016.
 */
public class StringSub {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int substringLength = scanner.nextInt();

        ArrayList<String> subStrings = new ArrayList<>();
        for (int c = 0; c < str.length(); c++) {
            for (int i = 1; i <= str.length() - c; i++) {
                if (str.substring(c, c + i).length() == substringLength)
                    subStrings.add(str.substring(c, c + i));
            }
        }
        Collections.sort(subStrings);

        System.out.println(subStrings.get(0));
        System.out.println(subStrings.get(subStrings.size() - 1));
    }
}
