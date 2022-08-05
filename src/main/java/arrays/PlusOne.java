package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 * <p>
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * <p>
 * Example 2:
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 */
public class PlusOne {

    private static int[] plusOne(int[] arr) {
        int length = arr.length;
        int carry = 0;
        // start with the reverse loop
        for (int i = (length - 1); i >= 0; i--) {
            int lastSum = arr[i] + 1;
            if (lastSum > 9) {
                int lastDigit = lastSum % 10;
                arr[i] = lastDigit;
                carry = 1;
            }
            else {
                arr[i] = lastSum;
                carry = 0;
                break;
            }
        }
        // if we got a carry from our calculations such that 99, then we need to add it to previous digits
        // and at the same time have to increase the # of digits count in array.So create a new array
        if (carry != 0) {
            int[] retArr = new int[length + 1];
            retArr[0] = carry;
            System.arraycopy(arr, 0, retArr, 1, arr.length);
            return retArr;
        }
        return arr;
    }

    private static List<Integer> plusOne(List<Integer> digits) {
        for (int i = digits.size() - 1; i >= 0; i--) {
            int digit = digits.get(i);
            if (digit < 9) {
                digits.set(i, digit + 1);
                return null;
            }
            else {
                digits.set(i, 0);
            }
        }
        digits.add(0);
        digits.set(0, 1);

        return digits;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 9};
        System.out.println(Arrays.toString(plusOne(arr)));

    }
}
