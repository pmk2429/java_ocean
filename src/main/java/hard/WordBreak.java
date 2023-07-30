package hard;

import java.util.*;
import java.util.stream.Collectors;

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
 * ~!MyFav
 */
public class WordBreak {

    private static boolean wordBreakHelper(String str, Set<String> wordDictionary) {
        int length = str.length();
        if (length == 0) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            String currSubStr = str.substring(0, i); // 0 -> i
            String nextSubStr = str.substring(i); // i -> length
            if (wordDictionary.contains(currSubStr) && wordBreakHelper(nextSubStr, wordDictionary)) {
                return true;
            }
        }
        return false;
    }

    private static boolean findWordInDictionary(String str, Set<String> wordDictionary) {
        return wordBreakHelper(str, wordDictionary);
    }

    private static boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        int[] visited = new int[length];
        Set<String> wordDictSet = new HashSet<>(wordDict);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            int start = queue.remove();
            // if not visited
            if (visited[start] == 0) {
                for (int end = start + 1; end <= length; end++) {
                    String subStr = s.substring(start, end);
                    if (wordDictSet.contains(subStr)) {
                        queue.add(end);
                        if (end == length) {
                            return true;
                        }
                    }
                }
                visited[start] = 1;
            }
        }
        return false;
    }

    private static List<String> wordBreak(String s, String[] words) {
        int length = s.length();
        int[] visited = new int[length];
        Set<String> wordDictSet = Arrays.stream(words).collect(Collectors.toSet());
        Deque<Integer> queue = new ArrayDeque<>();
        List<String> res = new ArrayList<>();

        queue.add(0);

        while (!queue.isEmpty()) {
            // int start = queue.poll() || queue.remove() || queue.removeFirst();
            int start = queue.poll(); // start of the current word
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
                    queue.add(end);  // queue.offer() || queue.addLast()
                }
                // mark visited
                visited[start] = 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "nota";
        String[] wordDict = {"a", "no", "not", "to", "fala", "eat", "alligator", "yahoo"};
        System.out.print(s + " -> ");
        System.out.println(wordBreak(s, wordDict));

        String animals = "catsandog";
        String[] wordDictAnimals = {"cats", "dog", "sand", "and", "cat"};
        System.out.print(animals + " -> ");
        System.out.println(wordBreak(animals, wordDictAnimals));
        System.out.println(wordBreak(animals, Arrays.asList(wordDictAnimals)));
    }
}
