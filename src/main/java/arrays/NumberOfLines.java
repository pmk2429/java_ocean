package arrays;

import java.util.Arrays;

/**
 * We are to write the letters of a given string S, from left to right into lines. Each line has maximum width 100
 * units, and if writing a letter would cause the width of the line to exceed 100 units, it is written on the next line.
 * We are given an array widths, an array where widths[0] is the width of 'a',
 * widths[1] is the width of 'b', ..., and widths[25] is the width of 'z'.
 * <p>
 * Now answer two questions:
 * - how many lines have at least one character from S, and
 * - what is the width used by the last such line? Return your answer as an integer list of length 2.
 * <p>
 * Example:
 * --------
 * Input:
 * widths = [10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
 * S = "abcdefghijklmnopqrstuvwxyz"
 * Output: [3, 60]
 * Explanation:
 * All letters have the same length of 10. To write all 26 letters,
 * we need two full lines and one line with 60 units.
 * <p>
 * Example:
 * --------
 * Input:
 * widths = [4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
 * S = "bbbcccdddaaa"
 * Output: [2, 4]
 * Explanation:
 * All letters except 'a' have the same length of 10, and
 * "bbbcccdddaa" will cover 9 * 10 + 2 * 4 = 98 units.
 * For the last 'a', it is written on the second line because
 * there is only 2 units left in the first line.
 * So the answer is 2 lines, plus 4 units in the second line.
 * <p>
 * Note:
 * <p>
 * The length of S will be in the range [1, 1000].
 * S will only contain lowercase letters.
 * widths is an array of length 26.
 * widths[i] will be in the range of [2, 10].
 */
public class NumberOfLines {

    private static int[] numberOfLinesOptimized(int[] widths, String S) {
        int res = 1, cur = 0;
        for (char c : S.toCharArray()) {
            int width = widths[c - 'a'];
            res = cur + width > 100 ? res + 1 : res;
            cur = cur + width > 100 ? width : cur + width;
        }
        return new int[]{res, cur};
    }

    private static int[] numberOfLines(int[] widths, String str) {
        int[] output = new int[2];
        int charFrequencySum = 0;
        int lineLimit = 100;
        int totalLines = 1;

        for (int i = 0; i < str.length(); i++) {
            int curCharWidth = 1;
            char c = str.charAt(i);
            int index = c - 'a';
            // multiply the width of char until frequency of char limit is reached
            curCharWidth = curCharWidth * widths[index];
            if (charFrequencySum + curCharWidth > lineLimit) {
                totalLines++;
                charFrequencySum = widths[index];
            }
            else {
                // iterator to find the total number of chars yet
                charFrequencySum += curCharWidth;
            }
        }
        output[0] = totalLines;
        output[1] = charFrequencySum;

        return output;
    }

    public static void main(String[] args) {
        int[] widths = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        int[] o2 = numberOfLines(widths, "abcdefghijklmnopqrstuvwxyz");
        System.out.println(Arrays.toString(o2));
        int[] widths2 = {4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        int[] output = numberOfLines(widths2, "bbbcccdddaaa");
        System.out.println(Arrays.toString(output));
    }
}
