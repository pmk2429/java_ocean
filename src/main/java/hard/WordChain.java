package hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given an array of words where each word consists of lowercase English letters.
 * <p>
 * wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing
 * the order of the other characters to make it equal to wordB.
 * <p>
 * For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
 * A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2,
 * word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.
 * <p>
 * Return the length of the longest possible word chain with words chosen from the given list of words.
 * <p>
 * Example 1:
 * ----------
 * Input: words = ["a","b","ba","bca","bda","bdca"]
 * Output: 4
 * Explanation: One of the longest word chains is ["a","ba","bda","bdca"].
 * <p>
 * Example 2:
 * ----------
 * Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
 * Output: 5
 * Explanation: All the words can be put in a word chain ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].
 * <p>
 * Example 3:
 * ----------
 * Input: words = ["abcd","dbqca"]
 * Output: 1
 * Explanation: The trivial word chain ["abcd"] is one of the longest word chains.
 * ["abcd","dbqca"] is not a valid word chain because the ordering of the letters is changed.
 * <p>
 * Constraints:
 * ----------
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 16
 * words[i] only consists of lowercase English letters.
 * <p>
 * Similar to {@link strings.RansomNote}
 * <p>
 * ~!@#HARD:REVISE
 */
public class WordChain {

    private static int longestWordChain(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        int res = 0;
        Arrays.sort(words, Comparator.comparingInt(String::length)); // Sort the words based on their lengths
        Map<String, Integer> map = new HashMap<>(); // Stores each word and length of its max chain.

        for (String word : words) {
            // Each word is at least 1 chain long
            map.put(word, 1);
            for (int i = 0; i < word.length(); i++) {
                // Form next word removing 1 char each time for each w
                StringBuilder sb = new StringBuilder(word);
                String next = sb.deleteCharAt(i).toString();
                if (map.containsKey(next) && map.get(next) + 1 > map.get(word)) {
                    // If the new chain is longer, update the map
                    map.put(word, map.get(next) + 1);
                }
            }
            res = Math.max(res, map.get(word)); // Store max length of all chains
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words1 = {"a", "b", "ba", "bca", "bda", "bdca"};
        System.out.println(longestWordChain(words1));
        String[] words2 = {"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"};
        System.out.println(longestWordChain(words2));
        String[] ransomMagazine = {"a", "b"};
        System.out.println(longestWordChain(ransomMagazine));
    }
}
