package strings;

/**
 * Given an array of characters chars, compress it using the following algorithm:
 * Begin with an empty string s. For each group of consecutive repeating characters in chars:
 * If the group's length is 1, append the character to s.
 * Otherwise, append the character followed by the group's length.
 * The compressed string s should not be returned separately, but instead, be stored in the input character array chars.
 * Note that group lengths that are 10 or longer will be split into multiple characters in chars.
 * After you are done modifying the input array, return the new length of the array.
 * You must write an algorithm that uses only constant extra space.
 * <p>
 * Example 1:
 * ----------
 * Input: chars = ["a","a","b","b","c","c","c"]
 * Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 * Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
 * <p>
 * Example 2:
 * ----------
 * Input: chars = ["a"]
 * Output: Return 1, and the first character of the input array should be: ["a"]
 * Explanation: The only group is "a", which remains uncompressed since it's a single character.
 * <p>
 * Example 3:
 * ----------
 * Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
 * Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
 * <p>
 * Constraints:
 * ------------
 * 1 <= chars.length <= 2000
 * chars[i] is a lowercase English letter, uppercase English letter, digit, or symbol.
 */
public class CompressString {

    private static int compress(char[] chars) {
        int i = 0, res = 0;
        int length = chars.length;
        // i takes care of each individual and unique characters only
        while (i < length) {
            int groupLength = 1;
            while (i + groupLength < length && chars[i + groupLength] == chars[i]) {
                groupLength++;
            }
            chars[res++] = chars[i];
            if (groupLength > 1) { // for cases with multiple digits group length, we need to split the chars
                char[] groupLengthChars = Integer.toString(groupLength).toCharArray();
                for (char c : groupLengthChars) {
                    chars[res++] = c;
                }
            }
            i += groupLength;
        }
        return res;
    }

    public static void main(String[] args) {
        char[] chars1 = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(compress(chars1));
        char[] chars2 = {'a'};
        System.out.println(compress(chars2));
        char[] chars3 = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        System.out.println(compress(chars3));
    }
}
