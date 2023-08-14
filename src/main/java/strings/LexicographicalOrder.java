package strings;

/**
 * Lexicographically the largest string possible consisting of at most K consecutive similar characters.
 * Given a string S and an integer K, the task is to generate lexicographically the largest string possible from the
 * given string, by removing characters also, that consists of at most K consecutive similar characters.
 * <p>
 * Example 1:
 * ---------
 * Input: S = “baccc”, K = 2
 * Output: ccbca
 * <p>
 * Example 2:
 * ----------
 * Input: S = “ccbbb”, K = 2
 * Output: ccbb
 */
public class LexicographicalOrder {

    private static final int MAX_CHAR = 26;

    private static String newString(String originalLabel, int charLimit) {
        int n = originalLabel.length();
        // Stores the frequency of characters
        int[] charCount = new int[MAX_CHAR];

        for (char c : originalLabel.toCharArray()) {
            charCount[c - 'a']++;
        }

        StringBuilder newString = new StringBuilder(n);

        for (int i = MAX_CHAR - 1; i >= 0; i--) {
            int count = 0;
            while (charCount[i] > 0) {
                newString.append((char) (i + 'a'));
                // Decrease count in charset
                charCount[i]--;
                // Increase count
                count++;
                // Check if count reached to charLimit
                if (charCount[i] > 0 && count == charLimit) {
                    // Find nearest lower char
                    Character next = nextAvailableChar(charCount, i);
                    // If no character can be appended
                    if (next == null) {
                        return newString.toString();
                    }
                    // Append nearest lower character
                    newString.append(next);
                    // Reset count for next calculation
                    count = 0;
                }
            }
        }

        // Return new largest string
        return newString.toString();
    }

    // Function to return nearest lower character
    private static Character nextAvailableChar(int[] charset, int start) {
        for (int i = start - 1; i >= 0; i--) {
            if (charset[i] > 0) {
                charset[i]--;
                return (char) (i + 'a');
            }
        }

        // if no character can be appended
        return null;
    }

    // Driver Code
    public static void main(String[] args) {
        String S = "azzzzz";
        int K = 2;
        System.out.println(newString(S, K));
        String S1 = "azzxxx";
        int K1 = 2;
        System.out.println(newString(S1, K1));
    }
}
