package matrix;

import java.util.*;

/**
 * Given a word of length n and n six-sided dice with a character in each side.
 * Find out if this word can be constructed by the set of given dice.
 * <p>
 * Example 1:
 * ----------
 * Input:
 * word = "hello"
 * dice = [[a, l, c, d, e, f], [a, b, c, d, e, f], [a, b, c, h, e, f], [a, b, c, d, o, f], [a, b, c, l, e, f]]
 * Output: true
 * Explanation: dice[2][3] + dice[1][4] + dice[0][1] + dice[4][3] + dice[3][4]
 * <p>
 * Example 2:
 * ----------
 * Input:
 * word = "hello"
 * dice = [[a, b, c, d, e, f], [a, b, c, d, e, f], [a, b, c, d, e, f], [a, b, c, d, e, f], [a, b, c, d, e, f]]
 * Output: false
 * <p>
 * Example 3:
 * ----------
 * Input:
 * word = "aaaa"
 * dice = [[a, a, a, a, a, a], [b, b, b, b, b, b], [a, b, c, d, e, f], [a, b, c, d, e, f]]
 * Output: false
 * <p>
 * Related to {@link trie.WordSearch} and {@link WordSearchMaze}.
 */
public class DicesWordSearch {

    /**
     * Perform DFS operation to expand deep into each node and it's neighbors recursively.
     */
    public static boolean isPossible(Map<Character, List<Integer>> graph, char[] target, int i, Set<Integer> visited) {
        if (i >= target.length) {
            return true;
        }

        List<Integer> neighbors = graph.getOrDefault(target[i], new ArrayList<>());

        for (int x : neighbors) {
            if (!visited.contains(x)) {
                visited.add(x);
                if (isPossible(graph, target, i + 1, visited)) {
                    return true;
                }
                visited.remove(x);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] dices = {
            {'l', 'l', 'c', 'd', 'e', 'f'},
            {'e', 'b', 'c', 'd', 'p', 'f'},
            {'a', 'w', 'c', 'h', 'e', 's'},
            {'a', 'b', 'c', 'd', 'o', 's'},
            {'n', 'i', 'c', 'l', 'e', 'f'}
        };

        int M = dices.length;
        int N = dices[0].length;

        String word = "lewis";

        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                // build graph with current char as a node and neighbors as LinkedList.
                char currChar = dices[i][j];
                List<Integer> adjacencyList = map.getOrDefault(currChar, new ArrayList<>());
                adjacencyList.add(i);
                map.put(currChar, adjacencyList);
            }
        }
        boolean ans = isPossible(map, word.toCharArray(), 0, new HashSet<>());
        System.out.println(ans);
    }

}
