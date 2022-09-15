package intervals;

import java.util.*;

public class MergeIntervals {

    private static class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return Integer.compare(a.start, b.start);
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort(new IntervalComparator());
        Deque<Interval> merged = new ArrayDeque<>();
        for (Interval interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || interval.start > merged.getLast().end) {
                merged.add(interval);
            }
            else { // otherwise, there is overlap, so we merge the current and previous intervals.
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }

        return new ArrayList<>(merged);
    }
}