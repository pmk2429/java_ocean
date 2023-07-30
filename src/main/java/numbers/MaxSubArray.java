package numbers;

import java.util.Arrays;

/**
 * Created by Pavitra on 4/22/2016.
 * <p>
 * ~!@#HARD:REVISE
 */
public class MaxSubArray {

    private static int maxSubArray(int[] nums) {
        int ans = nums[0], sum = 0;
        for (int num : nums) {
            sum = Math.max(num, sum + num);
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public static int[] subArraySum(int[] A) {
        int[] m = new int[A.length];
        int startingIndex = A.length - 1;
        int endingIndex = 0;

        // find endingIndex
        m[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            m[i] = Math.max(A[i], m[i - 1] + A[i]);
            if (m[endingIndex] < m[i]) {
                endingIndex = i;
            }
        }

        // find startingIndex
        Arrays.fill(m, 0);
        m[A.length - 1] = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; i--) {
            m[i] = Math.max(A[i], m[i + 1] + A[i]);
            if (m[startingIndex] < m[i]) {
                startingIndex = i;
            }
        }

        if (endingIndex <= startingIndex) {
            return null; //no array size less than 2 allowed
        }

        int[] result = Arrays.copyOfRange(A, startingIndex, endingIndex + 1);
        return result;
    }

    private static int maxSubArraySum(int[] nums) {
        int maxSubArr = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int currSubArr = 0;
            for (int j = i; j < nums.length; j++) {
                currSubArr += nums[j];
                maxSubArr = Math.max(maxSubArr, currSubArr);
            }
        }
        return maxSubArr;
    }

    public static void main(String[] args) {
        // The subarray [4,-1,2,1] has the largest sum 6.
        int maxSubArray = maxSubArraySum(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(maxSubArray);
    }
}