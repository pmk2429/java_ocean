package arrays;

public class WaysToSplitArray2 {

    private static int waysToSplitArray(int[] nums) {
        // prefix sum
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        int waysToSplit = 0;
        for (int i = 0, j = 0, k = 0; i < nums.length - 2 && 3 * nums[i] <= nums[nums.length - 1]; i++) {
            j = Math.max(j, i + 1);
            while (j < nums.length - 1 && nums[j] - nums[i] < nums[i])
                j++;
            k = Math.max(k, j);
            while (k < nums.length - 1 && nums[k] - nums[i] <= nums[nums.length - 1] - nums[k])
                k++;
            waysToSplit = (waysToSplit + k - j) % 1000000007;
        }
        return waysToSplit;
    }

    public static void main(String[] args) {
        int[] nums = {10, 4, -8, 7};
        System.out.println(waysToSplitArray(nums));
    }
}
