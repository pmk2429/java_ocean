package parentheses;

import java.util.Stack;

/**
 * Given a balanced parentheses string s, return the score of the string.
 * The score of a balanced parentheses string is based on the following rule:
 * - "()" has score 1.
 * - AB has score A + B, where A and B are balanced parentheses strings.
 * - (A) has score 2 * A, where A is a balanced parentheses string.
 * <p>
 * Example 1:
 * ----------
 * Input: s = "()"
 * Output: 1
 * <p>
 * Example 2:
 * ----------
 * Input: s = "(())"
 * Output: 2
 * <p>
 * Example 3:
 * ----------
 * Input: s = "()()"
 * Output: 2
 * <p>
 * Constraints:
 * ------------
 * 2 <= s.length <= 50
 * s consists of only '(' and ')'.
 * s is a balanced parentheses strin
 */
public class ParenthesesScore {

    private static int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // The score of the current frame

        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(0);
            else {
                int v = stack.pop();
                int w = stack.pop();
                stack.push(w + Math.max(2 * v, 1));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.printf("() -> %d", scoreOfParentheses("()"));
        System.out.println();
        System.out.printf("(()) -> %d", scoreOfParentheses("(())"));
        System.out.println();
        System.out.printf("()() -> %d", scoreOfParentheses("()()"));
    }
}
