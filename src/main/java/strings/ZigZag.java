package strings;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/zigzag-conversion/solution/
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
        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }

    public static void main(String[] args) {

    }
}
