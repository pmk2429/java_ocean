package trie;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Design an algorithm that accepts a stream of characters and checks if a suffix of these characters is a string of
 * a given array of strings words.
 * For example, if words = ["abc", "xyz"] and the stream added the four characters (one by one) 'a', 'x', 'y', and
 * 'z', your algorithm should detect that the suffix "xyz" of the characters "axyz" matches "xyz" from words.
 * <p>
 * Implement the StreamChecker class:
 * ----------------------------------
 * StreamChecker(String[] words) Initializes the object with the strings array words.
 * boolean query(char letter) Accepts a new character from the stream and returns true if any non-empty suffix from
 * the stream forms a word that is in words.
 * <p>
 * Example 1:
 * ---------
 * Input
 * ["StreamChecker", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query"]
 * [[["cd", "f", "kl"]], ["a"], ["b"], ["c"], ["d"], ["e"], ["f"], ["g"], ["h"], ["i"], ["j"], ["k"], ["l"]]
 * Output
 * [null, false, false, false, true, false, true, false, false, false, false, false, true]
 * <p>
 * Explanation
 * -----------
 * StreamChecker streamChecker = new StreamChecker(["cd", "f", "kl"]);
 * streamChecker.query("a"); // return False
 * streamChecker.query("b"); // return False
 * streamChecker.query("c"); // return False
 * streamChecker.query("d"); // return True, because 'cd' is in the wordlist
 * streamChecker.query("e"); // return False
 * streamChecker.query("f"); // return True, because 'f' is in the wordlist
 * streamChecker.query("g"); // return False
 * streamChecker.query("h"); // return False
 * streamChecker.query("i"); // return False
 * streamChecker.query("j"); // return False
 * streamChecker.query("k"); // return False
 * streamChecker.query("l"); // return True, because 'kl' is in the wordlist
 * <p>
 * Constraints:
 * ------------
 * 1 <= words.length <= 2000
 * 1 <= words[i].length <= 200
 * words[i] consists of lowercase English letters.
 * letter is a lowercase English letter.
 * At most 4 * 104 calls will be made to query.
 */
public class StreamChecker {

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap();
        boolean word = false;
    }

    TrieNode trie = new TrieNode();
    Deque<Character> stream = new ArrayDeque<>();

    public StreamChecker(String[] words) {
        for (String word : words) {
            TrieNode node = trie;
            String reversedWord = new StringBuilder(word).reverse().toString();
            for (char ch : reversedWord.toCharArray()) {
                if (!node.children.containsKey(ch)) {
                    node.children.put(ch, new TrieNode());
                }
                node = node.children.get(ch);
            }
            node.word = true;
        }
    }

    public boolean query(char letter) {
        stream.addFirst(letter);

        TrieNode node = trie;
        for (char ch : stream) {
            if (node.word) {
                return true;
            }
            if (!node.children.containsKey(ch)) {
                return false;
            }
            node = node.children.get(ch);
        }
        return node.word;
    }

    public static void main(String[] args) {
        StreamChecker streamChecker = new StreamChecker(new String[]{"cd", "f", "kl"});
        streamChecker.query('a'); // return False
        streamChecker.query('b'); // return False
        streamChecker.query('c'); // return False
        streamChecker.query('d'); // return True, because 'cd' is in the wordlist
        streamChecker.query('e'); // return False
        streamChecker.query('f'); // return True, because 'f' is in the wordlist
        streamChecker.query('g'); // return False
        streamChecker.query('h'); // return False
        streamChecker.query('i'); // return False
        streamChecker.query('j'); // return False
        streamChecker.query('k'); // return False
        streamChecker.query('l'); // return True, because 'kl' is in the wordlist

    }
}
