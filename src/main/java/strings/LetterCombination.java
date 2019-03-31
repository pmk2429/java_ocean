package strings;

import java.util.*;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is described as the one in old number pad on phones.
 * Note that 1 does not map to any letters
 * <p>
 * Example:
 * --------
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * <p>
 * Note:
 * -----
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombination {
  // Classic substring problem
  private static List<String> letterCombinations(String num) {
    Set<String> combos = new TreeSet<>();
    Map<Integer, String> code = new HashMap<>();
    code.put(2, "abc");
    code.put(3, "def");
    code.put(4, "ghi");
    code.put(5, "jkl");
    code.put(6, "mno");
    code.put(7, "pqrs");
    code.put(8, "tuv");
    code.put(9, "wxyz");

    char[] digits = num.toCharArray();
    String s1 = code.get(digits[0] - 48);
    String s2 = code.get(digits[1] - 48);

    for (int c = 0; c < s1.length(); c++) {
      for (int i = 0; i < s2.length(); i++) {
        String sub = String.valueOf(s1.charAt(c)) + String.valueOf(s2.charAt(i));
        combos.add(sub);
      }
    }
    return new ArrayList<>(combos);
  }

  public static void main(String[] args) {
    String str = "23";
    System.out.println(letterCombinations(str));
  }
}
