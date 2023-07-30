package hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Restore IP Addresses
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * <p>
 * Example:
 * --------
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 * <p>
 * ~!@#HARD:REVISEti
 *
 */
public class RestoreIpAddresses {

    private int length;
    private String inputAddressString;
    private final Deque<String> segments = new ArrayDeque<>();
    private final List<String> output = new ArrayList<>();

    /**
     * Check if the current segment is valid :
     * 1. less or equal to 255
     * 2. the first character could be '0'
     * only if the segment is equal to '0'
     */
    public boolean valid(String segment) {
        int length = segment.length();
        if (length > 3) {
            return false;
        }
        return (segment.charAt(0) != '0') ? (Integer.parseInt(segment) <= 255) : (length == 1);
    }

    /**
     * Append the current list of segments
     * to the list of solutions
     */
    private void updateOutput(int currDotPos) {
        String curSegment = inputAddressString.substring(currDotPos + 1, length);
        if (valid(curSegment)) {
            segments.add(curSegment);
            output.add(String.join(".", segments));
            segments.removeLast();
        }
    }

    /**
     * prevDotPos : the position of the previously placed dot
     * dots : number of dots to place
     */
    private void dfs(int prevDotPos, int dots) {
        // The current dot currPos could be placed in a range from prevDotPos + 1 to prevDotPos + 4.
        // The dot couldn't be placed after the last character in the string.
        int maxPos = Math.min(length - 1, prevDotPos + 4);
        for (int currPos = prevDotPos + 1; currPos < maxPos; currPos++) {
            String segment = inputAddressString.substring(prevDotPos + 1, currPos + 1);
            if (valid(segment)) {
                segments.add(segment);  // place dot
                if (dots - 1 == 0) {     // if all 3 dots are placed
                    updateOutput(currPos);  // add the solution to output
                }
                else {
                    dfs(currPos, dots - 1); // continue to place dots
                }
                segments.removeLast();  // remove the last placed dot
            }
        }
    }

    private List<String> restoreIpAddresses(String input) {
        length = input.length();
        inputAddressString = input;
        dfs(-1, 3);
        return output;
    }

    public static void main(String[] args) {
        String inputStr = "25525511135";
        RestoreIpAddresses addresses = new RestoreIpAddresses();
        List<String> ipAddress = addresses.restoreIpAddresses(inputStr);
        System.out.println(ipAddress);
    }
}
