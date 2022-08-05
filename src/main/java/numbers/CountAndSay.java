package numbers;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * <p>
 * 1.   1
 * 2.   11
 * 3.   21
 * 4.   1211
 * 5.   111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth term of the count-and-say sequence.
 * Note: Each term of the sequence of integers will be represented as a string.
 * <p>
 * Example 1:
 * ----------
 * Input: 1
 * Output: "1"
 * <p>
 * Example 2:
 * ----------
 * Input: 4
 * Output: "1211"
 */
public class CountAndSay {

    private static String nextString(String str) {
        int strLen = str.length();
        StringBuilder next = new StringBuilder();
        int i = 0;
        while (i < strLen) {
            int j = i;
            int count = 0;
            char currentNumber = str.charAt(i);
            while (j < strLen && str.charAt(j) == currentNumber) {
                j++;
                count++;
            }
            next.append(count).append(currentNumber);
            i = j;
        }
        return next.toString();
    }

    private static String countAndSay(int num) {
        String csStr = "1";
        if (num <= 1) {
            return csStr;
        }
        else {
            for (int i = 2; i <= num; i++) {
                csStr = nextString(csStr);
            }
        }
        return csStr;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(countAndSay(n));
    }
}
