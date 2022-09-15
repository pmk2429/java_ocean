package arrays;

import java.util.Arrays;
import java.util.BitSet;

/**
 * Find Missing Number(s)
 * <p>
 * - WAP to find one missing number in an array
 * - WAP to find more than one missing numbers in continuous array of sorted numbers
 * - WAP to find missing numbers from an array of duplicates
 */
public class MissingNumber {

    // missing number in an unsorted array
    private static int findMissing(int[] arr, int totalCount) {
        int nSum = totalCount * (totalCount + 1) / 2;
        int actualSum = Arrays.stream(arr).sum();
        return nSum - actualSum;
    }

    // missing number using BitSet
    private static void findMultipleMissing(int[] arr, int count) {
        int missingCount = count - arr.length;
        BitSet bitSet = new BitSet(count);

        for (int i : arr) {
            bitSet.set(i - 1);
        }

        int lastMissingIndex = 0;
        for (int i = 0; i < missingCount; i++) {
            lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
            System.out.println(++lastMissingIndex);
        }
    }

    private static void findMissingFromDuplicates(int[] arr) {
        int[] register = new int[arr.length];

        for (int i : arr) {
            register[i] = 1;
        }

        for (int i = 1; i < register.length; i++) {
            if (register[i] == 0) {
                System.out.println(i);
            }
        }
    }

    /**
     * findMissingNumber(int [], int, int) method is used to find the
     * missing number from an array of integers.
     * It does the finding by adding all the numbers in a specific range,
     * and then it will add all the numbers in the actual array.
     * Finally, the difference between the actual sum i.e. the total of
     * all the numbers in the actual array(start to end) and the total
     * of all the numbers in the array yields the missing number.
     */
    private static int findMissingNumber(int[] nums) {
        int n = nums.length;
        int sum = n;
        for (int i = 0; i < n; i++) {
            sum += i - nums[i];
        }
        return sum;
    }

    private static int missingNumberXOR(int[] nums) {
        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }

        return xor ^ i;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 6, 7, 8, 9, 10};
        System.out.println("Missing # in an array:");
        System.out.println(findMissing(a, 10));

        int[] b = new int[]{1, 2, 3, 4, 6, 7, 9, 10};
        System.out.println("\nAll missing #s in an array:");
        findMultipleMissing(b, 10);

        int[] input = {1, 1, 2, 3, 5, 5, 7, 9, 9, 9};
        System.out.println("\nMissing #s in an array of duplicates:");
        findMissingFromDuplicates(input);
    }
}
