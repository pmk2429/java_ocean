package intervals;

import java.util.*;

/**
 * For example:
 * A: [1,5], [10,14], [16,18]
 * B: [2,6], [8,10], [11,20]
 * <p>
 * output [1,6], [8, 20]
 */
public class MergeIntervalsSeparateLists {

    private static final Comparator<Interval> intervalComparator = Comparator.comparingInt(i -> i.start);

    private static List<Interval> merge(List<Interval> list1, List<Interval> list2) {
        list1.addAll(list2);

        list1.sort(intervalComparator);

        Deque<Interval> merged = new ArrayDeque<>();
        for (Interval interval : list1) {
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

    public static void main(String[] args) {
        List<Interval> list1 = new ArrayList<>() {{
            add(new Interval(1, 5));
            add(new Interval(10, 14));
            add(new Interval(16, 18));
        }};
        List<Interval> list2 = new ArrayList<>() {{
            add(new Interval(2, 6));
            add(new Interval(8, 10));
            add(new Interval(11, 20));
        }};
        List<Interval> merged = merge(list1, list2);
        System.out.println(merged);
    }

}
