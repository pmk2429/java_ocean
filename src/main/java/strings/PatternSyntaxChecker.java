package strings;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Checks if the Pattern is valid or not
 * Created by Pavitra on 5/10/2016.
 */
public class PatternSyntaxChecker {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases > 0) {
            PatternSyntaxException exc = null;
            String pattern = in.nextLine();
            try {
                Pattern.compile(pattern);
            } catch (PatternSyntaxException pts) {
                exc = pts;
            }
            System.out.println((exc != null) ? "Invalid" : "Valid");
        }
    }
}
