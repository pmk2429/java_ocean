package strings;

public class AlphabeticalOrder {
    private static boolean isAlphabeticalOrder(String s) {
        int n = s.length();

        for (int i = 1; i < n; i++) {
            if (s.charAt(i - 1) > s.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    private static int longestContinuousSubstring(String s) {
        int j = 0, res = 1;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) != s.charAt(j) + i - j) {
                j = i;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        String pmk = "pavitra";
        System.out.println(isAlphabeticalOrder(pmk));

        String lca = "abacaba";
        System.out.println(longestContinuousSubstring(lca));
        String lca2 = "abcdef";
        System.out.println(longestContinuousSubstring(lca2));
    }
}
