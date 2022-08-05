package arrays.subs;

import java.util.ArrayList;
import java.util.List;

/**
 * LongestSubstring class is used to find the longest substring without
 * repeating characters in the string.
 *
 * @author Pavitra
 */

public class LongestSubstring {

    private static String findLongestDistinctSubString(String str) {
        List<Character> subStrList = new ArrayList<>();
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
                subStrList.add(currChar);
            }
            unique.append(subStrList.get(i).toString());
        }
        return unique.toString();
    }

    public static void main(String[] args) {
        String str = "a b c def ghi jkl mno pqrstu vw xyz";
        String strm = "the quick brown fox";
        System.out.println(findLongestDistinctSubString(str));
        System.out.println(findLongestDistinctSubString(strm));
    }
}
