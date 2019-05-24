package strings;

import java.util.HashMap;
import java.util.Map;

public class VerifyAlienOrder {
  public boolean isAlienSorted(String[] words, String order) {
    int[] index = new int[26];
    for (int i = 0; i < order.length(); ++i)
      index[order.charAt(i) - 'a'] = i;

    search:
    for (int i = 0; i < words.length - 1; ++i) {
      String word1 = words[i];
      String word2 = words[i + 1];

      // Find the first difference word1[k] != word2[k].
      for (int k = 0; k < Math.min(word1.length(), word2.length()); ++k) {
        if (word1.charAt(k) != word2.charAt(k)) {
          // If they compare badly, it's not sorted.
          if (index[word1.charAt(k) - 'a'] > index[word2.charAt(k) - 'a']) {
            return false;
          }
          continue search;
        }
      }

      // If we didn't find a first difference, the
      // words are like ("app", "apple").
      if (word1.length() > word2.length())
        return false;
    }

    return true;
  }

  public boolean isAlienSorted1(String[] words, String order) {
    Map<Character, Integer> map = new HashMap<>();
    int i = 0;

    for (Character ch : order.toCharArray()) {
      map.put(ch, i++);
    }

    int alienIndex = Integer.MIN_VALUE;
    for (String word : words) {
      int idx = map.get(word.charAt(0));
      if (alienIndex >= idx) {
        return false;
      }
      alienIndex = idx;
    }
    return true;
  }
}
