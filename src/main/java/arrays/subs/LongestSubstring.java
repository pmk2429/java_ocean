package arrays.subs;

import java.util.ArrayList;

/**
 * LongestSubstring class is used to find the longest substring without
 * repeating characters in the string.
 *
 * @author Pavitra
 */

public class LongestSubstring {
  /**
   * findLongestDistinctString() is used to find the longest string in the
   * given string.
   *
   * @param str
   * @return the longest distinct substring
   */
  private static String findLongestDistinctString(String str) {
    ArrayList<Character> subStrList = new ArrayList<>();
    StringBuilder unique = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      if (subStrList.contains(str.charAt(i))) {
        if (Character.isWhitespace(str.charAt(i))) {
          subStrList.add(str.charAt(i));
        } else {
          break;
        }
      } else {
        subStrList.add(str.charAt(i));
      }
      unique.append(subStrList.get(i).toString());
    }
    return unique.toString();
  }

  public static void main(String[] args) {
    // String str = "a b c def ghi jkl mno pqrstu vw xyz";
    String str = "the quick brown fox";
    System.out.println(findLongestDistinctString(str));
  }
}
