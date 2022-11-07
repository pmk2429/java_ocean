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
 *
 * ~!@#HARD:REVISE
 */
public class WordChain {

    private static int longestStrChain(String[] words) {
        if (words == null || words.length == 0) return 0;
        int res = 0;
        Arrays.sort(words, Comparator.comparingInt(String::length)); // Sort the words based on their lengths
        Map<String, Integer> map = new HashMap<>(); // Stores each word and length of its max chain.

        for (String w : words) { // From the shortest word to the longest word
            map.put(w, 1); // Each word is atleast 1 chain long
            for (int i = 0; i < w.length(); i++) { // Form next word removing 1 char each time for each w
                StringBuilder sb = new StringBuilder(w);
                String next = sb.deleteCharAt(i).toString();
                if (map.containsKey(next) && map.get(next) + 1 > map.get(w))
                    map.put(w, map.get(next) + 1); //If the new chain is longer, update the map
            }
            res = Math.max(res, map.get(w)); //Store max length of all chains
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words1 = {"a", "b", "ba", "bca", "bda", "bdca"};
        String[] words2 = {"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"};
        System.out.println(longestStrChain(words1));
        System.out.println(longestStrChain(words2));
    }
}
