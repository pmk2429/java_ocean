package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL", a move consists of either replacing one
 * occurrence of "XL" with "LX", or replacing one occurrence of "RX" with "XR".
 * Given the starting string start and the ending string end, return True if and only if there exists a sequence of
 * moves to transform one string to the other.
 * <p>
 * Example:
 * --------
 * Input: start = "RX XL RX R XL", end = "XR LX XR R LX"
 * Output: True
 * Explanation:
 * We can transform start to end following these steps:
 * RXXLRXRXL ->
 * XRXLRXRXL ->
 * XRLXRXRXL ->
 * XRLXXRRXL ->
 * XRLXXRRLX
 * <p>
 * Note:
 * -----
 * 1 <= len(start) = len(end) <= 10000.
 * Both start and end will only consist of characters in {'L', 'R', 'X'}.
 */
public class SwapAdjacentString {

    private static boolean canTransform(String start, String end) {
        Map<String, String> moves = new HashMap<>() {{
            put("XL", "LX");
            put("RX", "XR");
        }};

        boolean transform = true;

        String validChars = "^[LXR]*$";

        if (!start.matches(validChars) || !end.matches(validChars)) {
            return false;
        }

        if (start.length() < 1 || start.length() > 1000) {
            return false;
        }

        if (end.length() < 1 || end.length() > 1000) {
            return false;
        }

        int i = 0;
        while (i < start.length()) {
            int j = i + 1;
            if (j < start.length()) {
                String startSub = start.substring(i, j + 1);
                String endSub = end.substring(i, j + 1);
                if (moves.containsKey(startSub)) {
                    if (!moves.get(startSub).equals(endSub)) {
                        transform = false;
                        i++;
                        continue;
                    }
                    else {
                        transform = true;
                    }
                }
            }
            i = i + 2;
        }

        return transform;
    }

    public static void main(String[] args) {
        String start = "RXXLRXRXL";
        String end = "XRLXXRRLX";

        System.out.println(canTransform(start, end));
    }
}
