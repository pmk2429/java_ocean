package arrays.subs;

import java.util.HashSet;
import java.util.Set;

/**
 * Write a program to find the common substrings between the two given strings.
 * However, do not include substrings that are contained within longer common substrings.
 * <p>
 * For example, given the input strings "eatsleepnightxyz" and "eatsleepabcxyz", the results should be:
 * <p>
 * eatsleep (due to eatsleepnightxyz eatsleepabcxyz)
 * xyz (due to eatsleepnightxyz eatsleepabcxyz)
 * a (due to eatsleepnightxyz eatsleepabcxyz)
 * t (due to eatsleepnightxyz eatsleepabcxyz)
 * <p>
 * However, the result set should not include e from  eatsleepnightxyz eatsleepabcxyz, because both es are already
 * contained in the eatsleep mentioned above. Nor should you include ea, eat, ats, etc.,
 * as those are also all covered by eatsleep.
 * <p>
 * In this, you don't have to make use of String utility methods like: contains, indexOf, StringTokenizer, split and replace.
 */
public class LongestCommonSubstring {
  private static Set<String> longestCommonSubstrings(String s, String t) {
    int[][] table = new int[s.length()][t.length()];
    int longest = 0;
    Set<String> result = new HashSet<>();

    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j < t.length(); j++) {
        if (s.charAt(i) != t.charAt(j)) {
          continue;
        }

        table[i][j] = (i == 0 || j == 0) ? 1 : 1 + table[i - 1][j - 1];

        if (table[i][j] > longest) {
          longest = table[i][j];
          result.clear();
        }
        
        if (table[i][j] == longest) {
          result.add(s.substring(i - longest + 1, i + 1));
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    String a = "pavitra";
    String b = "travis";
    System.out.println(longestCommonSubstrings(a, b));
  }
}
