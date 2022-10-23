package numbers;


/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * <p>
 * For example:
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * <p>
 * Example 1:
 * ----------
 * Input: "A"
 * Output: 1
 * <p>
 * Example 2:
 * ----------
 * Input: "AB"
 * Output: 28
 * <p>
 * Example 3:
 * ----------
 * Input: "ZY"
 * Output: 701
 */
public class ExcelSheetColumnNumber {

    private static int getColNumber(String colName) {
        // considering length = 2 for colName that is a String of multiple chars
        int length = colName.length();
        int[] charValue = new int[length];
        for (int i = 0; i < length; i++) {
            charValue[i] = colName.charAt(i) - 'A';
        }
        int constant = 26;
        int colNumber = 0;
        for (int i = 0, j = 1; i < length - 1; i++, j = i + 1) {
            int multiplier = (colNumber == 0) ? charValue[i] : colNumber;
            colNumber = multiplier * constant + charValue[j];
        }

        return colNumber;
    }

    public static void main(String[] args) {
        String colName = "AB";
        System.out.println(getColNumber(colName));
    }
}
