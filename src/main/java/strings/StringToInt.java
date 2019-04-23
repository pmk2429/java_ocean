package strings;

public class StringToInt {

  private static final int maxDiv10 = Integer.MAX_VALUE / 10;

  private static int atoi(String str) {
    int i = 0, n = str.length();
    while (i < n && Character.isWhitespace(str.charAt(i))) i++;
    int sign = 1;
    if (i < n && str.charAt(i) == '+') {
      i++;
    } else if (i < n && str.charAt(i) == '-') {
      sign = -1;
      i++;
    }
    int num = 0;
    while (i < n && Character.isDigit(str.charAt(i))) {
      int digit = Character.getNumericValue(str.charAt(i));
      if (num > maxDiv10 || num == maxDiv10 && digit >= 8) {
        return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      }
      num = num * 10 + digit;
      i++;
    }
    return sign * num;
  }

  private static int strToInt(String str) {
    int i = 0;
    int conversion = 0;
    boolean isNeg = false;
    int length = str.length();

    // Check for negative sign; if it's there, set the isNeg flag
    if (str.charAt(0) == '-') {
      isNeg = true;
      i = 1;
    }

    // Process each character of the string;
    while (i < length && Character.isDigit(str.charAt(i))) {
      conversion *= 10;
      conversion += str.charAt(i++) - '0'; // Minus the ASCII code of '0' to get the value of the charAt(i++).
    }

    if (isNeg) {
      conversion = -conversion;
    }
    return conversion;
  }

  private static String intToString(int n) {
    // get total length of the numerical digit value
    int length = (int) (Math.log10(n) + 1);
    // initiate char array with length
    char[] strArr = new char[length];
    int remainder;
    for (int i = length - 1; i >= 0; i--) {
      remainder = n % 10;
      char c = (char) (remainder + '0');
      strArr[i] = c;
      n = n / 10;
    }

    return String.valueOf(strArr);
  }

  public static void main(String[] args) {
    int n = 123;
    System.out.println(intToString(n));

    String num = "-pa642";
    System.out.println(strToInt(num));
  }
}
