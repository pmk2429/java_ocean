package arrays.subs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices
 * of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 * <p>
 * Example 1:
 * ----------
 * Input:
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 * <p>
 * Example 2:
 * ----------
 * Input:
 * s = "wordgoodgoodgoodbestword",
 * words = ["word","good","best","word"]
 * Output: []
 */
public class SubstringConcatenation {
    public List<Integer> findSubstring(String s, String[] words) {

        int totalWords = words.length;

        List<Integer> ans = new ArrayList<>();
        if (totalWords == 0) {
            return ans;
        }

        Map<String, Integer> subStrMap = new HashMap<>();
        for (String word : words) {
            subStrMap.put(word, subStrMap.getOrDefault(word, 0) + 1);
        }

        int k = words[0].length() * totalWords;
        int inc = words[0].length();
        int n = s.length();

        for (int i = 0; i < n - k + 1; i++) { // Iterate through all windows
            Map<String, Integer> copy = new HashMap<>(subStrMap);
            int counter = copy.size();
            for (int j = i; j < i + k; j += inc) { // For each window, check if  each word is in the hashmap.
                String word = s.substring(j, j + inc);
                if (copy.containsKey(word)) {
                    if (copy.get(word) == 1) {
                        counter--;
                    }
                    copy.put(word, copy.get(word) - 1);
                }
            }
            if (counter == 0) {
                ans.add(i);
            }
        }

        return ans;
    }
}
