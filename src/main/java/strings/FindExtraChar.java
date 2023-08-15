package strings;

/**
 * WAP to Find one extra character in a string
 * Given two strings which are of lengths n and n+1. The second string contains all the character of the first string,
 * but there is one extra character. Your task to find the extra character in the second string.
 * <p>
 * Examples:
 * ----------
 * Input : string strA = "abcd";
 * string strB = "cbdae";
 * Output : e
 * string B contain all the element
 * there is a one extra character which is e
 * ----------
 * Input : string strA = "kxml";
 * string strB = "klxml";
 * Output : l
 * string B contain all the element
 * there is a one extra character which is l
 */
public class FindExtraChar {

    private static char findExtraCharByLooping(String strA, String strB) {
        int[] charFreq = new int[256];
        for (int i = 0; i < strA.length(); i++) {
            charFreq[strA.charAt(i)]++;
        }

        for (int i = 0; i < strB.length(); i++) {
            int bAscii = strB.charAt(i);
            if (charFreq[bAscii] == 0) {
                return strB.charAt(i);
            }
        }
        return '#';
    }

    private static char findExtraCharByComparison(String strA, String strB) {
        char extraChar = '\0';
        for (int i = 0; i < strB.length(); i++) {
            char curBChar = strB.charAt(i);
            if (strA.indexOf(curBChar) < 0) {
                extraChar = curBChar;
                break;
            }
        }
        return extraChar;
    }

    public static void main(String[] args) {
        String strA = "kxlm";
        String strB = "kxlmkamxlp";
        System.out.println(findExtraCharByLooping(strA, strB));
        System.out.println(findExtraCharByComparison(strA, strB));
    }
}
