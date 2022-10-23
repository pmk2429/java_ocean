package arrays.subs;

import java.util.Arrays;

/**
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
 * <p>
 * A subsequence of a string is a new string which is formed from the original string by deleting some
 * (can be none) of the characters without disturbing the relative positions of the remaining characters.
 * (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * <p>
 * Example 1:
 * ----------
 * Input: S = "rabbbit", T = "rabbit"
 * Output: 3
 * Explanation:
 * ------------
 * As shown below, there are 3 ways you can generate "rabbit" from S.
 * (The caret symbol ^ means the chosen letters)
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 * <p>
 * Example 2:
 * ----------
 * Input: S = "babgbag", T = "bag"
 * Output: 5
 * Explanation:
 * ----------
 * As shown below, there are 5 ways you can generate "bag" from S.
 * (The caret symbol ^ means the chosen letters)
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 * ^  ^^
 * babgbag
 * ^^^
 * <p>
 * This problem is similar to {@link strings.FrequencyOfSubstring}
 * <p>
 * ~!@#HARD:REVISE
 */
public class Subsequences {
    private static int numDistinct(String str, String sub) {
        if (str == null || sub == null || sub.length() > str.length()) {
            return 0;
        }

        int strLength = str.length(), subLength = sub.length();
        int[] counts = new int[strLength + 1];

        Arrays.fill(counts, 1);

        // starting with 1
        for (int i = 1; i <= subLength; i++) {
            int pre = 0;
            // starting with 1
            for (int j = 1; j <= strLength; j++) {
                int preSub = counts[j];
                // compare one character to the left
                if (sub.charAt(i - 1) == str.charAt(j - 1)) {
                    counts[j] = counts[j - 1] + pre;
                }
                else {
                    counts[j] = (j == 1 ? 0 : counts[j - 1]);
                }
                pre = preSub;
            }
            counts[0] = 0;
        }
        return counts[strLength];
    }

    public static void main(String[] args) {
        String S = "rabbbit";
        String T = "rabbit";
        System.out.println(numDistinct(S, T));
        String S1 = "babgbag";
        String T1 = "bag";
        System.out.println(numDistinct(S1, T1));
    }
}
