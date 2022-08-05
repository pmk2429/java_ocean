package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Union {
    private static int[] findUnion(int[] arr1, int[] arr2) {
        HashSet<Integer> union = new HashSet<>();
        for (int i : arr1) {
            union.add(i);
        }

        for (int i : arr2) {
            union.add(i);
        }

        return union.stream().mapToInt(i -> i).toArray();
    }

    private static int[] union(int[] a, int[] b) {
        if (a.length == 0 || b.length == 0) {
            return null;
        }

        int i = 0, j = 0;
        int m = a.length;
        int n = b.length;

        int minLength = Math.min(n, m);

        List<Integer> union = new ArrayList<>();

        while (i < minLength && j < minLength) {
            if (a[i] < b[j]) {
                union.add(a[i++]);
            }
            else if (b[j] < a[i]) {
                union.add(b[j++]);
            }
            else {
                union.add(a[i]);
                i++;
                j++;
            }
        }

        while (i < m) {
            union.add(a[i++]);
        }

        while (j < n) {
            union.add(b[j++]);
        }

        return union.stream().mapToInt(x -> x).toArray();
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 4};
        int[] arr2 = new int[]{4, 5, 6, 7, 8};
        System.out.println(Arrays.toString(union(arr1, arr2)));
    }
}
