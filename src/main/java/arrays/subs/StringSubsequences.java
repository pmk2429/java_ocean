package arrays.subs;

import java.util.ArrayList;
import java.util.List;

public class StringSubsequences {

    /**
     * We use a binary approach to generate subsequences.
     * - The number of possible subsequences for a string of length n is 2^n.
     * - The outer loop (mask) iterates through all possible combinations of elements.
     * - The inner loop (i) checks whether the i-th bit in the binary representation of mask is set to 1. If it is, we
     * include the character at index i in the subsequence.
     * - We construct the subsequence by appending characters to a StringBuilder.
     */
    public static List<String> getAllSubsequences(String str) {
        int n = str.length();
        int totalSubsequences = 1 << n; // Total 2^n subsequences
        List<String> res = new ArrayList<>();

        for (int mask = 0; mask < totalSubsequences; mask++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sb.append(str.charAt(i));
                }
            }
            res.add(sb.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getAllSubsequences("abcde"));
    }
}
