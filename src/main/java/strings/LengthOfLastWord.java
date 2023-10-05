package strings;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * <p>
 * Example:
 * --------
 * Input: "Hello World"
 * Output: 5
 */
public class LengthOfLastWord {

    private static int lengthOfLastWord(String str) {
        if (HanaStringUtils.isNullOrEmpty(str)) {
            return 0;
        }

        // trim whitespaces
        str = str.trim();

        // String[] words = str.split(" ");
        // int wordsLength = words.length;
        // return words[wordsLength - 1].length()

        int lastWordLength = 0;
        int length = str.length();
        for (int i = length - 1; i >= 0 && str.charAt(i) != ' '; i--) {
            if (str.charAt(i) == '.') {
                continue;
            }
            lastWordLength++;
        }

        return lastWordLength;
    }


    public static void main(String[] args) {
        String str = "Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the " +
            "length of last word in the universe.";
        System.out.println(lengthOfLastWord(str));
    }
}
