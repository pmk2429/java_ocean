package numbers;

import java.util.Arrays;

import static java.lang.Math.min;

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

    private static int maxSubArraySum(int s, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum >= s) {
                ans = min(ans, i + 1 - left);
                sum -= nums[left++];
            }
        }
        return (ans != Integer.MAX_VALUE) ? ans : 0;
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

    public static void main(String[] args) {
        int[] max = subArraySum(new int[]{-1, 2, -1, -12, 35, 31, 26});
        System.out.println(Arrays.toString(max));
    }
}