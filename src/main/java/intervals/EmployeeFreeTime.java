package intervals;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * We are given a list schedule of employees, which represents the working time for each employee.
 * Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.
 * Return the list of finite intervals representing common, positive-length free time for all employees,
 * also in sorted order.
 * (Even though we are representing Intervals in the form [x, y], the objects inside are Intervals, not lists or arrays.
 * For example, schedule[0][0].start = 1, schedule[0][0].end = 2, and schedule[0][0][0] is not defined).
 * Also, we wouldn't include intervals like [5, 5] in our answer, as they have zero length.
 * <p>
 * Example 1:
 * ----------
 * Input: schedule =
 * [
 * [[1,2],[5,6]],
 * [[1,3]],
 * [[4,10]]
 * ]
 * Output: [[3,4]]
 * Explanation: There are a total of three employees, and all common
 * free time intervals would be [-inf, 1], [3, 4], [10, inf].
 * We discard any intervals that contain inf as they aren't finite.
 * <p>
 * Example 2:
 * ----------
 * Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
 * Output: [[5,6],[7,9]]
 * <p>
 * Constraints:
 * ------------
 * 1 <= schedule.length , schedule[i].length <= 50
 * 0 <= schedule[i].start < schedule[i].end <= 10^8
 * <p>
 * ~!@#HARD:REVISE
 */
public class EmployeeFreeTime {

    private static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();

        //Queue<Interval> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.end));
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> (a.start == b.start)
            ? Integer.compare(a.end, b.end)
            : Integer.compare(a.start, b.start));

        schedule.forEach(pq::addAll);

        Interval currentInterval = pq.poll();
        while (!pq.isEmpty()) {
            if (currentInterval != null) {
                if (pq.peek().start > currentInterval.end) { // no intersect
                    result.add(new Interval(currentInterval.end, pq.peek().start));
                    currentInterval = pq.poll(); // becomes the next temp interval
                }
                else { // intersecting interval so merge them with end being updated to the max of those two intervals
                    currentInterval = pq.peek().end > currentInterval.end ? pq.peek() : currentInterval;
                    pq.poll();
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Interval>> schedule = new ArrayList<>() {{
            add(List.of(new Interval(1, 2), new Interval(5, 6)));
            add(List.of(new Interval(1, 3)));
            add(List.of(new Interval(4, 10)));
        }};
        List<Interval> freeTime = employeeFreeTime(schedule);
        freeTime.forEach(interval -> System.out.println(interval.start + " -> " + interval.end));
        List<List<Interval>> employeeSchedule = new ArrayList<>() {{
            add(List.of(new Interval(1, 3), new Interval(6, 7)));
            add(List.of(new Interval(2, 4)));
            add(List.of(new Interval(2, 5), new Interval(9, 12)));
        }};
        List<Interval> freeTime2 = employeeFreeTime(employeeSchedule);
        freeTime2.forEach(interval -> System.out.println(interval.start + " -> " + interval.end));
    }
}
