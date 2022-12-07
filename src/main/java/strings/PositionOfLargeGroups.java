package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * In a string S of lowercase letters, these letters form consecutive groups of the same character.
 * For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".
 * Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every
 * large group.
 * <p>
 * The final answer should be in lexicographic order.
 * <p>
 * Example 1:
 * ----------
 * Input: "abbxxxxzzy"
 * Output: [[3,6]]
 * Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
 * <p>
 * Example 2:
 * ----------
 * Input: "abc"
 * Output: []
 * Explanation: We have "a","b" and "c" but no large group.
 * <p>
 * Example 3:
 * ---------
 * Input: "abcdddeeeeaabbbcd"
 * Output: [[3,5],[6,9],[12,14]]
 * <p>
 * Note:  1 <= S.length <= 1000
 */
public class PositionOfLargeGroups {

    private static List<List<Integer>> largeGroupPositions(String str) {
        List<List<Integer>> groups = new ArrayList<>();
        int startPos = 0;
        int endPos = 0;
        int i = 0, j;
        while (i < str.length()) {
            List<Integer> position = new ArrayList<>();
            startPos = i;
            j = i + 1;
            if (j < str.length()) {
                while (str.charAt(i) == str.charAt(j)) {
                    endPos = j;
                    j++;
                }
                if (endPos - startPos >= 2) {
                    position.add(startPos);
                    position.add(endPos);
                    groups.add(position);
                }
            }
            i = j;
        }
        return groups;
    }

    public static void main(String[] args) {
        String S = "abbxxxxzzy";
        String S1 = "abcdddeeeeaabbbcd";
        List<List<Integer>> orderLists = largeGroupPositions(S1);
        for (List<Integer> order : orderLists) {
            System.out.println(order);
        }
    }
}
