package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that
 * each letter appears in at most one part, and return a list of integers representing the size of these parts.
 * <p>
 * Example 1:
 * ----------
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * ------------
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 * <p>
 * Note:
 * -----
 * S will have length in range [1, 500].
 * S will consist of lowercase letters ('a' to 'z') only.
 */
public class PartitionLabels {

    /**
     * Time Complexity: O(N), where N is the length of S.
     * Space Complexity: O(1) to keep data structure last of not more
     * <p>
     * Based on the condition give, first find the first and last occurrence in the String.
     * This will make sure that the partitions are divided based on the ends and not arbitrarily.
     */
    private static List<Integer> partitionLabels(String str) {
        int[] lastIndex = new int[26]; // stores the last index; occurrence of current char
        for (int i = 0; i < str.length(); i++) {
            lastIndex[str.charAt(i) - 'a'] = i;
        }

        int j = 0, partitionIndex = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            j = Math.max(j, lastIndex[str.charAt(i) - 'a']);
            // once `j` has reached `i` make the partition
            if (i == j) {
                ans.add(i - partitionIndex + 1);
                // once partition is done, increment partitionIndex to curr index + 1
                partitionIndex = i + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(str));
    }
}
