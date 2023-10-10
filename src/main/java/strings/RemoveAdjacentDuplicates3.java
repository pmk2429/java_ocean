package strings;

import java.util.Stack;

/**
 * You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters
 * from s and removing them, causing the left and the right side of the deleted substring to concatenate together.
 * We repeatedly make k duplicate removals on s until we no longer can.
 * Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.
 * <p>
 * Example 1:
 * ----------
 * Input: s = "abcd", k = 2
 * Output: "abcd"
 * Explanation: There's nothing to delete.
 * <p>
 * Example 2:
 * ----------
 * Input: s = "deeedbbcccbdaa", k = 3
 * Output: "aa"
 * Explanation:
 * First delete "eee" and "ccc", get "ddbbbdaa"
 * Then delete "bbb", get "dddaa"
 * Finally delete "ddd", get "aa"
 * <p>
 * Example 3:
 * ----------
 * Input: s = "pbbcggttciiippooaais", k = 2
 * Output: "ps"
 * <p>
 * Constraints:
 * ------------
 * 1 <= s.length <= 105
 * 2 <= k <= 104
 * s only contains lowercase English letters.
 */
public class RemoveAdjacentDuplicates3 {

    /**
     * Similar to {@link market.StockSpanner} where we maintain the cached results in Stack.
     */
    private static String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> counts = new Stack<>();
        for (int i = 0; i < sb.length(); i++) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                counts.push(1);
            }
            else {
                int incremented = counts.pop() + 1;
                if (incremented == k) {
                    // delete `k` chars together
                    sb.delete(i - k + 1, i + 1);
                    // reset `i` back to the start before deleted count
                    i = i - k;
                }
                else {
                    counts.push(incremented);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("deeedbbcccbdaa -> " + removeDuplicates("deeedbbcccbdaa", 3));
    }
}
