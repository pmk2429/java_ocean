package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given a char array representing tasks CPU needs to do. It contains capital letters A to Z where different letters
 * represent different tasks. Tasks could be done without original order. Each task could be done in one interval.
 * For each interval, CPU could finish one task or just be idle.
 * <p>
 * However, there is a non-negative cooling interval n that means between two same tasks, there must be at least
 * n intervals that CPU is doing different tasks or just be idle.
 * <p>
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 * <p>
 * Example:
 * --------
 * Input: tasks = ['A','A','A','B','B','B'], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 * <p>
 * Note:
 * -----
 * The number of tasks is in the range [1, 10000].
 * The integer n is in the range [0, 100].
 */
public class TasksScheduler {

    private static int leastIntervals(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks) {
            map[c - 'A']++;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(26, Collections.reverseOrder());

        for (int f : map) {
            if (f > 0) {
                queue.offer(f);
            }
        }

        int time = 0;

        while (!queue.isEmpty()) {
            int i = 0;
            List<Integer> temp = new ArrayList<>();
            while (i <= n) {
                if (!queue.isEmpty()) {
                    if (queue.peek() > 1) {
                        temp.add(queue.poll() - 1);
                    }
                    else {
                        queue.poll();
                    }
                }
                time++;
                if (queue.isEmpty() && temp.size() == 0) {
                    break;
                }
                i++;
            }
            queue.addAll(temp);
        }
        return time;
    }

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(leastIntervals(tasks, n));
    }
}
