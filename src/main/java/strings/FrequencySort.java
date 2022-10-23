package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Building PriorityQueue Comparator is the main logic in solving this problem.
 */
public class FrequencySort {

    private static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        //PriorityQueue<Character> pq2 = new PriorityQueue<>((c1, c2) -> map.get(c2) - map.get(c1));
        PriorityQueue<Character> pq = new PriorityQueue<>((c1, c2) -> map.get(c1).equals(map.get(c2))
            ? c1.compareTo(c2)
            : map.get(c2) - map.get(c1));

        for (Character c : map.keySet()) {
            pq.offer(c);
        }

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            char val = pq.poll();
            int freq = map.get(val);
            for (int i = 0; i < freq; i++) {
                // creates a string with increasing order of Frequency else
                sb.append(val);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("pavitra"));
    }
}
