package arrays.subs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Pavitra on 11/12/2015.
 */
public class AllSubstrings {

    private static String longestUniqueSubstring(String str) {
        Map<Character, Integer> visited = new HashMap<>();
        String longestUniqueSubstring = "";
        for (int i = 0, j = 0; j < str.length(); j++) {
            char currChar = str.charAt(j);
            if (visited.containsKey(currChar)) {
                i = Math.max(i, visited.get(currChar) + 1);
            }
            if (longestUniqueSubstring.length() < j - i + 1) {
                longestUniqueSubstring = str.substring(i, j + 1);
            }
            visited.put(currChar, j);
        }
        return longestUniqueSubstring;
    }

    private static void allUniqueSubstrings() {
        String str = "pavitra";

        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length() - i; j++) {
                String sub = str.substring(i, i + j);
                System.out.println(sub);
            }
        }
    }

    public static void allSubstrings() {
        String sub;
        String str = "pavitra";
        int i, c, length = str.length();

        for (c = 0; c < length; c++) {
            for (i = 1; i <= length - c; i++) {
                if (i >= 2) {
                    sub = str.substring(c, c + i);
                    System.out.println(sub);
                }
            }
        }
    }

    private static int longestContinuousSubstring(String s) {
        int j = 0, res = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(j) + i - j) {
                j = i;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        allSubstrings();
        System.out.println("--------------");
        allUniqueSubstrings();
        System.out.println("--------------");
        System.out.println(longestUniqueSubstring("pavitra"));
        String lca = "abacaba";
        System.out.println(longestContinuousSubstring(lca));
        String lca2 = "abcdef";
        System.out.println(longestContinuousSubstring(lca2));
    }
}
