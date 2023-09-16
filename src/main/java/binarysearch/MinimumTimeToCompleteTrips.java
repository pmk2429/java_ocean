package binarysearch;

import binarysearch.CapacityToShipPackagesWithinDDays;

import java.util.Arrays;

/**
 * You are given an array time where time[i] denotes the time taken by the ith bus to complete one trip.
 * Each bus can make multiple trips successively; that is, the next trip can start immediately after completing the
 * current trip. Also, each bus operates independently; that is, the trips of one bus do not influence the trips
 * of any other bus.
 * You are also given an integer totalTrips, which denotes the number of trips all buses should make in total.
 * Return the minimum time required for all buses to complete at least totalTrips trips.
 * <p>
 * Example 1:
 * ----------
 * Input: time = [1,2,3], totalTrips = 5
 * Output: 3
 * Explanation:
 * - At time t = 1, the number of trips completed by each bus are [1,0,0].
 * The total number of trips completed is 1 + 0 + 0 = 1.
 * - At time t = 2, the number of trips completed by each bus are [2,1,0].
 * The total number of trips completed is 2 + 1 + 0 = 3.
 * - At time t = 3, the number of trips completed by each bus are [3,1,1].
 * The total number of trips completed is 3 + 1 + 1 = 5.
 * So the minimum time needed for all buses to complete at least 5 trips is 3.
 * <p>
 * Example 2:
 * ----------
 * Input: time = [2], totalTrips = 1
 * Output: 2
 * Explanation:
 * There is only one bus, and it will complete its first trip at t = 2.
 * So the minimum time needed to complete 1 trip is 2.
 * <p>
 * Constraints:
 * ----------
 * 1 <= time.length <= 105
 * 1 <= time[i], totalTrips <= 107
 * <p>
 * Similar to {@link CapacityToShipPackagesWithinDDays}
 */
public class MinimumTimeToCompleteTrips {

    /**
     * For givenTime T, first bus takes givenTime/T to complete a trip.
     * So for givenTime = 3, and for total times = 3,
     * Trips by Bus 1 = 3 / 1 = 3
     * Trips by Bus 2 = 3 / 2 = 1
     * Trips by Bus 3 = 3 / 3 = 1
     * Sum of all trips for givenTime = 3 : 3 + 1 + 1 = 5
     */
    private static boolean timeEnough(int[] time, long givenTime, int totalTrips) {
        long actualTrips = 0;
        for (int t : time)
            actualTrips += givenTime / t;
        return actualTrips >= totalTrips;
    }

    /**
     * Binary Search to reduce the problem space of finding the time.
     */
    private static long minimumTime(int[] time, int totalTrips) {
        // Initialize the left and right boundaries.
        int maxTime = Arrays.stream(time).max().getAsInt();
        int minTime = Arrays.stream(time).min().getAsInt();
        long left = 1;
        long right = (long) minTime * totalTrips;

        // Binary search to find the minimum time to finish the task.
        while (left < right) {
            long mid = (left + right) / 2;
            if (timeEnough(time, mid, totalTrips)) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] time = {1, 2, 3};
        int totalTrips = 5;
        System.out.println(minimumTime(time, totalTrips));
    }
}
