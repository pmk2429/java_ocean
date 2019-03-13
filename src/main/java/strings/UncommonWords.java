package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
    ArrayList<String> uncommonWords = new ArrayList<>();
    HashMap<String, Integer> wordsMap = new HashMap<>();
    for (int i = 0; i < aWords.length; i++) {
      if (wordsMap.containsKey(aWords[i])) {
        wordsMap.put(aWords[i], wordsMap.get(aWords[i]) + 1);
      } else {
        wordsMap.put(aWords[i], 1);
      }
    }

    for (int i = 0; i < bWords.length; i++) {
      if (wordsMap.containsKey(bWords[i])) {
        wordsMap.put(bWords[i], wordsMap.get(bWords[i]) + 1);
      } else {
        wordsMap.put(bWords[i], 1);
      }
    }

    for (Map.Entry<String, Integer> entryMap : wordsMap.entrySet()) {
      if (entryMap.getValue() == 1) {
        uncommonWords.add(entryMap.getKey());
      }
    }

    String[] stockArr = new String[uncommonWords.size()];
    stockArr = uncommonWords.toArray(stockArr);
    return stockArr;
  }

  public static void main(String[] args) {
    String a = "apple apple";
    String b = "banana";

    System.out.println(Arrays.toString(uncommonWords(a, b)));
  }
}
