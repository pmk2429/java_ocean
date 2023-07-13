package strings;


/**
 * You are given a string s of lowercase English letters and an integer array shifts of the same length.
 * Call the shift() of a letter, the next letter in the alphabet, (wrapping around so that 'z' becomes 'a').
 * For example, shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'.
 * Now for each shifts[i] = x, we want to shift the first i + 1 letters of s, x times.
 * Return the final string after all such shifts to s are applied.
 * <p>
 * Example 1:
 * ----------
 * Input: s = "abc", shifts = [3,5,9]
 * Output: "rpl"
 * Explanation: We start with "abc".
 * After shifting the first 1 letters of s by 3, we have "dbc".
 * After shifting the first 2 letters of s by 5, we have "igc".
 * After shifting the first 3 letters of s by 9, we have "rpl", the answer.
 * <p>
 * Example 2:
 * ----------
 * Input: s = "aaa", shifts = [1,2,3]
 * Output: "gfd"
 * <p>
 * Constraints:
 * ----------
 * 1 <= s.length <= 105
 * s consists of lowercase English letters.
 * shifts.length == s.length
 * 0 <= shifts[i] <= 109
 * <p>
 * ~!@#HARD:REVISE
 */
public class ShiftLettersInString {

    /**
     * This is equivalent to shifting "abc" with shifts=[3+5+9 , 5+9 , 9 ] == [17 , 14 , 9]
     * So the intuition of this solution is to do reverse prefix sum.
     * <a href="https://leetcode.com/problems/shifting-letters/solutions/1451878/c-java-python-easy-solution-well-explained-with-code-for-reference/">...</a>
     */
    private static String shiftingLetters(String s, int[] shifts) {
        if (s == null || s.trim().length() == 0) {
            return null;
        }

        StringBuilder ans = new StringBuilder(s);
        int length = s.length();
        long shift = 0;
        for (int i = length - 1; i >= 0; i--) {
            ans.setCharAt(i, (char) ((s.charAt(i) - 'a' + (shift + shifts[i]) % 26) % 26 + 'a'));
            shift += shifts[i];
        }
        return ans.toString();
    }

    public static void main(String[] args) {

    }
}
