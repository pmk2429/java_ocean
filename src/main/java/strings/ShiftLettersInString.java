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
     * <p>
     * this statement is taking a character from the original string, applying a shift to it, and updating
     * the corresponding character in a StringBuilder with the shifted character
     * <p>
     * (shift + shifts[i]) % 26:
     * This calculates the new shift value for the character.
     * shift is a running total of shifts calculated for previous characters, and shifts[i] is the
     * shift specified for the current character at index i.
     * The modulo operation % 26 ensures that the shift value wraps around within the range of the
     * English alphabet (26 letters).
     * <p>
     * ((s.charAt(i) - 'a' + (shift + shifts[i]) % 26) % 26):
     * This combines the previous two steps to calculate the new 0-based index of the character within the
     * English alphabet after applying the shift.
     */
    private static String shiftingLetters(String s, int[] shifts) {
        if (s == null || s.trim().length() == 0) {
            return null;
        }

        StringBuilder ans = new StringBuilder(s);
        int length = s.length();
        long shift = 0;
        for (int i = length - 1; i >= 0; i--) {
            int charValue = s.charAt(i) - 'a';
            int shiftValue = (int) ((shift + shifts[i]) % 26);
            int shiftedCharValue = (charValue + shiftValue) % 26;
            char shiftedChar = (char) (shiftedCharValue + 'a');
            ans.setCharAt(i, shiftedChar);
            // ans.setCharAt(i, (char) ((s.charAt(i) - 'a' + (shift + shifts[i]) % 26) % 26 + 'a'));
            shift += shifts[i];
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "abc";
        int[] shifts = {3, 5, 9};
        System.out.println(shiftingLetters(s, shifts));
        String s1 = "aaa";
        int[] shifts1 = {1, 2, 3};
        System.out.println(shiftingLetters(s1, shifts1));
    }
}
