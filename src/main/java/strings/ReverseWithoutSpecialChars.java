package strings;

/**
 * Reverse an array without affecting special characters
 * Given a string, that contains special character together with alphabets (‘a’ to ‘z’ and ‘A’ to ‘Z’),
 * reverse the string in a way that special characters are not affected.
 * <p>
 * Examples:
 * Input:   str = "a,b$c"
 * Output:  str = "c,b$a"
 * Note that $ and , are not moved anywhere.
 * Only subsequence "abc" is reversed
 * <p>
 * Input:   str = "Ab,c,de!$"
 * Output:  str = "ed,c,bA!$"
 */
public class ReverseWithoutSpecialChars {

  private static String reverseWithoutSpecialChars(String str) {
    char[] rev = new char[str.length()];
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      if (!Character.isLetter(str.charAt(i))) {
        // array of special chars
        rev[i] = str.charAt(i);
      } else {
        // String of letters by order in original String
        sb.append(str.charAt(i));
      }
    }
    sb.reverse();
    int j = 0;
    for (int i = 0; i < rev.length; i++) {
      // cell is empty
      if (rev[i] == 0) {
        rev[i] = sb.charAt(j);
        j++;
      }
    }
    return String.valueOf(rev);
  }

  /* Algo to swap values of letters while traversing the array from start and back simultaneously.
   */
  private static String reverseOnlyChars(String str) {
    char[] res = str.toCharArray();
    int i = 0, j = str.length() - 1;
    while (i <= j) {
      if (Character.isLetter(str.charAt(i))) {
        if (Character.isLetter(str.charAt(j))) {
          char temp = str.charAt(i);
          res[i] = str.charAt(j);
          res[j] = temp;
          i++;
          j--;
        } else {
          j--;
        }
      } else {
        res[i] = str.charAt(i);
        i++;
      }
    }
    return String.valueOf(res);
  }

  public static void main(String[] args) {
    String str = "a,b$c";
    System.out.println(reverseWithoutSpecialChars(str));
    String str2 = "az%b#c*d"; // dc%b#z*a
    System.out.println(reverseOnlyChars(str2));
  }
}
