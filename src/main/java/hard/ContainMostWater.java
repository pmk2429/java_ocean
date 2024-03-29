package hard;

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of
 * the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 * <p>
 * Example 1:
 * ==========
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 * In this case, the max area of water (blue section) the container can contain is 49.
 * <p>
 * Example 2:
 * ==========
 * Input: height = [1,1]
 * Output: 1
 * <p>
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainMostWater {
    private static int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1;
        int maxArea = 0;

        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(heights[left], heights[right]) * (right - left));
            if (heights[left] < heights[right]) {
                left++;
            }
            else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }
}
