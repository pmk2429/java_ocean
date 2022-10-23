package parentheses;

/**
 * Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')',
 * and in any positions ) so that the resulting parentheses string is valid.
 * <p>
 * Formally, a parentheses string is valid if and only if:
 * <p>
 * It is the empty string, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.
 * <p>
 * Example 1:
 * <p>
 * Input: "())"
 * Output: 1
 * Example 2:
 * <p>
 * Input: "((("
 * Output: 3
 * Example 3:
 * <p>
 * Input: "()"
 * Output: 0
 * Example 4:
 * <p>
 * Input: "()))(("
 * Output: 4
 */
public class ValidParentheses {

    private static int minAddToMakeValid(String S) {
        int ans = 0, bal = 0;
        for (int i = 0; i < S.length(); ++i) {
            bal += S.charAt(i) == '(' ? 1 : -1;
            // It is guaranteed bal >= -1
            if (bal == -1) {
                ans++;
                bal++;
            }
        }

        return ans + bal;
    }

    public static void main(String[] args) {
        String str = "()))((";
        System.out.println(minAddToMakeValid(str));
    }
}
