package slidingWindow;

/**
 * You are given the string croakOfFrogs, which represents a combination of the string "croak" from different frogs,
 * that is, multiple frogs can croak at the same time, so multiple "croak" are mixed.
 * Return the minimum number of different frogs to finish all the croaks in the given string.
 * A valid "croak" means a frog is printing five letters 'c', 'r', 'o', 'a', and 'k' sequentially.
 * The frogs have to print all five letters to finish a croak. If the given string is not a combination of a
 * valid "croak" return -1.
 * <p>
 * Example 1:
 * ----------
 * Input: croakOfFrogs = "croakcroak"
 * Output: 1
 * Explanation: One frog yelling "croak" twice.
 * <p>
 * Example 2:
 * ----------
 * Input: croakOfFrogs = "crcoakroak"
 * Output: 2
 * Explanation: The minimum number of frogs is two.
 * The first frog could yell "crcoakroak".
 * The second frog could yell later "crcoakroak".
 * <p>
 * Example 3:
 * ----------
 * Input: croakOfFrogs = "croakcrook"
 * Output: -1
 * Explanation: The given string is an invalid combination of "croak" from different frogs.
 * <p>
 * Constraints:
 * ------------
 * 1 <= croakOfFrogs.length <= 105
 * croakOfFrogs is either 'c', 'r', 'o', 'a', or 'k'.
 */
public class FrogsCroaking {
    // check string validity
    private static boolean isValid(char c, int[] charFreq) {
        char prevChar;
        if (c == 'r') prevChar = 'c';
        else if (c == 'o') prevChar = 'r';
        else if (c == 'a') prevChar = 'o';
        else prevChar = 'a';

        return charFreq[prevChar - 'a'] >= charFreq[c - 'a'];
    }

    public static int minNumberOfFrogs(String croakOfFrogs) {
        int[] charFreq = new int[26];
        int count = 0;
        int maxCount = 0;

        for (char c : croakOfFrogs.toCharArray()) {
            charFreq[c - 'a']++;
            // deduce boundary count
            if (c == 'c') { // left boundary
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                if (!isValid(c, charFreq)) return -1;
                if (c == 'k') { // right boundary
                    count--;
                }
            }
        }
        // check if the string is finished
        return count == 0 ? maxCount : -1;
    }

    public static void main(String[] args) {
        System.out.println(minNumberOfFrogs("croakcroak"));
        System.out.println(minNumberOfFrogs("crcoakroak"));
        System.out.println(minNumberOfFrogs("croakcrook"));
    }
}
