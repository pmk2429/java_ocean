package arrays.subs;

/**
 * Created by Pavitra on 11/12/2015.
 */
public class AllSubstrings {

    private static String longestUniqueSubstring() {
        String str = "pavitra";
        String maxUniqueSubstring = "";
        int subLength = Integer.MIN_VALUE;

        char[] charFreq = new char[256];

        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length() - i; j++) {
                if (charFreq[i] == 0) {
                    charFreq[i]++;
                    String sub = str.substring(i, i + j);
                    if (sub.length() > subLength) {
                        subLength = sub.length();
                        maxUniqueSubstring = sub;
                    }
                }
            }
        }

        return maxUniqueSubstring;
    }

    private static void allUniqueSubstrings() {
        String str = "pavitra";

        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length() - i; j++) {
                String sub = str.substring(i, i + j);
                System.out.println(sub);
            }
        }
    }

    public static void allSubstrings() {
        String sub;
        String str = "pavitra";
        int i, c, length = str.length();

        for (c = 0; c < length; c++) {
            for (i = 1; i <= length - c; i++) {
                if (i >= 2) {
                    sub = str.substring(c, c + i);
                    System.out.println(sub);
                }
            }
        }
    }

    public static void main(String[] args) {
        allSubstrings();
        System.out.println("--------------");
        allUniqueSubstrings();
    }
}
