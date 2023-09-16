package binarysearch;

import java.util.Arrays;

/**
 * A conveyor belt has packages that must be shipped from one port to another within days.
 * The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the
 * conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of
 * the ship.
 * Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being
 * shipped within days days.
 * <p>
 * Example 1:
 * ----------
 * Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
 * Output: 15
 * Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
 * 1st day: 1, 2, 3, 4, 5
 * 2nd day: 6, 7
 * 3rd day: 8
 * 4th day: 9
 * 5th day: 10
 * Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages
 * into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
 * <p>
 * Example 2:
 * ----------
 * Input: weights = [3,2,2,4,1,4], days = 3
 * Output: 6
 * Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
 * 1st day: 3, 2
 * 2nd day: 2, 4
 * 3rd day: 1, 4
 * <p>
 * Example 3:
 * ----------
 * Input: weights = [1,2,3,1,1], days = 4
 * Output: 3
 * Explanation:
 * 1st day: 1
 * 2nd day: 2
 * 3rd day: 3
 * 4th day: 1, 1
 * <p>
 * Constraints:
 * ------------
 * 1 <= days <= weights.length <= 5 * 104
 * 1 <= weights[i] <= 500
 * <p>
 * Similar to {@link MinimumTimeToCompleteTrips}
 */
public class CapacityToShipPackagesWithinDDays {

    // Check whether the packages can be shipped in less than "days" days with
    // "c" capacity.
    private static boolean feasible(int[] weights, int givenWeight, int days) {
        int daysNeeded = 1, currentLoad = 0;
        for (int weight : weights) {
            currentLoad += weight;
            if (currentLoad > givenWeight) {
                daysNeeded++;
                currentLoad = weight;
            }
        }

        return daysNeeded <= days;
    }

    /**
     * Based on the intuition, it's obvious that the load capacity would be somewhere in the range of
     * MAX_WEIGHT <= TOTAL_WEIGHT so using the binary search problem, we can set our bounds accordingly.
     */
    private static int shipWithinDays(int[] weights, int days) {
        int maxLoad, l = Arrays.stream(weights).max().getAsInt();
        int totalLoad, r = Arrays.stream(weights).sum();

        while (l < r) {
            int mid = (l + r) / 2;
            if (feasible(weights, mid, days)) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        System.out.println(shipWithinDays(weights, days));
        int[] weights2 = {3, 2, 2, 4, 1, 4};
        int days2 = 3;
        System.out.println(shipWithinDays(weights2, days2));
    }
}
