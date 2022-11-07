package hard;

import java.util.Arrays;
import java.util.Comparator;

/**
 * N cars are going to the same destination along a one lane road. The destination is target miles away.
 * <p>
 * Each car i has a constant speed[i] (in miles per hour), and initial position[i] miles towards the
 * target along the road. A car can never pass another car ahead of it, but it can catch up to it, and drive bumper
 * to bumper at the same speed. The distance between these two cars is ignored - they are assumed to have the same
 * position. A car fleet is some non-empty set of cars driving at the same position and same speed. Note that a
 * single car is also a car fleet. If a car catches up to a car fleet right at the destination point, it will still
 * be considered as one car fleet.
 * <p>
 * How many car fleets will arrive at the destination?
 * <p>
 * Example 1:
 * ----------
 * Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
 * Output: 3
 * Explanation:
 * The cars starting at 10 and 8 become a fleet, meeting each other at 12.
 * The car starting at 0 doesn't catch up to any other car, so it is a fleet by itself.
 * The cars starting at 5 and 3 become a fleet, meeting each other at 6.
 * Note that no other cars meet these fleets before the destination, so the answer is 3.
 * <p>
 * Note:
 * -----
 * 0 <= N <= 10 ^ 4
 * 0 < target <= 10 ^ 6
 * 0 < speed[i] <= 10 ^ 6
 * 0 <= position[i] < target
 * All initial positions are different.
 *
 * ~!@#HARD:REVISE
 */
public class CarFleet {
    private static int carFleet(int target, int[] position, int[] speed) {
        int N = position.length; // total number of cars

        if (N <= 0) {
            return -1;
        }

        Car[] cars = new Car[N];
        for (int i = 0; i < N; i++) {
            cars[i] = new Car(position[i], (double) (target - position[i]) / speed[i]);
        }
        Arrays.sort(cars, Comparator.comparingInt(a -> a .position));

        int ans = 0, t = N;
        while (--t > 0) {
            if (cars[t].time < cars[t - 1].time) {
                ans++; // if cars[t] arrives sooner, it can't be caught
            }
            else {
                cars[t - 1] = cars[t]; // else, cars[t-1] arrives at same time as cars[t] and so they are one fleet
            }
        }

        return ans + (t == 0 ? 1 : 0); //lone car is fleet (if it exists)
    }

    public static void main(String[] args) {
        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};

        System.out.println(carFleet(target, position, speed));
    }
}

class Car {
    int position;
    double time;

    Car(int p, double t) {
        position = p;
        time = t;
    }
}
