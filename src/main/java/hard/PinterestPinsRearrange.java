package hard;

/**
 * A Pinterest feed consists of a set of Pins which are within interests a User has shown interest in.
 * Each Pin has an interest, such as “fashion”, “vehicles”, “travel”, etc.
 * In order to make the feed look like it contains a variety of Pins, we don’t want two Pins of the same
 * interest next to each other. Given a set of Pins, reorder the Pins so that no two Pins of the same interest
 * are next to each other.
 * <p>
 * Example: 1
 * ----------
 * Given Pins with interests: [“fashion”, “vehicles”, “vehicles”].
 * We would reorder these Pins so the Pins in the “vehicles” interests are not next to each other:
 * [“vehicles”, “fashion”, “vehicles”]
 * <p>
 * Example 2: [“travel”, “vehicles”, fashion”] ->
 * Example 3: [“travel”, "travel"] -> Output: ["travel"]
 * Example 4: [“travel”, "vehicles", "fashion", "travel", "travel"] -> Output: ["travel"]
 * Example 5: [“travel”, "vehicles", "travel", "travel"] -> Output: ["travel"]
 */

import java.util.*;

class InterestData {
    String interest;
    int count;

    InterestData(String interest, int count) {
        this.interest = interest;
        this.count = count;
    }
}

public class PinterestPinsRearrange {

    private static List<String> rearrangeArray(List<String> interests) {
        if (interests == null || interests.isEmpty()) {
            return null;
        }

        List<String> result = new ArrayList<>();
        Map<String, Integer> freqMap = new HashMap<>();

        for (String interest : interests) {
            freqMap.put(interest, freqMap.getOrDefault(interest, 0) + 1);
        }

        Queue<InterestData> pq = new PriorityQueue<>((i1, i2) -> i2.count - i1.count);

        // Adding high freq elements in descending order
        for (String interest : freqMap.keySet()) {
            pq.offer(new InterestData(interest, freqMap.get(interest)));
        }

        InterestData prevId = new InterestData(null, -1);

        while (!pq.isEmpty()) {
            // pop top element from queue
            InterestData currId = pq.poll();
            result.add(currId.interest);

            if (prevId.count > 0) {
                pq.offer(prevId);
            }

            // Since we have already used the interest, decrement the frequency by one
            currId.count--;
            // assign curr InterestData to prev InterestData
            prevId = currId;
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> interests = Arrays.asList("vehicle", "travel", "fashion", "travel", "travel");
        List<String> rearranged = rearrangeArray(interests);
        System.out.println(rearranged);
    }
}
