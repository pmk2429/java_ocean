package slidingWindow;

/**
 * Given a string s consisting only of characters a, b and c.
 * Return the number of substrings containing at least one occurrence of all these characters a, b and c.
 * <p>
 * Example 1:
 * ==========
 * Input: s = "abcabc"
 * Output: 10
 * Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca",
 * "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).
 * <p>
 * Example 2:
 * ==========
 * Input: s = "aaacb"
 * Output: 3
 * Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb"
 * and "acb".
 * <p>
 * Example 3:
 * ==========
 * Input: s = "abc"
 * Output: 1
 * <p>
 * Constraints:
 * ==========
 * 3 <= s.length <= 5 x 10^4
 * s only consists of a, b or c characters.
 */
public class SubstringContainingChars {

    private static int numberOfSubstrings(String s) {
        int[] last = {-1, -1, -1};
        int res = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            last[s.charAt(i) - 'a'] = i;
            // res = res + 1 + min of all 3 items in last
            res += 1 + Math.min(last[0], Math.min(last[1], last[2]));
        }
        return res;
    }


    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(numberOfSubstrings(s));
        String s1 = "aaacb";
        System.out.println(numberOfSubstrings(s1));
    }
}
