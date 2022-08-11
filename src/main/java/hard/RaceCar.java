package hard;

/**
 * Your car starts at position 0 and speed +1 on an infinite number line.  (Your car can go into negative positions.)
 * <p>
 * Your car drives automatically according to a sequence of instructions A (accelerate) and R (reverse).
 * <p>
 * When you get an instruction "A", your car does the following: position += speed, speed *= 2.
 * <p>
 * When you get an instruction "R", your car does the following: if your speed is positive then speed = -1 , otherwise speed = 1.  (Your position stays the same.)
 * <p>
 * For example, after commands "AAR", your car goes to positions 0->1->3->3, and your speed goes to 1->2->4->-1.
 * <p>
 * Now for some target position, say the length of the shortest sequence of instructions to get there.
 * <p>
 * Example 1:
 * ----------
 * Input:
 * target = 3
 * Output: 2
 * Explanation:
 * ----------
 * The shortest instruction sequence is "AA".
 * Your position goes from 0->1->3.
 * <p>
 * Example 2:
 * ----------
 * Input:
 * target = 6
 * Output: 5
 * Explanation:
 * ----------
 * The shortest instruction sequence is "AAARA".
 * Your position goes from 0->1->3->7->7->6.
 * <p>
 * Note:
 * -----
 * 1 <= target <= 10000.
 */
public class RaceCar {

    private int racecar(int target) {

        int position = 0;
        int speed = 1;

        // 1. Design algo for smallest solvable unit of problem


        // 2. Extend the algo to entire problem set

        // 3. Mind your edge cases

        // 4. Test

        // 5. Optimize

        return -1;
    }

    public static void main(String[] args) {

    }
}
