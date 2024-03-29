package numbers;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 */
public class SingleNumber {

    private int singleNumber3Times(int[] A, int n) {
        int ones = 0, twos = 0, threes = 0;
        for (int i = 0; i < n; i++) {
            twos |= ones & A[i];
            ones ^= A[i];
            threes = ones & twos;
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }

    /**
     * Given an array of integers, every element appears three times except for one. Find that single one.
     * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
     */
    private static int singleNumberOn(int[] A) {
        Set<Integer> set = new HashSet<>();
        int multipleNum = -1;
        for (int x : A) {
            if (set.contains(x)) {
                set.remove(x);
                multipleNum = x;
            }
            else {
                set.add(x);
            }
        }
        return multipleNum;
    }

    private static int singleNumber2(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 5, 4, 2, 7, 8};
        System.out.println(singleNumberOn(nums));
        int[] nums2 = {4, 1, 2, 1, 2};
        System.out.println(singleNumber2(nums2));
    }
}
