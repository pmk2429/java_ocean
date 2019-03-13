package strings;

/**
 * Quick way to check if all the characters of a string are same
 * Given a string, check if all the characters of the string are same or not.
 * <p>
 * Examples:
 * <p>
 * Input : s = "geeks"
 * Output : No
 * <p>
 * Input : s = "gggg"
 * Output : Yes
 */
public class AllSameCharsInString {

  private static boolean sameChars(String str) {
    boolean isSame = false;
    char[] strArr = str.toCharArray();
    for (int i = 0, j = 1; j < strArr.length; i++, j++) {
      isSame = strArr[i] == strArr[j];
    }
    return isSame;
  }

  public static void main(String[] args) {
    String str = "pavitra";
    String str1 = "ppa";
    String str2 = "ppppppp";
    System.out.println(sameChars(str));
    System.out.println(sameChars(str1));
    System.out.println(sameChars(str2));
  }
}
