package hard;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * A car travels from a starting position to a destination which is target miles east of the starting position.
 * There are gas stations along the way. The gas stations are represented as an array stations where stations[i] =
 * [position i, fuel i] indicates that the ith gas station is position i miles east of the starting position and has
 * fuel i liters of gas.
 * The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it.
 * It uses one liter of gas per one mile that it drives. When the car reaches a gas station, it may stop and refuel,
 * transferring all the gas from the station into the car.
 * Return the minimum number of refueling stops the car must make in order to reach its destination.
 * If it cannot reach the destination, return -1.
 * Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there.
 * If the car reaches the destination with 0 fuel left, it is still considered to have arrived.
 * <p>
 * Example 1:
 * ----------
 * Input: target = 1, startFuel = 1, stations = []
 * Output: 0
 * Explanation: We can reach the target without refueling.
 * <p>
 * Example 2:
 * ----------
 * Input: target = 100, startFuel = 1, stations = [[10,100]]
 * Output: -1
 * Explanation: We can not reach the target (or even the first gas station).
 * <p>
 * Example 3:
 * ----------
 * Input: target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
 * Output: 2
 * Explanation: We start with 10 liters of fuel.
 * We drive to position 10, expending 10 liters of fuel.  We refuel from 0 liters to 60 liters of gas.
 * Then, we drive from position 10 to position 60 (expending 50 liters of fuel),
 * and refuel from 10 liters to 50 liters of gas.  We then drive to and reach the target.
 * We made 2 refueling stops along the way, so we return 2.
 */
public class MinimumNumberOfRefuelingStops {

    private static int minRefuelStops(int target, int tank, int[][] stations) {
        // pq is a maxheap of gas station capacities
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int ans = 0, prevGasLocation = 0;
        for (int[] station : stations) {
            int gasLocation = station[0];
            int gasCapacity = station[1];

            tank -= gasLocation - prevGasLocation;
            while (!pq.isEmpty() && tank < 0) {
                tank += pq.poll();
                ans++;
            }
            if (tank < 0) {
                return -1;
            }
            pq.offer(gasCapacity);
            prevGasLocation = gasLocation;
        }

        // Repeat body for last station = (target, inf)
        tank -= target - prevGasLocation;
        while (!pq.isEmpty() && tank < 0) {
            tank += pq.poll();
            ans++;
        }
        if (tank < 0) {
            return -1;
        }

        return ans;
    }

    public static void main(String[] args) {
        int target = 100, tank = 1;
        int[][] stations = {{10, 100}};
        System.out.println(minRefuelStops(target, tank, stations));
        int target2 = 100, tank2 = 10;
        int[][] stations2 = {{10, 60}, {20, 30}, {30, 30}, {60, 40}};
        System.out.println(minRefuelStops(target2, tank2, stations2));
    }
}
