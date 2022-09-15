package arrays;

import java.util.Arrays;

/**
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of
 * American keyboard like the image below.
 * <p>
 * Example:
 * ---------
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 */
public class KeyboardRow {

    private static String[] findWords(String[] words) {
        String firstRow = "qwertyuiop";
        String secondRow = "asdfghjkl";
        String thirdRow = "zxcvbnm";

        for (int i = 0; i < words.length; i++) {
            boolean validWord = true;
            String curWord = words[i].toLowerCase();
            String firstChar = curWord.substring(0, 1);
            int currLength = curWord.length();

            if (firstRow.contains(firstChar)) {
                for (int j = 1; j < currLength; j++) {
                    if (!firstRow.contains(String.valueOf(curWord.charAt(j)))) {
                        validWord = false;
                        break;
                    }
                }
            }
            else if (secondRow.contains(firstChar)) {
                for (int j = 1; j < currLength; j++) {
                    if (!secondRow.contains(String.valueOf(curWord.charAt(j)))) {
                        validWord = false;
                        break;
                    }
                }
            }
            else if (thirdRow.contains(firstChar)) {
                for (int j = 1; j < currLength; j++) {
                    if (!thirdRow.contains(String.valueOf(curWord.charAt(j)))) {
                        validWord = false;
                        break;
                    }
                }
            }
            if (!validWord) {
                words[i] = null;
            }
        }
        return words;
    }

    public static void main(String[] args) {
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        System.out.println(Arrays.toString(findWords(words)));
    }
}
