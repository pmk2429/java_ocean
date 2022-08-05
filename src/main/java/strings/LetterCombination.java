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

    private final static Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    private final static List<String> output = new ArrayList<>();

    private static void backtrack(String combination, String nextDigits) {
        // if there is no more digits to check
        if (nextDigits.length() == 0) {
            // the combination is done
            output.add(combination);
        }
        else { // if there are still digits to check
            // iterate over all letters which map the next available digit
            String digit = nextDigits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                // append the current letter to the combination and proceed to the next digits
                backtrack(combination + letter, nextDigits.substring(1));
            }
        }
    }

    private static List<String> letterCombinations(String digits) {
        if (digits.length() != 0) {
            backtrack("", digits);
        }
        return output;
    }

    // Classic substring problem
    private static List<String> letterCombinationsSubstr(String num) {
        Set<String> combos = new TreeSet<>();

        String s1 = phone.get(num.substring(0, 1));
        String s2 = phone.get(num.substring(1));

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                String sub = String.valueOf(s1.charAt(i)) + String.valueOf(s2.charAt(j));
                combos.add(sub);
            }
        }
        return new ArrayList<>(combos);
    }

    public static void main(String[] args) {
        String str = "23";
        System.out.println(letterCombinationsSubstr(str));
    }
}
