package arrays;

import java.util.Arrays;
import java.util.Stack;

/**
 * There are n buildings in a line. You are given an integer array heights of size n that represents the heights of
 * the buildings in the line.
 * The ocean is to the right of the buildings. A building has an ocean view if the building can see the ocean without
 * obstructions. Formally, a building has an ocean view if all the buildings to its right have a smaller height.
 * Return a list of indices (0-indexed) of buildings that have an ocean view, sorted in increasing order.
 * <p>
 * Example 1:
 * ----------
 * Input: heights = [4,2,3,1]
 * Output: [0,2,3]
 * Explanation: Building 1 (0-indexed) does not have an ocean view because building 2 is taller.
 * <p>
 * Example 2:
 * ----------
 * Input: heights = [4,3,2,1]
 * Output: [0,1,2,3]
 * Explanation: All the buildings have an ocean view.
 * <p>
 * Example 3:
 * ----------
 * Input: heights = [1,3,2,4]
 * Output: [3]
 * Explanation: Only building 3 has an ocean view.
 * <p>
 * Similar to {@link DailyTemperatures}
 */
public class BuildingWithOceanView {

    private static int[] findBuildings(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            if (stack.isEmpty() || heights[i] > heights[stack.peek()]) {
                stack.push(i);
            }
        }

        int[] buildings = new int[stack.size()];
        int idx = 0;
        while (!stack.isEmpty()) {
            buildings[idx++] = stack.pop();
        }

        return buildings;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findBuildings(new int[]{4, 2, 3, 1})));
        System.out.println(Arrays.toString(findBuildings(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(findBuildings(new int[]{1, 3, 2, 4})));
    }

}
