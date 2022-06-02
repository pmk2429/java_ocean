package strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FrequencyOfSubstring {

    public static boolean isEmpty(String s) {
        return s == null || s.length() == 0;
    }

    /* Counts how many times the substring appears in the larger string. */
    public static int countMatches(String text, String str) {
        if (isEmpty(text) || isEmpty(str)) {
            return 0;
        }

        Matcher matcher = Pattern.compile(str).matcher(text);

        int count = 0;
        while (matcher.find()) {
            count++;
        }

        return count;
    }

    private static int substrFrequency(String text, String sub) {
        int m = text.length();
        int n = sub.length();
        int freq = 0;

        for (int i = 0; i <= m - n; i++) {
            int j;
            for (j = 0; j < n; j++) {
                if (text.charAt(i + j) != sub.charAt(j)) {
                    break;
                }
            }
            // if whole sub is traversed
            if (j == n) {
                freq++;
            }
        }
        return freq;
    }

    public static void main(String[] args) {
        String text = "dhimantmanandsuperman";
        String sub = "man";
        System.out.println(substrFrequency(text, sub));
        System.out.println(countMatches(text, sub));
    }
}
