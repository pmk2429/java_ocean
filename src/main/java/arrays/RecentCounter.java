package arrays;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Write a class RecentCounter to count recent requests.
 * It has only one method: ping(int t), where t represents some time in milliseconds.
 * Return the number of pings that have been made from 3000 milliseconds ago until now.
 * Any ping with time in [t - 3000, t] will count, including the current ping.
 * It is guaranteed that every call to ping uses a strictly larger value of t than before.
 * <p>
 * Example 1:
 * ----------
 * Input: inputs = ["RecentCounter","ping","ping","ping","ping"], inputs = [[],[1],[100],[3001],[3002]]
 * Output: [null,1,2,3,3]
 * <p>
 * Note:
 * -----
 * Each test case will have at most 10000 calls to ping.
 * Each test case will call ping with strictly increasing values of t.
 * Each call to ping will have 1 <= t <= 10^9.
 * <p>
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
class RecentCounter {

    private final Deque<Integer> slidingWindow;

    public RecentCounter() {
        slidingWindow = new ArrayDeque<>();
        // can also use LinkedList
        // slidingWindow = new LinkedList<>();
    }

    public int ping(int t) {
        // step 1). append the current call
        slidingWindow.offer(t);

        // step 2). invalidate the outdated pings -- keep sliding the window
        while (slidingWindow.getFirst() < t - 3000) {
            slidingWindow.removeFirst();
        }

        return slidingWindow.size();
    }

    public static void main(String[] args) {
        RecentCounter obj = new RecentCounter();
        int param1 = obj.ping(1);
        System.out.println(param1);
        int param2 = obj.ping(100);
        System.out.println(param2);
        int param3 = obj.ping(3001);
        System.out.println(param3);
        int param4 = obj.ping(3002);
        System.out.println(param4);
    }
}

