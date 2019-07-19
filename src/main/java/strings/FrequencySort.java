package strings;

import java.util.HashMap;
import java.util.PriorityQueue;

public class FrequencySort {

  private static String frequencySort(String s) {
    HashMap<Character, Integer> map = new HashMap<>();

    for (Character c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    PriorityQueue<Character> pq = new PriorityQueue<>((c1, c2) -> map.get(c2) - map.get(c1));

    for (Character c : map.keySet()) {
      pq.offer(c);
    }

    StringBuilder sb = new StringBuilder();

    while (!pq.isEmpty()) {
      char val = pq.poll();
      int freq = map.get(val);
      for (int i = 0; i < freq; i++) {
        sb.append(val);
      }
    }

    return sb.toString();
    //Stream<Map.Entry<Character, Integer>> sorted =
    //    map.entrySet().stream()
    //        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()));
  }

  public static void main(String[] args) {

  }

}