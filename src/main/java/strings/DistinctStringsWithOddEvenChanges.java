package strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Distinct strings with odd and even changes allowed
 * Given an array of lower case strings, the task is to find the number of strings that are distinct.
 * Two strings are distinct if on applying the following operations on one string the second string cannot be formed.
 * <p>
 * A character on odd index can be swapped with another character at odd index only.
 * A character on even index can be swapped with another character on even index only.
 * Examples:
 * <p>
 * Input  : arr[] = {"abcd", "cbad", "bacd"}
 * Output : 2
 * The 2nd string can be converted to the 1st by swapping
 * the first and third characters. So there are 2 distinct
 * strings as the third string cannot be converted to the
 * first.
 * <p>
 * Input  : arr[] = {"abc", "cba"}
 * Output : 1
 */
public class DistinctStringsWithOddEvenChanges {

  private static final int MAX_CHAR = 26;

  private static String encodeString(char[] str) {
    // hashEven stores the count of even indexed character
    // for each string hashOdd stores the count of odd
    // indexed characters for each string
    int[] hashEven = new int[MAX_CHAR];
    int[] hashOdd = new int[MAX_CHAR];

    // creating hash for each string
    for (int i = 0; i < str.length; i++) {
      char c = str[i];
      if ((i & 1) != 0) // If index of current character is odd
        hashOdd[c - 'a']++;
      else
        hashEven[c - 'a']++;

    }

    // For every character from 'a' to 'z', we store its
    // count at even position followed by a separator,
    // followed by count at odd position.
    StringBuilder encodedBuilder = new StringBuilder();
    for (int i = 0; i < MAX_CHAR; i++) {
      encodedBuilder.append(hashEven[i]);
      encodedBuilder.append('-');
      encodedBuilder.append(hashOdd[i]);
      encodedBuilder.append('-');
    }
    return encodedBuilder.toString();
  }

  // This function basically uses a hashing based set to
  // store strings which are distinct according criteria given in question.
  private static int countDistinct(String[] input, int n) {
    int countDist = 0; // Initialize result

    // Create an empty set and store all distinct strings in it
    Set<String> s = new HashSet<>();
    for (int i = 0; i < n; i++) {
      // If this encoding appears first time, increment
      // count of distinct encodings.
      char[] inputArr = input[i].toCharArray();
      String encodedString = encodeString(inputArr);
      if (!s.contains(encodedString)) {
        s.add(encodedString);
        countDist++;
      }
    }

    return countDist;
  }

  public static void main(String[] args) {
    String[] input = {"abcd", "acbd", "adcb", "cdba", "bcda", "badc"};
    int n = input.length;

    System.out.println(countDistinct(input, n));
  }
}
