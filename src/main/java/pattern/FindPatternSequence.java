package pattern;

/**
 * Count of occurrences of a “1(0+)1” pattern in a string
 * Given an alphanumeric string, find the number of times a pattern 1(0+)1 occurs in the given string.
 * Here, (0+) signifies the presence of non empty sequence of consecutive 0’s.
 * <p>
 * Examples:
 * ---------
 * Input :  010001
 * Output : 3
 * First sequence is in between 0th and 3rd index.
 * Second sequence is in between 3rd and 5th index.
 * Third sequence is in between 5th and 9th index.
 * So total number of sequences comes out to be 3.
 * <p>
 * Example 2:
 * ---------
 * Input : 1001ab010abc01001
 * Output : 2
 * First sequence is in between 0th and 3rd index.
 * Second valid sequence is in between 13th and 16th
 * index. So total number of sequences comes out to
 * be 2.
 */
public class FindPatternSequence {

  private static int findTotalSequence(String str) {
    int totalSequence = 0;
    boolean startSequence = false;

    int i = 0;
    while (i < str.length()) {
      char curChar = str.charAt(i);
      if (curChar == '1' || curChar == '0') {
        if (!startSequence && curChar == '1') { // we found first '1'
          startSequence = true;
        } else if (startSequence && curChar == '1') { // this means we hit the ending '1'
          if (str.charAt(i - 1) == '0') {
            totalSequence++;
          }
        }
        i++;
      } else {
        if (startSequence) {
          startSequence = false;
        }
        i++;
      }
    }

    return totalSequence;
  }

  public static void main(String[] args) {
    String str = "1001001ab101";
    System.out.println(findTotalSequence(str));
  }
}
