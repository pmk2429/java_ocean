package intervals;

/**
 * Given on-call rotation schedule for multiple people by: their name, start time and end time of the rotation:
 * <p>
 * Input:
 * Abby,1 10
 * Ben, 5, 7
 * Carla 6, 12,
 * David 15, 17
 * <p>
 * Your goal is to return rotation table without overlapping periods representing who is on call during that time.
 * Return "Start time", "End time" and list of on-call people:
 * <p>
 * Output:
 * 1 5 Abby
 * 5 6 Abby, Ben
 * 6 7 Abby, Ben, Carla
 * 7 10 Abby, Carla
 * 10 12 Carla
 * 15 17 David
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class EmployeeInterval {
    int start;
    int end;
    String person;

    EmployeeInterval(int start, int end, String person) {
        this.start = start;
        this.end = end;
        this.person = person;
    }
}

public class OnCallRotation {
    public static List<EmployeeInterval> generateRotationTable(List<EmployeeInterval> intervals) {
        List<EmployeeInterval> rotationTable = new ArrayList<>();
        PriorityQueue<EmployeeInterval> scheduler = new PriorityQueue<>(Comparator.comparingInt(interval -> interval.start));

        for (EmployeeInterval interval : intervals) {
            while (!scheduler.isEmpty() && interval.start >= scheduler.peek().end) {
                scheduler.poll();
            }

            scheduler.offer(interval);

            int prevEnd = interval.start;
            for (EmployeeInterval activeInterval : scheduler) {
                rotationTable.add(new EmployeeInterval(prevEnd, activeInterval.start, activeInterval.person));
                prevEnd = activeInterval.end;
            }
        }

        return rotationTable;
    }

    public static void main(String[] args) {
        List<EmployeeInterval> intervals = new ArrayList<>();
        intervals.add(new EmployeeInterval(1, 10, "Abby"));
        intervals.add(new EmployeeInterval(5, 7, "Ben"));
        intervals.add(new EmployeeInterval(6, 12, "Carla"));
        intervals.add(new EmployeeInterval(15, 17, "David"));

        List<EmployeeInterval> rotationTable = generateRotationTable(intervals);

        for (EmployeeInterval interval : rotationTable) {
            System.out.println(interval.start + " " + interval.end + " " + interval.person);
        }
    }
}

