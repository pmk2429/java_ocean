package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Maximum sum of packets in each channel.
 * Each channel must contain atleast one packet
 * If there are more than one packet in a channel, find the median of all packets
 * <p>
 * A Median of a list for odd number of elements is a middle value whereas the median of list with even number of
 * elements is an average of middle and middle+1 values.
 * <p>
 * Example
 * -------
 * Packets = [1, 2, 3, 4, 5]
 * Channels = 2;
 * <p>
 * Channel 1 = [1, 2, 3, 4]
 * Channel 2 = [5]
 * <p>
 * Median of Channel 1 = (2 + 3)/ 2 = 2.5
 * Median of Channel 2 = 5
 * <p>
 * Total Max output efficiency = 2.5 + 7 = 7.5
 * Ceiling of (7.5) = 8
 * <p>
 * ~!@#HARD:REVISE
 */
public class AmazonOAMaximumQualityChannel {
    private static long maximumQuality(List<Integer> packets, int channels) {
        // Write your code here
        int n = packets.size();

        double answer = 0;
        if (n == channels) {
            for (int i = 0; i < n; i++) {
                answer += packets.get(i);
            }
            return (long) answer;
        }

        Collections.sort(packets);

        for (int i = n - channels + 1; i < n; i++) {
            answer += packets.get(i);
        }

        n = n - channels;
        int midIndex = n / 2;
        if (n % 2 == 0) {
            // odd assuming one last index is not considered while calculating n
            answer += packets.get(midIndex);
        }
        else {
            // even assuming one last index is not considered while calculating n
            double value = packets.get(midIndex) + packets.get((midIndex) + 1);
            answer += value / 2;
        }
        return (long) Math.ceil(answer);
    }

    public static void main(String[] args) {
        List<Integer> packets = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int channels = 2;
        System.out.println(maximumQuality(packets, channels));
    }
}
