package hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    private static final List<Integer[]> queue = new ArrayList<>();
    private static final Set<Integer[]> visited = new HashSet<>();
    private static int moves;

    private static int raceCar(int target) {
        queue.add(new Integer[]{0, 0, 1}); // #moves, position, speed

        while (queue.size() > 0) {
            moves = queue.get(0)[0];
            int position = queue.get(0)[1];
            int speed = queue.get(0)[2];
            queue.remove(0);

            if (position == target) {
                return moves;
            }
            else if (visited.contains(new Integer[]{position, speed})) {
                continue;
            }
            else {
                visited.add(new Integer[]{position, speed});
                queue.add(new Integer[]{moves + 1, position + speed, speed * 2});
                if ((position + speed > target && speed > 0) || (position + speed < target && speed < 0)) {
                    queue.add(new Integer[]{moves + 1, position, speed > 0 ? -1 : 1});
                }
            }
        }
        return moves;
    }

    public static void main(String[] args) {

    }
}
