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

  private static int strStrON2(String haystack, String needle) {
    for (int i = 0; ; i++) {
      for (int j = 0; ; j++) {
        if (j == needle.length()) return i;
        if (i + j == haystack.length()) return -1;
        if (needle.charAt(j) != haystack.charAt(i + j)) break;
      }
    }
  }

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
