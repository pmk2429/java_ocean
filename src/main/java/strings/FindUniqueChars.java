package strings;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * Print all distinct characters of a string in order
 * <p>
 * Given a string, find the all distinct (or non-repeating characters) in it.
 * For example, if the input string is “Geeks for Geeks”, then output should be ‘for’ and if input string
 * is “Geeks Quiz”, then output should be ‘GksQuiz’.
 * <p>
 * The distinct characters should be printed in same order as they appear in input string.
 * <p>
 * Examples:
 * Input  : Geeks for Geeks
 * Output : for
 * Input  : Hello Geeks
 * Output : HoGks
 * <p>
 */
public class FindUniqueChars {

    // Implementation using HashTable
    private static String distinctChars(String str) {
        StringBuilder sbr = new StringBuilder();
        // maintains the insertion order
        LinkedHashMap<Character, Integer> charsTable = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            charsTable.merge(currChar, 1, Integer::sum);
        }
        Set<Character> keys = charsTable.keySet();
        for (Character key : keys) {
            if (charsTable.get(key) == 1) {
                sbr.append(key);
            }
        }
        return sbr.toString();
    }

    // Does not maintain the order of characters
    private static String distinctCharsO1Space(String str) {
        StringBuilder sbr = new StringBuilder();
        char[] charFreq = new char[256];
        for (int i = 0; i < str.length(); i++) {
            charFreq[str.charAt(i)]++;
        }

        for (int i = 0; i < charFreq.length; i++) {
            if (charFreq[i] == 1) {
                sbr.append((char) i);
            }
        }
        return sbr.toString();
    }

    // Maintains index of chars in the string as is and traverse the String only once
    private static String distinctCharsSingleLoop(String str) {
        StringBuilder sbr = new StringBuilder();
        final int MAX_CHAR = 256;
        int n = str.length();
        int[] count = new int[MAX_CHAR];
        int[] index = new int[MAX_CHAR];

        Arrays.fill(count, 0);
        Arrays.fill(index, n);

        for (int i = 0; i < n; i++) {
            char currChar = str.charAt(i);
            count[currChar]++;

            // if the character is not yet traversed, set the count of char to 1
            if (count[currChar] == 1 && !Character.isWhitespace(currChar)) {
                index[currChar] = i; // index of character in the given string
            }

            // If character repeats, then remove it from index[]
            if (count[currChar] == 2) {
                index[currChar] = n;
            }
        }

        // Constant time operation
        Arrays.sort(index);

        // this way we will know what characters indices in given String are unique and distinct
        for (int i = 0; i < MAX_CHAR && index[i] != n; i++) {
            sbr.append(str.charAt(index[i]));
        }

        return sbr.toString();
    }

    public static void main(String[] args) {
        String str = "Geeks for abc Geeks bcd";
        System.out.println(distinctCharsO1Space(str.toLowerCase()));
        System.out.println(distinctCharsSingleLoop(str.toLowerCase()));
    }
}
