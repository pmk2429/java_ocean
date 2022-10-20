package hard;

import java.util.*;

/**
 * Given a non-empty string addStr and a dictionary wordDict containing a list of non-empty words, determine if addStr can be
 * segmented into a space-separated sequence of one or more dictionary words.
 * <p>
 * Note:
 * ------
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * <p>
 * Example 1:
 * ----------
 * Input: addStr = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * <p>
 * Example 2:
 * ----------
 * Input: addStr = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * <p>
 * Example 3:
 * ----------
 * Input: addStr = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 * <p>
 * ~!@#HARD:REVISE
 */
public class WordBreak {

    private static List<String> wordBreak(String s, String[] words) {
        int length = s.length();
        Set<String> wordDictSet = new HashSet<>(Arrays.asList(words));
        Deque<Integer> queue = new ArrayDeque<>();
        List<String> res = new ArrayList<>();
        int[] visited = new int[length];

        queue.add(0);

        while (!queue.isEmpty()) {
            // int start = queue.poll() || queue.remove() || queue.removeLast();
            int start = queue.remove(); // start of the current word
            // if not visited
            if (visited[start] == 0) {
                for (int end = start + 1; end <= length; end++) {
                    // end measures end of the current word
                    String subStr = s.substring(start, end);
                    if (wordDictSet.contains(subStr)) {
                        res.add(subStr);
                    }
                    if (end == length) {
                        break;
                    }
                    queue.add(end);
                }
                // mark visited
                visited[start] = 1;
            }
        }
        return res;
    }

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
        String s = "nota";
        String[] wordDict = {"a", "no", "not", "to", "fala", "eat", "alligator", "yahoo"};
        System.out.println(wordBreak(s, wordDict));

        String animals = "catsandog";
        String[] wordDictAnimals = {"cats", "dog", "sand", "and", "cat"};
        System.out.println(wordBreak(animals, wordDictAnimals));
    }
}
