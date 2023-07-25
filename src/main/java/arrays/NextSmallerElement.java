package arrays;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Next Smaller Element
 * Given an array, print the Next Smaller Element (NSE) for every element.
 * The Smaller Element for an element x is the first smaller element on the right side of x in array.
 * Elements for which no smaller element exist (on right side), consider next smaller element as -1.
 * <p>
 * Examples:
 * a) For any array, rightmost element always has next smaller element as -1.
 * b) For an array which is sorted in increasing order, all elements have next smaller element as -1.
 * c) For the input array [4, 8, 5, 2, 25] the next smaller elements for each element are as follows.
 * ------------------
 * Element     NSE
 * 4      -->   2
 * 8      -->   5
 * 5      -->   2
 * 2      -->   -1
 * 25     -->   -1
 * d) For the input array [13, 7, 6, 12], the next smaller elements for each element are as follows.
 * -------------------
 * Element       NSE
 * 13      -->    7
 * 7       -->    6
 * 6       -->   -1
 * 12      -->   -1
 * Also check {@link ClosestGreaterElement} and {@link hard.OrderedMapContainsDuplicate}.
 */
public class NextSmallerElement {

    private static void nextSmallerElement(int[] arr) {
        int length = arr.length;
        int lastIndex = length - 1;
        int[] nse = new int[length];
        int j;
        for (int i = 0; i < length; i++) {
            if (i == lastIndex) {
                nse[i] = -1;
                break;
            }
            j = i + 1;
            if (j < length) {
                if (arr[i] > arr[j]) {
                    nse[i] = arr[j];
                }
                else {
                    while (j < lastIndex && arr[i] < arr[j]) {
                        j++;
                    }
                    nse[i] = (j == lastIndex) ? -1 : arr[j];
                }
            }
        }
        System.out.println(Arrays.toString(nse));
    }

    /**
     * Similar to {@link ClosestGreaterElement}
     */
    private static int[] closestSmallerElementUsingSelfBalancingTree(int[] arr) {
        int[] ans = new int[arr.length];
        TreeSet<Integer> selfBalancingTree = new TreeSet<>();
        for (int i : arr) {
            selfBalancingTree.add(i);
        }

        for (int i = 0; i < arr.length; i++) {
            Integer smaller = selfBalancingTree.lower(arr[i]);
            ans[i] = smaller == null ? -1 : smaller;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {4, 8, 5, 2, 25};
        nextSmallerElement(arr);
        System.out.println(Arrays.toString(closestSmallerElementUsingSelfBalancingTree(arr)));
        int[] arr1 = {13, 7, 6, 12};
        nextSmallerElement(arr1);
    }
}
