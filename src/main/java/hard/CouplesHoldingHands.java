package hard;

import java.util.HashMap;
import java.util.Map;

/**
 * There are n couples sitting in 2n seats arranged in a row and want to hold hands.
 * The people and seats are represented by an integer array row where row[i] is the ID of the person sitting
 * in the ith seat. The couples are numbered in order, the first couple being (0, 1),
 * the second couple being (2, 3), and so on with the last couple being (2n - 2, 2n - 1).
 * <p>
 * Return the minimum number of swaps so that every couple is sitting side by side.
 * A swap consists of choosing any two people, then they stand up and switch seats.
 * <p>
 * Example 1:
 * ==========
 * Input: row = [0,2,1,3]
 * Output: 1
 * Explanation: We only need to swap the second (row[1]) and third (row[2]) person.
 * <p>
 * Example 2:
 * ==========
 * Input: row = [3,2,0,1]
 * Output: 0
 * Explanation: All couples are already seated side by side.
 * <p>
 * Constraints:
 * ==========
 * 2n == row.length
 * 2 <= n <= 30
 * n is even.
 * 0 <= row[i] < 2n
 * All the elements of row are unique.
 */
public class CouplesHoldingHands {
    private static int minSwapsCouples(int[] row) {
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        int res = 0;
        while (index < row.length) {
            map.put(row[index], row[index + 1]);
            map.put(row[index + 1], row[index]);
            index = index + 2;
        }
        index = 0;
        while (index < row.length) {
            if (map.get(index) != index + 1) {
                int nextvalue = map.get(index + 1);
                int currentvalue = map.get(index);
                map.put(index, index + 1);
                map.put(currentvalue, nextvalue);
                map.put(nextvalue, currentvalue);
                res++;
            }
            index = index + 2;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] row = {0, 2, 1, 3};
        System.out.println(minSwapsCouples(row));
    }
}
