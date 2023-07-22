package strings;

/**
 * Reverse vowels in String
 */
public class ReverseVowels {

    private static String reverseVowels(String str) {
        char[] word = str.toCharArray();
        int start = 0;
        int end = str.length() - 1;
        String vowels = "aeiouAEIOU";

        while (start < end) {
            // Move start pointer until it points to a vowel
            while (start < end && vowels.indexOf(word[start]) == -1) {
                start++;
            }

            // Move end pointer until it points to a vowel
            while (start < end && vowels.indexOf(word[end]) == -1) {
                end--;
            }

            // Swap the vowels
            char temp = word[start];
            word[start] = word[end];
            word[end] = temp;

            // Move the pointers towards each other
            start++;
            end--;
        }

        return new String(word);
    }

    public static void main(String[] args) {
        String str = "leetcode";
        System.out.println(reverseVowels(str));
    }
}
