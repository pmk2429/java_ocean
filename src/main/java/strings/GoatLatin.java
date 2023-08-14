package strings;

/**
 * A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.
 * <p>
 * We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
 * The rules of Goat Latin are as follows:
 * 1. If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
 * For example, the word 'apple' becomes 'applema'.
 * 2. If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add
 * "ma".
 * For example, the word "goat" becomes "oatgma".
 * 3. Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
 * For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
 * Return the final sentence representing the conversion from S to Goat Latin.
 * <p>
 * Example 1:
 * ----------
 * Input: "I speak Goat Latin"
 * Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * <p>
 * Example 2:
 * ----------
 * Input: "The quick brown fox jumped over the lazy dog"
 * Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 * <p>
 * Notes:
 * ------
 * S contains only uppercase, lowercase and spaces. Exactly one space between each word.
 * 1 <= S.length <= 150.
 */
public class GoatLatin {

    private static String getMaaString(int n) {
        StringBuilder ma = new StringBuilder();
        ma.append("ma");
        for (int i = 0; i <= n; i++) {
            ma.append("a");
        }
        return ma.toString();
    }

    private static String toGoatLatin(String str) {
        StringBuilder sb = new StringBuilder();
        String[] words = str.trim().split(" ");
        String vowels = "aeiou";

        for (int i = 0; i < words.length; i++) {
            String curWord = words[i];
            String curr;
            char firstChar = curWord.charAt(0);
            // check if current word starts with vowel
            if (vowels.indexOf(Character.toLowerCase(firstChar)) != -1) {
                curr = curWord + getMaaString(i);
            }
            else { // String starts with consonant
                curr = curWord.substring(1) + firstChar + getMaaString(i);
            }
            sb.append(curr).append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "I speak Goat Latin";
        String str2 = "The quick brown fox jumped over the lazy dog";
        System.out.println(toGoatLatin(str));
        System.out.println(toGoatLatin(str2));
    }
}
