package slidingWindow;

import java.util.Set;

/**
 * Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 * <p>
 * Example 1:
 * ----------
 * Input: s = "abciiidef", k = 3
 * Output: 3
 * Explanation: The substring "iii" contains 3 vowel letters.
 * <p>
 * Example 2:
 * ----------
 * Input: s = "aeiou", k = 2
 * Output: 2
 * Explanation: Any substring of length 2 contains 2 vowels.
 * <p>
 * Example 3:
 * ----------
 * Input: s = "leetcode", k = 3
 * Output: 2
 * Explanation: "lee", "eet" and "ode" contain 2 vowels.
 * <p>
 * Constraints:
 * ------------
 * 1 <= s.length <= 105
 * s consists of lowercase English letters.
 * 1 <= k <= s.length
 */
public class MaxVowelSubstring {

    private static int maxVowels(String s, int k) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        // Build the window of size k, count the number of vowels it contains.
        int count = 0;
        for (int i = 0; i < k; i++) {
            count += vowels.contains(s.charAt(i)) ? 1 : 0;
        }
        int answer = count;

        // Slide the window to the right, focus on the added character and the
        // removed character and update "count". Record the largest "count".
        for (int i = k; i < s.length(); i++) {
            count += vowels.contains(s.charAt(i)) ? 1 : 0;
            count -= vowels.contains(s.charAt(i - k)) ? 1 : 0;
            answer = Math.max(answer, count);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("abciiidef -> " + maxVowels("abciiidef", 3));
        System.out.println("leetcode -> " + maxVowels("leetcode", 3));
        System.out.println("aeiou -> " + maxVowels("aeiou", 2));
    }
}
