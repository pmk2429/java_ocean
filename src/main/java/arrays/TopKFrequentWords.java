package arrays;

import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Given a non-empty list of words, return the k most frequent elements.
 * <p>
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency,
 * then the word with the lower alphabetical order comes first.
 * <p>
 * Example 1:
 * ----------
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 * Note that "i" comes before "love" due to a lower alphabetical order.
 * <p>
 * Example 2:
 * ----------
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 * with the number of occurrence being 4, 3, 2 and 1 respectively.
 * <p>
 * Note:
 * -----
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Input words contain only lowercase letters.
 * Follow up:
 * Try to solve it in O(n log k) time and O(n) extra space.
 */
public class TopKFrequentWords {

  private static void freq(String[] wirds, int k) {
    Stream<String> stream = Stream.of(wirds).parallel();
    Map<String, Long> wordFreq = stream
        .collect(Collectors.groupingBy(String::toString, Collectors.counting()));
    System.out.println(wordFreq);
  }

  private static List<String> kFreqWords(String[] words, int k) {
    ConcurrentMap<String, Integer> m = new ConcurrentHashMap<>();
    m.compute("x", (j, v) -> v == null ? 1 : v + 1);
    return null;
  }

  /**
   * Add elements to the HashMap and then sort the map by Value using Stream API
   *
   * @param words
   * @param k
   * @return
   */
  private static List<String> kFrequentWords(String[] words, int k) {
    List<String> firstKWords = new ArrayList<>();

    // to maintain the natural order of insertion
    Map<String, Integer> wordMap = new HashMap<>();
    for (String w : words) {
      Integer n = wordMap.get(w);
      n = (n == null) ? 1 : ++n;
      wordMap.put(w, n);
    }

    Map<String, Integer> sortedWords = wordMap.entrySet().stream()
        .sorted(Entry.comparingByValue(Collections.reverseOrder()))
        .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
            (e1, e2) -> e1, LinkedHashMap::new));

    int count = 0;
    for (Map.Entry<String, Integer> entry : sortedWords.entrySet()) {
      if (count >= k) {
        break;
      }

      firstKWords.add(entry.getKey());
      count++;
    }
    // now considering all elements are sorted based on their natural ordering, loop through k elements
    return firstKWords;
  }

  private static List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> count = new HashMap<>();
    for (String word : words) {
      count.put(word, count.getOrDefault(word, 0) + 1);
    }
    List<String> candidates = new ArrayList<>(count.keySet());
    Collections.sort(candidates,
        (w1, w2) ->
            count.get(w1).equals(count.get(w2))
                ? w1.compareTo(w2)
                : count.get(w2) - count.get(w1));

    return candidates.subList(0, k);
  }

  private static List<String> topKFrequentHeap(String[] words, int k) {
    Map<String, Integer> count = new HashMap<>();
    for (String word : words) {
      count.put(word, count.getOrDefault(word, 0) + 1);
    }

    PriorityQueue<String> heap = new PriorityQueue<>((w1, w2) -> count.get(w1).equals(count.get(w2))
        ? w1.compareTo(w2)
        : count.get(w1) - count.get(w2));

    for (String word : count.keySet()) {
      heap.offer(word);
      if (heap.size() > k) {
        heap.poll();
      }
    }

    return new ArrayList<>(heap);
  }

  public static void main(String[] args) {
    String[] str = {"i", "love", "leetcode", "i", "love", "coding"};
    int k = 2;
    System.out.println(topKFrequentHeap(str, k));
  }
}
