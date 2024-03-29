package arrays;

/**
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.
 * <p>
 * Example 1:
 * ----------
 * Input: [1,2,3]
 * Output: 6
 * <p>
 * Example 2:
 * ----------
 * Input: [1,2,3,4]
 * Output: 24
 * <p>
 * Note:
 * -----
 * The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
 * Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
 */
public class MaximumProductOfThree {
    public int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int n : nums) {
            // find min
            if (n <= min1) {
                min2 = min1;
                min1 = n;
            }
            else if (n <= min2) { // n lies between min1 and min2
                min2 = n;
            }

            // find max
            if (n >= max1) { // n is greater than max1, max2 and max3
                max3 = max2;
                max2 = max1;
                max1 = n;
            }
            else if (n >= max2) { // n lies between max1 and max2
                max3 = max2;
                max2 = n;
            }
            else if (n >= max3) { // n lies between max2 and max3
                max3 = n;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}
