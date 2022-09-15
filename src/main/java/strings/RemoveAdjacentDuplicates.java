package strings;

import java.util.Stack;

/**
 * Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
 * We repeatedly make duplicate removals on S until we no longer can.
 * Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.
 * <p>
 * Example 1:
 * ----------
 * Input: "abbaca"
 * Output: "ca"
 * Explanation:
 * ----------
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only
 * possible move. The result of this move is that the string is "aaca", of which only "aa" is possible,
 * so the final string is "ca".
 * <p>
 * Note:
 * ----
 * 1 <= S.length <= 20000
 * S consists only of English lowercase letters.
 */
public class RemoveAdjacentDuplicates {

    private static String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (char s : S.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == s)
                stack.pop();
            else
                stack.push(s);
        }
        StringBuilder sb = new StringBuilder();
        for (char s : stack) sb.append(s);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("abbaca -> " + removeDuplicates("abbaca"));
    }
}
