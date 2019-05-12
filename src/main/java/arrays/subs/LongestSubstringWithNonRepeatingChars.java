package arrays.subs;

import java.util.*;

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

  private static String findLongestUniqueSubstring(String str) {
    char[] strArr = str.toCharArray();
    int i;
    int n = str.length();

    // starting point of current substring.
    int st = 0;

    // length of current substring.
    int currlen;

    // maximum length substring without repeating characters
    int maxlen = 0;

    // starting index of maximum length substring
    int start = 0;

    // Hash Map to store last occurrence of each already visited character.
    Map<Character, Integer> pos = new HashMap<>();

    // Last occurrence of first character is index 0;
    pos.put(strArr[0], 0);

    for (i = 1; i < n; i++) {
      // If this character is not present in hash, then this is first occurrence of this
      // character, store this in hash.
      if (!pos.containsKey(strArr[i])) {
        pos.put(strArr[i], i);
      } else {
        // If this character is present in hash then this character has previous occurrence,
        // check if that occurrence is before or after starting point of current substring.
        if (pos.get(strArr[i]) >= st) {

          // find length of current substring and
          // update maxlen and start accordingly.
          currlen = i - st;
          if (maxlen < currlen) {
            maxlen = currlen;
            start = st;
          }

          // Next substring will start after the last occurrence of current character to avoid its repetition.
          st = pos.get(strArr[i]) + 1;
        }

        // Update last occurrence of current character.
        pos.put(strArr[i], i);
      }
    }

    // Compare length of last substring with maxlen and update maxlen and start accordingly
    if (maxlen < i - st) {
      maxlen = i - st;
      start = st;
    }

    // The required longest substring without repeating characters is from str[start] to str[start + maxlen-1].
    return str.substring(start, maxlen);
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

    System.out.println(findLongestUniqueSubstring(str));
  }
}
