package hard;

import java.util.*;

public class EmployeeFreeTime {

  private static final Comparator<Time> timeComparator = (t1, t2) -> {
    if (t1.start == t2.start) {
      return t1.end - t2.end;
    }
    return t1.start - t2.start;
  };

  private static List<Time> findFreeTime(List<List<Time>> times, int dayStart, int dayEnd) {
    List<Time> availableTimes = new ArrayList<>();

    if (times == null) {
      return null;
    }

    Queue<Time> pq = new PriorityQueue<>(times.size(), timeComparator);

    for (List<Time> timeSlots : times) {
      for (Time t : timeSlots) {
        pq.offer(t);
      }
    }

    while (!pq.isEmpty()) {
      System.out.println(pq.peek().name);
    }

    return availableTimes;
  }

  public static void main(String[] args) {
    List<Time> employee1 = new ArrayList<>();
    employee1.add(new Time("A", 10, 11));
    employee1.add(new Time("B", 15, 16));
    employee1.add(new Time("C", 10, 12));

    List<Time> employee2 = new ArrayList<>();
    employee2.add(new Time("D", 13, 14));
    employee2.add(new Time("E", 15, 17));

    List<List<Time>> times = new ArrayList<>();
    times.add(employee1);
    times.add(employee2);

    int dayStart = 9;
    int dayEnd = 19;

    findFreeTime(times, dayStart, dayEnd);
  }
}

class Time {
  String name;
  int start;
  int end;

  public Time(String name, int start, int end) {
    this.name = name;
    this.start = start;
    this.end = end;
  }
}
