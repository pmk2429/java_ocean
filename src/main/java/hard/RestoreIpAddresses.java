package hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Restore IP Addresses
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * <p>
 * Example:
 * --------
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 */
public class RestoreIpAddresses {

    private int length;
    private String addStr;
    private final LinkedList<String> segments = new LinkedList<>();
    private final List<String> output = new ArrayList<>();

    /**
     * Check if the current segment is valid :
     * 1. less or equal to 255
     * 2. the first character could be '0'
     * only if the segment is equal to '0'
     */
    public boolean valid(String segment) {
        int m = segment.length();
        if (m > 3) {
            return false;
        }
        return (segment.charAt(0) != '0') ? (Integer.parseInt(segment) <= 255) : (m == 1);
    }

    /**
     * Append the current list of segments
     * to the list of solutions
     */
    private void updateOutput(int currDotPos) {
        String curSegment = addStr.substring(currDotPos + 1, length);
        if (valid(curSegment)) {
            segments.add(curSegment);
            output.add(String.join(".", segments));
            segments.removeLast();
        }
    }

    /**
     * prev_pos : the position of the previously placed dot
     * dots : number of dots to place
     */
    private void backtrack(int prevDotPos, int dots) {
        // The current dot curr_pos could be placed
        // in a range from prev_pos + 1 to prev_pos + 4.
        // The dot couldn't be placed
        // after the last character in the string.
        int maxPos = Math.min(length - 1, prevDotPos + 4);
        for (int currPos = prevDotPos + 1; currPos < maxPos; currPos++) {
            String segment = addStr.substring(prevDotPos + 1, currPos + 1);
            if (valid(segment)) {
                segments.add(segment);  // place dot
                if (dots - 1 == 0) {     // if all 3 dots are placed
                    updateOutput(currPos);  // add the solution to output
                }
                else {
                    backtrack(currPos, dots - 1);  // continue to place dots
                }
                segments.removeLast();  // remove the last placed dot
            }
        }
    }

    private List<String> restoreIpAddresses(String input) {
        length = input.length();
        addStr = input;
        backtrack(-1, 3);
        return output;
    }

    public static void main(String[] args) {
        String inputStr = "";
        RestoreIpAddresses addresses = new RestoreIpAddresses();
        List<String> ipAddrs = addresses.restoreIpAddresses(inputStr);
        System.out.println(ipAddrs);
    }
}
