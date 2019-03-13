package strings;

/**
 * StringPermutations class is used to find all PERMUTATIONS of a given string
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Pavitra
 */

public class StringPermutations {

  public static void main(String[] args) {
    String s = "digital";
//        String s1 = "ABC";
//        String s2 = "PMK";
    System.out.println("\nString " + s + ":\nPermutations: ");
    Set<String> allStringPermutationsSet = stringPermutation(s);
    Iterator<String> setIterator = allStringPermutationsSet.iterator();

    while (setIterator.hasNext()) {
      if (setIterator.next().length() > 3) {
        System.out.println(setIterator.next());
      }
    }

  }

  /**
   * Method to get all permutations of a given String.
   *
   * @param str
   * @return
   */
  private static Set<String> stringPermutation(String str) {
    Set<String> result = new HashSet<>();
    if (str == null) {
      return null;
    } else if (str.length() == 0) {
      result.add("");
      return result;
    }

    char firstChar = str.charAt(0);
    String rem = str.substring(1);
    Set<String> words = stringPermutation(rem);
    for (String newString : words) {
      for (int i = 0; i <= newString.length(); i++) {
        result.add(addChar(newString, firstChar, i));
      }
    }
    return result;
  }

  /**
   * Method to add a char to a given String.
   *
   * @param str
   * @param c
   * @param j
   * @return
   */
  private static String addChar(String str, char c, int j) {
    String first = str.substring(0, j);
    String last = str.substring(j);
    return first + c + last;
  }

}
