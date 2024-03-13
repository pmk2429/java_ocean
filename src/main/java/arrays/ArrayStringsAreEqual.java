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
    private static boolean arrayStringsAreEqual(String[] firstWordArr, String[] secondWordArr) {
        int w1 = 0;
        int w2 = 0;
        int c1 = 0;
        int c2 = 0;
        int word1Length = firstWordArr.length;
        int word2Length = secondWordArr.length;

        while (w1 < word1Length && w2 < word2Length) {
            if (firstWordArr[w1].charAt(c1++) != secondWordArr[w2].charAt(c2++)) {
                return false;
            }

            // reset character pointer and increment the word pointer to point to next pointer in the Array
            if (c1 == firstWordArr[w1].length()) {
                w1++;
                c1 = 0;
            }

            // reset character pointer and increment the word pointer to point to next pointer in the Array
            if (c2 == secondWordArr[w2].length()) {
                w2++;
                c2 = 0;
            }
        }

        return w1 == word1Length && w2 == word2Length;
    }

    public static void main(String[] args) {
        String[] word1 = {"a", "cb"}, word2 = {"ab", "c"};
        System.out.println(arrayStringsAreEqual(word1, word2));
    }
}
