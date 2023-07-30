package strings;

/**
 * Given two strings S and T, return if they are equal when both are typed into empty text editors.
 * # means a backspace character.
 * <p>
 * Example 1:
 * ----------
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * <p>
 * Example 2:
 * ----------
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * <p>
 * Example 3:
 * ----------
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * <p>
 * Example 4:
 * ----------
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 * Note:
 * <p>
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 */
public class BackspaceCompare {
    private static boolean backspaceCompare(String S, String T) {
        StringBuilder sSb = new StringBuilder();
        StringBuilder tSb = new StringBuilder();

        if (S == null || T == null) {
            return false;
        }

        if (S.length() < 1 || S.length() > 200) {
            return false;
        }

        if (T.length() < 1 || T.length() > 200) {
            return false;
        }

        String pattern = ".*[A-Z].*";
        if (S.matches(pattern) || T.matches(pattern)) {
            return false;
        }

        for (int i = 0; i < S.length(); i++) {
            char curChar = S.charAt(i);
            if (curChar != '#') {
                sSb.append(curChar);
            }
            else {
                // curr char is '#' and so subString/decrease length of the current String
                if (sSb.length() > 0) {
                    sSb.deleteCharAt(sSb.length() - 1);
                }
            }
        }

        for (int i = 0; i < T.length(); i++) {
            char curChar = T.charAt(i);
            if (curChar != '#') {
                tSb.append(curChar);
            }
            else {
                if (tSb.length() > 0) {
                    tSb.deleteCharAt(tSb.length() - 1);
                }
            }
        }

        return sSb.toString().equals(tSb.toString());
    }

    public static void main(String[] args) {
        String s1 = "a##c";
        String s2 = "#a#c";
        System.out.println("Equal in Text Editor ? " + backspaceCompare(s1, s2));
    }
}
