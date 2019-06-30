package hard;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {

  private class IntervalComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval a, Interval b) {
      return Integer.compare(a.start, b.start);
    }
  }

  public List<Interval> merge(List<Interval> intervals) {
    intervals.sort(new IntervalComparator());

    LinkedList<Interval> merged = new LinkedList<>();
    for (Interval interval : intervals) {
      // if the list of merged intervals is empty or if the current
      // interval does not overlap with the previous, simply append it.
      if (merged.isEmpty() || merged.getLast().end < interval.start) {
        merged.add(interval);
      }

      // otherwise, there is overlap, so we merge the current and previous intervals.
      else {
        merged.getLast().end = Math.max(merged.getLast().end, interval.end);
      }
    }

    return merged;
  }
}

class Interval {
  int start;
  int end;
}
