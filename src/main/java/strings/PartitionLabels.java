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

    // based on the condition give, first find the first and last occurrence in the String. This will make sure that
    // the partitions are divided based on the ends and not arbitrarily
    private static List<Integer> partitionLabels(String S) {
        List<Integer> partitions = new ArrayList<>();

        int start = 0, end = 0;
        char firstChar = S.charAt(start);

        // find last index of 'a' in S


        return partitions;
    }

    public static void main(String[] args) {
        String str = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(str));
    }
}
