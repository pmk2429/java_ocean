package arrays;

/**
 * Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.
 * A string is represented by an array if the array elements concatenated in order forms the string.
 * <p>
 * Example 1:
 * ----------
 * Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
 * Output: true
 * Explanation:
 * word1 represents string "ab" + "c" -> "abc"
 * word2 represents string "a" + "bc" -> "abc"
 * The strings are the same, so return true.
 * <p>
 * Example 2:
 * ----------
 * Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
 * Output: false
 * <p>
 * Example 3:
 * ----------
 * Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
 * Output: true
 * <p>
 * Constraints:
 * ------------
 * 1 <= word1.length, word2.length <= 103
 * 1 <= word1[i].length, word2[i].length <= 103
 * 1 <= sum(word1[i].length), sum(word2[i].length) <= 103
 * word1[i] and word2[i] consist of lowercase letters.
 */
public class ArrayStringsAreEqual {
    private static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int word1Pointer = 0;
        int word2Pointer = 0;
        int char1Pointer = 0;
        int char2Pointer = 0;
        int word1Length = word1.length;
        int word2Length = word2.length;

        while (word1Pointer < word1Length && word2Pointer < word2Length) {
            if (word1[word1Pointer].charAt(char1Pointer++) != word2[word2Pointer].charAt(char2Pointer++)) {
                return false;
            }

            // reset character pointer and increment the word pointer to point to next pointer in the Array
            if (char1Pointer == word1[word1Pointer].length()) {
                word1Pointer++;
                char1Pointer = 0;
            }

            // reset character pointer and increment the word pointer to point to next pointer in the Array
            if (char2Pointer == word2[word2Pointer].length()) {
                word2Pointer++;
                char2Pointer = 0;
            }
        }

        return word1Pointer == word1Length && word2Pointer == word2Length;
    }

    public static void main(String[] args) {
        String[] word1 = {"a", "cb"}, word2 = {"ab", "c"};
        System.out.println(arrayStringsAreEqual(word1, word2));
    }
}
