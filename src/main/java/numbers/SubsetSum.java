package numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavitra on 4/22/2016.
 */
public class SubsetSum {

    private static boolean subsetSum(int[] A, int k) {
        int n = A.length;

        // `T[i][j]` stores true if subset with sum `j` can be attained
        // using items up to first `i` items
        boolean[][] T = new boolean[n + 1][k + 1];

        // if the sum is zero
        for (int i = 0; i <= n; i++) {
            T[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                // don't include the i'th element if `j-A[i-1]` is negative
                if (A[i - 1] > j) {
                    T[i][j] = T[i - 1][j];
                }
                else {
                    // find the subset with sum `j` by excluding or including the i'th item
                    T[i][j] = T[i - 1][j] || T[i - 1][j - A[i - 1]];
                }
            }
        }

        // return maximum value
        return T[n][k];
    }

    private static boolean findSubsetSum(int[] numbers, int index, ArrayList<Integer> subset, int sum) {
        if (index >= numbers.length) {
            return false;
        }

        if (sum - numbers[index] == 0) {
            subset.add(numbers[index]);
            return true;
        }

        if (sum - numbers[index] < 0) {
            return false;
        }

        sum -= numbers[index];
        for (int i = index + 1; i < numbers.length; i++) {
            if (findSubsetSum(numbers, i, subset, sum)) {
                subset.add(numbers[index]);
                return true;
            }
        }

        return false;
    }

    public static List<Integer> findSubsetSum(int[] numbers, int sum) {
        ArrayList<Integer> subset = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if (findSubsetSum(numbers, i, subset, sum)) {
                return subset;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] values = {2, 3, 4, 5, 6, 7, 8};
        System.out.println(findSubsetSum(values, 15));
    }
}
