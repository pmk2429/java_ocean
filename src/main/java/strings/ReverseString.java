package strings;

import java.util.Scanner;

public class ReverseString {
    /**
     * reverseWholeString() method will take a String as an input and will
     * reverse the entire string character by character. For eg: inputString: my
     * name is pavitra kansara arasnak artivap si eman ym.
     */
    private static String reverseWholeString(String inputString) {
        inputString = inputString.trim();
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
     */
    private static String reverseWordsInString(String inputString) {
        String[] words = inputString.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            String reversedString = reverseWholeString(word);
            sb.append(reversedString).append(" ");
        }
        return sb.toString();
    }

    /**
     * Example 1:
     * ----------
     * Input: s = "the sky is blue"
     * Output: "blue is sky the"
     * <p>
     * Example 2:
     * ----------
     * Input: s = "  hello world  "
     * Output: "world hello"
     * Explanation: Your reversed string should not contain leading or trailing spaces.
     * <p>
     * Example 3:
     * ----------
     * Input: s = "a good   example"
     * Output: "example good a"
     * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
     */
    private static String reverseOrderOfWordsInString(String inputString) {
        // Trim the input string to remove leading and trailing spaces
        String[] words = inputString.trim().split("\\s+");

        // Initialize the output string
        StringBuilder result = new StringBuilder();

        // Iterate through the words in reverse order
        for (int i = words.length - 1; i >= 0; i--) {
            // Append the current word and a space to the output
            result.append(words[i]).append(" ");
        }

        // Append the first word to the output (without trailing space)
        return result.toString();
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

        // reverse order of words and remove whitespaces in string
        System.out.println(reverseOrderOfWordsInString(inputString));
    }
}
