package strings;

import java.util.*;

public class ReverseString {
    /**
     * reverseWholeString() method will take a String as an input and will
     * reverse the entire string character by character. For eg: inputString: my
     * name is pavitra kansara arasnak artivap si eman ym.
     *
     * @param inputString
     * @return
     */
    private static String reverseWholeString(String inputString) {
        StringBuilder reversed = new StringBuilder();
        int length = inputString.length();
        for (int i = length - 1; i >= 0; i--) {
            reversed.append(inputString.charAt(i));
        }
        return reversed.toString();
    }

    /**
     * reverseWordsinString() method will reverse each word in the string
     * <p>
     * For eg: input String: my name is pavitra kasnara output String: ym eman
     * si artivap aransak
     * <p>
     * So this method will call the reverseString method for each word in the
     * String.
     *
     * @param inputString
     * @return
     */
    private static String reverseWordsInString(String inputString) {
        String[] words = inputString.split(" ");
        StringBuilder sb = new StringBuilder();
        String[] reversedWords = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            reversedWords[i] = reverseWholeString(words[i]);
            sb.append(reversedWords[i]).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("Enter the string to reverse:");
        System.out.print("> ");
        Scanner input = new Scanner(System.in);
        String inputString = input.nextLine();
        input.close();

        // reverse entire string
        System.out.println(reverseWholeString(inputString));

        // reverse words in string
        System.out.println(reverseWordsInString(inputString));
    }
}
