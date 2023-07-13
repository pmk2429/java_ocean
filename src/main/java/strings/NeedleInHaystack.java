package strings;

/**
 * Created by Pavitra on 4/23/2016.
 */
public class NeedleInHaystack {
    private static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        int nL = needle.length();
        int i = 0;
        int j = i + nL;

        while (j <= haystack.length()) {
            if ((haystack.substring(i, j)).equals(needle)) {
                return i;
            }
            i++;
            j++;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("Pavitrakansara", "rak"));
    }
}
