package intervals;

import java.util.*;

public class MergeIntervals {

    /**
     * In merging intervals or inserting new intervals, the idea is always the same:
     * - Sort the intervals by start time
     * - Update the end of the latest inserted interval
     * - The updating end is the part of merging intervals if there's an overlap.
     */
    private static final Comparator<Interval> intervalComparator = Comparator.comparingInt(i -> i.start);

    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort(intervalComparator);
        Deque<Interval> merged = new ArrayDeque<>();
        for (Interval interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || interval.start >= merged.getLast().end) {
                merged.add(interval);
            }
            else { // otherwise, there is overlap, so we merge the current and previous intervals.
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }

        return new ArrayList<>(merged);
    }
}