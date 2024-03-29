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
        int[] charFreq = new int[256];
        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            if (charFreq[currChar] == 0) {
                charFreq[currChar]++;
                newStr.append(currChar);
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
