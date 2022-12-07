package arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Pavitra on 4/23/2016.
 */
public class LongestContinuousNumber {
    private static int longestFlat(int[] array) {
        int count = 1;
        ArrayList<Integer> countList = new ArrayList<>();
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                count++;
            }
            else {
                countList.add(count);
                count = 1;
            }
        }
        return Collections.max(countList);
    }

    public static void main(String[] args) {
        int largest = longestFlat(new int[]{1, 1, 1, 2, 2, 2, 2, 3, 4});
        System.out.println(largest);
    }
}
