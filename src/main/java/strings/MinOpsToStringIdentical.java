package strings;

import java.util.stream.IntStream;

/**
 * Similar to {@link Anagrams}.
 */
public class MinOpsToStringIdentical {
    private static int minOps(String A, String B) {

        int aLength = A.length();
        int bLength = B.length();

        // This parts checks whether conversion is possible or not
        if (aLength != bLength) {
            return -1;
        }

        int i, j, res = 0;
        int[] charFreq = new int[256];

        // subtract count for every character in B
        for (i = 0; i < aLength; i++) {
            charFreq[A.charAt(i)]++;
            charFreq[B.charAt(i)]--;
        }

        // Check if all counts become 0
        boolean allZeroes = IntStream.of(charFreq).allMatch(x -> x == 0);
        if (!allZeroes) {
            return -1;
        }

        i = aLength - 1;
        j = bLength - 1;

        while (i >= 0) {
            // If there is a mismatch, then keep incrementing result 'res'
            // until B[j] is not found in A[0..i]
            if (A.charAt(i) != B.charAt(j)) {
                res++;
            }
            else {
                j--;
            }
            i--;
        }
        return res;
    }

    public static void main(String[] args) {
        String A = "PMK";
        String B = "MKP";

        System.out.println(minOps(A, B));
    }
}
