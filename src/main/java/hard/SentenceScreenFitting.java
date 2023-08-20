package hard;

/**
 * Given a rows x cols screen and a sentence represented as a list of strings, return the number of times the given
 * sentence can be fitted on the screen.
 * The order of words in the sentence must remain unchanged, and a word cannot be split into two lines. A single
 * space must separate two consecutive words in a line.
 * <p>
 * Example 1:
 * ----------
 * Input: sentence = ["hello","world"], rows = 2, cols = 8
 * Output: 1
 * <p>
 * Explanation:
 * ------------
 * hello---
 * world---
 * The character '-' signifies an empty space on the screen.
 * <p>
 * Example 2:
 * ----------
 * Input: sentence = ["a", "bcd", "e"], rows = 3, cols = 6
 * Output: 2
 * Explanation:
 * ------------
 * a-bcd-
 * e-a---
 * bcd-e-
 * The character '-' signifies an empty space on the screen.
 * <p>
 * Example 3:
 * ----------
 * Input: sentence = ["i","had","apple","pie"], rows = 4, cols = 5
 * Output: 1
 * Explanation:
 * i-had
 * apple
 * pie-i
 * had--
 * The character '-' signifies an empty space on the screen.
 * <p>
 * Constraints:
 * ------------
 * 1 <= sentence.length <= 100
 * 1 <= sentence[i].length <= 10
 * sentence[i] consists of lowercase English letters.
 * 1 <= rows, cols <= 2 * 104
 */
public class SentenceScreenFitting {
    private static int wordsTyping(String[] sentence, int rows, int cols) {
        int count = 0;
        int rowIndex = 0;
        int i = 0;
        int spaces = cols;
        int totalWords = sentence.length;
        while (rowIndex < rows) {
            String currWord = sentence[i];
            int currWordLength = currWord.length();
            if (currWordLength <= spaces) {
                spaces -= currWordLength;
                spaces--; //-1 means extra'-'
                i++;
            }
            else {
                rowIndex++;
                spaces = cols;
            }
            // if all words in sentences are traversed, reset wordIndex; `i` and increase count
            if (i == totalWords) {
                count++;
                i = 0;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] sentence = {"hello", "world"};
        int rows = 2, cols = 8;
        System.out.println(wordsTyping(sentence, rows, cols));
    }
}
