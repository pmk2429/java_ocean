package strings;

/**
 * Reverse vowels in String
 */
public class ReverseVowels {

    private static String reverseVowels(String str) {
        char[] letters = str.toCharArray();
        String vowels = "aeiou";
        int i = 0;
        int j = str.length() - 1;
        while (i <= j) {
            if (vowels.indexOf(Character.toLowerCase(str.charAt(i))) != -1) {
                char temp = str.charAt(i);
                letters[i] = letters[j];
                letters[j] = temp;
                i++;
                j--;
            }
            else {
                letters[i] = str.charAt(i);
                i++;
            }
        }
        return String.valueOf(letters);
    }

    public static void main(String[] args) {
        String str = "leetcode";
        System.out.println(reverseVowels(str));
    }
}
