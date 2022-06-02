package strings;

/**
 * Remove duplicates from a string in O(1) extra space
 * Given a string str of lowercase characters, the task is to remove duplicates and return a resultant
 * string without modifying the order of characters in the original string.
 * <p>
 * Examples:
 * ---------
 * Input: str = "geeksforgeeks"
 * Output: geksfor
 * Input: str = "characters"
 * Output: chartes
 */
public class RemoveDuplicatesO1Space {

    private static String removeDuplicatesAllChars(String str) {
        StringBuilder newStr = new StringBuilder();
        int[] alphabets = new int[256];
        for (int i = 0; i < str.length(); i++) {
            int charPos = str.charAt(i);
            if (alphabets[charPos] == 0) {
                newStr.append(str.charAt(i));
                alphabets[charPos]++;
            }
        }
        return newStr.toString();
    }

    private static String removeDuplicates(String originalString) {
        StringBuilder newStr = new StringBuilder();
        int[] alphabets = new int[26];
        for (int i = 0; i < originalString.length(); i++) {
            int alphabetPos = originalString.charAt(i) - 97;
            if (alphabets[alphabetPos] == 0) {
                newStr.append(originalString.charAt(i));
                alphabets[alphabetPos]++;
            }
        }
        return newStr.toString();
    }

    public String removeDuplicatesON(String S) {
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for (char character : S.toCharArray()) {
            if (sbLength != 0 && character == sb.charAt(sbLength - 1))
                sb.deleteCharAt(sbLength-- - 1);
            else {
                sb.append(character);
                sbLength++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "Geeks for Geeks";
        System.out.println(removeDuplicatesAllChars(str));
    }
}
