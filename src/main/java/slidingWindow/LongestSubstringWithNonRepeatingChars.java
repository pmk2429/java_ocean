package slidingWindow;

import java.util.Arrays;

/**
 * Sliding Window problem.
 * <p>
 * ~!@#HARD:REVISE
 */
public class LongestSubstringWithNonRepeatingChars {

    /**
     * Similar to {@link LongestSubstringWithoutRepeating#lengthOfLongestUniqueSubstring(String)}
     */
    private static String longestUniqueSubstring(String str) {
        String maxUniqueSubstring = "";
        int subLength = Integer.MIN_VALUE;

        char[] charFreq = new char[256];

        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length() - i; j++) {
                if (charFreq[i] == 0) {
                    charFreq[i]++;
                    String sub = str.substring(i, i + j);
                    if (sub.length() > subLength) {
                        subLength = sub.length();
                        maxUniqueSubstring = sub;
                    }
                }
            }
        }

        return maxUniqueSubstring;
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
        String str = "abcabcbb";
        System.out.println(longestUniqueSubstring(str));
    }
}
