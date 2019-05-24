package strings;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 * <p>
 * Example:
 * --------
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * <p>
 * Note:
 * --------
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
public class GroupAnagrams {

  private static List<List<String>> groupAnagrams(String[] strs) {
    if (strs == null || strs.length == 0) {
      return new ArrayList<>();
    }
    Map<String, List<String>> map = new HashMap<>();

    for (String s : strs) {
      char[] chars = s.toCharArray();
      Arrays.sort(chars);
      String keyStr = String.valueOf(chars);
      if (!map.containsKey(keyStr)) {
        map.put(keyStr, new ArrayList<>());
      }
      map.get(keyStr).add(s);
    }

    return new ArrayList<>(map.values());
  }

  public static void main(String[] args) {
    String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    List<List<String>> anagrams = groupAnagrams(strs);
    for (List<String> str : anagrams) {
      System.out.println(str);
    }
  }
}
