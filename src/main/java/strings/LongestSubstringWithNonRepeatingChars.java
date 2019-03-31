package strings;

import java.util.Set;
import java.util.TreeSet;

public class LongestSubstringWithNonRepeatingChars {

  private static String longestUniqueSubstring(String str) {
    String maxUniqueSubstring = "";
    int subLength = Integer.MIN_VALUE;

    char[] allchars = new char[256];

    for (int i = 0; i < str.length(); i++) {
      for (int j = i; j < str.length() - i; j++) {
        if (allchars[i] == 0) {
          allchars[i]++;
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

  private static Set<String> allUniqueSubstrings(String str) {
    Set<String> substrings = new TreeSet<>();
    char[] allchars = new char[256];

    for (int i = 0; i < str.length(); i++) {
      for (int j = i; j < str.length() - i; j++) {
        if (allchars[i] == 0) {
          allchars[i]++;
          String sub = str.substring(i, i + j);
          if (sub.length() > 0) {
            substrings.add(sub);
          }
        }
      }
    }
    return substrings;
  }

  public static void main(String[] args) {
    String str = "abcabcbb";
    System.out.println(longestUniqueSubstring(str));
  }
}
