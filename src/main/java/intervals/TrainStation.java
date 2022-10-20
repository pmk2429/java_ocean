package intervals;

import java.util.Arrays;

/**
 * Given a schedule containing the arrival and departure time of trains in a station, find the minimum number of
 * platforms needed to avoid delay in any train’s arrival.
 * <p>
 * Example 1:
 * ----------
 * Trains arrival   = { 2.00, 2.10, 3.00, 3.20, 3.50, 5.00 }
 * Trains departure = { 2.30, 3.40, 3.20, 4.30, 4.00, 5.20 }
 * <p>
 * The minimum platforms needed is 2
 * <p>
 * The train arrived at 2.00 on platform 1
 * The train arrived at 2.10 on platform 2
 * The train departed at 2.30 from platform 1
 * The train arrived at 3.00 on platform 1
 * The train departed at 3.20 from platform 1
 * The train arrived at 3.20 on platform 1
 * The train departed at 3.40 from platform 2
 * The train arrived at 3.50 on platform 2
 * The train departed at 4.00 from platform 2
 * The train departed at 4.30 from platform 1
 * The train arrived at 5.00 on platform 1
 * The train departed at 5.20 from platform 1
 */
public class TrainStation {
    public static int findMinPlatforms(double[] arrival, double[] departure) {
        // sort arrival time of trains
        Arrays.sort(arrival);

        // sort departure time of trains
        Arrays.sort(departure);

        // maintains the count of trains
        int count = 0;

        // stores minimum platforms needed
        int platforms = 0;

        // take two indices for arrival and departure time
        int i = 0, j = 0;

        // run till all trains have arrived
        while (i < arrival.length) {
            // if a train is scheduled to arrive next
            if (arrival[i] < departure[j]) {
                // increase the count of trains and update minimum
                // platforms if required
                platforms = Integer.max(platforms, ++count);

                // move the pointer to the next arrival
                i++;
            }

            // if the train is scheduled to depart next i.e.
            // `departure[j] < arrival[i]`, decrease trains' count
            // and move pointer `j` to the next departure.

            // If two trains are arriving and departing simultaneously,
            // i.e., `arrival[i] == departure[j]`, depart the train first
            else {
                count--;
                j++;
            }
        }

        return platforms;
    }

    public static void main(String[] args) {
        double[] arrival = {2.00, 2.10, 3.00, 3.20, 3.50, 5.00};
        double[] departure = {2.30, 3.40, 3.20, 4.30, 4.00, 5.20};

        System.out.print("The minimum platforms needed is "
            + findMinPlatforms(arrival, departure));
    }
}
