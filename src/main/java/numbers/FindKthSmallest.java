package numbers;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindKthSmallest {

    // Uses PriorityQueue
    private static int kthSmallestUsingHeap(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(k, Collections.reverseOrder());
        for (int i : nums) {
            q.offer(i);
            if (q.size() > k) {
                q.poll();
            }
        }

        return q.peek();
    }

    public static void main(String[] args) {
        int[] a = {5, 4, 1, 8, 5, 7, 9};
        System.out.println("# " + kthSmallestUsingHeap(a, 3));
    }
}
