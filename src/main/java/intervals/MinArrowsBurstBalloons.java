package intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * There are some spherical balloons taped onto a flat wall that represents the XY-plane.
 * The balloons are represented as a 2D integer array points where points[i] = [xstart, xend] denotes a
 * balloon whose horizontal diameter stretches between xstart and xend. You do not know the exact y-coordinates of the balloons.
 * Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis.
 * A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend.
 * There is no limit to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely,
 * bursting any balloons in its path.
 * Given the array points, return the minimum number of arrows that must be shot to burst all balloons.
 * <p>
 * Example 1:
 * ----------
 * Input: points = [[10,16],[2,8],[1,6],[7,12]]
 * Output: 2
 * Explanation: The balloons can be burst by 2 arrows:
 * - Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
 * - Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
 * <p>
 * Example 2:
 * ----------
 * Input: points = [[1,2],[3,4],[5,6],[7,8]]
 * Output: 4
 * Explanation: One arrow needs to be shot for each balloon for a total of 4 arrows.
 * <p>
 * Example 3:
 * ----------
 * Input: points = [[1,2],[2,3],[3,4],[4,5]]
 * Output: 2
 * Explanation: The balloons can be burst by 2 arrows:
 * - Shoot an arrow at x = 2, bursting the balloons [1,2] and [2,3].
 * - Shoot an arrow at x = 4, bursting the balloons [3,4] and [4,5].
 * <p>
 * Constraints:
 * ------------
 * 1 <= points.length <= 105
 * points[i].length == 2
 * -231 <= xstart < xend <= 231 - 1
 * <p>
 * Similar to {@link intervals.EraseOverlappingIntervals}
 * <p>
 * ~!@#HARD:REVISE
 */
public class MinArrowsBurstBalloons {

    private static int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        // Using the o1[1] - o2[1] trick for comparison might cause Integer overflow
        // for very large or small values.
        //
        // Arrays.sort(points, (a, b) -> {
        //      if (a[1] == b[1]) return 0;
        //      if (a[1] < b[1]) return -1;
        //      return 1;
        // });
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        int arrows = 1;
        int xStart, xEnd, firstEnd = points[0][1]; // firstEnd points to `end` of first sorted point
        for (int[] point : points) {
            xStart = point[0];
            xEnd = point[1];
            // if the current balloon starts after the end of another one needs one more arrow
            if (xStart > firstEnd) {
                arrows++;
                firstEnd = xEnd;
            }
        }

        return arrows;
    }

    public static void main(String[] args) {
        int[][] points = {
            {10, 16},
            {2, 8},
            {1, 6},
            {7, 12}
        };
        System.out.println(findMinArrowShots(points));
        int[][] balloons = {
            {1, 2}, {2, 3}, {3, 4}, {4, 5}
        };
        System.out.println(findMinArrowShots(balloons));
    }
}
