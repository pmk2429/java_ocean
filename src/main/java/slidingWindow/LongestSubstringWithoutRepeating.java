package slidingWindow;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * ----------
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * Example 2:
 * ----------
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * <p>
 * Example 3:
 * ----------
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * ~!@#HARD:REVISE
 */
public class LongestSubstringWithoutRepeating {

    /** Sliding Window Problem */
    public static int lengthOfLongestUniqueSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // map to store the character and its latest index encountered
        Map<Character, Integer> map = new HashMap<>();
        int longestUniqueSubstringLength = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (map.containsKey(currChar)) {
                // update j to right next to `currChar` previous index + 1
                // this will update the window size for deducing max further down below
                j = Math.max(j, map.get(currChar) + 1);
            }
            map.put(currChar, i);
            // deduce the window size which is the length of max substring
            longestUniqueSubstringLength = Math.max(longestUniqueSubstringLength, i - j + 1);
        }
        return longestUniqueSubstringLength;
    }

    public int lengthOfLongestSubstringUsingArray(String s) {
        int result = 0;
        int[] cache = new int[256];
        for (int i = 0, j = 0; i < s.length(); i++) {
            j = (cache[s.charAt(i)] > 0) ? Math.max(j, cache[s.charAt(i)]) : j;
            cache[s.charAt(i)] = i + 1;
            result = Math.max(result, i - j + 1);
        }
        return result;
    }

    public int lengthOfLongestSubstringLinkedList(String s) {
        Queue<Character> queue = new LinkedList<>();
        int res = 0;
        for (char c : s.toCharArray()) {
            while (queue.contains(c)) {
                queue.poll();
            }
            queue.offer(c);
            res = Math.max(res, queue.size());
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestUniqueSubstring("abcabcbb"));
        System.out.println(lengthOfLongestUniqueSubstring("bbbbb"));
        System.out.println(lengthOfLongestUniqueSubstring("pwwkew"));
    }
}
