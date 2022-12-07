package strings;

import java.util.Arrays;

/**
 * Given a string s and a character c that occurs in s, return an array of integers answer where answer.length == s
 * .length and answer[i] is the distance from index i to the closest occurrence of character c in s.
 * The distance between two indices i and j is abs(i - j), where abs is the absolute value function.
 * <p>
 * Example 1:
 * ----------
 * Input: s = "loveleetcode", c = "e"
 * Output: [3,2,1,0,1,0,0,1,2,2,1,0]
 * Explanation: The character 'e' appears at indices 3, 5, 6, and 11 (0-indexed).
 * The closest occurrence of 'e' for index 0 is at index 3, so the distance is abs(0 - 3) = 3.
 * The closest occurrence of 'e' for index 1 is at index 3, so the distance is abs(1 - 3) = 2.
 * For index 4, there is a tie between the 'e' at index 3 and the 'e' at index 5, but the distance is still the same: abs(4 - 3) == abs(4 - 5) = 1.
 * The closest occurrence of 'e' for index 8 is at index 6, so the distance is abs(8 - 6) = 2.
 * <p>
 * Example 2:
 * ----------
 * Input: s = "aaab", c = "b"
 * Output: [3,2,1,0]
 */
public class ShortestDistanceToChar {
    private static int[] shortestToChar(String S, char C) {
        if (S == null || S.length() == 0) {
            return null;
        }
        int length = S.length();
        int[] ans = new int[length];

        // 1st pass from the start
        int position = -length;
        for (int i = 0; i < length; i++) {
            if (S.charAt(i) == C) {
                // position keeps track of last known encountered position of `e`
                position = i;
            }
            ans[i] = i - position; // difference between `current index` and the index of `C`
        }

        // 2nd pass from the end
        for (int i = length - 1; i >= 0; i--) {
            if (S.charAt(i) == C) {
                // position keeps track of last known encountered position of `e`
                position = i;
            }
            ans[i] = Math.min(ans[i], position - i);
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        char c = 'e';
        System.out.println(Arrays.toString(shortestToChar(s, c)));
    }
}
