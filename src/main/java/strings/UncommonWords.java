package strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * We are given two sentences A and B. (A sentence is a string of space separated words.
 * Each word consists only of lowercase letters.) A word is uncommon if it appears exactly once in one of the
 * sentences, and does not appear in the other sentence. Return a list of all uncommon words.
 * You may return the list in any order.
 * <p>
 * Example 1:
 * -----------
 * Input: A = "this apple is sweet", B = "this apple is sour"
 * Output: ["sweet","sour"]
 * <p>
 * Example 2:
 * -----------
 * Input: A = "apple apple", B = "banana"
 * Output: ["banana"]
 * <p>
 * Note:
 * -----
 * 0 <= A.length <= 200
 * 0 <= B.length <= 200
 * A and B both contain only spaces and lowercase letters.
 */
public class UncommonWords {

    private static String[] uncommonWords(String a, String b) {
        String[] aWords = a.split(" ");
        String[] bWords = b.split(" ");
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String aWord : aWords) {
            wordsMap.put(aWord, wordsMap.getOrDefault(aWord, 0) + 1);
        }

        for (String bWord : bWords) {
            wordsMap.put(bWord, wordsMap.getOrDefault(bWord, 0) + 1);
        }

        List<String> uncommonWords = wordsMap.entrySet()
            .stream()
            .filter(entry -> entry.getValue() == 1)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());

        /*
        Set<String> uncommonWords = wordsMap.entrySet().stream()
            .filter(entryMap -> entryMap.getValue() == 1)
            .map(Map.Entry::getKey)
            .collect(Collectors.toSet());
         */

        return uncommonWords.toArray(String[]::new);
    }

    public static void main(String[] args) {
        String a = "apple apple";
        String b = "banana";

        System.out.println(Arrays.toString(uncommonWords(a, b)));
    }
}
