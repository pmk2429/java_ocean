package intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of intervals where intervals[i] = [starting, ending], return the minimum number of intervals
 * you need to remove to make the rest of the intervals non-overlapping.
 * <p>
 * Example 1:
 * ----------
 * Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * Input: intervals = [[1,2],[2,3],[1,3],[3,4]]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
 * <p>
 * Example 2:
 * ----------
 * Input: intervals = [[1,2],[1,2],[1,2]]
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
 * <p>
 * Example 3:
 * ----------
 * Input: intervals = [[1,2],[2,3]]
 * Output: 0
 * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 * <p>
 * Constraints:
 * ------------
 * 1 <= intervals.length <= 105
 * intervals[i].length == 2
 * -5 * 104 <= starti < endi <= 5 * 104
 */
public class EraseOverlappingIntervals {

    private static int eraseOverlapIntervals(int[][] intervals) {
        // sort intervals based on their end
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int ans = 0;
        int prevEnd = Integer.MIN_VALUE;

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            if (start >= prevEnd) {
                // update the end to most recently seen interval
                prevEnd = end;
            }
            else {
                // Here, the start of the interval is less than the most recent end, so it's an overlap
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(eraseOverlapIntervals(intervals));
        int[][] intervals2 = {{1, 2}, {1, 2}, {1, 2}};
        System.out.println(eraseOverlapIntervals(intervals2));
        int[][] intervals3 = {{1, 2}, {2, 3}};
        System.out.println(eraseOverlapIntervals(intervals3));
    }

}
