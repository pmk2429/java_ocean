package slidingWindow;

import java.util.*;

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
 * <p>
 * ~!@#HARD:REVISE
 */
public class LongestSubstringWithoutRepeating {

    /**
     * Sliding Window Problem
     */
    private static int lengthOfLongestUniqueSubstring(String s) {
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

    /**
     * ~!@#HARD:REVISE
     */
    private static int lengthOfLongestSubstringUsingArray(String s) {
        int result = 0;
        int[] charFreq = new int[256];
        for (int i = 0, j = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            j = (charFreq[curr] > 0) ? Math.max(j, charFreq[curr]) : j;
            charFreq[curr] = i + 1;
            result = Math.max(result, i - j + 1);
        }
        return result;
    }

    /**
     * ~!@#HARD:REVISE
     */
    private static int lengthOfLongestSubstringLinkedList(String s) {
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

    private static int longestSubstringUniqueLength(String s) {
        int[] charMap = new int[256];
        Arrays.fill(charMap, -1);
        int i = 0, maxLen = 0;
        for (int j = 0; j < s.length(); j++) {
            if (charMap[s.charAt(j)] >= i) {
                i = charMap[s.charAt(j)] + 1;
            }
            charMap[s.charAt(j)] = j;
            maxLen = Math.max(j - i + 1, maxLen);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestUniqueSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstringLinkedList("abcabcbb"));
        System.out.println(lengthOfLongestSubstringLinkedList("pavitra"));
        System.out.println(lengthOfLongestUniqueSubstring("bbbbb"));
        System.out.println(lengthOfLongestUniqueSubstring("pwwkew"));
        String str = "pavitra";
        System.out.println(longestSubstringUniqueLength(str));
    }
}
