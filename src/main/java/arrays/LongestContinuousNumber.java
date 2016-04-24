package arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Pavitra on 4/23/2016.
 */
public class LongestContinuousNumber {
    public static void main(String[] args) {
        int largest = longest_flat(new int[]{1, 1, 1, 2, 2, 2, 2});
        System.out.println(largest);
    }

    public static int longest_flat(int[] array) {
        int count = 1;
        ArrayList<Integer> countList = new ArrayList<>();
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                count++;
            }
            if (array[i] != array[i + 1]) {
                countList.add(count);
                count = 0;
            }
        }
        return Collections.max(countList);
    }
}
