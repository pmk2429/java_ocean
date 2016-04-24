package strings;

/**
 * Created by Pavitra on 4/23/2016.
 */
public class NeedleInHaystack {
    public static void main(String[] args) {
        System.out.println(strStr("Pavitrakansara", "rak"));
    }

    public static int strStr(String haystack, String needle) {
        if (haystack.contains(needle)) {
            System.out.println("yes");
            return haystack.indexOf(needle);
        } else {
            return -1;
        }
    }
}
