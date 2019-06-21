package strings;

/**
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this
 * string is valid. We define the validity of a string by these rules:
 * <p>
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * An empty string is also valid.
 * <p>
 * Example 1:
 * Input: "()"
 * Output: True
 * Example 2:
 * Input: "(*)"
 * Output: True
 * Example 3:
 * Input: "(*))"
 * Output: True
 * Note:
 * The string size will be in the range [1, 100].
 */
public class ValidParanthesis {

  private static boolean isValid(String paren) {
    if (paren == null) {
      return false;
    }

    if (paren.length() <= 1 || paren.length() > 100) {
      return false;
    }

    if (paren.charAt(0) == ')') {
      return false;
    }

    int lo = 0, hi = 0;
    for (char c : paren.toCharArray()) {
      lo += c == '(' ? 1 : -1;
      hi += c == ')' ? -1 : 1;
      if (hi < 0) {
        break;
      }
      lo = Math.max(lo, 0);
    }
    return lo == 0;
  }

  public static void main(String[] args) {
    String str = "(*))";
    System.out.println(isValid(str));
  }
}
