package strings;

/**
 * Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get
 * long pressed, and the character will be typed 1 or more times. You examine the typed characters of the keyboard.
 * Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.
 * <p>
 * Example 1:
 * ----------
 * Input: name = "alex", typed = "aaleex"
 * Output: true
 * Explanation: 'a' and 'e' in 'alex' were long pressed.
 * <p>
 * Example 2:
 * ----------
 * Input: name = "saeed", typed = "ssaaedd"
 * Output: false
 * Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
 * <p>
 * Example 3:
 * ----------
 * Input: name = "leelee", typed = "lleeelee"
 * Output: true
 * <p>
 * Example 4:
 * ----------
 * Input: name = "laiden", typed = "laiden"
 * Output: true
 * Explanation: It's not necessary to long press any character.
 * <p>
 * Note:
 * -----
 * name.length <= 1000
 * typed.length <= 1000
 * The characters of name and typed are lowercase letters.
 */
public class LongPressedName {

    private static boolean isLongPressedName(String name, String typed) {
        if (name.equals(typed)) {
            return true;
        }

        if (name.length() > 1000 || typed.length() > 1000) {
            return false;
        }

        int m = name.length(), n = typed.length();
        int i = 0, j = 0;

        while (i < m && j < n) {
            char c1 = name.charAt(i), c2 = typed.charAt(j);
            // we are handling different chars, no!
            if (c1 != c2) {
                return false;
            }

            // count of consecutive c1/c2
            int count1 = 0;
            while (i < m && name.charAt(i) == c1) {
                count1++;
                i++;
            }

            // count of consecutive c1/c2
            int count2 = 0;
            while (j < n && typed.charAt(j) == c2) {
                count2++;
                j++;
            }

            if (count2 < count1) {
                return false;
            }
        }

        // they both reach the end
        return i == m && j == n;
    }

    public static void main(String[] args) {
        String name = "leelee";
        String typed = "lleeelee";
        System.out.println(isLongPressedName(name, typed));
    }
}
