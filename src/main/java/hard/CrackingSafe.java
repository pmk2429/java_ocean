package hard;

import java.util.HashSet;
import java.util.Set;

/**
 * There is a box protected by a password. The password is length digits, where each letter can be one of the first k
 * digits 0, 1, ..., k-1.
 * You can keep inputting the password, the password will automatically be matched against the last length digits entered.
 * For example, assuming the password is "345", I can open it when I type "012345", but I enter a total of 6 digits.
 * <p>
 * Please return any string of minimum length that is guaranteed to open the box after the entire string is inputted.
 * <p>
 * Example 1:
 * Input: length = 1, k = 2
 * Output: "01"
 * Note: "10" will be accepted too.
 * <p>
 * Example 2:
 * Input: length = 2, k = 2
 * Output: "00110"
 * Note: "01100", "10011", "11001" will be accepted too.
 * <p>
 * Note:
 * length will be in the range [1, 4].
 * k will be in the range [1, 10].
 * k^length will be at most 4096.
 */
public class CrackingSafe {

    private static Set<String> seen;
    private static StringBuilder ans;

    private static void dfs(String node, int k) {
        for (int x = 0; x < k; x++) {
            String neighbor = node + x;
            if (!seen.contains(neighbor)) {
                seen.add(neighbor);
                dfs(neighbor.substring(1), k);
                ans.append(x);
            }
        }
    }

    private static String crackSafe(int n, int k) {
        if (n < 0 || n > 4) {
            return "0";
        }

        if (k < 0 || k > 10) {
            return "0";
        }

        if (n == 1 && k == 1) {
            return "0";
        }

        seen = new HashSet<>();
        ans = new StringBuilder();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; ++i) {
            sb.append("0");
        }
        String start = sb.toString();

        dfs(start, k);
        ans.append(start);
        return new String(ans);
    }

    public static void main(String[] args) {
        int n = 2;
        int k = 5;
        System.out.println(crackSafe(n, k));
    }
}
