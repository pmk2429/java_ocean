package intervals;

import java.util.Arrays;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 * <p>
 * Example 1:
 * ----------
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * <p>
 * Example 2:
 * ----------
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * <p>
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
public class InsertIntervals {

  private static int[][] insert(int[][] intervals, int[] newInterval) {
    int M = intervals.length;

    // Time : O(n) Space : O(n)
    if (newInterval == null) return intervals;

    int[][] list = new int[intervals.length + 1][2];

    int i = 0;
    int idx = 0;

    int start = newInterval[0];
    int end = newInterval[1];

    while (i < M && intervals[i][1] < start) {
      list[idx][0] = intervals[i][0];
      list[idx][1] = intervals[i][1];
      idx++;
      i++;
    }

    // replace the new intervals with the minimum value
    while (i < M && intervals[i][0] <= end) {
      newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
      newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
      i++;
    }

    list[idx][0] = newInterval[0];
    list[idx++][1] = newInterval[1];

    while (i < M) {
      list[idx][0] = intervals[i][0];
      list[idx++][1] = intervals[i++][1];
    }

    // create a 2D array that doesn't contain extra spaces
    int[][] res = new int[idx][2];
    for (int j = 0; j < idx; j++) {
      res[j][0] = list[j][0];
      res[j][1] = list[j][1];
    }

    return res;
  }

  public static void main(String[] args) {
    int[][] intervals = {{1, 3}, {6, 9}};
    int[] newInterval = {2, 5};
    int[][] updatedInterval = insert(intervals, newInterval);
    System.out.println(Arrays.deepToString(updatedInterval));

    int[][] ints = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
    int[] newints = {4, 8};
    int[][] updsints = insert(ints, newints);
    System.out.println(Arrays.deepToString(updsints));
  }
}
