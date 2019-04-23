package strings;

/**
 * Created by Pavitra on 4/23/2016.
 */
public class NeedleInHaystack {
  private static int needleInHaystack(String haystack, String needle) {
    if (haystack.contains(needle)) {
      System.out.println("yes");
      return haystack.indexOf(needle);
    } else {
      return -1;
    }
  }

  private static int strStr(String haystack, String needle) {
    for (int i = 0; ; i++) {
      for (int j = 0; ; j++) {
        if (j == needle.length()) return i;
        if (i + j == haystack.length()) return -1;
        if (needle.charAt(j) != haystack.charAt(i + j)) break;
      }
    }
  }

  public static void main(String[] args) {
    System.out.println(strStr("Pavitrakansara", "rak"));
  }
}
