package hard;

import java.util.*;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 * <p>
 * Note:
 * ------
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * <p>
 * Example 1:
 * ----------
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * <p>
 * Example 2:
 * ----------
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * <p>
 * Example 3:
 * ----------
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */
public class WordBreak {

  private static boolean wordBreak(String s, List<String> wordDict) {
    Set<String> wordDictSet = new HashSet<>(wordDict);
    Queue<Integer> queue = new LinkedList<>();
    int[] visited = new int[s.length()];
    queue.add(0);
    int length = s.length();

    while (!queue.isEmpty()) {
      int start = queue.remove();
      // if not visited
      if (visited[start] == 0) {
        for (int end = start + 1; end <= length; end++) {
          if (wordDictSet.contains(s.substring(start, end))) {
            queue.add(end);
            if (end == s.length()) {
              return true;
            }
          }
        }
        visited[start] = 1;
      }
    }
    return false;
  }
  public static void main(String[] args) {

  }
}
