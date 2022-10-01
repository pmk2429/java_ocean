package slidingWindow;

import java.util.*;

/**
 * A string s is nice if, for every letter of the alphabet that s contains, it appears both in uppercase and lowercase.
 * For example, "abABB" is nice because 'A' and 'a' appear, and 'B' and 'b' appear. However, "abA" is not because 'b' appears, but 'B' does not.
 * <p>
 * Given a string s, return the longest substring of s that is nice. If there are multiple, return the substring of
 * the earliest occurrence. If there are none, return an empty string.
 * <p>
 * Example 1:
 * ==========
 * Input: s = "YazaAay"
 * Output: "aAa"
 * Explanation: "aAa" is a nice string because 'A/a' is the only letter of the alphabet in s, and both 'A' and 'a' appear.
 * "aAa" is the longest nice substring.
 * <p>
 * Example 2:
 * ==========
 * Input: s = "Bb"
 * Output: "Bb"
 * Explanation: "Bb" is a nice string because both 'B' and 'b' appear. The whole string is a substring.
 * <p>
 * Example 3:
 * ==========
 * Input: s = "c"
 * Output: ""
 * Explanation: There are no nice substrings.
 * <p>
 * Constraints:
 * ==========
 * 1 <= s.length <= 100
 * s consists of uppercase and lowercase English letters.
 *
 * ~!@#HARD:REVISE
 * ~!@#DIVIDE&CONQUER
 */
public class LongestNiceSubstring {
    private static String longestNiceSubstring(String s) {
        if (s.length() < 2) {
            return "";
        }
        char[] arr = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c : arr) set.add(c);
        for (int i = 0; i < arr.length; i++) {
            char currChar = arr[i];
            if (set.contains(Character.toUpperCase(currChar)) && set.contains(Character.toLowerCase(currChar))) continue;
            // divide and conquer
            String sub1 = longestNiceSubstring(s.substring(0, i)); // left - first sub problem
            String sub2 = longestNiceSubstring(s.substring(i + 1)); // second - right sub problem
            return sub1.length() >= sub2.length() ? sub1 : sub2;
        }
        return s;
    }

    public static void main(String[] args) {
        String s = "YazaAay";
        System.out.println(longestNiceSubstring(s));
        String s1 = "Bb";
        System.out.println(longestNiceSubstring(s1));
    }
}
