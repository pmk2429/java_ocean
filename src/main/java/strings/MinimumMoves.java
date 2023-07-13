package strings;

/**
 * You are given a string s consisting of n characters which are either 'X' or 'O'.
 * A move is defined as selecting three consecutive characters of s and converting them to 'O'.
 * Note that if a move is applied to the character 'O', it will stay the same.
 * Return the minimum number of moves required so that all the characters of s are converted to 'O'.
 * <p>
 * Example 1:
 * ----------
 * Input: s = "XXX"
 * Output: 1
 * Explanation: XXX -> OOO
 * We select all the 3 characters and convert them in one move.
 * <p>
 * Example 2:
 * ----------
 * Input: s = "XXOX"
 * Output: 2
 * Explanation: XXOX -> OOOX -> OOOO
 * We select the first 3 characters in the first move, and convert them to 'O'.
 * Then we select the last 3 characters and convert them so that the final string contains all 'O's.
 * <p>
 * Example 3:
 * ----------
 * Input: s = "OOOO"
 * Output: 0
 * Explanation: There are no 'X's in s to convert.
 * <p>
 * Constraints:
 * ----------
 * 3 <= s.length <= 1000
 * s[i] is either 'X' or 'O'.
 */
public class MinimumMoves {

    private static int minimumMoves(String s) {
        if (s == null) {
            return -1;
        }

        int length = s.length();

        if (length < 3 || length > 1000) {
            return -1;
        }

        int i = 0;
        int moves = 0;
        while (i < length) {
            if (s.charAt(i) == 'X') {
                i = i + 3;
                moves++;
            }
            else {
                i++;
            }
        }
        return moves;
    }

    public static void main(String[] args) {
        String s = "XXX";
        System.out.println(minimumMoves(s));
        String s1 = "XXOX";
        System.out.println(minimumMoves(s1));
        String s2 = "OOOO";
        System.out.println(minimumMoves(s2));
    }
}
