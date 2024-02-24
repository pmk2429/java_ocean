package slidingWindow;

import java.util.Arrays;

/**
 * Maximum Bags With Full Capacity of Rocks
 * You have n bags numbered from 0 to n - 1. You are given two 0-indexed integer arrays capacity and rocks.
 * The ith bag can hold a maximum of capacity[i] rocks and currently contains rocks[i] rocks. You are also given an
 * integer additionalRocks, the number of additional rocks you can place in any of the bags.
 * <p>
 * Return the maximum number of bags that could have full capacity after placing the additional rocks in some bags.
 * <p>
 * Example 1:
 * ----------
 * Input: capacity = [2,3,4,5], rocks = [1,2,4,4], additionalRocks = 2
 * Output: 3
 * Explanation:
 * Place 1 rock in bag 0 and 1 rock in bag 1.
 * The number of rocks in each bag are now [2,3,4,4].
 * Bags 0, 1, and 2 have full capacity.
 * There are 3 bags at full capacity, so we return 3.
 * It can be shown that it is not possible to have more than 3 bags at full capacity.
 * Note that there may be other ways of placing the rocks that result in an answer of 3.
 * <p>
 * Example 2:
 * ----------
 * Input: capacity = [10,2,2], rocks = [2,2,0], additionalRocks = 100
 * Output: 3
 * Explanation:
 * Place 8 rocks in bag 0 and 2 rocks in bag 2.
 * The number of rocks in each bag are now [10,2,2].
 * Bags 0, 1, and 2 have full capacity.
 * There are 3 bags at full capacity, so we return 3.
 * It can be shown that it is not possible to have more than 3 bags at full capacity.
 * Note that we did not use all the additional rocks.
 * <p>
 * Constraints:
 * ----------
 * n == capacity.length == rocks.length
 * 1 <= n <= 5 * 104
 * 1 <= capacity[i] <= 109
 * 0 <= rocks[i] <= capacity[i]
 * 1 <= additionalRocks <= 109
 * <p>
 * ~!@#HARD:REVISE
 */
public class RocksInBags {
    private static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length, fullBags = 0;

        int[] remainingCapacity = new int[n];
        for (int i = 0; i < n; i++) {
            remainingCapacity[i] = capacity[i] - rocks[i];
        }

        // because we want to fill the bags with the least remaining capacity first
        Arrays.sort(remainingCapacity);

        // Iterate over sorted bags and fill them using additional rocks.
        for (int i = 0; i < n; i++) {
            // If we can fill the current one, fill it and move on. Otherwise, stop the iteration.
            if (additionalRocks >= remainingCapacity[i]) {
                additionalRocks -= remainingCapacity[i];
                fullBags++; // one bag is filled so increment counter
            }
            else {
                break;
            }
        }

        return fullBags;
    }

    public static void main(String[] args) {
        int[] capacity = {2, 3, 4, 5};
        int[] rocks = {1, 2, 4, 4};
        int additionalRocks = 2;
        System.out.println(maximumBags(capacity, rocks, additionalRocks));

        int[] capacity2 = {10, 2, 2};
        int[] rocks2 = {2, 2, 0};
        int additionalRocks2 = 100;
        System.out.println(maximumBags(capacity2, rocks2, additionalRocks2));
    }
}
