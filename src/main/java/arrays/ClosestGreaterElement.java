package arrays;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Find closest greater value for every element in array
 * Given an array of integers, find the closest greater element for every element. If there is no greater element then print -1
 * <p>
 * Examples:
 * ---------
 * Input : arr[] = {10, 5, 11, 6, 20, 12}
 * Output : 11 6 12 10 -1 20
 * <p>
 * Input : arr[] = {10, 5, 11, 10, 20, 12}
 * Output : 11 10 12 11 -1 20
 */
public class ClosestGreaterElement {

    /**
     * An efficient solution is to use Self Balancing BST.
     * In a Self Balancing BST, we can do both insert and closest greater operations in O(Log n) time.
     */
    private static int[] closestGreater(int[] arr) {
        int[] ans = new int[arr.length];
        // Insert all array elements into a TreeSet
        TreeSet<Integer> selfBalancingTree = new TreeSet<>();
        for (int j : arr) {
            selfBalancingTree.add(j);
        }

        // Find smallest greater element for every array element
        for (int i = 0; i < arr.length; i++) {
            Integer greater = selfBalancingTree.higher(arr[i]);
            ans[i] = greater == null ? -1 : greater;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 11, 6, 20, 12};
        System.out.println(Arrays.toString(closestGreater(arr)));
    }
}
