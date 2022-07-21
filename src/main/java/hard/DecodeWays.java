package hard;

/**
 * A message containing letters from A-Z can be encoded into numbers using the following mapping:
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of
 * the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
 * <p>
 * "AAJF" with the grouping (1 1 10 6)
 * "KJF" with the grouping (11 10 6)
 * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
 * <p>
 * Given a string s containing only digits, return the number of ways to decode it.
 * <p>
 * The test cases are generated so that the answer fits in a 32-bit integer.
 * <p>
 * Example 1:
 * -----------
 * Input: s = "12"
 * Output: 2
 * Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
 * <p>
 * Example 2:
 * -----------
 * Input: s = "226"
 * Output: 3
 * Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 * <p>
 * Example 3:
 * -----------
 * Input: s = "06"
 * Output: 0
 * Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
 * <p>
 * Constraints:
 * -----------
 * 1 <= s.length <= 100
 * s contains only digits and may contain leading zero(s).
 */
public class DecodeWays {
    private static int numOfDecoding(String s) {
        int n = s.length();
        if (n == 0) return 0;
        if (n > 100) return -1;

        int[] dp = new int[n + 1];
        dp[n] = 1; // last index will store 0
        for (int i = n - 1; i >= 0; i--) {
            char currChar = s.charAt(i);
            if (currChar != '0') {
                dp[i] = dp[i + 1];
                if (i < n - 1 && (currChar == '1' || currChar == '2' && s.charAt(i + 1) < '7')) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        String s2 = "12";
        System.out.println(numOfDecoding(s2));
        String s1 = "226";
        System.out.println(numOfDecoding(s1));
        String s = "06";
        System.out.println(numOfDecoding(s));
    }
}
