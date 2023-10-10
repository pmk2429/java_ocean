package hard;

/**
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
 * of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a
 * subsequence of "abcde" while "aec" is not).
 * <p>
 * Given two strings source and target, return the minimum number of subsequences of source such that their
 * concatenation equals target. If the task is impossible, return -1.
 * <p>
 * Example 1:
 * ----------
 * Input: source = "abc", target = "abcbc"
 * Output: 2
 * Explanation: The target "abcbc" can be formed by "abc" and "bc", which are subsequences of source "abc".
 * <p>
 * Example 2:
 * ----------
 * Input: source = "abc", target = "acdbc"
 * Output: -1
 * Explanation: The target string cannot be constructed from the subsequences of source string due to the character
 * "d" in target string.
 * <p>
 * Example 3:
 * ----------
 * Input: source = "xyz", target = "xzyxz"
 * Output: 3
 * Explanation: The target string can be constructed as follows "xz" + "y" + "xz".
 * <p>
 * Constraints:
 * <p>
 * 1 <= source.length, target.length <= 1000
 * source and target consist of lowercase English letters.
 */
public class ShortestWayToFormAString {

    private static int minSubsequencesRequired(String source, String target) {
        int[] chars = new int[26];

        for (char c : source.toCharArray()) {
            chars[c - 'a']++;
        }

        int sourceLength = source.length();
        int targetLength = target.length();

        if (targetLength < sourceLength) {
            return -1;
        }

        int i = 0, j = 0;
        int count = 1;
        while (j < targetLength) {
            char iChar = source.charAt(i);
            char jChar = target.charAt(j);
            if (iChar == jChar) {
                j++;
            }
            else if (chars[jChar - 'a'] <= 0) {
                // if none of the chars that are present in `source` are in `target`, return -1
                return -1;
            }
            i++;
            // if target end is not reached but source end is reached, start scanning `source` again.
            if (i == sourceLength && j != targetLength) {
                count++;
                i = 0;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String source = "abc", target = "abcbc";
        System.out.println(minSubsequencesRequired(source, target));
        String source1 = "xyz", target1 = "xzyxz";
        System.out.println(minSubsequencesRequired(source1, target1));
    }
}
