package strings;

/**
 * Reverse vowels in String
 */
public class ReverseVowels {

    private static String reverseVowels(String str) {
        char[] res = str.toCharArray();
        int i = 0;
        int j = str.length() - 1;
        String vowels = "aeiouAEIOU";

        while (i < j) {
            // Move start pointer until it points to a vowel
            while (i < j && vowels.indexOf(res[i]) == -1) {
                i++;
            }

            // Move end pointer until it points to a vowel
            while (i < j && vowels.indexOf(res[j]) == -1) {
                j--;
            }

            // Swap the vowels
            char temp = res[i];
            res[i] = res[j];
            res[j] = temp;

            // Move the pointers towards each other
            i++;
            j--;
        }

        return String.valueOf(res);
    }

    public static void main(String[] args) {
        String str = "leetcode";
        System.out.println(reverseVowels(str));
    }
}
