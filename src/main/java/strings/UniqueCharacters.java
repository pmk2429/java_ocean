package strings;

import java.util.Arrays;

public class UniqueCharacters {

  private final static int MAX_CHAR = 256;

  private static boolean containsUniqueChar(String str) {
    char[] chArray = str.toCharArray();

    // Using sorting
    // Arrays.sort() uses binarySort in the background
    // for non-primitives which is of O(nlogn) time complexity
    Arrays.sort(chArray);

    for (int i = 0; i < chArray.length - 1; i++) {
      // if the adjacent elements are not
      // equal, move to next element
      if (chArray[i] != chArray[i + 1]) {
        continue;
      }

      // if at any time, 2 adjacent elements
      // become equal, return false
      else {
        return false;
      }
    }
    return true;
  }

  private static boolean isStringUnique(String str) {
    // If length is greater than 256,
    // some characters must have been repeated
    if (str.length() > MAX_CHAR) {
      return false;
    }

    boolean[] chars = new boolean[MAX_CHAR];
    Arrays.fill(chars, false);

    for (int i = 0; i < str.length(); i++) {
      int index = (int) str.charAt(i);

     /* If the value is already true, string
     has duplicate characters, return false */
      if (chars[index] == true) {
        return false;
      }

      chars[index] = true;
    }

    /* No duplicates encountered, return true */
    return true;
  }

  private static boolean isUnique(String str) {
    // Assuming string can have characters a-z
    // this has 32 bits set to 0
    int checker = 0;

    for (int i = 0; i < str.length(); i++) {
      int bitAtIndex = str.charAt(i) - 'a';

      // if that bit is already set in checker,
      // return false
      if ((checker & (1 << bitAtIndex)) > 0) {
        return false;
      }

      // otherwise update and continue by
      // setting that bit in the checker
      checker = checker | (1 << bitAtIndex);
    }

    // no duplicates encountered, return true
    return true;
  }


  public static void main(String[] args) {

  }
}
