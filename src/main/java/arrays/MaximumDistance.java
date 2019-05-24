package arrays;

/**
 * In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty.
 * There is at least one empty seat, and at least one person sitting.
 * Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.
 * Return that maximum distance to closest person.
 * <p>
 * Example 1:
 * ----------
 * Input: [1,0,0,0,1,0,1]
 * Output: 2
 * Explanation:
 * If Alex sits in the second open seat (seats[2]), then the closest person has distance 2.
 * If Alex sits in any other open seat, the closest person has distance 1.
 * Thus, the maximum distance to the closest person is 2.
 * <p>
 * Example 2:
 * ----------
 * Input: [1,0,0,0]
 * Output: 3
 * Explanation:
 * If Alex sits in the last seat, the closest person is 3 seats away.
 * This is the maximum distance possible, so the answer is 3.
 * <p>
 * Note:
 * -----
 * 1 <= seats.length <= 20000
 * seats contains only 0s or 1s, at least one 0, and at least one 1.
 */
public class MaximumDistance {

  // Group by zeroes
  private static int maxClosestDistance(int[] seats) {
    int N = seats.length;
    int K = 0; // current longest group of empty seats
    int ans = 0;

    for (int i = 0; i < N; ++i) {
      if (seats[i] == 1) {
        K = 0;
      } else {
        K++;
        ans = Math.max(ans, (K + 1) / 2);
      }
    }

    // OR
    for (int i = 0; i < N; ++i) {
      if (seats[i] == 1) {
        ans = Math.max(ans, i);
        break;
      }
    }

    // OR
    for (int i = N - 1; i >= 0; --i)
      if (seats[i] == 1) {
        ans = Math.max(ans, N - 1 - i);
        break;
      }

    return ans;
  }

  public static void main(String[] args) {
    int[] input = {1, 0, 0, 0, 1, 0, 1};
    System.out.println(maxClosestDistance(input));
  }
}
