package strings;

import java.util.*;

/**
 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you.
 * You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules
 * of this new language. Derive the order of letters in this language.
 * <p>
 * Example 1:
 * ----------
 * Input:
 * [
 * "wrt",
 * "wrf",
 * "er",
 * "ett",
 * "rftt"
 * ]
 * Output: "wertf"
 * <p>
 * Example 2:
 * ----------
 * Input:
 * [
 * "z",
 * "x"
 * ]
 * Output: "zx"
 * <p>
 * Example 3:
 * ----------
 * Input:
 * [
 * "z",
 * "x",
 * "z"
 * ]
 * Output: ""
 * Explanation: The order is invalid, so return "".
 * <p>
 * Note:
 * ----------
 * You may assume all letters are in lowercase.
 * You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
 * If the order is invalid, return an empty string.
 * There may be multiple valid order of letters, return any one of them is fine.
 */
public class AlienDictionary {

  private static String alienOrder(String[] words) {
    Map<Character, Set<Character>> map = new HashMap<>();
    Map<Character, Integer> degree = new HashMap<>();

    StringBuilder order = new StringBuilder();
    if (words == null || words.length == 0) {
      return order.toString();
    }

    // create a degree of all unique chars
    for (String s : words) {
      for (char c : s.toCharArray()) {
        degree.put(c, 0);
      }
    }

    // build relationship with neighbors
    for (int i = 0; i < words.length - 1; i++) {
      String cur = words[i];
      String next = words[i + 1];

      int length = Math.min(cur.length(), next.length());

      for (int j = 0; j < length; j++) {
        char c1 = cur.charAt(j);
        char c2 = next.charAt(j);
        if (c1 != c2) {
          Set<Character> set = new HashSet<>();
          if (map.containsKey(c1)) {
            set = map.get(c1);
          }
          if (!set.contains(c2)) {
            set.add(c2);
            map.put(c1, set);
            degree.put(c2, degree.get(c2) + 1);
          }
          break;
        }
      }
    }

    // BFS
    Queue<Character> q = new LinkedList<>();
    for (char c : degree.keySet()) {
      if (degree.get(c) == 0) {
        q.offer(c);
      }
    }

    // Loop through the Queue, pop the top element, see if map contains the elements, if it does,
    // get all its neighbors , backtrack (decrement the degree because already processed and then
    // if the degree is 0, add it to queue for processing. This way each character is processed along
    // with its neighbors
    while (!q.isEmpty()) {
      char c = q.remove();
      order.append(c);
      if (map.containsKey(c)) {
        for (char c2 : map.get(c)) {
          degree.put(c2, degree.get(c2) - 1); // backtracking because solution is found
          if (degree.get(c2) == 0) {
            q.add(c2);
          }
        }
      }
    }
    // String base case
    if (order.length() != degree.size()) {
      return "";
    }

    return order.toString();
  }

  public static void main(String[] args) {
    String[] input = {
        "wrt",
        "wrf",
        "er",
        "ett",
        "rftt"
    };

    System.out.println(alienOrder(input));
  }
}
