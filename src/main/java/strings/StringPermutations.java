package strings;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Pavitra
 */
public class StringPermutations {

    private static String swap(String a, int i, int j) {
        char[] charArray = a.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    private static void permute(String str, int l, int r) {
        if (l == r) {
            // print or add to list
            System.out.println(str);
        }
        else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    /**
     * Method to get all permutations of a given String.
     *
     * @param str
     * @return
     */
    private static Set<String> stringPermutation(String str) {
        Set<String> result = new HashSet<>();
        if (str == null) {
            return null;
        }
        else if (str.length() == 0) {
            result.add("");
            return result;
        }

        char firstChar = str.charAt(0);
        String rem = str.substring(1);
        Set<String> words = stringPermutation(rem);
        for (String newString : words) {
            for (int i = 0; i <= newString.length(); i++) {
                result.add(addChar(newString, firstChar, i));
            }
        }
        return result;
    }

    /**
     * Method to add a char to a given String.
     *
     * @param str
     * @param c
     * @param j
     * @return
     */
    private static String addChar(String str, char c, int j) {
        String first = str.substring(0, j);
        String last = str.substring(j);
        return first + c + last;
    }

    public static void main(String[] args) {
        String str = "ABC";
        int n = str.length();
        permute(str, 0, n - 1);
    }
}
