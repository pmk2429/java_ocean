package arrays.subs;

/**
 * Created by Pavitra on 11/12/2015.
 */
public class AllSubstrings {
  public static void main(String[] args) {
    String sub;
    int i, c, length;

    String str = "pavitra";
    length = str.length();

    for (c = 0; c < length; c++) {
      for (i = 1; i <= length - c; i++) {
        if (i >= 2) {
          sub = str.substring(c, c + i);
          System.out.println(sub);
        }
      }
    }
  }
}
