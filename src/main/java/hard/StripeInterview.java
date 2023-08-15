package hard;

import java.util.Objects;

/**
 * For the purposes of this interview, imagine that we own a store. This
 * store doesn't always have customers shopping: there might be some long
 * stretches of time when no customers enter the store. We've asked our
 * employees to write simple notes to keep track of when customers are
 * shopping and when they aren't by simply writing a single letter every
 * hour: 'Y' if there were customers during that hour, 'N' if the store
 * was empty during that hour.
 *
 * For example, our employee might have written "Y Y N Y", which means
 * the store was open for four hours that day, and it had customers
 * shopping during every hour but its third one.
 *
 *   hour: | 1 | 2 | 3 | 4 |
 *   log:  | Y | Y | N | Y |
 *                   ^
 *                   |
 *             No customers during hour 3
 *
 * We suspect that we're keeping the store open too long, so we'd like to
 * understand when we *should have* closed the store. For simplicity's
 * sake, we'll talk about when to close the store by talking about how
 * many hours it was open: if our closing time is `2`, that means the
 * store would have been open for two hours and then closed.
 *
 *   hour:         | 1 | 2 | 3 | 4 |
 *   log:          | Y | Y | N | Y |
 *   closing_time: 0   1   2   3   4
 *                 ^               ^
 *                 |               |
 *          before hour #1    after hour #4
 *
 * (A closing time of 0 means we simply wouldn't have opened the store at
 * all that day.)
 *
 * First, let's define a "penalty": what we want to know is "how bad
 * would it be if we had closed the store at a given hour?" For a given
 * log and a given closing time, we compute our penalty like this:
 *
 *   +1 penalty for every hour that we're *open* with no customers
 *   +1 penalty for every hour that we're *closed* when customers would have shopped
 *
 * For example:
 *
 *   hour:    | 1 | 2 | 3 | 4 |   penalty = 3:
 *   log:     | Y | Y | N | Y |     (three hours with customers after closing)
 *   penalty: | * | * |   | * |
 *            ^
 *            |
 *          closing_time = 0
 *
 *   hour:    | 1 | 2 | 3 | 4 |   penalty = 2:
 *   log:     | N | Y | N | Y |      (one hour without customers while open +
 *   penalty: | * |   |   | * |       one hour with customers after closing)
 *                    ^
 *                    |
 *                  closing_time = 2
 *
 *   hour:    | 1 | 2 | 3 | 4 |   penalty = 1
 *   log:     | Y | Y | N | Y |      (one hour without customers while open)
 *   penalty: |   |   | * |   |
 *                            ^
 *                            |
 *                          closing_time = 4
 *
 * Note that if we have a log from `n` open hours, the `closing_time`
 * variable can range from 0, meaning "never even opened", to n, meaning
 * "open the entire time".
 *
 * 1)
 * Write a function `compute_penalty` that computes the total penalty, given
 *   a store log (as a space separated string) AND
 *   a closing time (as an integer)
 *
 * In addition to writing this function, you should use tests to
 * demonstrate that it's correct. Do some simple testing, and then quickly
 * describe a few other tests you would write given more time.
 *
 * ## Examples
 *
 * compute_penalty("Y Y N Y", 0) should return 3
 * compute_penalty("N Y N Y", 2) should return 2
 * compute_penalty("Y Y N Y", 4) should return 1
 */
public class StripeInterview {

    private static int computePenalty(String log, int closingTime) {
        // Store open - visitors
        // Store open - no visitors : +1 Penalty
        // Store close - visitors : +1 Penalty
        // Store was open then closed - compute all visitors after close

        int totalPenalty = 0;
        final String CUSTOMER_VISIT = "Y";
        final String CUSTOMER_NOT_VISIT = "N";

        if  (log == null || log.trim().length() == 0) {
            return totalPenalty;
        }

        String[] visitorLog = log.split(" ");

        int visitorLogLength = visitorLog.length;

        if (closingTime < 0 || closingTime > visitorLogLength) {
            return totalPenalty;
        }

        int sum = 0;
        for (int i = 0; i < visitorLogLength; i++) {
            // first case
            if (i >= closingTime) {
                if (Objects.equals(visitorLog[i], CUSTOMER_VISIT)) {
                    sum++;
                }
            } else {
                if (Objects.equals(visitorLog[i], CUSTOMER_NOT_VISIT)) {
                    sum++;
                }
            }
        }

        totalPenalty = Math.max(totalPenalty, sum);

        return totalPenalty;
    }

    /**
     * find_best_closing_time("Y Y N N") should return 2
     * find_best_closing_time("Y Y Y N N N N", 7) should return 3;
     * find_best_closing_time("Y Y Y N Y Y Y Y Y N Y Y N N N", 7) should return ;
     */
    private static int findBestClosingTime(String log) {
        // diff between first and lastIndex
        return 0;
    }

    private static <T> void assertEquals(T expected, T actual) {
        if (expected == null && actual == null || actual != null && actual.equals(expected)) {
            System.out.println("PASSED");
        } else {
            throw new AssertionError("Expected:\n  " + expected + "\nActual:\n  " + actual + "\n");
        }
    }

    public static void testComputePenalty() {
        System.out.println("compute_penalty");
        assertEquals(3, computePenalty("Y Y Y N N N N", 0));
        assertEquals(4, computePenalty("Y Y Y N N N N", 7));
        assertEquals(0, computePenalty("Y Y Y N N N N", 3));
        assertEquals(0, computePenalty("", 0));
        assertEquals(1, computePenalty("Y N Y N N N N", 3));
    }

    public static void main(String[] args) {
        String log1 = "Y Y N Y";
        int closingTime1 = 0;
        System.out.println(computePenalty(log1, closingTime1));

        // case 2
        String log2 = "N Y N Y";
        int closingTime2 = 2;
        System.out.println(computePenalty(log2, closingTime2));

        // case 3
        String log3 = "Y Y N Y";
        int closingTime3 = 4;
        System.out.println(computePenalty(log3, closingTime3));

        System.out.println("----------------------------------");

        // Tests
        testComputePenalty();
    }
}
