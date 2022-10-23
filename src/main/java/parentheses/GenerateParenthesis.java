package parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * Example 1:
 * ==========
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * Example 2:
 * ==========
 * Input: n = 1
 * Output: ["()"]
 * <p>
 * Constraints:
 * ==========
 * 1 <= n <= 8
 */
public class GenerateParenthesis {

    private static void backtrack(List<String> list, String str, int open, int close, int max) {
        // base case -- add to list only when the String size is 2x the input number
        if (str.length() == max * 2) {
            list.add(str);
            return;
        }

        if (open < max)
            backtrack(list, str + "(", open + 1, close, max);
        if (close < open)
            backtrack(list, str + ")", open, close + 1, max);
    }

    // backtracking problem
    private static List<String> generateParenthesis(int n) {
        if (n <= 1 || n >= 8) {
            return null;
        }

        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
        System.out.println(generateParenthesis(1));
    }
}
