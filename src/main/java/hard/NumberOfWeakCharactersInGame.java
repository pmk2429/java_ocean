package hard;

import java.util.Arrays;

/**
 * You are playing a game that contains multiple characters, and each of the characters has two main properties:
 * attack and defense. You are given a 2D integer array properties where properties[i] = [attacki, defensei]
 * represents the properties of the ith character in the game.
 * <p>
 * A character is said to be weak if any other character has both attack and defense levels strictly greater than
 * this character's attack and defense levels. More formally, a character i is said to be weak if there exists
 * another character j where attackj > attacki and defensej > defensei.
 * <p>
 * Return the number of weak characters.
 * <p>
 * Example 1:
 * ----------
 * Input: properties = [[5,5],[6,3],[3,6]]
 * Output: 0
 * Explanation: No character has strictly greater attack and defense than the other.
 * <p>
 * Example 2:
 * ----------
 * Input: properties = [[2,2],[3,3]]
 * Output: 1
 * Explanation: The first character is weak because the second character has a strictly greater attack and defense.
 * <p>
 * Example 3:
 * ----------
 * Input: properties = [[1,5],[10,4],[4,3]]
 * Output: 1
 * Explanation: The third character is weak because the second character has a strictly greater attack and defense.
 */
public class NumberOfWeakCharactersInGame {
    private static int numberOfWeakCharacters(int[][] properties) {
        // Sort in ascending order of attack,
        // If attack is same sort in descending order of defense
        Arrays.sort(properties, (a, b) -> (a[0] == b[0]) ? (b[1] - a[1]) : a[0] - b[0]);

        int weakCharacters = 0;
        int maxDefense = 0;
        for (int i = properties.length - 1; i >= 0; i--) {
            // Compare the current defense with the maximum achieved so far
            int currDefense = properties[i][1];
            if (currDefense < maxDefense) {
                weakCharacters++;
            }
            maxDefense = Math.max(maxDefense, currDefense);
        }

        return weakCharacters;
    }

    public static void main(String[] args) {
        int[][] properties = {{1, 5}, {10, 4}, {4, 3}};
        System.out.println(numberOfWeakCharacters(properties));
    }
}
