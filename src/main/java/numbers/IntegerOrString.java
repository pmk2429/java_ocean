package numbers;

/**
 * WAP to check if input is an integer or a string.
 */
public class IntegerOrString {

  private static void isNumber(String input) {
    boolean isDigit = false;
    for (int i = 0; i < input.length(); i++) {
      if (Character.isDigit(input.charAt(i))) {
        isDigit = true;
      } else {
        isDigit = false;
        break;
      }
    }
    System.out.println(isDigit);
  }

  private static boolean isNumberRaw(String s) {
    int i = 0, n = s.length();

    // trim the leading and trailing whitespaces
    s = s.trim();

    // leading + or - will denote the numerical value
    if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
      i++;
    }
    boolean isNumeric = false;

    while (i < n && Character.isDigit(s.charAt(i))) {
      i++;
      isNumeric = true;
    }

    // check for '.'
    if (i < n && s.charAt(i) == '.') {
      i++;
      while (i < n && Character.isDigit(s.charAt(i))) {
        i++;
        isNumeric = true;
      }
    }

    // check for exponential representation char - 'e'
    if (isNumeric && i < n && s.charAt(i) == 'e') {
      i++;
      isNumeric = false;
      if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
      while (i < n && Character.isDigit(s.charAt(i))) {
        i++;
        isNumeric = true;
      }
    }

    return isNumeric && i == n;
  }

  public static void main(String[] args) {
    String ip1 = "127";
    isNumber(ip1);
    String ip2 = "24.29";
    isNumber(ip2);
    String ip3 = "6LOL917";
    isNumber(ip3);
  }
}
