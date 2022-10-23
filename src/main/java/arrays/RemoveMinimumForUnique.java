package arrays;

import java.util.HashMap;

/**
 * Remove minimum number of elements such that no common element exist in both array
 * <p>
 * Given two arrays A[] and B[] consisting of n and m elements respectively.
 * Find minimum number of elements to remove from each array such that no common element exist in both.
 * <p>
 * Examples:
 * ---------
 * Input :
 * A[] = { 1, 2, 3, 4 }
 * B[] = { 2, 3, 4, 5, 8 }
 * Output :
 * 3
 * We need to remove 2, 3 and 4 from any array.
 * <p>
 * Input :
 * A[] = { 4, 2, 4, 4}
 * B[] = { 4, 3 }
 * Output :
 * 1
 * We need to remove 4 from from B[]
 * <p>
 * Input : A[] = { 1, 2, 3, 4 }
 * B[] = { 5, 6, 7 }
 * Output :
 * 0
 * There is no common element in both.
 */
public class RemoveMinimumForUnique {

    private static int minRemove(int[] a, int[] b, int n, int m) {
        HashMap<Integer, Integer> countA = new HashMap<>();
        HashMap<Integer, Integer> countB = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int temp = a[i];
            countA.put(temp, countA.getOrDefault(temp, 0) + 1);
        }

        for (int i = 0; i < m; i++) {
            int temp = b[i];
            countB.put(temp, countB.getOrDefault(temp, 0) + 1);
        }

        int res = 0;
        for (Integer x : countA.keySet()) {
            if (countB.containsKey(x)) {
                res += Math.min(countA.get(x), countB.get(x));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = {2, 3, 4, 5, 8, 4, 8, 7, 9, 3, 4};
        int n = a.length;
        int m = b.length;

        System.out.println(minRemove(a, b, n, m));
    }
}
