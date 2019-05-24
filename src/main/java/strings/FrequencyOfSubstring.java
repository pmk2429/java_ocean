package strings;

public class FrequencyOfSubstring {

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
        j = 0;
      }
    }
    return freq;
  }

  public static void main(String[] args) {
    String text = "dhimantmanandsuperman";
    String sub = "man";
    System.out.println(substrFrequency(text, sub));
  }
}
