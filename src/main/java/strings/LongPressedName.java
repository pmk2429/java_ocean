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
    boolean isLongPressed = true;

    if (name.equals(typed)) {
      return true;
    }

    if (name.length() > 1000 || typed.length() > 1000) {
      return false;
    }

    // specify the frequency of chars in name
    char[] typedFreq = new char[256];
    for (int i = 0; i < typed.length(); i++) {
      int position = typed.charAt(i);
      typedFreq[position]++;
    }

    // now loop through the typed chars inorder to find their frequency
    char[] nameFreq = new char[256];
    for (int i = 0; i < name.length(); i++) {
      int position = name.charAt(i);
      nameFreq[position]++;
    }

    // compare two arrays and check if the frequency of chars in typed is more than or equal to that of named array
    for (int i = 0; i < 256; i++) {
      if (typedFreq[i] < nameFreq[i]) {
        isLongPressed = false;
        break;
      }
    }

    return isLongPressed;
  }

  public static void main(String[] args) {
    String name = "laiden";
    String typed = "laiden";
    System.out.println(isLongPressedName(name, typed));
  }
}
