package strings;

import java.util.Stack;

/**
 * You are given a string s, which contains stars *.
 * In one operation, you can:
 * Choose a star in s.
 * Remove the closest non-star character to its left, as well as remove the star itself.
 * Return the string after all stars have been removed.
 * Note:
 * -----
 * The input will be generated such that the operation is always possible.
 * It can be shown that the resulting string will always be unique.
 * <p>
 * Example 1:
 * ----------
 * Input: s = "leet**cod*e"
 * Output: "lecoe"
 * Explanation: Performing the removals from left to right:
 * - The closest character to the 1st star is 't' in "leet**cod*e". s becomes "lee*cod*e".
 * - The closest character to the 2nd star is 'e' in "lee*cod*e". s becomes "lecod*e".
 * - The closest character to the 3rd star is 'd' in "lecod*e". s becomes "lecoe".
 * There are no more stars, so we return "lecoe".
 * <p>
 * Example 2:
 * ----------
 * Input: s = "erase*****"
 * Output: ""
 * Explanation: The entire string is removed, so we return an empty string.
 * <p>
 * Constraints:
 * ------------
 * 1 <= s.length <= 105
 * s consists of lowercase English letters and stars *.
 * The operation above can be performed on s.
 */
public class RemoveStartsFromString {

    private static String removeStarsStack(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                st.pop();
            }
            else {
                st.push(s.charAt(i));
            }
        }

        StringBuilder answer = new StringBuilder();
        while (!st.isEmpty()) {
            answer.append(st.pop());
        }

        return answer.reverse().toString();
    }

    private static String removeStarsTwoPointers(String s) {
        char[] ch = new char[s.length()];
        int j = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                j--;
            }
            else {
                ch[j++] = c;
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < j; i++) {
            answer.append(ch[i]);
        }

        return answer.toString();
    }

    private static String removeStars(String s) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (i > 0 && currChar == '*') {
                // If s[i] == '*', delete the last character from answer.
                answer.deleteCharAt(answer.length() - 1);
            }
            else { // Otherwise, we have a non-star character, so we append it to answer.
                answer.append(currChar);
            }
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        String s = "leet**cod*e";
        System.out.println(s + " -> " + removeStars(s));
        System.out.println(s + " -> " + removeStarsTwoPointers(s));
    }
}
