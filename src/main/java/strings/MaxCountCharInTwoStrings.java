package strings;

/**
 * Check if max occurring character of one string appears same no. of times in other
 * Given two strings, we need to take the character which has the maximum occurrence in the first string and then
 * we have to check if that particular character is present in the second string the same number of times as it is
 * present in the first string.
 * <p>
 * Examples:
 * ---------
 * Input : s1 = "sssgeek", s2 = "geeksss"
 * Output : Yes
 * Max occurring character in s1 is
 * 's'. It occurs same number of times
 * in s2
 * <p>
 * Input : geekyarticle, gfggfggfg
 * Output : No
 */
public class MaxCountCharInTwoStrings {

  private static boolean maxCharMatch(String s1, String s2) {
    int maxInFirst = Integer.MIN_VALUE;
    int maxInSecond = Integer.MIN_VALUE;

    if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
      return false;
    }

    int[] freqS1 = new int[256];
    int[] freqS2 = new int[256];

    char maxCharS1 = '\0';
    char maxCharS2 = '\0';

    // count max char in first String
    for (int i = 0; i < s1.length(); i++) {
      char curr = s1.charAt(i);
      freqS1[curr]++;
      // update the max char freq count
      if (freqS1[curr] > maxInFirst) {
        maxInFirst = freqS1[curr];
        maxCharS1 = curr;
      }
    }

    // count max char in first String
    for (int i = 0; i < s2.length(); i++) {
      char curr = s2.charAt(i);
      freqS2[curr]++;
      // update the max char freq count
      if (freqS2[curr] > maxInSecond) {
        maxInSecond = freqS2[curr];
        maxCharS2 = curr;
      }
    }

    // we can get away with second loop by removing the same process and negating the count
    /*
    for (int i = 0; i < s2.length(); i++) {
      if (maxChar1 == s2.charAt(i)) {
        maxInFirst--;

        // ultimately return true if maxInFirst is 0;
      }
    }
     */

    return (maxInFirst == maxInSecond) && (maxCharS1 == maxCharS2);
  }

  public static void main(String[] args) {
    String s1 = "sssgeek", s2 = "geeeeksss";
    System.out.println(maxCharMatch(s1, s2));
  }
}
