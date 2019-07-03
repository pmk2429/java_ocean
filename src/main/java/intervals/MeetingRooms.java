package intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.
 * <p>
 * Example 1:
 * ---------
 * Input: [[0, 30], [5, 10], [15, 20]]
 * Output: 2
 * <p>
 * Example 2:
 * ---------
 * Input: [[7,10], [2,4]]
 * Output: 1
 * <p>
 * Algorithm
 * ---------
 * Sort the given meetings by their start time.
 * Initialize a new min-heap and add the first meeting's ending time to the heap. We simply need to keep track of
 * the ending times as that tells us when a meeting room will get free.
 * For every meeting room check if the minimum element of the heap i.e. the room at the top of the heap is free or not.
 * If the room is free, then we extract the topmost element and add it back with the ending time of the current
 * meeting we are processing.
 * If not, then we allocate a new room and add it to the heap.
 * After processing all the meetings, the size of the heap will tell us the number of rooms allocated.
 * This will be the minimum number of rooms needed to accommodate all the meetings.
 */
public class MeetingRooms {

  /**
   * Definition for an interval. public class Interval { int start; int end; Interval() { start = 0;
   * end = 0; } Interval(int s, int e) { start = s; end = e; } }
   */
  public int minMeetingRooms(Interval[] intervals) {

    // Check for the base case. If there are no intervals, return 0
    if (intervals.length == 0) {
      return 0;
    }

    // Min heap
    PriorityQueue<Integer> scheduler = new PriorityQueue<>(
        intervals.length,
        new Comparator<Integer>() {
          public int compare(Integer a, Integer b) {
            return a - b;
          }
        });

    // Sort the intervals by start time
    Arrays.sort(intervals,
        new Comparator<Interval>() {
          public int compare(Interval a, Interval b) {
            return a.start - b.start;
          }
        });

    // Add the first meeting
    scheduler.add(intervals[0].end);

    // Iterate over remaining intervals
    for (int i = 1; i < intervals.length; i++) {
      // If the room due to free up the earliest is free, assign that room to this meeting
      if (intervals[i].start >= scheduler.peek()) {
        scheduler.poll();
      }

      // If a new room is to be assigned, then also we add to the heap,
      // If an old room is allocated, then also we have to add to the heap with updated end time.
      scheduler.add(intervals[i].end);
    }

    // The size of the heap tells us the minimum rooms required for all the meetings.
    return scheduler.size();
  }

  public static void main(String[] args) {

  }
}

