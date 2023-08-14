package strings;

/**
 * Reverse vowels in String
 */
public class ReverseVowels {

    private static String reverseVowels(String str) {
        char[] word = str.toCharArray();
        int i = 0;
        int j = str.length() - 1;
        String vowels = "aeiouAEIOU";

        while (i < j) {
            // Move start pointer until it points to a vowel
            while (i < j && vowels.indexOf(word[i]) == -1) {
                i++;
            }

            // Move end pointer until it points to a vowel
            while (i < j && vowels.indexOf(word[j]) == -1) {
                j--;
            }

            // Swap the vowels
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;

            // Move the pointers towards each other
            i++;
            j--;
        }

        return new String(word);
    }

    public static void main(String[] args) {
        String str = "leetcode";
        System.out.println(reverseVowels(str));
    }
}
