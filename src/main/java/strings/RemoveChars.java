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
        int[] charFreq = new int[256];
        int i = 0, resIndex = 0;

        for (int j = 0; j < mask.length(); j++) {
            charFreq[mask.charAt(j)]++;
        }

        while (i < firstArr.length) {
            char temp = firstArr[i];
            if (charFreq[temp] == 0) { // element is not present in mask
                firstArr[resIndex] = firstArr[i];
                resIndex++;
            }
            i++;
        }
        return new String(firstArr).substring(0, resIndex);
    }

    public static void main(String[] args) {
        String str = "pavitra";
        String mask_str = "art";
        System.out.println(removeChars(str, mask_str));
    }
}
