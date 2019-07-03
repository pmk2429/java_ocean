package intervals;

import hard.Interval;

import java.util.Arrays;
import java.util.Comparator;

public class CanAttendMeetings {

  private boolean overlap(hard.Interval i1, hard.Interval i2) {
    return ((i1.start >= i2.start && i1.start < i2.end) || (i2.start >= i1.start && i2.start < i1.end));
  }

  // method 1
  public boolean canAttend(hard.Interval[] intervals) {
    for (int i = 0; i < intervals.length; i++) {
      for (int j = i + 1; j < intervals.length; j++) {
        if (overlap(intervals[i], intervals[j])) return false;
      }
    }
    return true;
  }

  // method 2
  public boolean canAttendMeetings(hard.Interval[] intervals) {
    Arrays.sort(intervals, new Comparator<hard.Interval>() {
      public int compare(hard.Interval i1, Interval i2) {
        return i1.start - i2.start;
      }
    });

    for (int i = 0; i < intervals.length - 1; i++) {
      if (intervals[i].end > intervals[i + 1].start) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {

  }
}