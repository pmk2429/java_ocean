package arrays.subs;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all
 * unique combinations in candidates where the candidate numbers sums to target.
 * The same repeated number may be chosen from candidates unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * <p>
 * Example 1:
 * ----------
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * [7],
 * [2,2,3]
 * ]
 * <p>
 * Example 2:
 * ----------
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 */
public class SubsetsOfGivenLength {

    private static void combinationUtil(int[] arr, int n, int r, int index, int[] data, int i) {
        // Current combination is ready to be printed, print it
        if (index == r) {
            for (int j = 0; j < r; j++) {
                System.out.print(data[j] + " ");
            }
            System.out.println();
            return;
        }

        // When no more elements are there to put in data[]
        if (i >= n) {
            return;
        }

        // current is included, put next at next location
        data[index] = arr[i];

        // current is excluded, replace it with next
        combinationUtil(arr, n, r, index + 1, data, i + 1);

        // current is excluded, replace it with next (Note that i+1 is passed, but index is not changed)
        combinationUtil(arr, n, r, index, data, i + 1);
    }

    // The main function that prints all combinations of size r
    // in arr[] of size n. This function mainly uses combinationUtil()
    private static void printCombination(int[] arr, int n, int r) {
        // A temporary array to store all combination one by one
        int[] data = new int[r];

        // Print all combination using temporary array 'data[]'
        combinationUtil(arr, n, r, 0, data, 0);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int r = 3;
        int n = arr.length;
        printCombination(arr, n, r);
    }
}
