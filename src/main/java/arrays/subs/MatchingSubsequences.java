package arrays.subs;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.
 * A subsequence of a string is a new string generated from the original string with some characters (can be none)
 * deleted without changing the relative order of the remaining characters.
 * For example, "ace" is a subsequence of "abcde".
 * <p>
 * Example 1:
 * ----------
 * Input: s = "abcde", words = ["a","bb","acd","ace"]
 * Output: 3
 * Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".
 * <p>
 * Example 2:
 * ----------
 * Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
 * Output: 2
 * <p>
 * Constraints:
 * ------------
 * 1 <= s.length <= 5 * 104
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 50
 * s and words[i] consist of only lowercase English letters.
 */
public class MatchingSubsequences {

    private static char[] ca, cb;

    private static boolean subsequence(String word) {
        int i = 0;
        cb = word.toCharArray();
        for (char c : ca) {
            if (i < cb.length && c == cb[i]) {
                i++;
            }
        }
        return (i == cb.length);
    }

    private static int numMatchingSubsequences(String S, String[] words) {
        int ans = 0;
        ca = S.toCharArray();
        for (String word : words) {
            if (subsequence(word)) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * Since the length of S is large, let's think about ways to iterate through S only once, instead of many times
     * as in the brute force solution.
     * <p>
     * We can put words into buckets by starting character. If for example we have words = ['dog', 'cat', 'cop'],
     * then we can group them 'c' : ('cat', 'cop'), 'd' : ('dog',). This groups words by what letter they are
     * currently waiting for. Then, while iterating through letters of S, we will move our words through different buckets.
     * <p>
     * For example, if we have a string like S = 'dcaog':
     * <p>
     * heads = 'c' : ('cat', 'cop'), 'd' : ('dog',) at beginning;
     * heads = 'c' : ('cat', 'cop'), 'o' : ('og',) after S[0] = 'd';
     * heads = 'a' : ('at',), 'o' : ('og', 'op') after S[0] = 'c';
     * heads = 'o' : ('og', 'op'), 't': ('t',) after S[0] = 'a';
     * heads = 'g' : ('g',), 'p': ('p',), 't': ('t',) after S[0] = 'o';
     * heads = 'p': ('p',), 't': ('t',) after S[0] = 'g';
     * <p>
     * Algorithm
     * ---------
     * Instead of a dictionary, we'll use an array heads of length 26, one entry for each letter of the alphabet.
     * For each letter in S, we'll take all the words waiting for that letter, and have them wait for the next letter
     * in that word. If we use the last letter of some word, it adds 1 to the answer.
     */
    public static int numMatchingSubsequencesOptimized(String S, String[] words) {
        int ans = 0;
        List<Node>[] heads = new ArrayList[26];
        for (int i = 0; i < 26; ++i)
            heads[i] = new ArrayList<>();

        for (String word : words)
            heads[word.charAt(0) - 'a'].add(new Node(word, 0));

        for (char c : S.toCharArray()) {
            List<Node> old_bucket = heads[c - 'a'];
            heads[c - 'a'] = new ArrayList<Node>();

            for (Node node : old_bucket) {
                node.index++;
                if (node.index == node.word.length()) {
                    ans++;
                }
                else {
                    heads[node.word.charAt(node.index) - 'a'].add(node);
                }
            }
            old_bucket.clear();
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        System.out.println(numMatchingSubsequences(s, words));
    }
}

class Node {
    String word;
    int index;

    public Node(String w, int i) {
        word = w;
        index = i;
    }
}