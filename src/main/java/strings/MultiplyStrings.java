package strings;

public class MultiplyStrings {

  private static boolean isNumeric(String str) {
    return str.matches("-?\\d+(\\.\\d+)?");
  }

  // https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation
  private static String multiply(String x, String y) {
    StringBuilder sb = new StringBuilder();
    int[] pos = new int[x.length() + y.length()];

    if (!isNumeric(x) || !isNumeric(y)) {
      return null;
    }

    for (int i = x.length() - 1; i >= 0; i--) {
      for (int j = y.length() - 1; j >= 0; j--) {
        int mul = (x.charAt(i) - '0') * (y.charAt(j) - '0');
        int p1 = i + j;
        int p2 = i + j + 1;

        int sum = mul + pos[p2];

        // start filling spaces from end
        pos[p2] = sum % 10;
        pos[p1] += sum / 10;
      }
    }

    for (int p : pos) {
      if (!(sb.length() == 0 && p == 0)) {
        sb.append(p);
      }
    }
    return sb.length() == 0 ? "0" : sb.toString();
  }

  public static void main(String[] args) {
    String x = "126";
    String y = "34";
    System.out.println(multiply(x, y));
  }
}
