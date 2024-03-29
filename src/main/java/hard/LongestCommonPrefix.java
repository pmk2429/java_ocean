package hard;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * ----------
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * <p>
 * Example 2:
 * ----------
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix amongst the input strings.
 * <p>
 * Constraints:
 * ------------
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters.
 */
public class LongestCommonPrefix {

    private static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                // keep decreasing the length of prefix to find a match.
                // since we're trying to find prefix the intuition is to decrease length instead of moving i
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] str = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(str));
        String[] str2 = {"superman", "superstar", "superwoman", "superpower", "superficial"};
        System.out.println(longestCommonPrefix(str2));
    }
}
