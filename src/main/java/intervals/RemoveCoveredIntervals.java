package intervals;

import java.util.Arrays;

/**
 * Given an array intervals where intervals[i] = [li, ri] represent the interval [li, ri), remove all intervals that
 * are covered by another interval in the list.
 * The interval [a, b) is covered by the interval [c, d) if and only if c <= a and b <= d.
 * So basically for intervals (start1, end1) and (start2, end2), if start2 <= start1 && end1 <= end2, we can say
 * that interval2 covers interval1.
 * Return the number of remaining intervals.
 * <p>
 * Example 1:
 * ----------
 * Input: intervals = [[1,4],[3,6],[2,8]]
 * Output: 2
 * Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.
 * <p>
 * Example 2:
 * ----------
 * Input: intervals = [[1,4],[2,3]]
 * Output: 1
 * <p>
 * Constraints:
 * ------------
 * 1 <= intervals.length <= 1000
 * intervals[i].length == 2
 * 0 <= li < ri <= 105
 * All the given intervals are unique.
 */
public class RemoveCoveredIntervals {

    private static int removeCoveredIntervals(int[][] intervals) {
        // Sort by start point.
        // If two intervals share the same start point, put the longer one to be the first; one with higher end time.
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int count = 0;
        int prevEnd = 0;
        for (int[] interval : intervals) {
            int end = interval[1];
            // if current interval is not covered by the previous one, update the end
            if (end > prevEnd) {
                count++;
                prevEnd = end;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {3, 6}, {2, 8}};
        System.out.println(removeCoveredIntervals(intervals));
    }
}
