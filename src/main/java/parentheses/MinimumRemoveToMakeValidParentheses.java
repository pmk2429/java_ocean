package parentheses;

import java.util.Stack;

/**
 * Given a string s of '(' , ')' and lowercase English characters.
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting
 * parentheses string is valid and return any valid string.
 * Formally, a parentheses string is valid if and only if:
 * - It is the empty string, contains only lowercase characters, or
 * - It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * - It can be written as (A), where A is a valid string.
 * <p>
 * Example 1:
 * ----------
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 * <p>
 * Example 2:
 * ----------
 * Input: s = "a)b(c)d"
 * Output: "ab(c)d"
 * <p>
 * Example 3:
 * ----------
 * Input: s = "))(("
 * Output: ""
 * Explanation: An empty string is also valid.
 */
public class MinimumRemoveToMakeValidParentheses {

    private static String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < sb.length(); ++i) {
            char c = sb.charAt(i);
            if (c == '(') {
                stack.push(i);
            }
            else if (sb.charAt(i) == ')') {
                if (!stack.empty()) {
                    stack.pop();
                }
                else {
                    sb.setCharAt(i, '*');
                }
            }
        }
        while (!stack.empty()) {
            sb.setCharAt(stack.pop(), '*');
        }

        return sb.toString().replaceAll("\\*", "");
    }

    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        System.out.println(minRemoveToMakeValid(s));
        String s2 = "))((";
        System.out.println(minRemoveToMakeValid(s2));
    }
}
