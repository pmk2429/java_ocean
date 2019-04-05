package strings;

/**
 * Check if a binary string has two consecutive occurrences of one everywhere.
 * Given a string str consisting of only characters ‘a’ and ‘b’, the task is to check whether the string is valid or not.
 * In a valid string, every group of consecutive b must be of length 2 and must appear after 1 or more occurrences
 * of character ‘a’ i.e. “abba” is a valid sub-string but “abbb” and aba are not.
 * Print 1 if the string is valid else print -1.
 * <p>
 * Example 1:
 * ---------
 * Input: str = “abbaaabbabba”
 * Output: 1
 * <p>
 * Example 2:
 * ---------
 * Input: str = “abbaaababb”
 * Output: -1
 */
public class BinaryStringOccurrence {

  private static int checkConsecutiveOccurrenceSimple(String binaryStr) {
    int isValid = -1;

    if (binaryStr == null) {
      return isValid;
    }

    if (binaryStr.length() == 0) {
      return isValid;
    }

    String pattern = "^[a|b]*$";
    if (!binaryStr.matches(pattern)) {
      return isValid;
    }

    int i = 0;
    int aLength = 0, bLength = 0;
    while (i < binaryStr.length()) {
      char curChar = binaryStr.charAt(i);
      if (curChar == 'a') {
        aLength++;
      }

      if (curChar == 'b') {
        bLength++;
      }

      // if both are adjusted based on our needs
      if (aLength >= 1) { // this branching will prevent compiler from running into else condition
        if (bLength == 2) {
          isValid = 1;
          aLength = bLength = 0;
        }
      } else {
        isValid = -1;
      }
      i++;
    }

    return isValid;
  }

  private static int checkConsecutiveOccurrence(String binaryStr) {
    int isValid = -1;
    // 3) Consider edge/corner cases

    // 1) Analyze and develop algo for smallest possible unit of problem
    int i = 0;
    int bLength = 0;
    boolean aExists = false;
    while (i < binaryStr.length()) {
      char curChar = binaryStr.charAt(i);
      if (curChar == 'a' || curChar == 'b') {
        if (curChar == 'a' && !aExists) {
          aExists = true;
        } else if (curChar == 'b' && aExists) { // this means that we are now looking for two consecutive 'b' chars
          if (binaryStr.charAt(i - 1) == 'b' && bLength == 1) {
            isValid = 1;
            aExists = false;
            bLength = 0;
          } else {
            bLength++;
            isValid = -1;
          }
        } else {
          isValid = -1;
        }
      } else {
        isValid = -1;
        break;
      }
      i++;
    }

    // 2) Extend algo to entire problem set

    // 4) Optimize

    return isValid;
  }

  public static void main(String[] args) {
    String binaryStr = "abbaaabbabba";
    System.out.println(checkConsecutiveOccurrenceSimple(binaryStr));
  }
}
