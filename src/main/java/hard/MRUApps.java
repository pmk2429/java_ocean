package hard;

import java.util.Arrays;

/**
 * Program for K Most Recently Used (MRU) Apps
 * Given an integer K and an array arr[] of N integers which contains the ids of the opened apps in a system where
 * <p>
 * arr[0] is the app currently in use
 * arr[1] is the app which was most recently used and
 * arr[N – 1] is the app which was least recently used.
 * The task is to print the contents of the array when the user using the system presses Alt + Tab exactly
 * K number of times. Note that after pressing Alt + Tab key, app opening pointer will move through apps from
 * 0th index towards right, depending upon the number of presses, so the app on which the press ends will shift
 * to 0th index, because that will become the most recently opened app.
 * <p>
 * Examples:
 * ---------
 * Input: arr[] = {3, 5, 2, 4, 1}, K = 3
 * Output: 4 3 5 2 1
 * User want to switch to the app with id 4, it’ll become the currently active app and the previously active app
 * (with id 3) will be the most recently used app.
 * <p>
 * Input: arr[] = {5, 7, 2, 3, 4, 1, 6}, K = 10
 * Output: 3 5 7 2 4 1 6
 */
public class MRUApps {

    /**
     * Approach: Get the index of the app to which the user wants to switch i.e. appIndex = K % N.
     * Now, the current active app will be arr[appIndex] and all the other apps in the index range [0, appIndex – 1]
     * will have to be shifted by 1 element towards the right.
     */
    private static int[] MRU(int[] apps, int tabs) {
        int N = apps.length;

        // Finding the end index after K presses
        int switchToIndex = (tabs % N);

        // Shifting elements by 1 towards the found index on which the K press ends
        int x = switchToIndex;
        int switchToApp = apps[switchToIndex];

        while (x > 0) {
            apps[x] = apps[--x];
        }

        // Update the current active app
        apps[0] = switchToApp;

        return apps;
    }


    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 4, 1};
        int k = 3;
        System.out.println(Arrays.toString(MRU(arr, k)));
    }
}
