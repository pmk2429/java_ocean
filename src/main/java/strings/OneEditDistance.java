package strings;

/**
 * Question:
 * Given two strings S and T, determine if they are both one edit distance apart.
 * Hint:
 * 1. If | n – m | is greater than 1, we know immediately both are not one-edit distance apart.
 * 2. It might help if you consider these cases separately, m == n and m ≠ n.
 * 3. Assume that m is always ≤ n, which greatly simplifies the conditional statements.
 * If m > n, we could just simply swap S and T.
 * 4. If m == n, it becomes finding if there is exactly one modified operation. If m ≠ n, you do not have to consider
 * the delete operation. Just consider the insert operation in T.
 * <p>
 * Example 1:
 * ==========
 * Input: s = "ab", t = "acb"
 * Output: true
 * Explanation: We can insert 'c' into s to get t.
 * <p>
 * Example 2:
 * ==========
 * Input: s = "", t = ""
 * Output: false
 * Explanation: We cannot get t from s by only one step.
 */
public class OneEditDistance {
    private static boolean isOneEditDistance(String s, String t) {
        int sLength = s.length(), tLength = t.length();

        if (sLength > tLength) {
            return isOneEditDistance(t, s);
        }

        if (tLength - sLength > 1) {
            return false;
        }

        int i = 0, shift = tLength - sLength;

        while (i < sLength && s.charAt(i) == t.charAt(i)) {
            i++;
        }

        if (i == sLength) {
            return shift > 0;
        }

        if (shift == 0) {
            i++;
        }

        while (i < sLength && s.charAt(i) == t.charAt(i + shift)) {
            i++;
        }

        return i == sLength;
    }

    public static void main(String[] args) {
        String s = "ab", t = "acb";
        System.out.println(isOneEditDistance(s, t));
        String m = "", n = "";
        System.out.println(isOneEditDistance(m, n));
    }
}
