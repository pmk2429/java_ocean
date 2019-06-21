package hard;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * <p>
 * Example 1:
 * ----------
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * <p>
 * Example 2:
 * ----------
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 */
public class InterleavingString {
  private static String s1;
  private static String s2;
  private static String s3;

  private static Boolean[][] memo;

  private static boolean backtrack(int len1, int len2) {
    int len3 = len1 + len2;

    // base case
    if (len1 == 0 && len2 == 0 && len3 == 0) {
      return true;
    }

    if (memo[len1][len2] != null) {
      return memo[len1][len2];
    }

    // compare last char of S3 and last char of S1
    if (len1 > 0 && s3.charAt(len3 - 1) == s1.charAt(len1 - 1)) {
      if (backtrack(len1 - 1, len2)) {
        memo[len1][len2] = true;
        return true;
      }
    }

    // compare last char of S3 and last char of S2
    if (len2 > 0 && s3.charAt(len3 - 1) == s2.charAt(len2 - 1)) {
      if (backtrack(len1, len2 - 1)) {
        memo[len1][len2] = true;
        return true;
      }
    }

    memo[len1][len2] = false;
    return false;
  }

  private static boolean isInterleave(String a1, String a2, String a3) {
    s1 = a1;
    s2 = a2;
    s3 = a3;
    memo = new Boolean[s1.length() + 1][s2.length() + 1];

    if (s1.length() + s2.length() != s3.length()) {
      return false;
    }

    return backtrack(s1.length(), s2.length());
  }

  public static void main(String[] args) {
    String s1 = "aabcc";
    String s2 = "dbbca";
    String s3 = "aadbbcbcac";

    System.out.println(isInterleave(s1, s2, s3));
  }
}
