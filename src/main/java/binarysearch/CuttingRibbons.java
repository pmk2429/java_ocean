package binarysearch;

/**
 * You are given an integer array ribbons, where ribbons[i] represents the length of the ith ribbon, and an integer k.
 * You may cut any of the ribbons into any number of segments of positive integer lengths, or perform no cuts at all.
 * <p>
 * For example, if you have a ribbon of length 4, you can:
 * - Keep the ribbon of length 4,
 * - Cut it into one ribbon of length 3 and one ribbon of length 1,
 * - Cut it into two ribbons of length 2,
 * - Cut it into one ribbon of length 2 and two ribbons of length 1, or
 * - Cut it into four ribbons of length 1.
 * Your goal is to obtain k ribbons of all the same positive integer length. You are allowed to throw away any
 * excess ribbon as a result of cutting.
 * Return the maximum possible positive integer length that you can obtain k ribbons of, or 0 if you cannot obtain k
 * ribbons of the same length.
 * <p>
 * Example 1:
 * ----------
 * Input: ribbons = [9,7,5], k = 3
 * Output: 5
 * Explanation:
 * - Cut the first ribbon to two ribbons, one of length 5 and one of length 4.
 * - Cut the second ribbon to two ribbons, one of length 5 and one of length 2.
 * - Keep the third ribbon as it is.
 * Now you have 3 ribbons of length 5.
 * <p>
 * Example 2:
 * ----------
 * Input: ribbons = [7,5,9], k = 4
 * Output: 4
 * Explanation:
 * - Cut the first ribbon to two ribbons, one of length 4 and one of length 3.
 * - Cut the second ribbon to two ribbons, one of length 4 and one of length 1.
 * - Cut the third ribbon to three ribbons, two of length 4 and one of length 1.
 * Now you have 4 ribbons of length 4.
 * <p>
 * Example 3:
 * ----------
 * Input: ribbons = [5,7,9], k = 22
 * Output: 0
 * Explanation: You cannot obtain k ribbons of the same positive integer length.
 * <p>
 * Constraints:
 * ------------
 * 1 <= ribbons.length <= 105
 * 1 <= ribbons[i] <= 105
 * 1 <= k <= 109
 */
public class CuttingRibbons {

    private static boolean isCutPossible(int[] ribbons, int givenLength, int k) {
        int count = 0;
        for (int ribbon : ribbons) {
            count += (ribbon / givenLength);
        }
        return count >= k;
    }

    /**
     * Time Complexity : O(N log (max length))
     * Space Complexity: O(1)
     * <p>
     * Instead of finding the last valid answer (upper bound of valid answer),
     * try to find the first invalid answer (lower bound of invalid answer).
     */
    private static int maxLength(int[] ribbons, int k) {
        int left = 1;
        int right = (int) 1e5 + 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (!isCutPossible(ribbons, mid, k)) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return left - 1;
    }


    public static void main(String[] args) {
        System.out.println(maxLength(new int[]{9, 7, 5}, 3));
        System.out.println(maxLength(new int[]{7, 5, 9}, 4));
        System.out.println(maxLength(new int[]{5, 7, 9}, 22));
    }
}
