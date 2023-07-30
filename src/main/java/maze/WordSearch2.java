package maze;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those
 * horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 * <p>
 * Example:
 * --------
 * Input:
 * board = [
 * ['o','a','a','n'],
 * ['e','t','a','e'],
 * ['i','h','k','r'],
 * ['i','f','l','v']
 * ]
 * words = ["oath","pea","eat","rain"]
 * <p>
 * Output: ["eat","oath"]
 */
public class WordSearch2 {

    private static int M;
    private static int N;

    private boolean outOfBounds(char[][] board, int x, int y) {
        return x < 0 || x >= board.length || y < 0 || y >= board[0].length;
    }

    private void recursiveFindWords(List<String> result, char[][] board, TrieNode parent, int x, int y) {
        // return if out of bounds, if visited and if current cell is a character in the trie
        if (outOfBounds(board, x, y) || board[x][y] == '#' || parent.children.get(board[x][y]) == null) {
            return;
        }

        char xy = board[x][y];

        TrieNode child = parent.children.get(xy);
        if (child.isEndOfWord) { // Found a word
            result.add(child.word);
            child.isEndOfWord = false; // Set false to avoid adding word to result multiple times
            // Don't RETURN since child.word can be a prefix of other words, e.g., 'ane' and 'aneis'
        }

        board[x][y] = '#'; // '#' marks a cell as visited

        recursiveFindWords(result, board, child, x, y - 1); // left
        recursiveFindWords(result, board, child, x - 1, y); // up
        recursiveFindWords(result, board, child, x, y + 1); // right
        recursiveFindWords(result, board, child, x + 1, y); // down

        board[x][y] = xy; // Set as unvisited since we are about to backtracking
    }

    // The trie is represented by a root node, not a Trie object
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            if (word == null || word.isEmpty()) {
                continue;
            }

            TrieNode parent = root;
            for (int i = 0; i < word.length(); i++) {
                char cur = word.charAt(i);
                TrieNode child = parent.children.get(cur);
                if (child == null) {
                    child = new TrieNode();
                    parent.children.put(cur, child);
                }
                parent = child;
            }

            parent.isEndOfWord = true;
            parent.word = word; // Store a word at the leaf node
        }

        return root;
    }
    private class TrieNode {
        boolean isEndOfWord; // this.word is null if isEndOfWord is false
        String word; // Store the word so that no StringBuilder is needed to build the word char by char
        Map<Character, TrieNode> children;
        TrieNode() {
            this.children = new HashMap<>();
        }

    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return result;
        }

        TrieNode root = buildTrie(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                recursiveFindWords(result, board, root, i, j);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'o', 'a', 'a', 'n'},
            {'e', 't', 'a', 'e'},
            {'i', 'h', 'k', 'r'},
            {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};

        M = board.length;
        N = board[0].length;
    }
}
