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
 * <p>
 * Similar to {@link RansomNote}.
 */
public class RemoveChars {

    /**
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     */
    private static String removeChars(String first, String mask) {
        char[] firstArr = first.toCharArray();
        int[] charFreq = new int[256];
        int i = 0, resIndex = 0;

        for (char c : mask.toCharArray()) {
            charFreq[c]++;
        }

        while (i < firstArr.length) {
            if (charFreq[firstArr[i]] == 0) { // element is not present in mask
                firstArr[resIndex] = firstArr[i];
                resIndex++;
            }
            i++;
        }
        return String.valueOf(firstArr).substring(0, resIndex);
    }

    public static void main(String[] args) {
        String str = "pavitra";
        String mask_str = "art";
        System.out.println(removeChars(str, mask_str));
    }
}
