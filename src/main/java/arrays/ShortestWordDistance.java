package arrays;

/**
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 * <p>
 * Example:
 * --------
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * Input: word1 = “coding”, word2 = “practice”
 * Output: 3
 * <p>
 * Input: word1 = "makes", word2 = "coding"
 * Output: 1
 * <p>
 * Note:
 * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
public class ShortestWordDistance {

    private static int shortestDistance(String[] words, String word1, String word2) {
        // 1. Break down problem into shortest possible abstraction
        // 2. Solve that unit piece using algorithm
        // 3. Extend algorithm to entire problem space
        // 4. Mind edges
        // 5. Test solution
        // 6. Optimize

        int shortestDistance = words.length;
        int i1 = -1, i2 = -1;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                i1 = i;
            }
            else if (words[i].equals(word2)) {
                i2 = i;
            }
            if (i1 != -1 && i2 != -1) {
                shortestDistance = Math.min(shortestDistance, Math.abs(i2 - i1));
            }
        }

        return shortestDistance;
    }

    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "coding";
        String word2 = "practice";
        System.out.println(shortestDistance(words, word1, word2));
    }
}
