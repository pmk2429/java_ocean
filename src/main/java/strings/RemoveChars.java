package strings;

/**
 * Remove characters from the first string which are present in the second string
 * <p>
 * WAP that takes two strings as arguments and removes the characters from first string which are present in second
 * string (mask string).
 * <p>
 * Example String str = "pavitra";
 * String mask_str = "art";
 * Output = "pvi"
 */
public class RemoveChars {

    private static String removeChars(String first, String mask) {
        char[] firstArr = first.toCharArray();
        int[] charCount = new int[256];
        int index = 0, resIndex = 0;

        for (int i = 0; i < mask.length(); i++) {
            charCount[mask.charAt(i)]++;
        }

        while (index < firstArr.length) {
            char temp = firstArr[index];
            if (charCount[temp] == 0) { // element is not present in mask
                firstArr[resIndex] = firstArr[index];
                resIndex++;
            }
            index++;
        }
        first = new String(firstArr);
        return first.substring(0, resIndex);
    }

    public static void main(String[] args) {
        String str = "pavitra";
        String mask_str = "art";
        System.out.println(removeChars(str, mask_str));
    }
}
