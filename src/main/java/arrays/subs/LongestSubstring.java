package arrays.subs;

import java.util.ArrayList;

/**
 * LongestSubstring class is used to find the longest substring without
 * repeating characters in the string.
 *
 * @author Pavitra
 */

public class LongestSubstring {
    /**
     * findLongestDistinctString() is used to find the longest string in the
     * given string.
     *
     * @param str
     * @return the longest distinct substring
     */
    private static String findLongestDistinctSubString(String str) {
        ArrayList<Character> subStrList = new ArrayList<>();
        StringBuilder unique = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            if (subStrList.contains(currChar)) {
                if (Character.isWhitespace(currChar)) {
                    subStrList.add(currChar);
                }
                else {
                    break;
                }
            }
            else {
                subStrList.add(str.charAt(i));
            }
            unique.append(subStrList.get(i).toString());
        }
        return unique.toString();
    }

    public static void main(String[] args) {
        // String str = "a b c def ghi jkl mno pqrstu vw xyz";
        String str = "the quick brown fox";
        System.out.println(findLongestDistinctSubString(str));
    }
}
