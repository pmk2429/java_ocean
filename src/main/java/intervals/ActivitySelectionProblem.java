package intervals;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <b>Activity Selection Problem:</b>
 * <p>
 * Given a set of activities, along with the starting and finishing time of each activity,
 * find the maximum number of activities performed by a single person assuming that a person can only work on a
 * single activity at a time.
 * <p>
 * For example:
 * ------------
 * Input: Following set of activities
 * (1, 4), (3, 5), (0, 6), (5, 7), (3, 8), (5, 9), (6, 10), (8, 11), (8, 12), (2, 13), (12, 14)
 * Output:
 * (1, 4), (5, 7), (8, 11), (12, 14)
 */
public class ActivitySelectionProblem {

    private static final Comparator<Pair> pairComparator = Comparator.comparingInt(Pair::getFinish);

    public static List<Pair> selectActivity(List<Pair> activities) {
        // keeps track of the index of the last selected activity
        int lastSelectedActivity = 0;

        // set to store the selected activities index
        Set<Integer> result = new HashSet<>();

        activities.sort(pairComparator);

        // select 0 as the first activity
        if (activities.size() > 0) {
            result.add(0);
        }

        // start iterating from the second element of the list up to its last element
        for (int i = 1; i < activities.size(); i++) {
            // if the start time of the i'th activity is greater or equal
            // to the finish time of the last selected activity, it
            // can be included in the activities list
            if (activities.get(i).getStart() >= activities.get(lastSelectedActivity).getFinish()) {
                result.add(i);
                lastSelectedActivity = i;
            }
        }

        // Get all Activity `Pair`s mapping to the stored indices in `result`.
        return result.stream().map(activities::get).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Pair> activities = Arrays.asList(
            new Pair(1, 4),
            new Pair(3, 5),
            new Pair(0, 6),
            new Pair(5, 7),
            new Pair(3, 8),
            new Pair(5, 9),
            new Pair(6, 10),
            new Pair(8, 11),
            new Pair(8, 12),
            new Pair(2, 13),
            new Pair(12, 14)
        );

        List<Pair> result = selectActivity(activities);
        System.out.println(result);
    }
}

