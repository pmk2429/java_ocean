package strings;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * <p>
 * Example 1:
 * ----------
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * <p>
 * Example 2:
 * ----------
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 * <p>
 * Example 3:
 * ----------
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 * <p>
 * Example 4:
 * ----------
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 * <p>
 * Notes:
 * ------
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */
public class WordPattern {
    private static boolean wordPattern(String pattern, String str) {
        int patternLength = pattern.length();

        if (patternLength == 0 || str == null) {
            return false;
        }

        String[] words = str.split(" ");
        if (words.length != patternLength) {
            return false;
        }

        if (words.length == 1 && !words[0].equals(pattern)) {
            return true;
        }

        HashMap<Character, String> hm = new HashMap<>();

        for (int i = 0; i < patternLength; i++) {
            char a = pattern.charAt(i);
            String b = words[i];

            if (hm.containsKey(a) && !hm.get(a).equals(b) || !hm.containsKey(a) && hm.containsValue(b))
                return false;
            else
                hm.put(a, b);

        }

        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog cat cat dog";
        System.out.print(wordPattern(pattern, str));
    }
}
