package hard;

import java.util.Arrays;
import java.util.Stack;

/**
 * We are given an array asteroids of integers representing asteroids in a row.
 * For each asteroid, the absolute value represents its size, and the sign represents its direction
 * (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode.
 * If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 * <p>
 * Example 1:
 * ----------
 * Input:
 * asteroids = [5, 10, -5]
 * Output: [5, 10]
 * Explanation:
 * The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.
 * <p>
 * Example 2:
 * ----------
 * Input:
 * asteroids = [8, -8]
 * Output: []
 * Explanation:
 * The 8 and -8 collide exploding each other.
 * <p>
 * Example 3:
 * ----------
 * Input:
 * asteroids = [10, 2, -5]
 * Output: [10]
 * Explanation:
 * The 2 and -5 collide resulting in -5.  The 10 and -5 collide resulting in 10.
 * <p>
 * Example 4:
 * ----------
 * Input:
 * asteroids = [-2, -1, 1, 2]
 * Output: [-2, -1, 1, 2]
 * Explanation:
 * The -2 and -1 are moving left, while the 1 and 2 are moving right.
 * Asteroids moving the same direction never meet, so no asteroids will meet each other.
 * Note:
 * <p>
 * The length of asteroids will be at most 10000.
 * Each asteroid will be a non-zero integer in the range [-1000, 1000]..
 */
public class AsteroidCollision {

    private static int helper(int[] as, int a, int b) {
        if (as.length <= 1) return as.length;
        while (b < as.length) {
            if (a < 0 || as[a] < 0 || as[b] > 0) {
                as[++a] = as[b++];  // Win-Win (both are survived)
            }
            else if (as[a] == -1 * as[b]) {
                a--;
                b++; // Lost-Lost (both are destroyed)
            }
            else if (as[a] < -1 * as[b]) {
                a--; // Win (b replace a, a go back)
            }
            else {
                b++; // Lost (b goes on, a stay)
            }
        }
        return a;
    }

    public static int[] asteroidCollision2(int[] asteroids) {
        int len = helper(asteroids, 0, 1) + 1;
        return Arrays.copyOfRange(asteroids, 0, len);
    }


    private static Integer[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0) {
            return null;
        }

        Stack<Integer> collisionDetector = new Stack<>();

        for (int currAsteroid : asteroids) {
            if (collisionDetector.isEmpty() || currAsteroid * collisionDetector.peek() > 0) {
                collisionDetector.push(currAsteroid);
            }
            else {
                boolean push = true;
                while (!collisionDetector.isEmpty() || currAsteroid < 0 && collisionDetector.peek() > 0) {
                    if (Math.abs(collisionDetector.peek()) > Math.abs(currAsteroid)) {
                        push = false;
                        break;
                    }
                    else if (Math.abs(collisionDetector.peek()) == Math.abs(currAsteroid)) {
                        push = false;
                        collisionDetector.pop();
                        break;
                    }
                    else {
                        collisionDetector.pop();
                    }
                }
                if (push) {
                    collisionDetector.push(currAsteroid);
                }
            }
        }

        return collisionDetector.toArray(new Integer[0]);
    }

    public static void main(String[] args) {
        int[] arr1 = {-8, 8};
        System.out.println(Arrays.toString(asteroidCollision(arr1)));
        int[] arr = {-2, -1, 1, 2};
        System.out.println(Arrays.toString(asteroidCollision(arr)));
    }
}
