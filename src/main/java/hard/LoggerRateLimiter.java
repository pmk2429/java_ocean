package hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Design a logger system that receives a stream of messages along with their timestamps.
 * Each unique message should only be printed at almost every 10 seconds (i.e. a message printed at timestamp t
 * will prevent other identical messages from being printed until timestamp t + 10).
 * All messages will come in chronological order. Several messages may arrive at the same timestamp.
 * Implement the Logger class:
 * ============================
 * Logger() Initializes the logger object.
 * bool shouldPrintMessage(int timestamp, string message) Returns true if the message should be printed in the given
 * timestamp, otherwise returns false.
 * <p>
 * Example 1:
 * ----------
 * Input
 * ["Logger", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage",
 * "shouldPrintMessage", "shouldPrintMessage"]
 * [[], [1, "foo"], [2, "bar"], [3, "foo"], [8, "bar"], [10, "foo"], [11, "foo"]]
 * Output
 * [null, true, true, false, false, false, true]
 * <p>
 * Explanation
 * -----------
 * Logger logger = new Logger();
 * logger.shouldPrintMessage(1, "foo");  // return true, next allowed timestamp for "foo" is 1 + 10 = 11
 * logger.shouldPrintMessage(2, "bar");  // return true, next allowed timestamp for "bar" is 2 + 10 = 12
 * logger.shouldPrintMessage(3, "foo");  // 3 < 11, return false
 * logger.shouldPrintMessage(8, "bar");  // 8 < 12, return false
 * logger.shouldPrintMessage(10, "foo"); // 10 < 11, return false
 * logger.shouldPrintMessage(11, "foo"); // 11 >= 11, return true, next allowed timestamp for "foo" is 11 + 10 = 21
 * <p>
 * Constraints:
 * ----------
 * 0 <= timestamp <= 109
 * Every timestamp will be passed in non-decreasing order (chronological order).
 * 1 <= message.length <= 30
 * At most 104 calls will be made to shouldPrintMessage.
 */
public class LoggerRateLimiter {

    private final Map<String, Integer> loggerMessageMap;

    /**
     * Initialize your data structure here.
     */
    public LoggerRateLimiter() {
        loggerMessageMap = new HashMap<>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!loggerMessageMap.containsKey(message)) {
            loggerMessageMap.put(message, timestamp);
            return true;
        }

        Integer oldTimestamp = loggerMessageMap.get(message);
        if (timestamp - oldTimestamp >= 10) {
            loggerMessageMap.put(message, timestamp);
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        LoggerRateLimiter logger = new LoggerRateLimiter();
        System.out.println(logger.shouldPrintMessage(1, "foo"));
        System.out.println(logger.shouldPrintMessage(2, "bar"));
        System.out.println(logger.shouldPrintMessage(3, "foo"));
        System.out.println(logger.shouldPrintMessage(8, "bar"));
        System.out.println(logger.shouldPrintMessage(10, "foo"));
        System.out.println(logger.shouldPrintMessage(11, "foo"));
    }
}
