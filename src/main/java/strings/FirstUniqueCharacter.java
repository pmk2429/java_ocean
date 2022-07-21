package strings;

import java.util.Hashtable;

/**
 * Given a string s, find the first non-repeating character in it and return its index.
 * If it does not exist, return -1.
 * <p>
 * Example 1:
 * ==========
 * Input: s = "leetcode"
 * Output: 0
 * <p>
 * Example 2:
 * ==========
 * Input: s = "loveleetcode"
 * Output: 2
 * <p>
 * Example 3:
 * ==========
 * Input: s = "aabb"
 * Output: -1
 * <p>
 * Constraints:
 * ==========
 * 1 <= s.length <= 105
 * s consists of only lowercase English letters.
 */
public class FirstUniqueCharacter {

    public static int firstUniqueChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        if (s.length() == 1) {
            return 0;
        }

        int firstUniqueIndex = -1;
        Hashtable<Character, Integer> charFreq = new Hashtable<>();
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            charFreq.put(currChar, charFreq.getOrDefault(currChar, 0) + 1);
        }

        System.out.println(charFreq);

        for (int i = 0; i < s.length(); i++) {
            if (charFreq.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return firstUniqueIndex;
    }

    public static char firstUniqueCharReturnChar(String s) {
        int[] charCount = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            charCount[c - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (charCount[chars[i] - 'a'] == 1) {
                return (char) i;
            }
        }
        return '\0';
    }

    public static int firstUniqueCharOptimized(String s) {
        int[] charCount = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            charCount[c - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (charCount[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s1 = "leetcode";
        System.out.println(firstUniqueCharOptimized(s1));
        String s2 = "loveleetcode";
        System.out.println(firstUniqueCharOptimized(s2));
        String s3 = "aabb";
        System.out.println(firstUniqueCharOptimized(s3));
    }
}
