package slidingWindow;

import java.util.HashSet;
import java.util.Set;

/**
 * A string is considered beautiful if it satisfies the following conditions:
 * <p>
 * Each of the 5 English vowels ('a', 'e', 'i', 'o', 'u') must appear at least once in it.
 * The letters must be sorted in alphabetical order (i.e. all 'a's before 'e's, all 'e's before 'i's, etc.).
 * For example, strings "aeiou" and "aaaaaaeiiiioou" are considered beautiful, but "uaeio", "aeoiu", and "aaaeeeooo" are not beautiful.
 * <p>
 * Given a string word consisting of English vowels, return the length of the longest beautiful substring of word. If no such substring exists, return 0.
 * <p>
 * A substring is a contiguous sequence of characters in a string.
 * <p>
 * Example 1:
 * ==========
 * Input: word = "aeiaaioaaaaeiiiiouuuooaauuaeiu"
 * Output: 13
 * Explanation: The longest beautiful substring in word is "aaaaeiiiiouuu" of length 13.
 * <p>
 * Example 2:
 * ==========
 * Input: word = "aeeeiiiioooauuuaeiou"
 * Output: 5
 * Explanation: The longest beautiful substring in word is "aeiou" of length 5.
 * <p>
 * Example 3:
 * ==========
 * Input: word = "a"
 * Output: 0
 * Explanation: There is no beautiful substring, so return 0.
 * <p>
 * Constraints:
 * ==========
 * 1 <= word.length <= 5 * 105
 * word consists of characters 'a', 'e', 'i', 'o', and 'u'.
 *
 * ~!@#HARD:REVISE
 */
public class BeautifulString {

    private static int longestBeautifulSubstring(String word) {
        int longest = 0;
        String vowels = "aeiou";
        Set<Character> seen = new HashSet<>();
        for (int lo = -1, hi = 0; hi < word.length(); hi++) {
            char currChar = word.charAt(hi);
            if (hi > 0 && word.charAt(hi - 1) > currChar) {
                seen = new HashSet<>(); // reset HashSet since the new char is smaller alphabetically than previous
                lo = hi - 1;
            }
            seen.add(currChar);
            // seen.size() will always be max set to 5 since HashSet doesn't allow duplicates
            if (seen.size() == vowels.length()) {
                longest = Math.max(longest, hi - lo);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        String word = "aeiaaioaaaaeiiiiouuuooaauuaeiu";
        System.out.println(longestBeautifulSubstring(word));
        String word2 = "aeeeiiiioooauuuaeiou";
        System.out.println(longestBeautifulSubstring(word2));
        String word3 = "a";
        System.out.println(longestBeautifulSubstring(word3));
    }
}
