package numbers;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * <p>
 * Example:
 * Input: 38
 * Output: 2
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 */
public class AddDigits {

    private static int length(int num) {
        int length = 0;
        long temp = 1;
        while (temp <= num) {
            length++;
            temp *= 10;
        }
        return length;
    }

    private static int addDigits(int num) {
        int finalSum = 0;
        while (length(num) != 1) {
            finalSum = 0;
            while (num % 10 != 0) {
                finalSum += num % 10;
                num = num / 10;
            }
            finalSum += num;
            num = finalSum;
        }
        return finalSum;
    }

    private static int addAllDigits(int num) {
        return 1 + (num - 1) % 9;
    }

    public static void main(String[] args) {
        System.out.println(addAllDigits(49));
    }
}
