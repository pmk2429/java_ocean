package strings;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * Print all distinct characters of a string in order
 * <p>
 * Given a string, find the all distinct (or non-repeating characters) in it.
 * For example, if the input string is “Geeks for Geeks”, then output should be ‘for’ and if input string
 * is “Geeks Quiz”, then output should be ‘GksQuiz’.
 * <p>
 * The distinct characters should be printed in same order as they appear in input string.
 * <p>
 * Examples:
 * Input  : Geeks for Geeks
 * Output : for
 * Input  : Hello Geeks
 * Output : HoGks
 * <p>
 */
public class DistinctChars {

  // Implementation using HashTable
  private static String distinctChars(String str) {
    StringBuilder sbr = new StringBuilder();
    LinkedHashMap<Character, Integer> charsTable = new LinkedHashMap<>();
    for (int i = 0; i < str.length(); i++) {
      if (charsTable.get(str.charAt(i)) == null) {
        charsTable.put(str.charAt(i), 1);
      } else {
        charsTable.put(str.charAt(i), charsTable.get(str.charAt(i)) + 1);
      }
    }
    Set<Character> keys = charsTable.keySet();
    for (Character key : keys) {
      if (charsTable.get(key) == 1) {
        sbr.append(key);
      }
    }
    return sbr.toString();
  }

  // Does not maintain the order of characters
  private static String distinctCharsConstantSpace(String str) {
    StringBuilder sbr = new StringBuilder();
    char[] allchars = new char[256];
    for (int i = 0; i < str.length(); i++) {
      int charPos = str.charAt(i);
      allchars[charPos]++;
    }

    for (int i = 0; i < allchars.length; i++) {
      if (allchars[i] == 1) {
        sbr.append((char) i);
      }
    }
    return sbr.toString();
  }

  // Maintains index of chars in the string as is and traverse the String only once
  private static String distinctCharsSingleLoop(String str) {
    StringBuilder sbr = new StringBuilder();
    final int MAX_CHAR = 256;
    int n = str.length();
    int[] count = new int[MAX_CHAR];
    int[] index = new int[MAX_CHAR];

    for (int i = 0; i < MAX_CHAR; i++) {
      count[i] = 0;
      index[i] = n;
    }

    for (int i = 0; i < n; i++) {
      char charPos = str.charAt(i);
      count[charPos]++;

      // if the character is not yer traversed, set the count of char to 1
      if (count[charPos] == 1 && str.charAt(i) != ' ') {
        index[charPos] = i; // index of character in the given string
      }

      // If character repeats, then remove it from index[] 
      if (count[charPos] == 2) {
        index[charPos] = n;
      }
    }

    // Constant time operation
    Arrays.sort(index);

    // this way we will know what characters indices in given String are unique and distinct
    for (int i = 0; i < MAX_CHAR && index[i] != n; i++) {
      sbr.append(str.charAt(index[i]));
    }

    return sbr.toString();
  }

  public static void main(String[] args) {
    String str = "Geeks for Geeks";
    System.out.println(distinctChars(str.toLowerCase()));
    System.out.println(distinctCharsConstantSpace(str.toLowerCase()));
    System.out.println(distinctCharsSingleLoop(str.toLowerCase()));
  }
}
