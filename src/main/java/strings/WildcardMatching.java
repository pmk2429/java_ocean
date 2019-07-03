package strings;

/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * <p>
 * Note:
 * -----
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
 * <p>
 * Example 1:
 * ----------
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * <p>
 * Example 2:
 * ----------
 * Input:
 * s = "aa"
 * p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 * <p>
 * Example 3:
 * ----------
 * Input:
 * s = "cb"
 * p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 * <p>
 * Example 4:
 * ----------
 * Input:
 * s = "adceb"
 * p = "*a*b"
 * Output: true
 * Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
 * <p>
 * Example 5:
 * ----------
 * Input:
 * s = "acdcb"
 * p = "a*c?b"
 * Output: false
 */
public class WildcardMatching {

  private static boolean isMatch(String s, String p) {
    if (s == null || p == null) {
      return false;
    }

    if (s.length() == 0 || p.length() == 0) {
      return false;
    }

    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    dp[0][0] = true;

    for (int i = 1; i <= s.length(); i++) {
      dp[i][0] = false;
    }

    for (int j = 1; j <= p.length(); j++) {
      if (p.charAt(j - 1) == '*') {
        dp[0][j] = dp[0][j - 1];
      }
    }

    for (int i = 1; i <= s.length(); i++) {
      for (int j = 1; j <= p.length(); j++) {
        if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
          dp[i][j] = dp[i - 1][j - 1];
        } else if (p.charAt(j - 1) == '*') {
          dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
        }
      }
    }
    return dp[s.length()][p.length()];
  }

  public static void main(String[] args) {
    String s = "acdcb";
    String p = "a*c?b";
    System.out.println(isMatch(s, p));
  }
}
