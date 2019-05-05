package strings;

import java.util.HashSet;
import java.util.Set;

public class SubstringAll {

  private static Set<String> allSubstrings(String str) {
    Set<String> allSubs = new HashSet<>();
    int i, j, length, count = 0;
    length = str.length();

    System.out.println("Substrings of \"" + str + "\" are :-");

    for (i = 0; i < length; i++) {
      for (j = 1; j <= length - i; j++) {
        allSubs.add(str.substring(i, i + j));
        count++;
      }
    }

    return allSubs;
  }

  public static void main(String[] args) {
    String str = "226";
    System.out.println(allSubstrings(str));
  }
}
