package strings;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/zigzag-conversion/solution/

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string s, int numRows);
 * <p>
 * Example 1:
 * ----------
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * <p>
 * Example 2:
 * ----------
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * ------------
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * Example 3:
 * ----------
 * Input: s = "A", numRows = 1
 * Output: "A"
 * <p>
 * Constraints:
 * ------------
 * 1 <= s.length <= 1000
 * s consists of English letters (lower-case and upper-case), ',' and '.'.
 * 1 <= numRows <= 1000
 */
public class ZigZag {

    /**
     * Sort by Row
     * <p>
     * Intuition
     * ---------
     * By iterating through the string from left to right, we can easily determine which row in the Zig-Zag pattern
     * that a character belongs to.
     * <p>
     * Algorithm
     * ---------
     * We can use min(numRows,len(s)) lists to represent the non-empty rows of the Zig-Zag Pattern.
     * Iterate through ss from left to right, appending each character to the appropriate row.
     * The appropriate row can be tracked using two variables: the current row and the current direction.
     * The current direction changes only when we moved up to the topmost row or moved down to the bottommost row.
     */
    private static String zigZag(String s, int numRows) {
        if (HanaStringUtils.isNullOrEmpty(s)) {
            return s;
        }

        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            // flip the direction for first or last row and then carry on with logic
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(zigZag(s, numRows));
    }
}
