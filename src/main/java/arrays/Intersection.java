package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * WAP to find intersecting elements from two arrays and return a new array.
 */
public class Intersection {

    private static int[] findIntersection(int[] arr1, int[] arr2) {
        Set<Integer> set1 = Arrays.stream(arr1).boxed().collect(Collectors.toSet());

        HashSet<Integer> set2 = new HashSet<>();
        for (int i : arr2) {
            if (set1.contains(i)) {
                set2.add(i);
            }
        }

        return set2.stream().mapToInt(i -> i).toArray();
    }

    private static int[] intersection(int[] a, int[] b) {
        if (a.length == 0 || b.length == 0) {
            return null;
        }
        int i = 0, j = 0;
        int m = a.length;
        int n = b.length;

        ArrayList<Integer> intersection = new ArrayList<>();

        while (i < m && j < n) {
            if (a[i] < b[j]) {
                i++;
            }
            else if (b[j] < a[i]) {
                j++;
            }
            else {
                // when both are equal
                intersection.add(a[i]);
                i++;
                j++;
            }
        }
        return intersection.stream().mapToInt(val -> val).toArray();
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        int[] arr2 = new int[]{4, 5, 6, 7, 8};
        int[] intersection = findIntersection(arr1, arr2);
        System.out.println(Arrays.toString(intersection));
        System.out.println("Without using Set: ");
        System.out.println(Arrays.toString(intersection(arr1, arr2)));
    }
}
